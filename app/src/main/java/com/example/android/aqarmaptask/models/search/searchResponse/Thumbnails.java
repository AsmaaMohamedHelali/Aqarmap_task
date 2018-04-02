
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class Thumbnails implements Parcelable {

    private String large;
    private String small;

    protected Thumbnails(Parcel in) {
        large = in.readString();
        small = in.readString();
    }

    public static final Creator<Thumbnails> CREATOR = new Creator<Thumbnails>() {
        @Override
        public Thumbnails createFromParcel(Parcel in) {
            return new Thumbnails(in);
        }

        @Override
        public Thumbnails[] newArray(int size) {
            return new Thumbnails[size];
        }
    };

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(large);
        parcel.writeString(small);
    }
}
