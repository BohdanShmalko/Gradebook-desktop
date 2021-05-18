package bogdaxios.gradebook.desktop.model.marks;

import java.sql.Timestamp;
import java.util.List;

public class DegreeProject {
    private Long studentId;
    private String topic;
    private Timestamp submission_date;
    private Timestamp date_protection;
    private Long headId;
    private List<Long> teachers;
    private int mark;
    private String ects;
    private String decision;
    private boolean honors;
    private Timestamp date_issue;
    private int number;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Long getHeadId() {
        return headId;
    }

    public void setHeadId(Long headId) {
        this.headId = headId;
    }

    public List<Long> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Long> teachers) {
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

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public boolean isHonors() {
        return honors;
    }

    public void setHonors(boolean honors) {
        this.honors = honors;
    }

    public Timestamp getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(Timestamp date_issue) {
        this.date_issue = date_issue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public DegreeProject() {
    }
}
