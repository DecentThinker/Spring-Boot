package com.example.JUnitAndMockito.mocking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public char returnFirstNameCharacter(int id)
    {
//        User user = userRepository.findUserById(id);
        User user = getUser();
        if(user==null)
            return '/';

        String name  = user.getName();
        return name.charAt(0);
    }

    public User getUser()
    {
        return null;
    }
}
