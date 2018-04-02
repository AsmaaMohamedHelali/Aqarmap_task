
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class Child_  implements Parcelable{

    private int id;
    private String title;
    private Boolean _private;

    protected Child_(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byte tmp_private = in.readByte();
        _private = tmp_private == 0 ? null : tmp_private == 1;
    }

    public static final Creator<Child_> CREATOR = new Creator<Child_>() {
        @Override
        public Child_ createFromParcel(Parcel in) {
            return new Child_(in);
        }

        @Override
        public Child_[] newArray(int size) {
            return new Child_[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeByte((byte) (_private == null ? 0 : _private ? 1 : 2));
    }
}
