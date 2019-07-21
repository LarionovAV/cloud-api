package com.es.cloudapi.web;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.formFillers.RecoveryPasswordForm;
import com.es.cloudapi.repository.PersonRepo;
import com.es.cloudapi.service.security.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RecoveryController {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepo personRepo;


    @GetMapping(value = "/recovery")
    public String Recovery(Model model, @AuthenticationPrincipal Person person) {
        model.addAttribute("Auth", person);
        model.addAttribute("RecoveryForm", new RecoveryPasswordForm());
        return "recovery";
    }

    @PostMapping(value = "/recovery")
    public String postRecovery(@Valid @ModelAttribute("RecoveryForm") RecoveryPasswordForm form,
                               BindingResult result) {
        Person person = personRepo.findOneByLoginAndActive(form.getLogin(), true);

        if (person == null)
            result.addError(new FieldError("RecoveryForm", "login", "Wrong login"));
        if (result.hasErrors())
            return "recovery";

        personService.recovery(form.getLogin(), form.getEmail());
        return "login";
    }
}
