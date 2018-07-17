package core.blueprint;
// Purpose: To hold sections in blueprint

public class Bsections {
    
    private String label;       // label of the section header
    private String font;        // font size 
    private int alignment;      // alignment of header L-C-R
    private int size;           // header font size
    private int qsize;          // question size
    private int qalignment;     // question alignment
    private boolean isShort;    // type of questions within section
    private Bquestions ques[];  // array of questions
    private int marksVisibilty; // *** if showing marks at header
    

    public Bsections(String label, String font, boolean isShort, int alignment, int size, int marksVisibilty, int qsize, int qalignment, Bquestions[] ques) {
        this.label = label;
        this.font = font;
        this.alignment = alignment;
        this.size = size;
        this.isShort = isShort;
        this.marksVisibilty = marksVisibilty;
        this.qsize = qsize;
        this.qalignment = qalignment;
        this.ques = ques;
    }

    public Bsections() {
    }

    public boolean isIsShort() {
        return isShort;
    }

    public void setIsShort(boolean isShort) {
        this.isShort = isShort;
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
