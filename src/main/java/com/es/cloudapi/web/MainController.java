package com.es.cloudapi.web;

import com.es.cloudapi.entity.access.Person;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal Person person) {
        model.addAttribute("Auth", person);
        return "index";
    }
}
