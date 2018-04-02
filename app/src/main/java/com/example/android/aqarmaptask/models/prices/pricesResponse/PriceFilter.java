
package com.example.android.aqarmaptask.models.prices.pricesResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class PriceFilter implements Parcelable {

    private int value;
    private Section section;

    protected PriceFilter(Parcel in) {
        value = in.readInt();
        section = in.readParcelable(Section.class.getClassLoader());
    }

    public static final Creator<PriceFilter> CREATOR = new Creator<PriceFilter>() {
        @Override
        public PriceFilter createFromParcel(Parcel in) {
            return new PriceFilter(in);
        }

        @Override
        public PriceFilter[] newArray(int size) {
            return new PriceFilter[size];
        }
    };

    public int getValue() {
        return value;
    }


    public Section getSection() {
        return section;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(value);
        parcel.writeParcelable(section, i);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
