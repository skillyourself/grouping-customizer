package com.groupingfilter;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(GroupingFilterConfig.CONFIG_GROUP)
public interface GroupingFilterConfig extends Config
{
    String CONFIG_GROUP = "groupingfilter";

    @ConfigSection(name = "Default Selection", description = "Set the default selected activity in the Grouping tab", position = 0)
    String defaultSection = "default";

    @ConfigSection(name = "Show/Hide", description = "Toggle visibility of activities in the Grouping tab", position = 1)
    String showHideSection = "showhide";

    @ConfigSection(name = "Text Color", description = "Change the text color of activities in the Grouping tab", position = 2)
    String colorSection = "colors";

    // ── Default Activity ──

    @ConfigItem(keyName = "defaultActivity", name = "Activity", description = "The default selected activity in the Grouping tab", section = defaultSection, position = 0)
    default GroupingActivity defaultActivity() { return GroupingActivity.NONE; }

    // ── Show / Hide ──

    @ConfigItem(keyName = "showPvpArena", name = "PvP Arena", description = "Show the PvP Arena button", section = showHideSection, position = 0)
    default boolean showPvpArena() { return true; }

    @ConfigItem(keyName = "showBarbarianAssault", name = "Barbarian Assault", description = "Show Barbarian Assault", section = showHideSection, position = 1)
    default boolean showBarbarianAssault() { return true; }

    @ConfigItem(keyName = "showBlastFurnace", name = "Blast Furnace", description = "Show Blast Furnace", section = showHideSection, position = 2)
    default boolean showBlastFurnace() { return true; }

    @ConfigItem(keyName = "showBurthorpeGamesRoom", name = "Burthorpe Games Room", description = "Show Burthorpe Games Room", section = showHideSection, position = 3)
    default boolean showBurthorpeGamesRoom() { return true; }

    @ConfigItem(keyName = "showCastleWars", name = "Castle Wars", description = "Show Castle Wars", section = showHideSection, position = 4)
    default boolean showCastleWars() { return true; }

    @ConfigItem(keyName = "showClanWars", name = "Clan Wars", description = "Show Clan Wars", section = showHideSection, position = 5)
    default boolean showClanWars() { return true; }

    @ConfigItem(keyName = "showDagannothKings", name = "Dagannoth Kings", description = "Show Dagannoth Kings", section = showHideSection, position = 6)
    default boolean showDagannothKings() { return true; }

    @ConfigItem(keyName = "showFishingTrawler", name = "Fishing Trawler", description = "Show Fishing Trawler", section = showHideSection, position = 7)
    default boolean showFishingTrawler() { return true; }

    @ConfigItem(keyName = "showGiantsFoundry", name = "Giants' Foundry", description = "Show Giants' Foundry", section = showHideSection, position = 8)
    default boolean showGiantsFoundry() { return true; }

    @ConfigItem(keyName = "showGodWars", name = "God Wars", description = "Show God Wars", section = showHideSection, position = 9)
    default boolean showGodWars() { return true; }

    @ConfigItem(keyName = "showGuardiansOfTheRift", name = "Guardians of the Rift", description = "Show Guardians of the Rift", section = showHideSection, position = 10)
    default boolean showGuardiansOfTheRift() { return true; }

    @ConfigItem(keyName = "showLastManStanding", name = "Last Man Standing", description = "Show Last Man Standing", section = showHideSection, position = 11)
    default boolean showLastManStanding() { return true; }

    @ConfigItem(keyName = "showMageTrainingArena", name = "Mage Training Arena", description = "Show Mage Training Arena", section = showHideSection, position = 12)
    default boolean showMageTrainingArena() { return true; }

    @ConfigItem(keyName = "showNightmareZone", name = "Nightmare Zone", description = "Show Nightmare Zone", section = showHideSection, position = 13)
    default boolean showNightmareZone() { return true; }

    @ConfigItem(keyName = "showPestControl", name = "Pest Control", description = "Show Pest Control", section = showHideSection, position = 14)
    default boolean showPestControl() { return true; }

