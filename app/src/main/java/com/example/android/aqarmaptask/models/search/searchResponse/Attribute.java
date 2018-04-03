
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Attribute implements Serializable{

    private int id;
    private Object listing;
    private CustomField custom_field;
    private String value;




    public int getId() {
        return id;
    }

    public CustomField getCustom_field() {
        return custom_field;
    }

    public String getValue() {
        return value;
    }


}
