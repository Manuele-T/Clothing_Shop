/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author manue
 */
//this class inherits from Product
public class Clothing extends Product {
    //creating new attributes
    private String measurement;
    
    //creating Getters
    public String getMeasurement () {return measurement;}
    
    //creating Setters
    public void setMeasurement (String measurementIn) {measurement = measurementIn;}
    
    //creating constructor - 0 parameters
    public Clothing()
    {
        super();
        measurement="";
    }
    
    //creating constructor - everything except productId
    public Clothing(String productNameIn, double priceIn, int stockLevelIn, String measurementIn)
    {
        super(productNameIn, priceIn, stockLevelIn);
        measurement=measurementIn;
    }
    
    //creating constructors - all parameters
    public Clothing(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, String measurementIn)
    {
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        measurement=measurementIn;
    }
    
}
