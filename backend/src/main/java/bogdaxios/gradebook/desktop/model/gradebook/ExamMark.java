package bogdaxios.gradebook.desktop.model.gradebook;

import bogdaxios.gradebook.desktop.entity.Teachers;

import java.util.List;

public class ExamMark {
    private int mark;
    private String ects;
    private List<Teachers> teachers;

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

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
    }

    public ExamMark() {
    }
}
