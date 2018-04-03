
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Listings implements Serializable {

    private String current_page_number;
    private int num_items_per_page;
    private List<Item> items = null;
    private int total_count;
    private int page_range;




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



}
