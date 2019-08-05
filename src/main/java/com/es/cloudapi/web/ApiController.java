package com.es.cloudapi.web;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.entity.access.Request;
import com.es.cloudapi.entity.access.RequestHeader;
import com.es.cloudapi.repository.PersonRepo;
import com.es.cloudapi.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    RequestRepo requestRepo;
    @Autowired
    PersonRepo personRepo;

    @RequestMapping("/api/{login}/**")
    public HttpEntity someMethod(@PathVariable String login, HttpServletRequest request) {
        Person person = personRepo.findOneByLoginAndActive(login ,true);
        String url = "";
        if (person != null) {
            url = request.getRequestURI().replaceFirst("/api/" + login + "/", "");
            List<Request> requests = requestRepo.findByPersonAndUrlAndActive(person, url, true);
            for (Request req : requests) {
                if (req.getReqType().equalsIgnoreCase(request.getMethod()) || req.getReqType().equals("")){
                    HttpHeaders headers = new HttpHeaders();
                    for (RequestHeader header : req.getHeaders()) {
                        String[] headerFields = header.getHeader().split(":");
                        headers.add(headerFields[0], headerFields[1]);
                    }
                    return new ResponseEntity(req.getContent(), headers, HttpStatus.valueOf(req.getHttpStatus()));
                }
            }
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
