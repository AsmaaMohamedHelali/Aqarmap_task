
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class MainPhoto implements Parcelable {

    private int id;
    private File file;
    private String caption;
    private Object type;

    protected MainPhoto(Parcel in) {
        id = in.readInt();
        caption = in.readString();
        file = in.readParcelable(File.class.getClassLoader());

    }

    public static final Creator<MainPhoto> CREATOR = new Creator<MainPhoto>() {
        @Override
        public MainPhoto createFromParcel(Parcel in) {
            return new MainPhoto(in);
        }

        @Override
        public MainPhoto[] newArray(int size) {
            return new MainPhoto[size];
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
        parcel.writeParcelable(file,i);
    }
}
