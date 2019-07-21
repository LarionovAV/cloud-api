package com.es.cloudapi.service.security;

import com.es.cloudapi.entity.access.RequestHeader;
import com.es.cloudapi.repository.HeaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {
    @Autowired
    HeaderRepo headerRepo;

    public RequestHeader addHeader(String header){
        RequestHeader newHeader  = headerRepo.findByHeader(header);
        if (newHeader == null) {
            newHeader = new RequestHeader();
            newHeader.setHeader(header);
            headerRepo.saveAndFlush(newHeader);
        }
        return newHeader;
    }
}
