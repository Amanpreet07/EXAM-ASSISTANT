package core.extras;
// Purpose: To manage the TODO lists for the admin

import java.io.Serializable;

public class ToDo implements Serializable{
    
   private String title;
   private String dot; // date of target
   private String doc; // date of creation
   private boolean status; // active/deleted

    public ToDo(String title, String dot, String doc, boolean status) {
        this.title = title;
        this.dot = dot;
        this.doc = doc;
        this.status = status;
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

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
   
   
}
