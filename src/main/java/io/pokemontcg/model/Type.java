package io.pokemontcg.model;

import com.squareup.moshi.Json;

public enum Type {
    @Json(name = "Colorless") COLORLESS,
    @Json(name = "Darkness") DARKNESS,
    @Json(name = "Dragon") DRAGON,
    @Json(name = "Fairy") FAIRY,
    @Json(name = "Fighting") FIGHTING,
    @Json(name = "Fire") FIRE,
    @Json(name = "Grass") GRASS,
    @Json(name = "Lightning") LIGHTNING,
    @Json(name = "Metal") METAL,
    @Json(name = "Psychic") PSYCHIC,
    @Json(name = "Water") WATER,
    @Json(name = "Free") FREE;
}
