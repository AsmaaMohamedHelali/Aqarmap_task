
package com.example.android.aqarmaptask.models.locations.locationsResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Location implements Parcelable {

    private int id;
    private String title;
    private Boolean searchable;
    private List<LocationSection> sections = null;

    protected Location(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byte tmpSearchable = in.readByte();
        searchable = tmpSearchable == 0 ? null : tmpSearchable == 1;
        sections=new ArrayList<LocationSection>();
        in.readList(sections,null);

    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }



    public List<LocationSection> getSections() {

        if (!(sections == null))
            return sections;
        else
            return new ArrayList<LocationSection>() ;
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
        parcel.writeList(sections);

    }
}
