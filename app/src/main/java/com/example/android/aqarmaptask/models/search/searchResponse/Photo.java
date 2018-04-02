
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class Photo implements Parcelable {

    private int id;
    private File file;
    private String caption;
    private Object type;

    protected Photo(Parcel in) {
        id = in.readInt();
        caption = in.readString();
        file = in.readParcelable(File.class.getClassLoader());

    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public int getId() {
        return id;
    }

    public File getFile() {
        return file;
    }

    public String getCaption() {
        return caption;
    }

    public Object getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(caption);
        parcel.writeParcelable(file, i);

    }
}
