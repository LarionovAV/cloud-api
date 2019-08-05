package com.es.cloudapi.web;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.entity.access.Request;
import com.es.cloudapi.formFillers.NewRequestForm;
import com.es.cloudapi.repository.HeaderRepo;
import com.es.cloudapi.repository.RequestRepo;
import com.es.cloudapi.service.security.HeaderService;
import com.es.cloudapi.service.security.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class CabinetController {
    @Autowired
    RequestRepo requestRepo;
    @Autowired
    HeaderRepo headerRepo;
    @Autowired
    RequestService requestService;
    @Autowired
    HeaderService headerService;

    private Request chReq = null;

    @GetMapping(value = "/cabinet")
    public String getCabinet(Model model, @AuthenticationPrincipal Person person) {
        model.addAttribute("Auth", person);
        model.addAttribute("reqList", requestRepo.findByPersonOrderByActiveDescPriorityDescNameAsc(person));
        model.addAttribute("chosenRequest" , chReq);
        return "cabinet";
    }





    /*
            ### Работа с запросами ###
     */
    @GetMapping(value = "/cabinet/newRequest")
    public String showPage(Model model){
        model.addAttribute("Request", new Request());
        return "newRequest";
    }

    @PostMapping(value = "/cabinet/newRequest")
    public String saveRequest(@ModelAttribute("Request") Request request,
                              @AuthenticationPrincipal Person auth){

        requestService.addRequest(request.getName(), request.getUrl(), request.getHttpStatus(), request.getContent(),
            auth, request.getPriority(), request.getReqType(), request.getHeadersString());

        return "redirect:/cabinet/newRequest";
    }

    @PostMapping(value = "/cabinet/refreshRequest")
    public String refreshRequest(@ModelAttribute("chosenRequest") Request chosen){
        chReq = requestService.refreshRequest(chosen);
        return "redirect:/cabinet";
    }

    @PostMapping(value = "/cabinet/requestInfo")
    public String showInfo(@RequestParam Integer reqId){
        chReq = requestRepo.findById(reqId);

        return "redirect:/cabinet";
    }
}
