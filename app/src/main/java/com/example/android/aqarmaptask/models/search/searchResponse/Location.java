
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class Location implements Serializable {

    private int id;
    private String title;
    private String slug;
    private Boolean searchable;
    private Boolean estimate;
    private List<Child__> children = null;


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public Boolean getEstimate() {
        return estimate;
    }

    public List<Child__> getChildren() {
        return children;
    }


}
