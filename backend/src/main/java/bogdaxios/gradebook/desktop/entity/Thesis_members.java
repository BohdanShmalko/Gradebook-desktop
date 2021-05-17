package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Thesis_members extends Base {
    private String status;
    private Long thesis_id;
    private Long teacher_id;

    public Thesis_members() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getThesis_id() {
        return thesis_id;
    }

    public void setThesis_id(Long thesis_id) {
        this.thesis_id = thesis_id;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }
}
