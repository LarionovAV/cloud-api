package com.es.cloudapi.formFillers;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class RecoveryPasswordForm {
    @NotBlank(message = "Field shouldn't be empty")
    private String login;
    @NotBlank(message = "Field shouldn't be empty")
    @Email(message = "Wrong email")
    private String email;

    public RecoveryPasswordForm() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
