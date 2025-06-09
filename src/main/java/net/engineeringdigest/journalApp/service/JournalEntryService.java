package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryInterface;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryInterface journalEntryInterface;

    @Autowired
    private UserService userService;

    private static final Logger logger= LoggerFactory.getLogger(JournalEntryService.class);

    //makes the entire flow transactional meaning if any one of the flow fails e.g. if saving in journal entries is successful but user entries fail then all the changes i.e. new journal entry saved in journal entries will also be rolled back.
    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username){
        try {
            journalEntry.setDate(LocalDateTime.now());
            User user = userService.findByUserName(username);
            JournalEntry saved = journalEntryInterface.save(journalEntry);

            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void saveEntry(JournalEntry journalEntry){
        journalEntryInterface.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryInterface.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryInterface.findById(id);
    }

    public void deleteById(ObjectId id,String username){

        User user = userService.findByUserName(username);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryInterface.deleteById(id);

    }
}
