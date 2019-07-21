package com.es.cloudapi.web;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.entity.access.Request;
import com.es.cloudapi.repository.PersonRepo;
import com.es.cloudapi.repository.RequestRepo;
import org.hibernate.secure.spi.PermissibleAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    RequestRepo requestRepo;
    @RequestMapping("/api/login/{url}")
    public HttpEntity someFunc(@PathVariable String url, HttpServletRequest request, @AuthenticationPrincipal Person person){
        List<Request> requests = requestRepo.findByPersonAndActiveOrderByPriorityDescNameAsc(person, true);
        return null;
    }

}
