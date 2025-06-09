package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping
    //localhost:8080/journal GET
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<User> getJournalById(@PathVariable ObjectId myId){
        Optional<User> journalEntry= userService.findById(myId);
        if(journalEntry.isPresent())
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalById(@PathVariable ObjectId myId){
        userService.deleteById(myId);
        return true;
    }

    @PutMapping
    public ResponseEntity<?> updateJournalById(@RequestBody User user){
         Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
         String username=authentication.getName();
        User oldEntry=userService.findByUserName(username);
        if(oldEntry!=null){
            oldEntry.setUserName(user.getUserName()!=null && !(user.getUserName().equals("")) ? user.getUserName() : oldEntry.getUserName());
            oldEntry.setPassword(user.getPassword()!=null && !(user.getPassword().equals("")) ? user.getPassword() : oldEntry.getPassword());
        }

        userService.saveEntry(oldEntry);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


