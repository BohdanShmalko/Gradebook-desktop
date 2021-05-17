package bogdaxios.gradebook.desktop.model.user;

import bogdaxios.gradebook.desktop.entity.Groups;

public class CreateGroup {
    private String name;
    private String cafedra;
    private String training_direction;
    private String educational_level;
    private String form_education;
    private Long specialty_id;

    public Groups getGroups() {
        Groups groups = new Groups();
        groups.setName(name);
        groups.setCafeda(cafedra);
        groups.setTraining_direction(training_direction);
        groups.setEducational_level(educational_level);
        groups.setForm_education(form_education);
        groups.setSpecialty_id(specialty_id);
        return groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCafedra() {
        return cafedra;
    }

    public void setCafedra(String cafedra) {
        this.cafedra = cafedra;
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

    public CreateGroup() {
    }
}
