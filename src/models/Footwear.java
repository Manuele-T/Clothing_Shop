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
public class Footwear extends Product {
    //creating new attribute
    private int size;
    
    //creating Getters
    public int getSize () {return size;}
    
    //creating Setters
    public void setSize (int sizeIn) {size = sizeIn;}
    
    //creating constructor - 0 parameters
    public Footwear()
    {
        super();
        size=0;
    }
    
    //creating constructor - everything except productId
    public Footwear(String productNameIn, double priceIn, int stockLevelIn, int sizeIn)
    {
        super(productNameIn, priceIn, stockLevelIn);
        size=sizeIn;
    }
    
    //creating constructors - all parameters
    
    public Footwear(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, int sizeIn)
    {
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        size=sizeIn;
    }
    
}
