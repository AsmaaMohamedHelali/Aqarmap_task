
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class CustomField implements Parcelable {

    private String name;
    private String label;
    private String type;

    protected CustomField(Parcel in) {
        name = in.readString();
        label = in.readString();
        type = in.readString();
    }

    public static final Creator<CustomField> CREATOR = new Creator<CustomField>() {
        @Override
        public CustomField createFromParcel(Parcel in) {
            return new CustomField(in);
        }

        @Override
        public CustomField[] newArray(int size) {
            return new CustomField[size];
        }
    };

    public String getName() {
        return name;
    }


    public String getLabel() {
        return label;
    }


    public String getType() {
        return type;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(label);
        parcel.writeString(type);
    }
}
