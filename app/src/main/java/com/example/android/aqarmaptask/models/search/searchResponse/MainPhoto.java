
package com.example.android.aqarmaptask.models.search.searchResponse;


import java.io.Serializable;

public class MainPhoto implements Serializable {

    private int id;
    private File file;
    private String caption;
    private Object type;


    public int getId() {
        return id;
    }

    public File getFile() {
        return file;
    }

    public String getCaption() {
        return caption;
    }

    public Object getType() {
        return type;
    }


}
