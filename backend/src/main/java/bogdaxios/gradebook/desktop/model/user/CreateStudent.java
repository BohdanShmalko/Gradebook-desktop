package bogdaxios.gradebook.desktop.model.user;

import bogdaxios.gradebook.desktop.entity.Auths;
import bogdaxios.gradebook.desktop.entity.Students;

public class CreateStudent {
    private String login;
    private String password;
    private String fullname;
    private int gradebook_number;
    private int course_admission;
    private String photoUrl;
    private Long group_id;

    public Auths getAuths() {
        Auths auths = new Auths();
        auths.setLogin(login);
        auths.setPassword(password);
        auths.setStatus("student");
        return auths;
    }

    public Students getStudents() {
        Students students = new Students();
        students.setFullname(fullname);
        students.setGradebook_number(gradebook_number);
        students.setCourse_admission(course_admission);
        students.setGroup_id(group_id);
        return students;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGradebook_number() {
        return gradebook_number;
    }

    public void setGradebook_number(int gradebook_number) {
        this.gradebook_number = gradebook_number;
    }

    public int getCourse_admission() {
        return course_admission;
    }

    public void setCourse_admission(int course_admission) {
        this.course_admission = course_admission;
    }

    public String getPhotoURL() {
        return photoUrl;
    }

    public void setPhotoURL(String photoURL) {
        this.photoUrl = photoURL;
    }

    public CreateStudent() {
    }
}
