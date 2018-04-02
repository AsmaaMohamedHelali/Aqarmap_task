
package com.example.android.aqarmaptask.models.search.searchResponse;


import android.os.Parcel;
import android.os.Parcelable;


public class SearchResponse implements Parcelable {

    private Listings listings;

    protected SearchResponse(Parcel in) {
        listings = in.readParcelable(Listings.class.getClassLoader());
    }

    public static final Creator<SearchResponse> CREATOR = new Creator<SearchResponse>() {
        @Override
        public SearchResponse createFromParcel(Parcel in) {
            return new SearchResponse(in);
        }

        @Override
        public SearchResponse[] newArray(int size) {
            return new SearchResponse[size];
        }
    };

    public Listings getListings() {
        return listings;
    }

    public void setListings(Listings listings) {
        this.listings = listings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(listings, i);
    }
}
