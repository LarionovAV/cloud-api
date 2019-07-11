package com.es.cloudapi.web;

import com.es.cloudapi.abstracts.HTTPRequesting;
import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.formFillers.RequestList;
import com.es.cloudapi.formFillers.TestRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CabinetController {

    private RequestList requests = RequestList.getInstance();

    @GetMapping(value = "/cabinet")
    public String getCabinet(Model model, @AuthenticationPrincipal Person person) {
        model.addAttribute("Auth", person);
        model.addAttribute("reqList", requests.getReqList());
        model.addAttribute("tRequest", new TestRequest());
        return "cabinet";
    }

    @PostMapping(value = "/cabinet")
    public String sendRequest(@ModelAttribute("tRequest") TestRequest testRequest,
        HttpServletRequest request, HttpServletResponse response){
        HTTPRequesting.getHTTPRequestInfo(request, response);
        return "redirect:cabinet";
    }
}
