package com.groupingfilter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GroupingActivity
{
    NONE("None", 0),
    BARBARIAN_ASSAULT("Barbarian Assault", 1),
    BLAST_FURNACE("Blast Furnace", 2),
    BURTHORPE_GAMES_ROOM("Burthorpe Games Room", 3),
    CASTLE_WARS("Castle Wars", 4),
    CLAN_WARS("Clan Wars", 5),
    DAGANNOTH_KINGS("Dagannoth Kings", 6),
    FISHING_TRAWLER("Fishing Trawler", 7),
    GIANTS_FOUNDRY("Giants' Foundry", 8),
    GOD_WARS("God Wars", 9),
    GUARDIANS_OF_THE_RIFT("Guardians of the Rift", 10),
    LAST_MAN_STANDING("Last Man Standing", 11),
    MAGE_TRAINING_ARENA("Mage Training Arena", 12),
    NIGHTMARE_ZONE("Nightmare Zone", 13),
    PEST_CONTROL("Pest Control", 14),
    PLAYER_OWNED_HOUSES("Player Owned Houses", 15),
    RAT_PITS("Rat Pits", 16),
    ROYAL_TITANS("Royal Titans", 17),
    SHADES_OF_MORTTON("Shades of Mort'ton", 18),
    SHIELD_OF_ARRAV("Shield of Arrav", 19),
    SHOOTING_STARS("Shooting Stars", 20),
    SOUL_WARS("Soul Wars", 21),
    THEATRE_OF_BLOOD("Theatre of Blood", 22),
    TITHE_FARM("Tithe Farm", 23),
    TOMBS_OF_AMASCUT("Tombs of Amascut", 24),
    TROUBLE_BREWING("Trouble Brewing", 25),
    TZHAAR_FIGHT_PIT("TzHaar Fight Pit", 26),
    VOLCANIC_MINE("Volcanic Mine", 27);

    private final String name;
    private final int gameId;

    @Override
    public String toString()
    {
        return name;
    }
}