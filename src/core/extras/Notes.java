package core.extras;
// Purpose: To manage NOTES for the ADMIN

import java.io.Serializable;

public class Notes implements Serializable{
   
    private String title;
    private String data;
    private String doc; // date of creation
    private boolean status; // active/deleted

    public Notes(String title, String data, String doc, boolean status) {
        this.title = title;
        this.data = data;
        this.doc = doc;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
