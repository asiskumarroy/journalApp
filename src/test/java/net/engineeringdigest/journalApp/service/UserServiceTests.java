package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//to start the application before testing otherwise the beans will be null.
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName(){
        assertNotNull(userRepository.findByUserName("vipul"));
    }

    //to provide dynamic values to function tests. Each comma separated value in csv source represents value of name in every iteration
    @ParameterizedTest
    @CsvSource({
            "vipul",
            "roy"
    })
    public void parameterizedTestFindByUserName(String name){
        assertNotNull(userRepository.findByUserName(name),"failed for "+name);
    }
}
