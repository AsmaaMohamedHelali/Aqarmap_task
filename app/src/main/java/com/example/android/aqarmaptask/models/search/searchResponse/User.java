
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String username;
    private String full_name;



    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public String getFullName() {
        return full_name;
    }



}
