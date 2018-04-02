
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Location implements Parcelable {

    private int id;
    private String title;
    private String slug;
    private Boolean searchable;
    private Boolean estimate;
    private List<Child__> children = null;

    protected Location(Parcel in) {
        id = in.readInt();
        title = in.readString();
        slug = in.readString();
        byte tmpSearchable = in.readByte();
        searchable = tmpSearchable == 0 ? null : tmpSearchable == 1;
        byte tmpEstimate = in.readByte();
        estimate = tmpEstimate == 0 ? null : tmpEstimate == 1;
        in.readList(children,null);

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

    public String getSlug() {
        return slug;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public Boolean getEstimate() {
        return estimate;
    }

    public List<Child__> getChildren() {
        return children;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(slug);
        parcel.writeByte((byte) (searchable == null ? 0 : searchable ? 1 : 2));
        parcel.writeByte((byte) (estimate == null ? 0 : estimate ? 1 : 2));
        parcel.writeList(children);
    }
}
