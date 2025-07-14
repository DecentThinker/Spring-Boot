package com.example.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class productionDatabase implements DbConnect
{

    @Override
    public void connectWithDatabase() {
        System.out.println("Connected to production database");
    }
}
