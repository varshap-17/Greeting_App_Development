package com.example.greetingappdevelopment.service;

import com.example.greetingappdevelopment.model.Greeting;
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
}
