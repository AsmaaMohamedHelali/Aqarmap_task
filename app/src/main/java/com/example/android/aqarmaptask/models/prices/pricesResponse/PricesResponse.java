
package com.example.android.aqarmaptask.models.prices.pricesResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class PricesResponse implements Parcelable {

    private List<PriceFilter> priceFilters = null;

    protected PricesResponse(Parcel in) {
        priceFilters=new ArrayList<PriceFilter>();
        in.readList(priceFilters,null);

    }

    public static final Creator<PricesResponse> CREATOR = new Creator<PricesResponse>() {
        @Override
        public PricesResponse createFromParcel(Parcel in) {
            return new PricesResponse(in);
        }

        @Override
        public PricesResponse[] newArray(int size) {
            return new PricesResponse[size];
        }
    };

    public List<PriceFilter> getPriceFilters() {
        if (!(priceFilters == null))
            return priceFilters;
        else
            return new ArrayList<PriceFilter>() ;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(priceFilters);
    }
}
