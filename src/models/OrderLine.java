/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author manue
 */
public class OrderLine {
    
    //attributes
    private int orderLineId;
    private Product product;
    private int quantity;
    private double lineTotal;
    
    //getters
    public int getOrderLineId() {return orderLineId;}
    public Product getProduct() {return product;}
    public int getQuantity() {return quantity;}
    public double getLineTotal() {return lineTotal;}
    
    //setters
    public void setOrderLineId(int orderLineIdin) {orderLineId=orderLineIdin;}
    public void setProduct (Product productIn) {product=productIn;}
    public void setQuantity (int quantityIn) {quantity = quantityIn;}
    public void setLineTotal (double lineTotalIn) {lineTotal=lineTotalIn;}
    
    //constructors - all parameters
    public OrderLine (int orderLineIdIn, Product productIn, int quantityIn, double lineTotalIn)
    {
        orderLineId = orderLineIdIn;
        product=productIn;
        quantity=quantityIn;
        lineTotal=lineTotalIn;
    }
    
    //constructors - all parameters, except lineTotal. Il will be calculated by price * quantity
    public OrderLine (int orderLineIdIn, Product productIn, int quantityIn)
    {
        orderLineId = orderLineIdIn;
        product=productIn;
        quantity=quantityIn;
        lineTotal=product.getPrice()*quantity;
    }
    
}
