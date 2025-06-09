package net.engineeringdigest.journalApp;

import org.springframework.stereotype.Component;

@Component
//This annotation also creates a class in IOC whose bean(object in springboot) can be autowired.
public class Dog {

    public String fun(){
        return "Hello, I am Dog.";
    }
}
