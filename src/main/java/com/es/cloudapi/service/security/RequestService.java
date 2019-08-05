package com.es.cloudapi.service.security;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.entity.access.Request;
import com.es.cloudapi.entity.access.RequestHeader;
import com.es.cloudapi.formFillers.NewRequestForm;
import com.es.cloudapi.repository.HeaderRepo;
import com.es.cloudapi.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RequestService {
    @Autowired
    RequestRepo requestRepo;
    @Autowired
    HeaderService headerService;

    public Request addRequest(String name, String url, int HTTPStatus, String body, Person owner, short priority, String method, String headers){
        Request newReq = new Request();
        newReq.setActive(true);
        newReq.setHttpStatus(HTTPStatus);
        newReq.setName(name);
        newReq.setPriority(priority);
        newReq.setReqType(method);
        newReq.setUrl(url);
        newReq.setPerson(owner);
        newReq.setContent(body);

        setHeaderSet(newReq, headers);

        requestRepo.saveAndFlush(newReq);
        return newReq;
    }
    public Request refreshRequest(Request req){

        setHeaderSet(req, req.getHeadersString());
        requestRepo.saveAndFlush(req);
        return req;
    }

    private void setHeaderSet(Request req, String headers){
        Set<RequestHeader> headerSet = new HashSet<>();
        String[] allHeaders = headers.split("\\r|\\n");
        for (String header: allHeaders) {
            header = header.replaceAll("\\s", "");
            if (!header.equals("")) {
                RequestHeader tmp = headerService.addHeader(header);
                headerSet.add(tmp);
            }
        }
        req.setHeaders(headerSet);
    }
}
