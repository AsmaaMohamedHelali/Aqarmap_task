
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

    private List<Photo> photos = null;
    private MainPhoto main_photo;
    private int id;
    private Object parent;
    private String title;
    private String description;
    private Section section;
    private int area;
    private int price;
    private String address;
    private Double center_lat;
    private Double center_lng;
    private int status;
    private int property_view;
    private int payment_method;
    private String video_url;
    private String published_at;
    private PropertyType property_type;
    private Location location;
    private User user;
    private List<Attribute> attributes = null;
    private List<Phone> phones = null;



    public List<Photo> getPhotos() {
        return photos;
    }


    public MainPhoto getMainPhoto() {
        return main_photo;
    }


    public int getId() {
        return id;
    }


    public Object getParent() {
        return parent;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }


    public Section getSection() {
        return section;
    }


    public int getArea() {
        return area;
    }


    public int getPrice() {
        return price;
    }


    public String getAddress() {
        return address;
    }


    public Double getCenterLat() {
        return center_lat;
    }


    public Double getCenterLng() {
        return center_lng;
    }


    public int getStatus() {
        return status;
    }


    public int getPropertyView() {
        return property_view;
    }


    public int getPaymentMethod() {
        return payment_method;
    }


    public String getVideoUrl() {
        return video_url;
    }


    public String getPublishedAt() {
        return published_at;
    }


    public PropertyType getPropertyType() {
        return property_type;
    }


    public Location getLocation() {
        return location;
    }


    public User getUser() {
        return user;
    }


    public List<Attribute> getAttributes() {
        return attributes;
    }


    public List<Phone> getPhones() {
        return phones;
    }


}
