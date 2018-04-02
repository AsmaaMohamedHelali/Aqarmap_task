
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class File implements Parcelable {

    private int id;
    private Thumbnails thumbnails;

    protected File(Parcel in) {
        id = in.readInt();
        thumbnails = in.readParcelable(Thumbnails.class.getClassLoader());

    }

    public static final Creator<File> CREATOR = new Creator<File>() {
        @Override
        public File createFromParcel(Parcel in) {
            return new File(in);
        }

        @Override
        public File[] newArray(int size) {
            return new File[size];
        }
    };

    public int getId() {
        return id;
    }


    public Thumbnails getThumbnails() {
        return thumbnails;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeParcelable(thumbnails, i);

    }
}
