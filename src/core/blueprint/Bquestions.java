package core.blueprint;
// Purpose: To hold questions for blueprint

public class Bquestions {
    
    private String value; // question 
    private String type;  // short or long
    private int marks;    // marks

    public Bquestions(String value, String type, int marks) {
        this.value = value;
        this.type = type;
        this.marks = marks;
    }

    public Bquestions() {
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
