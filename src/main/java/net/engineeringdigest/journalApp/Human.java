package net.engineeringdigest.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*It also creates a humN CLASS IN ioc WHOSE BEAN (OBJECT in springboot) can be autowired.

 */
public class Human {

    @Autowired
    //Dependency injection. Same as creating a dog instance in Human class.
    private Dog dog;

    @GetMapping("/pet")
    public String petLanguage(){
        return dog.fun();
    }

}
