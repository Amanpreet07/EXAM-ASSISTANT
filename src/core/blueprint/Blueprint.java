package core.blueprint;
// Purpose: To manage the structure of blueprints

import java.io.Serializable;

public class Blueprint implements Serializable{
    
    // global prop
    // -> FONT : TIMES NEW ROMAN
    
    // Exam Properties - metadata
    // One or two of these can be choosen as headers
    // other can be in order or in chunk
    // ->writeAs, in header, in group, partner, alignment, size, fonttype 
    // -> Date  
    // -> Subcode 
    // -> SubName 
    // -> Course  
    // -> class and sem  
    // -> Institution Name
    // -> Exam type
    // -> Department 
    // -> Weightage 
    // -> Time alloted 
    
    // instruction properties..
    // max of 10 instructions
    
    // questions...
    // -> sections... if NOT, default is 1.
    // -> marks visibility : No/after question:atomic/on section label:net/Both
    // if multiple, can be supported by section labels and their weightage.
    
    // for instructions.. to make a instruction header, make first as a heading.
    // with alias as required by the user
    
//    private final String FONT = FontFactory.TIMES_ROMAN;
//    private final String FONTB = FontFactory.TIMES_BOLD;
//    private final String FONTI = FontFactory.TIMES_ITALIC;
//    private final String FONTBI = FontFactory.TIMES_BOLDITALIC;
    
    // variables ↓↓↓
    
    private Bmeta bmeta[];         // meta data array
    private boolean Ins;           // if instructions are required 
    private boolean insStyleUnique; // if instructions  have unique style
    private String insFont;        // font if not unique
    private int insSize;           // size if not unique 
    private int insAlignment;      // alignment if not unique 
    private Binstructions bins[];  // instructions array
    private int sectionCount;      // number of sections 
    private int sectionQuestionCount[]; // array of count of questions in sections
    private Bsections bsec[];      // section array 

    public Blueprint(Bmeta[] bmeta, boolean Ins, boolean insStyleUnique, String insFont, int insSize, int insAlignment, Binstructions[] bins, int sectionCount, int[] sectionQuestionCount, Bsections[] bsec) {
        this.bmeta = bmeta;
        this.Ins = Ins;
        this.insStyleUnique = insStyleUnique;
        this.insFont = insFont;
        this.insSize = insSize;
        this.insAlignment = insAlignment;
        this.bins = bins;
        this.sectionCount = sectionCount;
        this.sectionQuestionCount = sectionQuestionCount;
        this.bsec = bsec;
    }

    public Blueprint() {
    }

    public Bmeta[] getBmeta() {
        return bmeta;
    }

    
    public void setBmeta(Bmeta[] bmeta) {
        this.bmeta = bmeta;
    }

    public boolean isIns() {
        return Ins;
    }

    public void setIns(boolean Ins) {
        this.Ins = Ins;
    }

    public boolean isInsStyleUnique() {
        return insStyleUnique;
    }

    public void setInsStyleUnique(boolean insStyleUnique) {
        this.insStyleUnique = insStyleUnique;
    }

    public String getInsFont() {
        return insFont;
    }

    public void setInsFont(String insFont) {
        this.insFont = insFont;
    }

    public int getInsSize() {
        return insSize;
    }

    public void setInsSize(int insSize) {
        this.insSize = insSize;
    }

    public int getInsAlignment() {
        return insAlignment;
    }

    public void setInsAlignment(int insAlignment) {
        this.insAlignment = insAlignment;
    }

    public Binstructions[] getBins() {
        return bins;
    }

    public void setBins(Binstructions[] bins) {
        this.bins = bins;
    }

    public int getSectionCount() {
        return sectionCount;
    }

    public void setSectionCount(int sectionCount) {
        this.sectionCount = sectionCount;
    }

    public int[] getSectionQuestionCount() {
        return sectionQuestionCount;
    }

    public void setSectionQuestionCount(int[] sectionQuestionCount) {
        this.sectionQuestionCount = sectionQuestionCount;
    }

    public Bsections[] getBsec() {
        return bsec;
    }

    public void setBsec(Bsections[] bsec) {
        this.bsec = bsec;
    }
    
    
}