    @ConfigItem(keyName = "showPlayerOwnedHouses", name = "Player Owned Houses", description = "Show Player Owned Houses", section = showHideSection, position = 15)
    default boolean showPlayerOwnedHouses() { return true; }

    @ConfigItem(keyName = "showRatPits", name = "Rat Pits", description = "Show Rat Pits", section = showHideSection, position = 16)
    default boolean showRatPits() { return true; }

    @ConfigItem(keyName = "showRoyalTitans", name = "Royal Titans", description = "Show Royal Titans", section = showHideSection, position = 17)
    default boolean showRoyalTitans() { return true; }

    @ConfigItem(keyName = "showShadesOfMortton", name = "Shades of Mort'ton", description = "Show Shades of Mort'ton", section = showHideSection, position = 18)
    default boolean showShadesOfMortton() { return true; }

    @ConfigItem(keyName = "showShieldOfArrav", name = "Shield of Arrav", description = "Show Shield of Arrav", section = showHideSection, position = 19)
    default boolean showShieldOfArrav() { return true; }

    @ConfigItem(keyName = "showShootingStars", name = "Shooting Stars", description = "Show Shooting Stars", section = showHideSection, position = 20)
    default boolean showShootingStars() { return true; }

    @ConfigItem(keyName = "showSoulWars", name = "Soul Wars", description = "Show Soul Wars", section = showHideSection, position = 21)
    default boolean showSoulWars() { return true; }

    @ConfigItem(keyName = "showTheatreOfBlood", name = "Theatre of Blood", description = "Show Theatre of Blood", section = showHideSection, position = 22)
    default boolean showTheatreOfBlood() { return true; }

    @ConfigItem(keyName = "showTitheFarm", name = "Tithe Farm", description = "Show Tithe Farm", section = showHideSection, position = 23)
    default boolean showTitheFarm() { return true; }

    @ConfigItem(keyName = "showTombsOfAmascut", name = "Tombs of Amascut", description = "Show Tombs of Amascut", section = showHideSection, position = 24)
    default boolean showTombsOfAmascut() { return true; }

    @ConfigItem(keyName = "showTroubleBrewing", name = "Trouble Brewing", description = "Show Trouble Brewing", section = showHideSection, position = 25)
    default boolean showTroubleBrewing() { return true; }

    @ConfigItem(keyName = "showTzHaarFightPit", name = "TzHaar Fight Pit", description = "Show TzHaar Fight Pit", section = showHideSection, position = 26)
    default boolean showTzHaarFightPit() { return true; }

    @ConfigItem(keyName = "showVolcanicMine", name = "Volcanic Mine", description = "Show Volcanic Mine", section = showHideSection, position = 27)
    default boolean showVolcanicMine() { return true; }

    @ConfigItem(keyName = "showNoneOption", name = "(none)", description = "Show the (none) deselect option in the dropdown", section = showHideSection, position = 28)
    default boolean showNoneOption() { return true; }

    // ── Colors ──

