
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Section implements Serializable {

    private int id;
    private String title;
    private Boolean main;
    private Boolean searchable;



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getMain() {
        return main;
    }

    public Boolean getSearchable() {
        return searchable;
    }


}
