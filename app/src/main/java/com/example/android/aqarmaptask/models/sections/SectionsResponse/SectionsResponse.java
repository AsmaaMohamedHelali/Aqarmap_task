
package com.example.android.aqarmaptask.models.sections.SectionsResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class SectionsResponse implements Parcelable {

    private List<Section> sections = null;

    protected SectionsResponse(Parcel in) {
//        this.sections = in.readL;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SectionsResponse> CREATOR = new Creator<SectionsResponse>() {
        @Override
        public SectionsResponse createFromParcel(Parcel in) {
            return new SectionsResponse(in);
        }

        @Override
        public SectionsResponse[] newArray(int size) {
            return new SectionsResponse[size];
        }
    };

    public List<Section> getSections() {

        if (!(sections == null))
            return sections;
        else
            return new ArrayList<Section>() ;
    }


}
