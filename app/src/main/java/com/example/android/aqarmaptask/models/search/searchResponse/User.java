
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int id;
    private String username;
    private String full_name;

    protected User(Parcel in) {
        id = in.readInt();
        username = in.readString();
        full_name = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public String getFullName() {
        return full_name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(username);
        parcel.writeString(full_name);
    }
}
