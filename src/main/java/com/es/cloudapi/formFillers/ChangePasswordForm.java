package com.es.cloudapi.formFillers;

import org.hibernate.validator.constraints.Length;

public class ChangePasswordForm {

    @Length(min = 6, message = "Password too short")
    private String password;

    private String password2;

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

    public ChangePasswordForm() {
    }
}
