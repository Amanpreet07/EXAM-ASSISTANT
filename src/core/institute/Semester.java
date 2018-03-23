package core.institute;
// Purpose: To store details about the semesters within course

import java.io.Serializable;

public class Semester implements Serializable{
    
    private String number;
    private Subject subjects[];

    public Semester(String number, Subject[] subjects) {
        this.number = number;
        this.subjects = subjects;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }
    
}
