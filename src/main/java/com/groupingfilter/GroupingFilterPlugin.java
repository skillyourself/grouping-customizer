package com.groupingfilter;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.VarClientID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "Grouping Customizer",
        description = "Hide, recolor, and set a default selection for activities in the Grouping tab",
        tags = {"grouping", "minigame", "filter", "hide", "teleport", "customize"}
)
public class GroupingFilterPlugin extends Plugin
{
    private static final int GROUPING_INTERFACE_GROUP_ID = 76;
    private static final int GROUPING_DROPDOWN_CONTENTS_CHILD_ID = 22;
    private static final int GROUPING_CURRENTGAME_CHILD_ID = 11;
    private static final int GROUPING_DROPDOWN_CHILD_ID = 18;
    private static final int GROUPING_DROPDOWN_SCROLLBAR_CHILD_ID = 23;

    private static final int PVP_ARENA_CONTAINER_CHILD_ID = 2;
    private static final int PVP_ARENA_GRAPHIC_CHILD_ID = 3;
    private static final int PVP_ARENA_TEXT_CHILD_ID = 4;

    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private GroupingFilterConfig config;

    private final Map<String, ActivityEntry> activityEntries = new LinkedHashMap<>();
    private boolean defaultActivityApplied = false;

    @Override
    protected void startUp() throws Exception
    {
        buildActivityMap();
        clientThread.invokeLater(() ->
        {
            filterGroupingList();
            filterPvpArena();
        });
        log.debug("Grouping Customizer started!");
    }

    @Override
    protected void shutDown() throws Exception
    {
        clientThread.invokeLater(() ->
        {
            restoreGroupingList();
            restorePvpArena();
        });
        log.debug("Grouping Customizer stopped!");
    }

    private void buildActivityMap()
    {
        activityEntries.clear();

        activityEntries.put("Barbarian Assault", new ActivityEntry(config::showBarbarianAssault, config::colorBarbarianAssault));
        activityEntries.put("Blast Furnace", new ActivityEntry(config::showBlastFurnace, config::colorBlastFurnace));
        activityEntries.put("Burthorpe Games Room", new ActivityEntry(config::showBurthorpeGamesRoom, config::colorBurthorpeGamesRoom));
        activityEntries.put("Castle Wars", new ActivityEntry(config::showCastleWars, config::colorCastleWars));
        activityEntries.put("Clan Wars", new ActivityEntry(config::showClanWars, config::colorClanWars));
        activityEntries.put("Dagannoth Kings", new ActivityEntry(config::showDagannothKings, config::colorDagannothKings));
        activityEntries.put("Fishing Trawler", new ActivityEntry(config::showFishingTrawler, config::colorFishingTrawler));
        activityEntries.put("Giants' Foundry", new ActivityEntry(config::showGiantsFoundry, config::colorGiantsFoundry));
        activityEntries.put("God Wars", new ActivityEntry(config::showGodWars, config::colorGodWars));
        activityEntries.put("Guardians of the Rift", new ActivityEntry(config::showGuardiansOfTheRift, config::colorGuardiansOfTheRift));
        activityEntries.put("Last Man Standing", new ActivityEntry(config::showLastManStanding, config::colorLastManStanding));
        activityEntries.put("Mage Training Arena", new ActivityEntry(config::showMageTrainingArena, config::colorMageTrainingArena));
        activityEntries.put("Nightmare Zone", new ActivityEntry(config::showNightmareZone, config::colorNightmareZone));
        activityEntries.put("Pest Control", new ActivityEntry(config::showPestControl, config::colorPestControl));
        activityEntries.put("Player Owned Houses", new ActivityEntry(config::showPlayerOwnedHouses, config::colorPlayerOwnedHouses));
        activityEntries.put("Rat Pits", new ActivityEntry(config::showRatPits, config::colorRatPits));
        activityEntries.put("Royal Titans", new ActivityEntry(config::showRoyalTitans, config::colorRoyalTitans));
        activityEntries.put("Shades of Mort'ton", new ActivityEntry(config::showShadesOfMortton, config::colorShadesOfMortton));
        activityEntries.put("Shield of Arrav", new ActivityEntry(config::showShieldOfArrav, config::colorShieldOfArrav));
        activityEntries.put("Shooting Stars", new ActivityEntry(config::showShootingStars, config::colorShootingStars));
        activityEntries.put("Soul Wars", new ActivityEntry(config::showSoulWars, config::colorSoulWars));
        activityEntries.put("Theatre of Blood", new ActivityEntry(config::showTheatreOfBlood, config::colorTheatreOfBlood));
        activityEntries.put("Tithe Farm", new ActivityEntry(config::showTitheFarm, config::colorTitheFarm));
        activityEntries.put("Tombs of Amascut", new ActivityEntry(config::showTombsOfAmascut, config::colorTombsOfAmascut));
        activityEntries.put("Trouble Brewing", new ActivityEntry(config::showTroubleBrewing, config::colorTroubleBrewing));
        activityEntries.put("TzHaar Fight Pit", new ActivityEntry(config::showTzHaarFightPit, config::colorTzHaarFightPit));
        activityEntries.put("Volcanic Mine", new ActivityEntry(config::showVolcanicMine, config::colorVolcanicMine));
        activityEntries.put("(none)", new ActivityEntry(config::showNoneOption, config::colorNoneOption));
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event)
    {
        if (!GroupingFilterConfig.CONFIG_GROUP.equals(event.getGroup()))
        {
            return;
        }

        buildActivityMap();

        if ("defaultActivity".equals(event.getKey()))
        {
            clientThread.invokeLater(() ->
            {
                applyDefaultActivity(true);
                filterGroupingList();
            });
            return;
        }

        clientThread.invokeLater(() ->
        {
            filterGroupingList();
            filterPvpArena();
        });
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded event)
    {
        if (event.getGroupId() == GROUPING_INTERFACE_GROUP_ID)
        {
            defaultActivityApplied = false;
            clientThread.invokeLater(() ->
            {
                applyDefaultActivity(false);
                filterGroupingList();
                filterPvpArena();
            });
        }
    }

