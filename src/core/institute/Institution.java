package core.institute;
// Purpose: To manage the institute's profile

import java.io.Serializable;

public class Institution implements Serializable{
    
    private String name;
    private String location;
    private int type; // school/college/univ/training/other
    private String admin_name;
    private String website;
    private String contact;
    private String email;
    private String linkedIn; // optional field
    private String twitter;  // optional field

    public Institution(String name, String location, int type, String admin_name, String website, String contact, String email, String linkedIn, String twitter) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.admin_name = admin_name;
        this.website = website;
        this.contact = contact;
        this.email = email;
        this.linkedIn = linkedIn;
        this.twitter = twitter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    
    
    
    
}
