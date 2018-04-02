
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class Attribute implements Parcelable {

    private int id;
    private Object listing;
    private CustomField custom_field;
    private String value;


    protected Attribute(Parcel in) {
        id = in.readInt();
        value = in.readString();
        custom_field=in.readParcelable(CustomField.class.getClassLoader());
    }

    public static final Creator<Attribute> CREATOR = new Creator<Attribute>() {
        @Override
        public Attribute createFromParcel(Parcel in) {
            return new Attribute(in);
        }

        @Override
        public Attribute[] newArray(int size) {
            return new Attribute[size];
        }
    };

    public int getId() {
        return id;
    }

    public Object getListing() {
        return listing;
    }

    public CustomField getCustom_field() {
        return custom_field;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(value);
        parcel.writeParcelable(custom_field,i);
    }
}
