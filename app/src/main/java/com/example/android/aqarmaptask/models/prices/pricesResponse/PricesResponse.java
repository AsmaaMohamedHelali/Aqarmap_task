
package com.example.android.aqarmaptask.models.prices.pricesResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class PricesResponse implements Parcelable {

    private List<PriceFilter> price_filters = null;

    protected PricesResponse(Parcel in) {
        price_filters=new ArrayList<PriceFilter>();
        in.readList(price_filters,null);

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
        if (!(price_filters == null))
            return price_filters;
        else
            return new ArrayList<PriceFilter>() ;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(price_filters);
    }
}
