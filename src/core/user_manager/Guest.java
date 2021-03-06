package core.user_manager;
// Purpose: To hold data about GUEST

import java.io.Serializable;

public class Guest implements Serializable{
    
    private String name;
    private String i_id; // user's id (host institution)
    private String contact; // optional field

    public Guest(String name, String i_id, String contact) {
        this.name = name;
        this.i_id = i_id;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}
