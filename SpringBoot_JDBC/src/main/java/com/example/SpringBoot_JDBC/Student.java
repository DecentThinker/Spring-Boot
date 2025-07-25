package com.example.SpringBoot_JDBC;

public class Student
{
    String username;
    String email;
    String password;

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
