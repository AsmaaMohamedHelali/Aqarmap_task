
package com.example.android.aqarmaptask.models.search.searchResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Item implements Parcelable {

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


    protected Item(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        area = in.readInt();
        price = in.readInt();
        address = in.readString();
        if (in.readByte() == 0) {
            center_lat = null;
        } else {
            center_lat = in.readDouble();
        }
        if (in.readByte() == 0) {
            center_lng = null;
        } else {
            center_lng = in.readDouble();
        }
        status = in.readInt();
        property_view = in.readInt();
        payment_method = in.readInt();
        video_url = in.readString();
        published_at = in.readString();
        photos = new ArrayList<Photo>();
        in.readList(photos, null);

        attributes = new ArrayList<Attribute>();
        in.readList(attributes, null);

        phones = new ArrayList<Phone>();
        in.readList(phones, null);

        user = in.readParcelable(User.class.getClassLoader());
        main_photo = in.readParcelable(MainPhoto.class.getClassLoader());


        location = in.readParcelable(Location.class.getClassLoader());
        section = in.readParcelable(Section.class.getClassLoader());
        property_type = in.readParcelable(PropertyType.class.getClassLoader());


    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(area);
        parcel.writeInt(price);
        parcel.writeString(address);
        if (center_lat == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(center_lat);
        }
        if (center_lng == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(center_lng);
        }
        parcel.writeInt(status);
        parcel.writeInt(property_view);
        parcel.writeInt(payment_method);
        parcel.writeString(video_url);
        parcel.writeString(published_at);

        parcel.writeParcelable(user, i);
        parcel.writeParcelable(main_photo, i);
        parcel.writeParcelable(section, i);
        parcel.writeParcelable(property_type, i);
        parcel.writeParcelable(location, i);





        parcel.writeList(attributes);
        parcel.writeList(phones);
        parcel.writeList(photos);

    }
}
