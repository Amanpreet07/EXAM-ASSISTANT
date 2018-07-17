package core.blueprint;
// Purpose: To hold META values for BLUEPRINT TOP SECTION

public class Bmeta {

    private String value;      // value
    private String alias;      // alias - attribute
    private boolean isHeader;  // if its a header
    private boolean isChunk;   // if its a chunk
    private int chunkNumber;   // chunk number if exists
    private int alignment;     // left - centre - right
    private String font;       // font type and style
    private int size;          // font size

    public Bmeta(String value, String alias, boolean isHeader, boolean group,
            int groupNumber, int alignment, String font, int size) {
        this.value = value;
        this.alias = alias;
        this.isHeader = isHeader;
        this.isChunk = group;
        this.chunkNumber = groupNumber;
        this.alignment = alignment;
        this.font = font;
        this.size = size;
    }

    public Bmeta() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isIsHeader() {
        return isHeader;
    }

    public void setIsHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }

    public boolean isGroup() {
        return isChunk;
    }

    public void setGroup(boolean group) {
        this.isChunk = group;
    }

    public int getGroupNumber() {
        return chunkNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.chunkNumber = groupNumber;
    }

    public int getAlignment() {
        return alignment;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}