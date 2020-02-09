package io.pokemontcg;

interface Filterable<E> {
    AbstractBuilder where(E parameter, String value);
    void clearSearchParameters();
}
