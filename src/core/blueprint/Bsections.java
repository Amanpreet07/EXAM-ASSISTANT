package core.blueprint;
// Purpose: To hold sections in blueprint
public class Bsections {
    
    private String label;
    private String font;
    private int alignment;
    private int size;
    private int qsize;
    private int qalignment;
    private Bquestions ques[];
    private int marksVisibilty; // not using...
    

    public Bsections(String label, String font, int alignment, int size, int marksVisibilty, int qsize, int qalignment, Bquestions[] ques) {
        this.label = label;
        this.font = font;
        this.alignment = alignment;
        this.size = size;
        this.marksVisibilty = marksVisibilty;
        this.qsize = qsize;
        this.qalignment = qalignment;
        this.ques = ques;
    }

    public Bsections() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getAlignment() {
        return alignment;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMarksVisibilty() {
        return marksVisibilty;
    }

    public void setMarksVisibilty(int marksVisibilty) {
        this.marksVisibilty = marksVisibilty;
    }

    public int getQsize() {
        return qsize;
    }

    public void setQsize(int qsize) {
        this.qsize = qsize;
    }

    public int getQalignment() {
        return qalignment;
    }

    public void setQalignment(int qalignment) {
        this.qalignment = qalignment;
    }

    public Bquestions[] getQues() {
        return ques;
    }

    public void setQues(Bquestions[] ques) {
        this.ques = ques;
    }
    
    
    
}
