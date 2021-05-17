package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specialties extends Base {
    private String name;
    private int number_name;
    private Long faculties_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_name() {
        return number_name;
    }

    public void setNumber_name(int number_name) {
        this.number_name = number_name;
    }

    public Long getFaculties_id() {
        return faculties_id;
    }

    public void setFaculties_id(Long faculties_id) {
        this.faculties_id = faculties_id;
    }

    public Specialties() {
    }
}
