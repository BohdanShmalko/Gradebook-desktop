package models;

import helpers.JSON;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Authorize {
    private String login;
    private String password;
    private boolean remember = false;
    private String token;

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Authorize(String login, String password, boolean remember) {
        this.login = login;
        this.password = password;
        this.remember = remember;
    }

    public Authorize() {}

    public Authorize(String json) {
        try {
            JSONObject db = JSON.parse(json);
            this.login = (String) db.get("login");
            this.password = (String) db.get("password");
            this.remember = (boolean) db.get("remember");
            this.token = (String) db.get("token");
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
}
