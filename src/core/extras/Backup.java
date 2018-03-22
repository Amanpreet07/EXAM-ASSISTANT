package core.extras;
// Purpose: To manage backups

import java.io.Serializable;

public class Backup implements Serializable{
    
    private String title;
    private String doc;
    private String location;
    private String size;

    public Backup(String title, String doc, String location, String size) {
        this.title = title;
        this.doc = doc;
        this.location = location;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
    
}
