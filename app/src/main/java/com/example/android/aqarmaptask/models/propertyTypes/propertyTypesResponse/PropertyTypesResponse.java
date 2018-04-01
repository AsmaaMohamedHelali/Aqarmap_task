
package com.example.android.aqarmaptask.models.propertyTypes.propertyTypesResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class PropertyTypesResponse implements Parcelable {

    private List<PropertyType> propertyTypes = null;

    protected PropertyTypesResponse(Parcel in) {
        propertyTypes = in.createTypedArrayList(PropertyType.CREATOR);
    }

    public static final Creator<PropertyTypesResponse> CREATOR = new Creator<PropertyTypesResponse>() {
        @Override
        public PropertyTypesResponse createFromParcel(Parcel in) {
            return new PropertyTypesResponse(in);
        }

        @Override
        public PropertyTypesResponse[] newArray(int size) {
            return new PropertyTypesResponse[size];
        }
    };

    public List<PropertyType> getPropertyTypes() {
        if (!(propertyTypes == null))
            return propertyTypes;
        else
            return new ArrayList<PropertyType>() ;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(propertyTypes);
    }
}
