package bogdaxios.gradebook.desktop.model.user;

import bogdaxios.gradebook.desktop.entity.Admins;
import bogdaxios.gradebook.desktop.entity.Auths;

public class CreateAdmin {
    private String login;
    private String password;
    private String fullname;

    public Auths getAuths() {
        Auths auths = new Auths();
        auths.setLogin(login);
        auths.setPassword(password);
        auths.setStatus("admin");
        return auths;
    }

    public Admins getAdmins() {
        Admins admins = new Admins();
        admins.setFullname(fullname);
        return admins;
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

    public CreateAdmin() {
    }
}
