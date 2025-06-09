//package net.engineeringdigest.journalApp.service;
//
//import net.engineeringdigest.journalApp.entity.User;
//import net.engineeringdigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.*;
//import org.mockito.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//public class UserDetailsServiceImplTests {
//
//    @InjectMocks
//    private UserDetailsServiceImpl userDetailsServiceImpl;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//    @Test
//    void loadUserByUsername(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(new User("ram","gvjhvh"));
//        UserDetails user = userDetailsServiceImpl.loadUserByUsername("ram");
//        assertNotNull(user);
//    }
//
//
//}
