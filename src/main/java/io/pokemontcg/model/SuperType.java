package io.pokemontcg.model;

public enum SuperType {
    ENERGY("Energy"),
    POKEMON("Pokémon"),
    TRAINER("Trainer");

    private String displayName;

    SuperType(String displayName) {
        this.displayName = displayName;
    }
}
