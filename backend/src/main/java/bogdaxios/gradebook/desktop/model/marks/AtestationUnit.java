package bogdaxios.gradebook.desktop.model.marks;

import bogdaxios.gradebook.desktop.entity.Teachers;

import java.util.List;

public class AtestationUnit {
    private  Long studentId;
    private String name;
    private int mark;
    private String ects;
    private List<Long> teachers;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Long> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Long> teachers) {
        this.teachers = teachers;
    }

    public AtestationUnit() {
    }
}
