
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Child implements Parcelable{

    private int id;
    private String title;
    private Boolean _private;
    private List<Child_> children = null;

    protected Child(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byte tmp_private = in.readByte();
        _private = tmp_private == 0 ? null : tmp_private == 1;
        children = in.createTypedArrayList(Child_.CREATOR);
    }

    public static final Creator<Child> CREATOR = new Creator<Child>() {
        @Override
        public Child createFromParcel(Parcel in) {
            return new Child(in);
        }

        @Override
        public Child[] newArray(int size) {
            return new Child[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean get_private() {
        return _private;
    }

    public List<Child_> getChildren() {
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
        parcel.writeByte((byte) (_private == null ? 0 : _private ? 1 : 2));
        parcel.writeTypedList(children);
    }
}
