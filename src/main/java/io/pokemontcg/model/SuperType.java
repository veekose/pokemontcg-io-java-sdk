package io.pokemontcg.model;

import com.squareup.moshi.Json;

public enum SuperType  {
    @Json(name = "Energy") ENERGY("Energy"),
    @Json(name = "Pok\u00E9mon") POKEMON("Pok\u00E9mon"),
    @Json(name = "Trainer") TRAINER("Trainer");

    private String displayName;

    SuperType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
