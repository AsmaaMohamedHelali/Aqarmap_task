
package com.example.android.aqarmaptask.models.locations.locationsResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class LocationSection implements Parcelable {

    private int id;
    private String title;
    private Boolean searchable;
    private List<LocationSubSection> children = null;

    protected LocationSection(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byte tmpSearchable = in.readByte();
        searchable = tmpSearchable == 0 ? null : tmpSearchable == 1;
        children=new ArrayList<LocationSubSection>();
        in.readList(children,null);

    }

    public static final Creator<LocationSection> CREATOR = new Creator<LocationSection>() {
        @Override
        public LocationSection createFromParcel(Parcel in) {
            return new LocationSection(in);
        }

        @Override
        public LocationSection[] newArray(int size) {
            return new LocationSection[size];
        }
    };

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }




    public List<LocationSubSection> getSubSections() {

        if (!(children == null))
            return children;
        else
            return new ArrayList<LocationSubSection>() ;
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
        parcel.writeList(children);
    }

    @Override
    public String toString() {
        return title;
    }
}