    @Subscribe
    public void onScriptPostFired(ScriptPostFired event)
    {
        filterGroupingList();
    }

    private void applyDefaultActivity(boolean force)
    {
        if (!force && defaultActivityApplied)
        {
            return;
        }

        GroupingActivity defaultAct = config.defaultActivity();
        if (defaultAct == GroupingActivity.NONE)
        {
            if (force)
            {
                client.setVarcIntValue(VarClientID.GROUPING_GAMEID, 0);
                Widget currentGameWidget = client.getWidget(GROUPING_INTERFACE_GROUP_ID, GROUPING_CURRENTGAME_CHILD_ID);
                if (currentGameWidget != null)
                {
                    currentGameWidget.setText("Select an activity...");
                }
            }
            defaultActivityApplied = true;
            return;
        }

        if (!force)
        {
            int current = client.getVarcIntValue(VarClientID.GROUPING_GAMEID);
            if (current != 0)
            {
                defaultActivityApplied = true;
                return;
            }
        }

        client.setVarcIntValue(VarClientID.GROUPING_GAMEID, defaultAct.getGameId());

        Widget currentGameWidget = client.getWidget(GROUPING_INTERFACE_GROUP_ID, GROUPING_CURRENTGAME_CHILD_ID);
        if (currentGameWidget != null)
        {
            currentGameWidget.setText(defaultAct.getName());
        }

        defaultActivityApplied = true;
        log.debug("Applied default grouping activity: {}", defaultAct.getName());
    }

    private void filterPvpArena()
    {
        boolean show = config.showPvpArena();

        Widget container = client.getWidget(GROUPING_INTERFACE_GROUP_ID, PVP_ARENA_CONTAINER_CHILD_ID);
        if (container != null)
        {
            container.setHidden(!show);
        }

        Widget graphic = client.getWidget(GROUPING_INTERFACE_GROUP_ID, PVP_ARENA_GRAPHIC_CHILD_ID);
        if (graphic != null)
        {
            graphic.setHidden(!show);
        }

        Widget text = client.getWidget(GROUPING_INTERFACE_GROUP_ID, PVP_ARENA_TEXT_CHILD_ID);
        if (text != null)
        {
            text.setHidden(!show);
            if (show)
            {
                Color color = config.colorPvpArena();
                text.setTextColor(color.getRGB() & 0xFFFFFF);
            }
        }
    }

