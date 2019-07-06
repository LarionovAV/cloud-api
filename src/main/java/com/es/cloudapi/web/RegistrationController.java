package com.es.cloudapi.web;

import com.es.cloudapi.formFillers.PersonRegistr;
import com.es.cloudapi.service.security.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private PersonService personService;
    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("personRegistr", new PersonRegistr());
        return "registration";
    }

    @GetMapping(value = "/registr")
    public String registr() {
        return "registr";
    }


    @PostMapping(value = "/registration")
    public String postRegistration(@Valid @ModelAttribute("personRegistr") PersonRegistr personRegistr, BindingResult bindingResult) {

        if (personRegistr.getPassword2() != "" && !personRegistr.getPassword().equals(personRegistr.getPassword2()))
            bindingResult.addError(new FieldError("personRegistr", "password2", "Passwords not equal"));
        if (bindingResult.hasErrors()){
            return "registration";
        }
        else {
            personService.register(personRegistr.getName(), personRegistr.getSurname(),
                personRegistr.getLogin(), personRegistr.getMail(), personRegistr.getPassword());
            return "registr";
        }

    }
}
