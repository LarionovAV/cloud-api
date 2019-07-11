package com.es.cloudapi.entity.access;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean active = true;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "password_hash")
    private String passwordHash;
    private String surname;
    private String name;
    private String email;
    private String patronymic;

    @Column(name = "incorrect_login_count")
    private short incorrectLoginCount;
    @Column(name = "blocked_password")
    private boolean blockedPassword;
    @Column(name = "blocked_admin")
    private boolean blockedAdmin;
    @Column(name = "date_add", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public Person() {

    }

    public Person(Integer id, boolean active, String login, String email, String name, String surname, String patronymic, String passwordHash, short incorrectLoginCount, boolean blockedPassword, boolean blockedAdmin) {
        this.id = id;
        this.active = active;
        this.login = login;
        this.email = email;
        this.name=name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.passwordHash = passwordHash;
        this.incorrectLoginCount = incorrectLoginCount;
        this.blockedPassword = blockedPassword;
        this.blockedAdmin = blockedAdmin;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public short getIncorrectLoginCount() {
        return incorrectLoginCount;
    }

    public void setIncorrectLoginCount(short incorrectLoginCount) {
        this.incorrectLoginCount = incorrectLoginCount;
    }

    public boolean isBlockedPassword() {
        return blockedPassword;
    }

    public void setBlockedPassword(boolean blockedPassword) {
        this.blockedPassword = blockedPassword;
    }

    public boolean isBlockedAdmin() {
        return blockedAdmin;
    }

    public void setBlockedAdmin(boolean blockedAdmin) {
        this.blockedAdmin = blockedAdmin;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getFio() {
        return (surname == null ? "" : surname) + " " +
               (name == null ? "" : name) + " " +
               (patronymic == null ? "" : patronymic);
    }


    @Override
    public int hashCode() { return Objects.hashCode(id); }

    @Override
    public boolean equals(Object object) {
        return (object instanceof Person) && Objects.equals(id, ((Person) object).id);
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", active=" + active +
               ", login='" + login + '\'' +
               ", mail='" + email + '\'' +
               ", passwordHash='" + passwordHash + '\'' +
               ", surname='" + surname + '\'' +
               ", name='" + name + '\'' +
               ", patronymic='" + patronymic + '\'' +
               ", incorrectLoginCount=" + incorrectLoginCount +
               ", blockedPassword=" + blockedPassword +
               ", blockedAdmin=" + blockedAdmin +
               ", dateAdd=" + dateAdd +
               '}';
    }
}
