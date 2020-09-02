package ua.kiev.prog.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class User {
    private String login;
    private String password;
    private boolean online;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String toJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public static User fromJSON(String s) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(s, User.class);
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
