package com.example.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//Another way to select profile is using the profile annotation and set the profile name
//then use that same profile name in corresponding application-production.properties file.
//there we can change the port ,database , etc.
@Profile("development")
public class develpmentDatabase implements DbConnect {

    @Override
    public void connectWithDatabase() {
        System.out.println("Connected to development database");
    }
}
