/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.HashMap;

/**
 *
 * @author manue
 */
//this class inherits from User
public class Customer extends User{
    //creating new attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postCode;
    private boolean isRegistered;
    private HashMap<Integer, Order> orders;
    
    //creating Getters
    public String getAddressLine1 () {return addressLine1;}
    public String getAddressLine2 () {return addressLine2;}
    public String getTown () {return town;}
    public String getPostCode () {return postCode;}
    public boolean getIsRegistered () {return isRegistered;}
    public HashMap<Integer, Order> getOrders() {return orders;}
    
    //creating Setters
    public void setAddressLine1 (String addressLine1In) {addressLine1 = addressLine1In;}
    public void setAddressLine2 (String addressLine2In) {addressLine2 = addressLine2In;}
    public void setGetTown (String townIn) {town = townIn;}
    public void setPostCode (String postCodeIn) {postCode = postCodeIn;}
    public void setIsRegistered (boolean isRegisteredIn) {isRegistered = isRegisteredIn;}
    public void setOrders (HashMap<Integer, Order> ordersIn) {orders = ordersIn;}

    //creating Constructor - 0 parameters. Orders is set to a new hashmap
    public Customer ()
    {
        super();
        addressLine1="";
        addressLine2="";
        town="";
        postCode="";
        isRegistered=false;
        orders=new HashMap();
    }
    
    //constructor - everything except isRegistered
    public Customer (String userNameIn, String passwordIn, String firstNameIn, String lastNameIn, String addressLine1In, String addressLine2In, String townIn, String postCodeIn)
    {
        super(userNameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1=addressLine1In;
        addressLine2=addressLine2In;
        town=townIn;
        postCode=postCodeIn;
        orders=new HashMap();
    }
    //gets the selected objects and shows the Staff user the greetings
    public String displayGreeting() {
        
        String greeting ="<html> Welcome " + this.getFirstName()+ " " + this.getLastname() +"<br> Enjoy Shopping!";
        //return the string
        return greeting;
        
    }
    
}