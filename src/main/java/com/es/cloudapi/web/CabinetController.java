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

    private NewRequestForm chReq = null;

    @GetMapping(value = "/cabinet")
    public String getCabinet(Model model, @AuthenticationPrincipal Person person) {
        model.addAttribute("Auth", person);
        model.addAttribute("reqList", requestRepo.findByPersonAndActiveOrderByPriorityDescNameAsc(person,true));
        model.addAttribute("chosenRequest" , chReq);
        return "cabinet";
    }





    /*
            ### Работа с запросами ###
     */
    @GetMapping(value = "/cabinet/newRequest")
    public String showPage(Model model){
        model.addAttribute("Request", new NewRequestForm());
        return "newRequest";
    }

    @PostMapping(value = "/cabinet/newRequest")
    public String sendRequest(@ModelAttribute("Request") NewRequestForm testRequest,
                              @AuthenticationPrincipal Person auth) throws IOException {

        requestService.addRequest(testRequest.getName(), testRequest.getUrl(), 0, null,
            auth, testRequest.getPriority(), testRequest.getReqType(), testRequest.getHeaders());

        return "redirect:/cabinet/newRequest";
    }

    @PostMapping(value = "/cabinet/refreshRequest")
    public String refreshRequest(@ModelAttribute("chosenRequest") NewRequestForm chosen){
        requestService.refreshRequest(chosen);
        return "redirect:/cabinet";
    }

    @PostMapping(value = "/cabinet/requestInfo")
    public String showInfo(@RequestParam Integer reqId){
        Request tmp = requestRepo.findById(reqId);
        chReq = new NewRequestForm();

        chReq.setId(reqId);
        chReq.setActive(tmp.isActive());
        chReq.setName(tmp.getName());
        chReq.setPriority(tmp.getPriority());
        chReq.setReqType(tmp.getReqType());
        chReq.setUrl(tmp.getUrl());
        chReq.setHeaders(tmp.headersToString());
        return "redirect:/cabinet";
    }
}
