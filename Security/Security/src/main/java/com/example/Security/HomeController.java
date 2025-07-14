package com.example.Security;

import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/get/home")
    public String getHome()
    {
        return "Inside the home method";
    }

    @GetMapping("/get/private")
    public String getPrivate()
    {
        return "Inside private Method";

    }

    @GetMapping("/get/admin")
    public String getAdmin()
    {
        return "Inside Admin Method";
    }

    //Any PostMapping request won't be completed without csrf token passed in Headers.Following method will be
    //used to get the CSRF token and then later will be used for any post request when csrf will be enabled.

    @GetMapping("/get/csrf")
    public CsrfToken getCSRFToken(HttpServletRequest httpServletRequest)
    {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
}
