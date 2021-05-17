package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Certification_members  extends Base{
    private Long certification_id;
    private Long teacher_id;

    public Long getCertification_id() {
        return certification_id;
    }

    public void setCertification_id(Long certification_id) {
        this.certification_id = certification_id;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public  Certification_members() {}
}
