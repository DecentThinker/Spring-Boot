package com.example.Security;

public class CreateUserRequest
{
    String username;
    String password;
    String role;


    public CreateUserRequest(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public CreateUserRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
