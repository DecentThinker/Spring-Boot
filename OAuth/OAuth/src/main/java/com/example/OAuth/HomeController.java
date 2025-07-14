package com.example.OAuth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController
{
    @GetMapping("/get/home")
    public String getHome(@AuthenticationPrincipal OAuth2User oAuth2User){

        String name = oAuth2User.getAttribute("name");
        Map<String, Object> userFieldsMap = oAuth2User.getAttributes();
        for (String key: userFieldsMap.keySet()){
            System.out.println(key+" :  "+userFieldsMap.get(key));
        }
        return "Welcome+"+name+" Inside the Home Page";
    }
}

