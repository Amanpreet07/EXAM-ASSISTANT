package core.user_manager;
// Purpose : To hold data about ADMIN

import java.io.Serializable;

public class Admin implements Serializable{
 
    private String name;
    private String gender;
    private int age;
    private String doc;
    private String institution;
    private String i_id; // for admins id.
    private String position;
    private String itype; // instituition type : school, college, univ, training, other
    private String avatar;
    private String contact;
    private String email;
    private String twitter; // optional field
    private String linkedIn; // optional field
    private boolean routine; // for backup routine during shutdown

    public Admin(String name, String gender, int age, String doc, String institution, String i_id, String position, String itype, String avatar, String contact, String email, String twitter, String linkedIn, boolean routine) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.doc = doc;
        this.institution = institution;
        this.i_id = i_id;
        this.position = position;
        this.itype = itype;
        this.avatar = avatar;
        this.contact = contact;
        this.email = email;
        this.twitter = twitter;
        this.linkedIn = linkedIn;
        this.routine = routine;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
    
    public boolean isRoutine() {
        return routine;
    }

    public void setRoutine(boolean routine) {
        this.routine = routine;
    }
    
    
}
