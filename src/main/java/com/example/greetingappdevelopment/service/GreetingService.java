package com.example.greetingappdevelopment.service;

import com.example.greetingappdevelopment.model.Greeting;
import com.example.greetingappdevelopment.model.User;
import com.example.greetingappdevelopment.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private static String template="Hello %s";

    @Autowired
    GreetingAppRepository repository;
    //uc2
    public String  getMessage(){
        return "Hello World";
    }
        public String getGreetingMessage(String firstName,String lastName){
        return "Hello"+firstName+" "+lastName;
    }
    public String saveMessage(User user){
        return "Hello"+user.getFirstName()+""+user.getLastName();
    }
    //uc4
    public Greeting saveMessage(Greeting greeting){
        Greeting newGreeting=new Greeting(String.format(template,greeting.getContent()));
        repository.save(newGreeting);
        return newGreeting;
    }
    //uc5
    public String getData(Integer id){
        Greeting ge=repository.getReferenceById(id);
        return ge.getContent();
    }
}
