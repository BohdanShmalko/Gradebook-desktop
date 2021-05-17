package bogdaxios.gradebook.desktop.model.gradebook;

import java.sql.Timestamp;

public class GetInf {
    private String fullname;
    private int gradebook_number;
    private int course_admission;
    private Timestamp date_entry;
    private Timestamp date_issue;
    private String photoURL;
    private String group;
    private String dean;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGradebook_number() {
        return gradebook_number;
    }

    public void setGradebook_number(int gradebook_number) {
        this.gradebook_number = gradebook_number;
    }

    public int getCourse_admission() {
        return course_admission;
    }

    public void setCourse_admission(int course_admission) {
        this.course_admission = course_admission;
    }

    public Timestamp getDate_entry() {
        return date_entry;
    }

    public void setDate_entry(Timestamp date_entry) {
        this.date_entry = date_entry;
    }

    public Timestamp getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(Timestamp date_issue) {
        this.date_issue = date_issue;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public GetInf() {
    }
}
