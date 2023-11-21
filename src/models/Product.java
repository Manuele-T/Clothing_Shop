/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author manue
 */
public class Product {

    //private Attributes for Product
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    
    //overriding the default .ToString()
    @Override
    public String toString()
    {   //selecting the attributes to be shown 
        String display = productName + " costs £" + String.format("%.02f", price);
        return display;
    }

    //creating Getter Methods 
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
    
    public int getStockLevel () {
        return stockLevel;
    }
    
    //creating Setter Methods
    
    public void setProductId (int productIdIn) {
        productId = productIdIn;
    }
    
    public void setProductName (String productNameIn) {
        productName = productNameIn;
    }
    
    public void setPrice (double priceIn) {
        price = priceIn;
    }
    
    public void setStockLevel (int stockLevelIn) {
        stockLevel = stockLevelIn;
    }
    
    //Constructor - 0 parameters
    public Product () {
        productId =0;
        productName = "";
        price = 0;
        stockLevel = 0;
    }
    
    //Constructor - 3 parameters, no ProductId
    public Product (String productNameIn, double priceIn, int stockLevelIn) {
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;        
    }
    
    // Constructor - all parameters in (4)
    public Product (int productIdIn, String productNameIn, double priceIn, int stockLevelIn) {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }

}

