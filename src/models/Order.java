/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author manue
 */
public class Order {
    
    //creating attributes
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private HashMap<Integer, OrderLine> orderLines;
       
    //calculating orderTotal
    public void calculateOrderTotal()
    {   //setting ordertotal to zero
        orderTotal = 0;
        //looping through the hashmap of orderlines
        for(Map.Entry<Integer, OrderLine> olEntry : orderLines.entrySet())
        {   //getting the value of any orderline
            OrderLine actualOrderLine = olEntry.getValue();
            //adding each value to our orderTotal
            orderTotal = orderTotal + actualOrderLine.getLineTotal();
        }
    }
        
    //to remove an orderline
    public void removeOrderLine(int productId)
    {
        //initialising orderLineId;
        int orderLineId = -1;
        for(Map.Entry<Integer, OrderLine> basketMapEntry : orderLines.entrySet())
        {
            OrderLine basketorderLine = basketMapEntry.getValue();
            Product productInBasket = basketorderLine.getProduct();
            //deleting according to animal id: we check it
            if(productId == productInBasket.getProductId())
            {
                orderLineId = basketorderLine.getOrderLineId();
            }
        }
        //removing the selected orderline from the hashmap
        orderLines.remove(orderLineId);
    }

    //adding an orderline to the hashmap of orderlines
    public boolean addOrderLine(OrderLine ol)
    {
        //initializing boolean
        boolean canItBeAdded = true;
        //adding orderline to our HashMap
        for(Map.Entry<Integer, OrderLine> basketMapEntry : orderLines.entrySet())
        {
            //getting the selected value for our hashmap
            OrderLine basketorderLine = basketMapEntry.getValue();
            //getting the selected product
            Product productInBasket = basketorderLine.getProduct();
            
            //checking if the product is already there: if true, it is
            if(ol.getProduct().getProductId() == productInBasket.getProductId())
            {   //setting boolean at false
                canItBeAdded = false;
            }
        }
        //if the product was not in the basket
        if(canItBeAdded == true)
        {   //initialising orderLineId
            int orderLineId = 0;
            //while loop, used to increase the orderLineId
            while(orderLines.containsKey(orderLineId))
            {
                orderLineId++;
            }
            ol.setOrderLineId(orderLineId);
            //adding the current orderline to OrderLines
            orderLines.put(orderLineId, ol);
        }
                
        return canItBeAdded;
    }
    //getters
    public int getOrderId() {return orderId;}
    public Date getOrderDate() {return orderDate;}
    public double getOrderTotal() {return orderTotal;}
    public String getStatus() {return status;}
    public HashMap<Integer, OrderLine> getOrderLines() {return orderLines;}
    //setters
    public void setOrderId(int orderIdIn){orderId = orderIdIn;}
    public void setOrderDate (Date orderDateIn) {orderDate = orderDateIn;}
    public void setOrderTotal (double orderTotalIn) {orderTotal=orderTotalIn;}
    public void setStatus (String StatusIn){status = StatusIn;}
    public void setOrderLines (HashMap<Integer, OrderLine> orderLinesIn) {orderLines = orderLinesIn;}
    //creating constructors 0 parameters. Order date is set as new date, orderlines is set to a new HashMap
      public Order()
    {
        orderId=0;
        orderDate = new Date();
        orderTotal=0;
        status="In Progress";
        orderLines = new HashMap();
    }
    //creating constructor - all parameters, except orderLines
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
    {
        orderId=orderIdIn;
        orderDate = orderDateIn;
        orderTotal=orderTotalIn;
        status=statusIn;
        orderLines = new HashMap();
    }
}
