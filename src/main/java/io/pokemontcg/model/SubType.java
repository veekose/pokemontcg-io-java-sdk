package io.pokemontcg.model;

import com.squareup.moshi.Json;

public enum SubType {
    @Json(name = "EX") EX("EX"),
    @Json(name = "Special") SPECIAL("Special"),
    @Json(name = "Restored") RESTORED("Restored"),
    @Json(name = "Level Up") LEVEL_UP("Level Up"),
    @Json(name = "MEGA") MEGA("MEGA"),
    @Json(name = "Technical Machine") TECHNICAL_MACHINE("Technical Machine"),
    @Json(name = "Item") ITEM("Item"),
    @Json(name = "Stadium") STADIUM("Stadium"),
    @Json(name = "Supporter") SUPPORTER("Supporter"),
    @Json(name = "Stage 1") STAGE_1("Stage 1"),
    @Json(name = "Stage 2") STAGE_2("Stage 2"),
    @Json(name = "GX") GX("GX"),
    @Json(name = "Pok\u00E9mon Tool") POKEMON_TOOL("Pok\u00E9mon Tool"),
    @Json(name = "Basic") BASIC("Basic"),
    @Json(name = "LEGEND") LEGEND("LEGEND"),
    @Json(name = "BREAK") BREAK("BREAK"),
    @Json(name = "Rocket's Secret Machine") ROCKETS_SECRET_MACHINE("Rocket's Secret Machine"),
    @Json(name = "TAG TEAM") TAG_TEAM("TAG TEAM"),
    @Json(name = "V") V("V"),
    @Json(name = "VMAX") VMAX("VMAX");

    private String displayName;

    SubType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
