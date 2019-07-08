package com.es.cloudapi.formFillers;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class PersonFormRegistration {

    @Size(min = 1, max = 128, message = "Wrong name size")
    private String name;

    @Length(min = 1, max = 128, message = "Wrong name size")
    private String surname;

    @Length(min = 5, max = 128, message = "Wrong size")
    private String login;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Password is required")
    private String password2;

    @Length(max = 128, message = "Email too long")
    @Email(message = "Wrong email format")
    private String mail;



    public PersonFormRegistration() {
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
