package com.example.greetingappdevelopment.controller;

import com.example.greetingappdevelopment.model.Greeting;
import com.example.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    private static final String template="Hello %s!";
    private final AtomicInteger counter= new AtomicInteger();

    @Autowired
    GreetingService greetingService;
    //uc1
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue = "world")String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    @PostMapping("/postgreeting")
    public Greeting sayHello(@RequestBody Greeting greeting){
        return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getContent()));
    }

    @PutMapping("/putgreeting/{counter}")
    public Greeting sayhello(@PathVariable int counter,@RequestParam(value="content") String content){
        return new Greeting(counter,String.format(template,content));
    }
}
