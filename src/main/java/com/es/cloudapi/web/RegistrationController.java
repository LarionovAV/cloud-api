package com.es.cloudapi.web;

import com.es.cloudapi.formFillers.PersonFormRegistration;
import com.es.cloudapi.repository.PersonRepo;
import com.es.cloudapi.service.security.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepo personRepo;

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("personFormRegistration", new PersonFormRegistration());
        return "registration";
    }

    @GetMapping(value = "/registr")
    public String registr() {
        return "registr";
    }


    @PostMapping(value = "/registration")
    public String postRegistration(@Valid @ModelAttribute("personFormRegistration") PersonFormRegistration personFormRegistration, BindingResult bindingResult) {

        if (personFormRegistration.getPassword2() != "" && !personFormRegistration.getPassword().equals(personFormRegistration.getPassword2()))
            bindingResult.addError(new FieldError("personFormRegistration", "password2", "Passwords not equal"));

        if (personRepo.findOneByLoginAndActive(personFormRegistration.getLogin(), true) != null)
            bindingResult.addError(new FieldError("personFormRegistration", "login", "Login is occupied, please use another one"));

        if (bindingResult.hasErrors()){
            return "registration";
        }
        else {
            personService.register(personFormRegistration.getName(), personFormRegistration.getSurname(),
                personFormRegistration.getLogin(), personFormRegistration.getMail(), personFormRegistration.getPassword());
            return "registr";
        }

    }
}
