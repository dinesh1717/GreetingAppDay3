package com.bridgelabz.greetingapp.contoller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IgreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private IgreetingService greetingService;

    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }


    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }


    @GetMapping("/path/{id}")
    public Greeting getGreetingById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }


    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable Long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }


    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }
}