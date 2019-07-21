package com.es.cloudapi.repository;

import com.es.cloudapi.entity.access.RequestHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepo extends JpaRepository<RequestHeader, Integer> {
    RequestHeader findByHeader(String header);
}
