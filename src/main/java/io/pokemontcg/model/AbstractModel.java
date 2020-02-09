package io.pokemontcg.model;

public class AbstractModel {
    private String links;
    private String pageSize;
    private String count;
    private String totalCount;
    private String rateLimit;
    private String rateLimitRemaining;

    public String getLinks() { return links; }
    public void setLinks(String links) { this.links = links; }

    public String getPageSize() { return pageSize; }
    public void setPageSize(String pageSize) { this.pageSize = pageSize; }

    public String getCount() { return count; }
    public void setCount(String count) { this.count = count; }

    public String getTotalCount() { return totalCount; }
    public void setTotalCount(String totalCount) { this.totalCount = totalCount; }

    public String getRateLimit() { return rateLimit; }
    public void setRateLimit(String rateLimit) { this.rateLimit = rateLimit; }

    public String getRateLimitRemaining() { return rateLimitRemaining; }
    public void setRateLimitRemaining(String rateLimitRemaining) { this.rateLimitRemaining = rateLimitRemaining; }
}
