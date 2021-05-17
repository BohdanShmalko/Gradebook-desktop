package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Estimates  extends Base{
    private String species_name;
    private String subject;
    private int hours;
    private int loans;
    private int mark;
    private String ects;
    private Timestamp date = new Timestamp(new Date().getTime());
    private int semester;
    private Long student_id;
    private Long teacher_id;

    public Estimates() {}

    public String getSpecies_name() {
        return species_name;
    }

    public void setSpecies_name(String species_name) {
        this.species_name = species_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getLoans() {
        return loans;
    }

    public void setLoans(int loans) {
        this.loans = loans;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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
}
