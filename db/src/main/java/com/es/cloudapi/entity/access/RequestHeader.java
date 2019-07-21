package com.es.cloudapi.entity.access;

import javax.persistence.*;

@Entity
@Table(name = "header")
public class RequestHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "head")
    private String header;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public RequestHeader() {
    }
}
