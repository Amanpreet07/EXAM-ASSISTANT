package core.blueprint;
// Purpose: To hold values for blueprint instructions

public class Binstructions {

    private String value;
    private int alignment;
    private int size;
    private String font;

    public Binstructions() {
    }

    public Binstructions(String value, int alignment, int size, String font) {
        this.value = value;
        this.alignment = alignment;
        this.size = size;
        this.font = font;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

}
