package com.example.greetingappdevelopment.model;

public class User {
    public String firstName;
    public String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public User(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
