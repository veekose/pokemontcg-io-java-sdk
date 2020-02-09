package io.pokemontcg.model;

import com.squareup.moshi.Json;

public enum Type {
    @Json(name = "Colorless") COLORLESS("Colorless"),
    @Json(name = "Darkness") DARKNESS("Darkness"),
    @Json(name = "Dragon") DRAGON("Dragon"),
    @Json(name = "Fairy") FAIRY("Fairy"),
    @Json(name = "Fighting") FIGHTING("Fighting"),
    @Json(name = "Fire") FIRE("Fire"),
    @Json(name = "Grass") GRASS("Grass"),
    @Json(name = "Lightning") LIGHTNING("Lightning"),
    @Json(name = "Metal") METAL("Metal"),
    @Json(name = "Psychic") PSYCHIC("Psychic"),
    @Json(name = "Water") WATER("Water"),
    @Json(name = "Free") FREE("Free");

    private String displayName;

    Type(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
