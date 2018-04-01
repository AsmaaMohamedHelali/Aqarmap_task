
package com.example.android.aqarmaptask.models.locations.locationsResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class LocationsResponse implements Parcelable {

    private List<Location> locations = null;

    protected LocationsResponse(Parcel in) {
        locations=new ArrayList<Location>();
        in.readList(locations,null);

    }

    public static final Creator<LocationsResponse> CREATOR = new Creator<LocationsResponse>() {
        @Override
        public LocationsResponse createFromParcel(Parcel in) {
            return new LocationsResponse(in);
        }

        @Override
        public LocationsResponse[] newArray(int size) {
            return new LocationsResponse[size];
        }
    };

    public List<Location> getLocations() {

        if (!(locations == null))
            return locations;
        else
            return new ArrayList<Location>() ;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(locations);

    }
}
