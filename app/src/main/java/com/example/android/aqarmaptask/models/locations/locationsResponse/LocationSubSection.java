
package com.example.android.aqarmaptask.models.locations.locationsResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LocationSubSection implements Parcelable {

    private int id;
    private String title;
    private Boolean searchable;
    private List<Object> children = null;

    protected LocationSubSection(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byte tmpSearchable = in.readByte();
        searchable = tmpSearchable == 0 ? null : tmpSearchable == 1;
    }

    public static final Creator<LocationSubSection> CREATOR = new Creator<LocationSubSection>() {
        @Override
        public LocationSubSection createFromParcel(Parcel in) {
            return new LocationSubSection(in);
        }

        @Override
        public LocationSubSection[] newArray(int size) {
            return new LocationSubSection[size];
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
        parcel.writeByte((byte) (searchable == null ? 0 : searchable ? 1 : 2));
    }
}
