package com.example.javafxanddatabase.dataBase;

public class AccountDAO {
    private int id;
    private String login;
    private String password;

    public AccountDAO(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
