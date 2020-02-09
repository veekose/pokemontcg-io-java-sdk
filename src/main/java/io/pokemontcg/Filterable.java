package io.pokemontcg;

interface Filterable<E> {
    AbstractBuilder where(E parameter, String value);
    AbstractBuilder where(String value);
    void clearSearchParameters();
}
