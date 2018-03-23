package core.institute;
// Purpose: To store details about the subjects in each semester

import java.io.Serializable;

public class Subject implements Serializable{
    
    private String name;
    private String code;
    private String credits;

    public Subject(String name, String code, String credits) {
        this.name = name;
        this.code = code;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }
    
}
