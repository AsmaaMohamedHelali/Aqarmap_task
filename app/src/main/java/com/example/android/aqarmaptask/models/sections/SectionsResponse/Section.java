
package com.example.android.aqarmaptask.models.sections.SectionsResponse;


import android.os.Parcel;
import android.os.Parcelable;

public class Section implements Parcelable {

    private int id;
    private String title;
    private Boolean main;
    private Boolean searchable;

    protected Section(Parcel in) {
        id = in.readInt();
        title = in.readString();
        byte tmpMain = in.readByte();
        main = tmpMain == 0 ? null : tmpMain == 1;
        byte tmpSearchable = in.readByte();
        searchable = tmpSearchable == 0 ? null : tmpSearchable == 1;
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


    public String getTitle() {
        return title;
    }


    public Boolean getMain() {
        return main;
    }


    public Boolean getSearchable() {
        return searchable;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeByte((byte) (main == null ? 0 : main ? 1 : 2));
        parcel.writeByte((byte) (searchable == null ? 0 : searchable ? 1 : 2));
    }
}
