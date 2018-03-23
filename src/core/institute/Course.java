package core.institute;
// Purpose: To store details about the courses offered by dept.

import java.io.Serializable;

public class Course implements Serializable{
    
    private String name;
    private String type; // bachelor/graduate/post etc
    private Semester semester[];

    public Course(String name, String type, Semester[] semester) {
        this.name = name;
        this.type = type;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Semester[] getSemester() {
        return semester;
    }

    public void setSemester(Semester[] semester) {
        this.semester = semester;
    }
    
}
