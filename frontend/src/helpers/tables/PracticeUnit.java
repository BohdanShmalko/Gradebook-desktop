package helpers.tables;

public class PracticeUnit {
    int mark;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PracticeUnit(int mark, String from, String to, String teachers, String ects, String date) {
        this.mark = mark;
        this.from = from;
        this.to = to;
        this.teachers = teachers;
        this.ects = ects;
        this.date = date;
    }

    String from, to, teachers, ects, date;
}
