package com.es.cloudapi.service.security;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PersonService {

    @Autowired
    private  PersonRepo personRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    JavaMailSender mailSender;



    public Person register(String username, String surname, String login, String email, String password) {
        Person p = new Person();
        p.setActive(true);
        p.setLogin(login);
        p.setName(username);
        p.setSurname(surname);
        p.setPasswordHash(passwordEncoder.encode(password));
        p.setEmail(email);
        return personRepo.saveAndFlush(p);
    }

    public Person changePassword(String login, String newPassword){
        Person p = personRepo.findOneByLoginAndActive(login, true);
        p.setPasswordHash(passwordEncoder.encode(newPassword));
        return personRepo.saveAndFlush(p);
    }


    private String getRandomPassword(){
        String password = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++){
            char ch = (char) (random.nextInt('Z'-'A') + 'A');
            password += ch;
        }

        return password;
    }
    public void recovery(String username, String email) {

        String newPassword = getRandomPassword();
        changePassword(username, newPassword);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Recovery");
        message.setText("Your password has been changed to -->  " + newPassword + "   <-- Please change it after signing in!!!");

        mailSender.send(message);
    }

    public List<Person> getPersonList(){
        return personRepo.findAll();
    }
}
