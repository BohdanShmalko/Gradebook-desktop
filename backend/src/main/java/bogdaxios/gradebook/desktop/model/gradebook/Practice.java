package bogdaxios.gradebook.desktop.model.gradebook;

import java.sql.Timestamp;

public class Practice {
    private Timestamp from_date;
    private Timestamp to_date;
    private String teacher;
    private int mark;
    private String ects;
    private Timestamp date;

    public Timestamp getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Timestamp from_date) {
        this.from_date = from_date;
    }

    public Timestamp getTo_date() {
        return to_date;
    }

    public void setTo_date(Timestamp to_date) {
        this.to_date = to_date;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Practice() {
    }
}
