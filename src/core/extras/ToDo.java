package core.extras;
// Purpose: To manage the TODO lists for the admin
public class ToDo {
    
   private String title;
   private String dot; // date of target
   private String doc; // date of creation
   private boolean status; // active/deleted

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