    @Alpha
    @ConfigItem(keyName = "colorPvpArena", name = "PvP Arena", description = "Text color for PvP Arena", section = colorSection, position = 0)
    default Color colorPvpArena() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorBarbarianAssault", name = "Barbarian Assault", description = "Text color for Barbarian Assault", section = colorSection, position = 1)
    default Color colorBarbarianAssault() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorBlastFurnace", name = "Blast Furnace", description = "Text color for Blast Furnace", section = colorSection, position = 2)
    default Color colorBlastFurnace() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorBurthorpeGamesRoom", name = "Burthorpe Games Room", description = "Text color for Burthorpe Games Room", section = colorSection, position = 3)
    default Color colorBurthorpeGamesRoom() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorCastleWars", name = "Castle Wars", description = "Text color for Castle Wars", section = colorSection, position = 4)
    default Color colorCastleWars() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorClanWars", name = "Clan Wars", description = "Text color for Clan Wars", section = colorSection, position = 5)
    default Color colorClanWars() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorDagannothKings", name = "Dagannoth Kings", description = "Text color for Dagannoth Kings", section = colorSection, position = 6)
    default Color colorDagannothKings() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorFishingTrawler", name = "Fishing Trawler", description = "Text color for Fishing Trawler", section = colorSection, position = 7)
    default Color colorFishingTrawler() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorGiantsFoundry", name = "Giants' Foundry", description = "Text color for Giants' Foundry", section = colorSection, position = 8)
    default Color colorGiantsFoundry() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorGodWars", name = "God Wars", description = "Text color for God Wars", section = colorSection, position = 9)
    default Color colorGodWars() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorGuardiansOfTheRift", name = "Guardians of the Rift", description = "Text color for Guardians of the Rift", section = colorSection, position = 10)
    default Color colorGuardiansOfTheRift() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorLastManStanding", name = "Last Man Standing", description = "Text color for Last Man Standing", section = colorSection, position = 11)
    default Color colorLastManStanding() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorMageTrainingArena", name = "Mage Training Arena", description = "Text color for Mage Training Arena", section = colorSection, position = 12)
    default Color colorMageTrainingArena() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorNightmareZone", name = "Nightmare Zone", description = "Text color for Nightmare Zone", section = colorSection, position = 13)
    default Color colorNightmareZone() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorPestControl", name = "Pest Control", description = "Text color for Pest Control", section = colorSection, position = 14)
    default Color colorPestControl() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorPlayerOwnedHouses", name = "Player Owned Houses", description = "Text color for Player Owned Houses", section = colorSection, position = 15)
    default Color colorPlayerOwnedHouses() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorRatPits", name = "Rat Pits", description = "Text color for Rat Pits", section = colorSection, position = 16)
    default Color colorRatPits() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorRoyalTitans", name = "Royal Titans", description = "Text color for Royal Titans", section = colorSection, position = 17)
    default Color colorRoyalTitans() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorShadesOfMortton", name = "Shades of Mort'ton", description = "Text color for Shades of Mort'ton", section = colorSection, position = 18)
    default Color colorShadesOfMortton() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorShieldOfArrav", name = "Shield of Arrav", description = "Text color for Shield of Arrav", section = colorSection, position = 19)
    default Color colorShieldOfArrav() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorShootingStars", name = "Shooting Stars", description = "Text color for Shooting Stars", section = colorSection, position = 20)
    default Color colorShootingStars() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorSoulWars", name = "Soul Wars", description = "Text color for Soul Wars", section = colorSection, position = 21)
    default Color colorSoulWars() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorTheatreOfBlood", name = "Theatre of Blood", description = "Text color for Theatre of Blood", section = colorSection, position = 22)
    default Color colorTheatreOfBlood() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorTitheFarm", name = "Tithe Farm", description = "Text color for Tithe Farm", section = colorSection, position = 23)
    default Color colorTitheFarm() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorTombsOfAmascut", name = "Tombs of Amascut", description = "Text color for Tombs of Amascut", section = colorSection, position = 24)
    default Color colorTombsOfAmascut() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorTroubleBrewing", name = "Trouble Brewing", description = "Text color for Trouble Brewing", section = colorSection, position = 25)
    default Color colorTroubleBrewing() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorTzHaarFightPit", name = "TzHaar Fight Pit", description = "Text color for TzHaar Fight Pit", section = colorSection, position = 26)
    default Color colorTzHaarFightPit() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorVolcanicMine", name = "Volcanic Mine", description = "Text color for Volcanic Mine", section = colorSection, position = 27)
    default Color colorVolcanicMine() { return new Color(255, 152, 31); }

    @Alpha
    @ConfigItem(keyName = "colorNoneOption", name = "(none)", description = "Text color for the (none) option", section = colorSection, position = 28)
    default Color colorNoneOption() { return new Color(255, 152, 31); }
}