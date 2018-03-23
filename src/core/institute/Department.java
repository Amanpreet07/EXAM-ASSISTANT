package core.institute;
// Purpose: To store details about the departments

import java.io.Serializable;

public class Department implements Serializable {
    
    private String name;
    private String head_name;
    private Course course[];

    public Department(String name, String head_name, Course[] course) {
        this.name = name;
        this.head_name = head_name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead_name() {
        return head_name;
    }

    public void setHead_name(String head_name) {
        this.head_name = head_name;
    }

    public Course[] getCourse() {
        return course;
    }

    public void setCourse(Course[] course) {
        this.course = course;
    }
    
}
