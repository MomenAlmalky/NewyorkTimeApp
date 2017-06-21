package com.example.almal.newyorktimes.data.local;

import com.example.almal.newyorktimes.data.model.Result;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by almal on 2017-06-20.
 */

public class Stories_Local extends RealmObject {

    String section;
    String image;
    String title;
    String publishData;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishData() {
        return publishData;
    }

    public void setPublishData(String publishData) {
        this.publishData = publishData;
    }
}
