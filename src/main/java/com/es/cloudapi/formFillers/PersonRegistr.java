package com.es.cloudapi.formFillers;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class PersonRegistr {

    @Size(min = 1, max = 128, message = "Wrong name size")
    String name;

    @Length(min = 1, max = 128, message = "Wrong name size")
    String surname;

    @Length(min = 5, max = 128, message = "Wrong size")
    String login;

    @NotEmpty(message = "Password is required")
    String password;

    @NotEmpty(message = "Password is required")
    String password2;

    @Length(max = 128, message = "Email too long")
    @Email(message = "Wrong email format")
    String mail;



    public PersonRegistr() {
    }

    public PersonRegistr(String login, String password, String password2, String mail, String name, String surname) {
        this.login = login;
        this.password = password;
        this.password2 = password2;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
}
