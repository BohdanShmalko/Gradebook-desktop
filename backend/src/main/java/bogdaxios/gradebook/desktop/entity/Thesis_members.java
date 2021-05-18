package bogdaxios.gradebook.desktop.entity;

import javax.persistence.*;

@Entity
public class Thesis_members extends Base {
    private String status;
    @Column(name = "thesis_id")
    private Long thesisId;
    private Long teacher_id;

    public Thesis_members() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getThesisId() {
        return thesisId;
    }

    public void setThesisId(Long thesisId) {
        this.thesisId = thesisId;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }
}
