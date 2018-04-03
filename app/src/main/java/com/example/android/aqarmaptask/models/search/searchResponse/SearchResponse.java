
package com.example.android.aqarmaptask.models.search.searchResponse;


import java.io.Serializable;

public class SearchResponse implements Serializable {

    private Listings listings;


    public Listings getListings() {
        return listings;
    }

    public void setListings(Listings listings) {
        this.listings = listings;
    }

}