    private void restorePvpArena()
    {
        int defaultColor = 0xff981f;

        Widget container = client.getWidget(GROUPING_INTERFACE_GROUP_ID, PVP_ARENA_CONTAINER_CHILD_ID);
        if (container != null)
        {
            container.setHidden(false);
        }

        Widget graphic = client.getWidget(GROUPING_INTERFACE_GROUP_ID, PVP_ARENA_GRAPHIC_CHILD_ID);
        if (graphic != null)
        {
            graphic.setHidden(false);
        }

        Widget text = client.getWidget(GROUPING_INTERFACE_GROUP_ID, PVP_ARENA_TEXT_CHILD_ID);
        if (text != null)
        {
            text.setHidden(false);
            text.setTextColor(defaultColor);
        }
    }

    private void filterGroupingList()
    {
        Widget listWidget = client.getWidget(GROUPING_INTERFACE_GROUP_ID, GROUPING_DROPDOWN_CONTENTS_CHILD_ID);
        if (listWidget == null)
        {
            return;
        }

        Widget[] children = listWidget.getDynamicChildren();
        if (children == null || children.length == 0)
        {
            return;
        }

        int yOffset = 0;
        int entryHeight = -1;

        for (Widget child : children)
        {
            String text = child.getText();
            if (text == null || text.isEmpty())
            {
                continue;
            }

            String cleanText = text.replaceAll("<[^>]+>", "").trim();
            if (cleanText.isEmpty())
            {
                continue;
            }

            if (entryHeight < 0)
            {
                entryHeight = child.getHeight();
                if (entryHeight <= 0)
                {
                    entryHeight = child.getOriginalHeight();
                }
            }

            ActivityEntry entry = activityEntries.get(cleanText);
            boolean shouldHide = (entry != null && !entry.visible.get());

            child.setHidden(shouldHide);

            if (!shouldHide)
            {
                if (entry != null)
                {
                    Color color = entry.color.get();
                    child.setTextColor(color.getRGB() & 0xFFFFFF);
                }

                child.setRelativeY(yOffset);
                child.setOriginalY(yOffset);
                yOffset += entryHeight;
            }
        }

        if (entryHeight > 0)
        {
            listWidget.setScrollHeight(yOffset);
        }

        // Hide scrollbar if all visible items fit within the dropdown area
        Widget dropdownWidget = client.getWidget(GROUPING_INTERFACE_GROUP_ID, GROUPING_DROPDOWN_CHILD_ID);
        Widget scrollbarWidget = client.getWidget(GROUPING_INTERFACE_GROUP_ID, GROUPING_DROPDOWN_SCROLLBAR_CHILD_ID);
        if (dropdownWidget != null && scrollbarWidget != null)
        {
            int visibleHeight = dropdownWidget.getHeight();
            if (visibleHeight <= 0)
            {
                visibleHeight = dropdownWidget.getOriginalHeight();
            }

            boolean needsScroll = yOffset > visibleHeight;
            scrollbarWidget.setHidden(!needsScroll);
        }
    }

    private void restoreGroupingList()
    {
        Widget listWidget = client.getWidget(GROUPING_INTERFACE_GROUP_ID, GROUPING_DROPDOWN_CONTENTS_CHILD_ID);
        if (listWidget == null)
        {
            return;
        }

        Widget[] children = listWidget.getDynamicChildren();
        if (children == null)
        {
            return;
        }

        int defaultColor = 0xff981f;
        int yOffset = 0;
        for (Widget child : children)
        {
            child.setHidden(false);
            child.setTextColor(defaultColor);
            int h = child.getHeight();
            if (h <= 0)
            {
                h = child.getOriginalHeight();
            }
            child.setRelativeY(yOffset);
            child.setOriginalY(yOffset);
            yOffset += h;
        }

        listWidget.setScrollHeight(yOffset);

        // Restore scrollbar
        Widget scrollbarWidget = client.getWidget(GROUPING_INTERFACE_GROUP_ID, GROUPING_DROPDOWN_SCROLLBAR_CHILD_ID);
        if (scrollbarWidget != null)
        {
            scrollbarWidget.setHidden(false);
        }
    }

    @Provides
    GroupingFilterConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(GroupingFilterConfig.class);
    }

    private static class ActivityEntry
    {
        final Supplier<Boolean> visible;
        final Supplier<Color> color;

        ActivityEntry(Supplier<Boolean> visible, Supplier<Color> color)
        {
            this.visible = visible;
            this.color = color;
        }
    }
}