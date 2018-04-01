
package com.example.android.aqarmaptask.models.prices.pricesResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class Section implements Parcelable {

    private int id;

    protected Section(Parcel in) {
        id = in.readInt();
    }

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };

    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
    }
}
