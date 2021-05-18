package bogdaxios.gradebook.desktop.model.marks;

import java.sql.Timestamp;

public class PracticeUnit {
    private String name;
    private int course;
    private String place;
    private String worked;
    private Timestamp from_date;
    private Timestamp to_date;
    private Long teacherId;
    private int mark;
    private String ects;
    private Long studentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getWorked() {
        return worked;
    }

    public void setWorked(String worked) {
        this.worked = worked;
    }

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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public PracticeUnit() {
    }
}
