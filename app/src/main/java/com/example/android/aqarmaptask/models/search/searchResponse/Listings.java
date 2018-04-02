
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Listings implements Parcelable {

    private String current_page_number;
    private int num_items_per_page;
    private List<Item> items = null;
    private int total_count;
    private int page_range;


    protected Listings(Parcel in) {
        current_page_number = in.readString();
        num_items_per_page = in.readInt();
        total_count = in.readInt();
        page_range = in.readInt();
        items=new ArrayList<Item>();
        in.readList(items,null);
    }

    public static final Creator<Listings> CREATOR = new Creator<Listings>() {
        @Override
        public Listings createFromParcel(Parcel in) {
            return new Listings(in);
        }

        @Override
        public Listings[] newArray(int size) {
            return new Listings[size];
        }
    };

    public String getCurrentPageNumber() {
        return current_page_number;
    }


    public int getNumItemsPerPage() {
        return num_items_per_page;
    }

    public void setNumItemsPerPage(Integer numItemsPerPage) {
        this.num_items_per_page = numItemsPerPage;
    }

    public List<Item> getItems() {
        return items;
    }


    public int getTotalCount() {
        return total_count;
    }


    public int getPageRange() {
        return page_range;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(current_page_number);
        parcel.writeInt(num_items_per_page);
        parcel.writeInt(total_count);
        parcel.writeInt(page_range);
        parcel.writeList(items);
    }
}
