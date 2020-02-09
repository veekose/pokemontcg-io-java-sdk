package io.pokemontcg;

public enum CardSearchParameters {
    ID("id"),
    NAME("name"),
    NATIONAL_POKEDEX_NUMBER("nationalPokedexNumber"),
    TYPES("types"),
    SUPER_TYPE("superType"),
    SUB_TYPE("subType"),
    EVOLVES_FROM("evolvesFrom"),
    ANCIENT_TRAIT("ancientTrait"),
    HP("hp"),
    RETREAT_COST("retreatCost"),
    CONVERTED_RETREAT_COST("convertedRetreatCost"),
    NUMBER("number"),
    ARTIST("artist"),
    RARITY("rarity"),
    SERIES("series"),
    SET("set"),
    SET_CODE("setCode"),
    TEXT("text"),
    RESISTANCES("resistances"),
    WEAKNESSES("weaknesses"),
    ATTACK_DAMAGE("attackDamage"),
    ATTACK_COST("attackCost"),
    ATTACK_NAME("attackName"),
    ATTACK_TEXT("attackText"),
    ABILITY_NAME("abilityName"),
    ABILITY_TEXT("abilityText"),
    ABILITY_TYPE("abilityType"),
    CONTAINS("contains"),
    PAGE("page"),
    PAGE_SIZE("pageSize");

    private String queryParameterName;

    CardSearchParameters(String queryParameterName) {
        this.queryParameterName = queryParameterName;
    }

    @Override
    public String toString() { return this.queryParameterName; }
}
