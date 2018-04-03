
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class CustomField implements Serializable {

    private String name;
    private String label;
    private String type;



    public String getName() {
        return name;
    }


    public String getLabel() {
        return label;
    }


    public String getType() {
        return type;
    }


}
