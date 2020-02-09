package io.pokemontcg;

public enum SetSearchParameters {
    PTCGOCODE("ptcgoCode"),
    NAME("name"),
    SERIES("series"),
    TOTALCARDS("totalCards"),
    STANDARDLEGAL("standardLegal"),
    EXPANDEDLEGAL("expandedLegal"),
    RELEASEDATE("releaseDate"),
    UPDATEDAT("updatedSince"),
    PAGE("page"),
    PAGE_SIZE("pageSize"),
    UPDATED_SINCE("updatedSince");

    private String queryParameterName;

    SetSearchParameters(String queryParameterName) {
        this.queryParameterName = queryParameterName;
    }

    @Override
    public String toString() { return this.queryParameterName; }
}
