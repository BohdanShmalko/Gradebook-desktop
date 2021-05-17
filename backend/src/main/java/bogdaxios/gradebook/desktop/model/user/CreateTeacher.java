package bogdaxios.gradebook.desktop.model.user;

import bogdaxios.gradebook.desktop.entity.Teachers;

public class CreateTeacher {
    private String name;
    private String surname;
    private String fathername;

    public Teachers getTeachers() {
        Teachers teachers = new Teachers();
        teachers.setName(name);
        teachers.setSurname(surname);
        teachers.setFathername(fathername);
        return teachers;
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

    public CreateTeacher() {
    }
}
