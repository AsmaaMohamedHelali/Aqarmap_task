
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PropertyType implements Parcelable {

    private int id;
    private String title;
    private Boolean _private;
    private List<Child> children = null;


    protected PropertyType(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byte tmp_private = in.readByte();
        _private = tmp_private == 0 ? null : tmp_private == 1;
        in.readList(children,null);

    }

    public static final Creator<PropertyType> CREATOR = new Creator<PropertyType>() {
        @Override
        public PropertyType createFromParcel(Parcel in) {
            return new PropertyType(in);
        }

        @Override
        public PropertyType[] newArray(int size) {
            return new PropertyType[size];
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

    public List<Child> getChildren() {
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
        parcel.writeList(children);
    }
}
