package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Students extends Base {
    private String fullname;
    private int gradebook_number;
    private int course_admission;
    private Timestamp date_entry = new Timestamp(new Date().getTime());
    private Date date_issue = new Timestamp(new Date().getTime());
    private String photo_url = "https://thumbs.dreamstime.com/b/default-avatar-profile-image-vector-social-media-user-icon-potrait-182347582.jpg";
    private Long auth_id;
    private Long group_id;

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

    public Date getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(Date date_issue) {
        this.date_issue = date_issue;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Long getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Long auth_id) {
        this.auth_id = auth_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public Students() {
    }
}
