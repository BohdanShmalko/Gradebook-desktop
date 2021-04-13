package helpers.tables;

public class ExamMark {
    int mark;
    String ects, commision;

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

    public String getCommision() {
        return commision;
    }

    public void setCommision(String commision) {
        this.commision = commision;
    }

    public ExamMark(int mark, String ects, String commision) {
        this.mark = mark;
        this.ects = ects;
        this.commision = commision;
    }
}
