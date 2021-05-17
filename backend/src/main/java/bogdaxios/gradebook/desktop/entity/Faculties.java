package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faculties extends Base {
    private String dean;
    private Long institutes_id;

    public Faculties() {
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public Long getInstitutes_id() {
        return institutes_id;
    }

    public void setInstitutes_id(Long institutes_id) {
        this.institutes_id = institutes_id;
    }
}
