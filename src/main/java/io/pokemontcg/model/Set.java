package io.pokemontcg.model;

public class Set {
    private String code;
    private String ptcgoCode;
    private String name;
    private String series;
    private int totalCards;
    private boolean standardLegal;
    private boolean expandedLegal;
    private String releaseDate;
    private String symbolUrl;
    private String logoUrl;
    private String updatedAt;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getPtcgoCode() { return ptcgoCode; }
    public void setPtcgoCode(String ptcgoCode) { this.ptcgoCode = ptcgoCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSeries() { return series; }
    public void setSeries(String series) { this.series = series; }

    public int getTotalCards() { return totalCards; }
    public void setTotalCards(int totalCards) { this.totalCards = totalCards; }

    public boolean getStandardLegal() { return standardLegal; }
    public void setStandardLegal(Boolean standardLegal) { this.standardLegal = standardLegal; }

    public boolean getExpandedLegal() { return expandedLegal; }
    public void setExpandedLegal(Boolean expandedLegal) { this.expandedLegal = expandedLegal; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getSymbolUrl() { return symbolUrl; }
    public void setSymbolUrl(String symbolUrl) { this.symbolUrl = symbolUrl; }

    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
