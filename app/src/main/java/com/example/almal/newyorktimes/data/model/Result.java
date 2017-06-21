
package com.example.almal.newyorktimes.data.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("section")

    private String section;
    @SerializedName("subsection")

    private String subsection;
    @SerializedName("title")

    private String title;
    @SerializedName("abstract")

    private String _abstract;
    @SerializedName("url")

    private String url;
    @SerializedName("byline")

    private String byline;
    @SerializedName("item_type")

    private String itemType;
    @SerializedName("updated_date")

    private String updatedDate;
    @SerializedName("created_date")

    private String createdDate;
    @SerializedName("published_date")

    private String publishedDate;
    @SerializedName("material_type_facet")

    private String materialTypeFacet;
    @SerializedName("kicker")

    private String kicker;
    @SerializedName("des_facet")

    private List<String> desFacet = null;
    @SerializedName("org_facet")

    private List<Object> orgFacet = null;
    @SerializedName("per_facet")

    private List<Object> perFacet = null;
    @SerializedName("geo_facet")

    private List<String> geoFacet = null;
    @SerializedName("multimedia")

    private List<Multimedium> multimedia = null;
    @SerializedName("short_url")

    private String shortUrl;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getMaterialTypeFacet() {
        return materialTypeFacet;
    }

    public void setMaterialTypeFacet(String materialTypeFacet) {
        this.materialTypeFacet = materialTypeFacet;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    public List<Object> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(List<Object> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public List<Object> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(List<Object> perFacet) {
        this.perFacet = perFacet;
    }

    public List<String> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(List<String> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    @Override
    public String toString() {
        return "Result{" +
                "section='" + section + '\'' +
                ", subsection='" + subsection + '\'' +
                ", title='" + title + '\'' +
                ", _abstract='" + _abstract + '\'' +
                ", url='" + url + '\'' +
                ", byline='" + byline + '\'' +
                ", itemType='" + itemType + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", materialTypeFacet='" + materialTypeFacet + '\'' +
                ", kicker='" + kicker + '\'' +
                ", desFacet=" + desFacet +
                ", orgFacet=" + orgFacet +
                ", perFacet=" + perFacet +
                ", geoFacet=" + geoFacet +
                ", multimedia=" + multimedia +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }


}
