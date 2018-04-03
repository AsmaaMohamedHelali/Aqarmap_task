
package com.example.android.aqarmaptask.models.search.searchResponse;


import java.io.Serializable;
import java.util.List;

public class Child implements Serializable {

    private int id;
    private String title;
    private Boolean _private;
    private List<Child_> children = null;



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean get_private() {
        return _private;
    }

    public List<Child_> getChildren() {
        return children;
    }


}
