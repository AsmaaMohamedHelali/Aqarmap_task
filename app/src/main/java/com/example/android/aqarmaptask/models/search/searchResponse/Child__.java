
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Child__  implements Serializable {

    private int id;
    private String title;
    private String slug;

    protected Child__(Parcel in) {
        id = in.readInt();
        title = in.readString();
        slug = in.readString();
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getSlug() {
        return slug;
    }


}
