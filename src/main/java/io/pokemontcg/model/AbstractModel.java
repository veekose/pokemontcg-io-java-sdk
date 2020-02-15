package io.pokemontcg.model;

public class AbstractModel {
    private String links;
    private int pageSize;
    private int count;
    private int totalCount;
    private String rateLimit;
    private String rateLimitRemaining;

    public String getLinks() { return links; }
    public void setLinks(String links) { this.links = links; }

    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public int getTotalCount() { return totalCount; }
    public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

    public String getRateLimit() { return rateLimit; }
    public void setRateLimit(String rateLimit) { this.rateLimit = rateLimit; }

    public String getRateLimitRemaining() { return rateLimitRemaining; }
    public void setRateLimitRemaining(String rateLimitRemaining) { this.rateLimitRemaining = rateLimitRemaining; }
}
