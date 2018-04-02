
package com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class PropertyType implements Parcelable {

    private int id;
    private String title;

    protected PropertyType(Parcel in) {
        id = in.readInt();
        title = in.readString();
    }

    public static final Creator<PropertyType> CREATOR = new Creator<PropertyType>() {
        @Override
        public PropertyType createFromParcel(Parcel in) {
            return new PropertyType(in);
        }

        @Override
        public PropertyType[] newArray(int size) {
            return new PropertyType[size];
        }
    };

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
