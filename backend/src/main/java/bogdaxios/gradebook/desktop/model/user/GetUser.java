package bogdaxios.gradebook.desktop.model.user;

import bogdaxios.gradebook.desktop.entity.Auths;

public class GetUser {
    private String login;
    private String password;

    public Auths getAuths() {
        Auths auths = new Auths();
        auths.setLogin(login);
        auths.setPassword(password);
        return auths;
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

    public GetUser() {
    }
}
