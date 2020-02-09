package io.pokemontcg.model;

public enum SubType {
    EX("EX"),
    SPECIAL("Special"),
    RESTORED("Restored"),
    LEVEL_UP("Level Up"),
    MEGA("MEGA"),
    TECHNICAL_MACHINE("Technical Machine"),
    ITEM("Item"),
    STADIUM("Stadium"),
    SUPPORTER("Supporter"),
    STAGE_1("Stage 1"),
    STAGE_2("Stage 2"),
    GX("GX"),
    POKEMON_TOOL("Pokémon Tool"),
    BASIC("Basic"),
    LEGEND("LEGEND"),
    BREAK("BREAK"),
    ROCKETS_SECRET_MACHINE("Rocket's Secret Machine"),
    TAG_TEAM("TAG TEAM");

    private String displayName;

    SubType(String displayName) {
        this.displayName = displayName;
    }
}
