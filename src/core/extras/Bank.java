package core.extras;
// To store scanned excel files for further use

import java.io.Serializable;

public class Bank implements Serializable {
    private String deptName;
    private String courseName;
    private String subjectName;
    private String subjectCode;
    private BankQues questions[];

    public Bank() {
    }

    public Bank(String deptName, String courseName, String subjectName, String subjectCode, BankQues[] questions) {
        this.deptName = deptName;
        this.courseName = courseName;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.questions = questions;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public BankQues[] getQuestions() {
        return questions;
    }

    public void setQuestions(BankQues[] questions) {
        this.questions = questions;
    }
    
    
}
