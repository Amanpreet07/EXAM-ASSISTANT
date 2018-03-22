package core;
// Purpose: to hold intermidiate values during background processing.
// singleton class to store values
public class Holder {
    
    private String one;
    private String two;

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }
    private static Holder holder;

    public static Holder getInstance() {
        return holder;
    }

    private Holder(){  // private constructor to make it singleton
        
    }
    
    
    
}
