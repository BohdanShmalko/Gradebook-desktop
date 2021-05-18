package bogdaxios.gradebook.desktop.entity;

import javax.persistence.*;

@Entity
public class Certification_members  extends Base{
    @Column(name = "certification_id")
    private Long certificationId;
    private Long teacher_id;

    public Long getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Long certificationId) {
        this.certificationId = certificationId;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public  Certification_members() {}
}
