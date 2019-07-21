package com.es.cloudapi.repository;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.entity.access.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {
    List<Request> findByPersonAndActiveOrderByPriorityDescNameAsc(Person person, boolean active);
    List<Request> findByPersonAndUrlAndActive(Person person, String url, boolean active);
    Request findById(Integer id);

}
