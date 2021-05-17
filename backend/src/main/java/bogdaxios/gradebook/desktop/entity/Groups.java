package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Groups extends Base {
    private String name;
    private String cafeda;
    private String training_direction;
    private String educational_level;
    private String form_education;
    private Long specialty_id;

    public Groups() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCafeda() {
        return cafeda;
    }

    public void setCafeda(String cafeda) {
        this.cafeda = cafeda;
    }

    public String getTraining_direction() {
        return training_direction;
    }

    public void setTraining_direction(String training_direction) {
        this.training_direction = training_direction;
    }

    public String getEducational_level() {
        return educational_level;
    }

    public void setEducational_level(String educational_level) {
        this.educational_level = educational_level;
    }

    public String getForm_education() {
        return form_education;
    }

    public void setForm_education(String form_education) {
        this.form_education = form_education;
    }

    public Long getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(Long specialty_id) {
        this.specialty_id = specialty_id;
    }
}
