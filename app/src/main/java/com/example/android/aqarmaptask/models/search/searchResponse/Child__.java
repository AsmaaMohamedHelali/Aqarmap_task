
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class Child__ implements Parcelable {

    private int id;
    private String title;
    private String slug;

    protected Child__(Parcel in) {
        id = in.readInt();
        title = in.readString();
        slug = in.readString();
    }

    public static final Creator<Child__> CREATOR = new Creator<Child__>() {
        @Override
        public Child__ createFromParcel(Parcel in) {
            return new Child__(in);
        }

        @Override
        public Child__[] newArray(int size) {
            return new Child__[size];
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(slug);
    }
}
