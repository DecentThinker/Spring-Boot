package com.example.JUnitAndMockito.mocking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

//    @Spy
//    //if we mark a class as spy the function which are not defined returns null.
//    // but those which are defined gives the actual implementation result.
//    UserService userService;

    //To tell the userService class know that we want to use the mock userRepository object
    //and not the which is autowired in UserService class;
    @InjectMocks
    UserService userService;


    @Mock
    UserRepository userRepository;

    @Test
    void returnFirstNameCharacter()
    {
        //defining the stubbing
//        when(userService.getUser()).thenReturn(new User(1,"Aman","aman@gmail.com"));
//        char ch = userService.returnFirstNameCharacter(1);
//        Assertions.assertEquals(ch,'A');

        when(userRepository.findUserById(anyInt())).thenReturn(new User(1,"Aman", "aman@gmail.com"));
        char ch = userService.returnFirstNameCharacter(3);
        Assertions.assertEquals(ch,'A');
    }
}