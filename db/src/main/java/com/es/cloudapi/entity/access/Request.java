package com.es.cloudapi.entity.access;


import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean active = true;

    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "request_type")
    private String reqType;
    @Column(name = "http_status")
    private int httpStatus;
    @Column(name = "priority")
    private short priority;

    @ManyToOne
    private Person person;

    public Request() {
    }

    public Request(boolean active, String name, String url, String reqType, int httpStatus, short priority) {
        this.active = active;
        this.name = name;
        this.url = url;
        this.reqType = reqType;
        this.httpStatus = httpStatus;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public short getPriority() {
        return priority;
    }

    public void setPriority(short priority) {
        this.priority = priority;
    }
}
