
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class File implements Serializable {

    private int id;
    private Thumbnails thumbnails;

    public int getId() {
        return id;
    }


    public Thumbnails getThumbnails() {
        return thumbnails;
    }



}
