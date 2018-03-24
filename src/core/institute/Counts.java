package core.institute;
// Purpose: To store counts of other parameters

import java.io.Serializable;

public class Counts implements Serializable{
    
    private int departments;
    private int courses;
    private int semesters;
    private int subjects;

    public Counts(int departments, int courses, int semesters, int subjects) {
        this.departments = departments;
        this.courses = courses;
        this.semesters = semesters;
        this.subjects = subjects;
    }

    public int getDepartments() {
        return departments;
    }

    public void setDepartments(int departments) {
        this.departments = departments;
    }

    public int getCourses() {
        return courses;
    }

    public void setCourses(int courses) {
        this.courses = courses;
    }

    public int getSemesters() {
        return semesters;
    }

    public void setSemesters(int semesters) {
        this.semesters = semesters;
    }

    public int getSubjects() {
        return subjects;
    }

    public void setSubjects(int subjects) {
        this.subjects = subjects;
    }
    
}
