package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Practices extends Base {
    private String name;
    private int course;
    private String place;
    private String worked;
    private Timestamp from_date = new Timestamp(new Date().getTime());
    private Timestamp to_date = new Timestamp(new Date().getTime());
    private int mark;
    private String ects;
    private Timestamp date = new Timestamp(new Date().getTime());
    private Long student_id;
    private Long teacher_id;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Practices() {
    }
}
