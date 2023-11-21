/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author manue
 */
public class User {

    //private Attributes for User
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    //creating Getter Methods 
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    //creating Setter Methods
    public void setUserName(String userNameIn) {
        userName = userNameIn;
    }

    public void setPassword(String passwordIn) {
        password = passwordIn;
    }

    public void setFirstName(String firstNameIn) {
        firstName = firstNameIn;
    }

    public void setLastName(String lastNameIn) {
        lastName = lastNameIn;
    }

    //creating Constructor - 0 parameters
    public User() {
        userName = "";
        password = "";
        firstName = "";
        lastName = "";
    }

    //creating Constructor - all parameters
    public User(String userNameIn, String passwordIn, String firstNameIn, String lastNameIn) {
        userName = userNameIn;
        password = passwordIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
    }

}
