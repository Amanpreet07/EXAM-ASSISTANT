package core.extras;
// Purpose: To manage ADMIN'S NOTIFICATIONS.

import java.io.Serializable;

public class Notif implements Serializable{
    
    private boolean status;
    private String title;
    private String data;
    private String doc; // date of creation
    private int type; // for change of image for different type of images.

    public Notif(boolean status, String title, String data, String doc, int type) {
        this.status = status;
        this.title = title;
        this.data = data;
        this.doc = doc;
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    
}
