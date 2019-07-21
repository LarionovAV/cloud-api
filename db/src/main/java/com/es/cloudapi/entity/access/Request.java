package com.es.cloudapi.entity.access;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean active;
    private String name;
    private String url;
    @Column(name = "request_type")
    private String reqType;
    @Column(name = "http_status")
    private int httpStatus;
    @Column(name = "priority")
    private short priority;
    @Column(name = "content")
    private String content;

    @ManyToOne(targetEntity = Person.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(targetEntity = RequestHeader.class,fetch = FetchType.EAGER)
    @JoinTable(
        name = "req_head_ref",
        joinColumns = {@JoinColumn(name = "request_id")},
        inverseJoinColumns = {@JoinColumn(name = "header_id")}
    )
    private Set<RequestHeader> headers = new HashSet<>();
    public Request() {
    }

    public Set<RequestHeader> getHeaders() {
        return headers;
    }

    public String headersToString(){
        String result = "";
        for (RequestHeader header : headers){
            result += header.getHeader() + "\n";
        }
        return result;
    }

    public void setHeaders(Set<RequestHeader> headers) {
        this.headers = headers;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
