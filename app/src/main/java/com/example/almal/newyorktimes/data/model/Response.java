
package com.example.almal.newyorktimes.data.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("status")

    private String status;
    @SerializedName("copyright")
    
    private String copyright;
    @SerializedName("section")

    private String section;
    @SerializedName("last_updated")

    private String lastUpdated;
    @SerializedName("num_results")

    private Integer numResults;
    @SerializedName("results")

    private List<Result> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


}
