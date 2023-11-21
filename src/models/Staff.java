/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author manue
 */
//this class inherits from User
public class Staff extends User{
    //creating new attributes
    private String position;
    private double salary;
    
    //creating getters
    public String getPosition () {return position;}
    public double getSalary () {return salary;}
    
    //creating setters
    public void setPosition (String positionIn) {position = positionIn;}
    public void setSalary (double salaryIn) {salary = salaryIn;}
    
    //creating constructors - 0 parameters
    public Staff ()
    {
        super();
        position="";
        salary=0;
    }
    
    //creating constructors - all parameters
    public Staff (String userNameIn, String passwordIn, String firstNameIn, String lastNameIn, String positionIn, double salaryIn)
    {
        super(userNameIn, passwordIn, firstNameIn, lastNameIn);
        position=positionIn;
        salary=salaryIn;
    }
    //gets the selected objects and shows the Staff user the greetings
    public String displayGreeting() {
        
        String greeting ="<html> Hello " + this.getFirstName()+" " + this.getLastname()+ "<br> You are logged in as a Staff";
        //returns the string
        return greeting;
        
            }
    
}
