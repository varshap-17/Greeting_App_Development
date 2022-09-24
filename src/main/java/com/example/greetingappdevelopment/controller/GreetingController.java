package com.example.greetingappdevelopment.controller;

import com.example.greetingappdevelopment.model.Greeting;
import com.example.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    //uc2
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }

    //uc3
    @PutMapping("/greetingmsg")
    public ResponseEntity<String> getgreetMessage(){
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }
    //uc4
    @GetMapping("/save")
    public ResponseEntity<Greeting> savemsg(){
        return new ResponseEntity<>(greetingService.saveMessage(new Greeting()), HttpStatus.OK);
    }
    //uc5
    @GetMapping("/getbyid/{id}")
    public String byid(@PathVariable Integer id){
        return greetingService.getData(id);
    }
    //uc6
    @GetMapping("/getlist")
    public List<Greeting> getAll(){
        return greetingService.getAllData();
    }
    //uc7
    @PutMapping("/edit/{id}")
    public Greeting editbyid(@PathVariable Integer id,@RequestParam String content){
        return greetingService.editdata(editbyid(id,content));
    }

}
