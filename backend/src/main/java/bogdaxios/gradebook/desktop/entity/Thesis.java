package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Thesis extends Base {
    private String topic;
    private Timestamp submission_date = new Timestamp(new Date().getTime());
    private Timestamp date_protection = new Timestamp(new Date().getTime());
    private String decision;
    private boolean honors;
    private int number;
    private int mark;
    private String ects;
    private Timestamp date_issue = new Timestamp(new Date().getTime());
    private Long student_id;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public Timestamp getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(Timestamp date_issue) {
        this.date_issue = date_issue;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Thesis() {
    }
}
