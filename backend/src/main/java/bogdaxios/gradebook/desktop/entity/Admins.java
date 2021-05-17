package bogdaxios.gradebook.desktop.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admins extends Base {
    @Column(name = "fullname")
    private String fullname;
    private Long faculties_id;
    private Long auth_id;

    public Admins() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getFaculties_id() {
        return faculties_id;
    }

    public void setFaculties_id(Long faculties_id) {
        this.faculties_id = faculties_id;
    }

    public Long getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Long auth_id) {
        this.auth_id = auth_id;
    }
}
