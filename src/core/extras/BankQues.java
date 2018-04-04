package core.extras;
// To store questions for bank
public class BankQues {
    
    private String chapter;
    private String topic;
    private String question;
    private String type;
    private String difficulty;
    private double marks;
    private boolean active;
    
    public BankQues() {
    }

    public BankQues(String chapter, String topic, String question, String type, String difficulty, double marks) {
        this.chapter = chapter;
        this.topic = topic;
        this.question = question;
        this.type = type;
        this.difficulty = difficulty;
        this.marks = marks;
        this.active = true;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTopic() {
        return topic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    
}
