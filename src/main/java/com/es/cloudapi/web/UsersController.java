package com.es.cloudapi.web;

import com.es.cloudapi.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @Autowired
    PersonRepo personRepo;


    @GetMapping(value = "/users")
    public String getUserList(Model model)
    {
        model.addAttribute("personList", personRepo.findAll());

        return "users";
    }
}
