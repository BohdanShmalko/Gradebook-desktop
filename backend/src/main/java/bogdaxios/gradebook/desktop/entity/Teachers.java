package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;

@Entity
public class Teachers extends Base {
    private String name;
    private String surname;

    public Teachers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    private String fathername;
}
