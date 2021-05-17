package bogdaxios.gradebook.desktop.model.gradebook;

import bogdaxios.gradebook.desktop.entity.Teachers;

import java.sql.Timestamp;
import java.util.List;

public class GetDegreeProject {
    private String student_name;
    private String topic;
    private Timestamp submission_date;
    private Timestamp date_protection;
    private Teachers head;
    private List<Teachers> teachers;
    private int mark;
    private String ects;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Timestamp getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Timestamp submission_date) {
        this.submission_date = submission_date;
    }

    public Timestamp getDate_protection() {
        return date_protection;
    }

    public void setDate_protection(Timestamp date_protection) {
        this.date_protection = date_protection;
    }

    public Teachers getHead() {
        return head;
    }

    public void setHead(Teachers head) {
        this.head = head;
    }

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
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

    public GetDegreeProject() {
    }
}
