package com.es.cloudapi.web;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.formFillers.ChangePasswordForm;
import com.es.cloudapi.service.security.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ChangePasswordController {

    @Autowired
    private PersonService personService;


    @GetMapping(value = "/change-password")
    public String showPage(Model model, @AuthenticationPrincipal Person person){
        model.addAttribute("chpform", new ChangePasswordForm());
        model.addAttribute("Auth", person);
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(@Valid @ModelAttribute("chpform") ChangePasswordForm form,
                                 @AuthenticationPrincipal Person person,
                                 BindingResult result){
        if (!form.getPassword().equals(form.getPassword2()))
            result.addError(new FieldError("chpform", "password2", "passwords not equal"));

        if (result.hasErrors()){
            return "change-password";
        }

        personService.changePassword(person.getLogin(), form.getPassword());
        return "redirect:cabinet";
    }
}
