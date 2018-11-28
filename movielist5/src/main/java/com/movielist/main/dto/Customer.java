package com.movielist.main.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private String login;
    private String pass;
    private String fName;

    public Customer() {}

    public Customer(String login, String pass, String name) {
        this.login = login;
        this.pass = pass;
        this.fName = name;
    }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }

    @Override
    public String toString() { return login + " " + pass + " " + fName; }
}
