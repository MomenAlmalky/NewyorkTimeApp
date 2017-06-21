
package com.example.almal.newyorktimes.data.model;

import com.google.gson.annotations.SerializedName;

public class Multimedium {

    @SerializedName("url")

    private String url;
    @SerializedName("format")

    private String format;
    @SerializedName("height")

    private Integer height;
    @SerializedName("width")

    private Integer width;
    @SerializedName("type")

    private String type;
    @SerializedName("subtype")

    private String subtype;
    @SerializedName("caption")

    private String caption;
    @SerializedName("copyright")

    private String copyright;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }


}
