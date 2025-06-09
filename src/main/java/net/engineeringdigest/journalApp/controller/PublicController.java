package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
/* Signifies the following class is a special type of component. Besides being a component it can handle HTTP requests.
* */
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping
    //This handles all get requests to /health-check endpoint.
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createEntry(@RequestBody User user){
        try{
            userService.saveEntry(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
        }

    }
}
