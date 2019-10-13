package main;
import javax.xml.stream.events.Attribute;

public class Reviewer {
    private String id;
    private String date;
    private String score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    @Override
    public String toString() {
       return "Reviewer: [" + id + " " + score + " " + date + "]";
    }
}
