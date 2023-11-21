/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/**
 *
 * @author manue
 */
public class DBManager {
    //creating string for the ucanaccessdriver driver
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    //connecting the driver "string" to the database
    private final String connectionString = "jdbc:ucanaccess://C:\\Users\\manue\\Documents\\NetBeansProjects\\30403218_Shop\\Data\\ShopDB.accdb";
    //creating hashmap
    public HashMap<Integer, Product> loadProducts()
    {
        HashMap<Integer, Product> loadedProducts = new HashMap();
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating sql statement 
            Statement stmt = conn.createStatement();
            //creating sql select statement. It returns values
            //rs is a variable that holds a database table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            //while loop, to get the selected values
            while (rs.next()) {                
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("StockLevel");
                String measurement = rs.getString("Measurement");
                int size= rs.getInt("Size");
               //loading the item which respect the conditions 
               if (measurement == null || measurement.equals(""))
               {
                   //Footwear constructors
                   Footwear footwear = new Footwear(productId, productName, price, stockLevel, size);
                   //adding the products
                   loadedProducts.put(productId, footwear);
               }
               else 
               {
                   //Clothing constructor
                   Clothing clothing = new Clothing (productId, productName, price, stockLevel, measurement);
                   //adding the products
                   loadedProducts.put(productId, clothing);
               }
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error loading procuts: " + ex.getMessage());
        } finally {
            return loadedProducts;
        }
        }
        
    //creating hashmap
    public HashMap<String, Staff> loadStaff() {   
        HashMap<String, Staff> loadedStaff = new HashMap();
        //creating a try and catch statement, to handle possible errors.
        //Accessing the database
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating sql statement 
            Statement stmt = conn.createStatement();
            //creating sql select statement. It returns values
            //rs is a variable that holds a database table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
            //creating a while loop to "loop" through the database
            //and read the data
            while (rs.next()) {
                String userName = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                //creating Staff object
                Staff staff = new Staff(userName, password, firstName, lastName, position, salary);
                //seeding the HashMap
                loadedStaff.put(userName, staff);
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error loading staff: " + ex.getMessage());
        } finally {
            return loadedStaff;
        }
    }
    
    //creating a method to validate Staff logins 
    public Staff staffLogin(String userNameIn, String passwordIn) 
    {   //initialising HashMap, by calling loadStaff() method
        HashMap<String, Staff> allLoadedStaff = loadStaff();
        if(allLoadedStaff.containsKey(userNameIn))
        {  //
           Staff staffWithThatUserName = allLoadedStaff.get(userNameIn);
           if (staffWithThatUserName.getPassword().equals(passwordIn))
           {
               return staffWithThatUserName;
           }
           else
           {
               return null;
           }
        }
        else
        {
            return null;
        }
    }
    
    public HashMap<String, Customer> loadCustomers() {   //creating hashmap
        HashMap<String, Customer> loadedCustomers = new HashMap();
        //creating a try and catch statement, to handle possible errors.
        //Accessing the database
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating sql statement 
            Statement stmt = conn.createStatement();
            //creating sql select statement. It returns values
            //rs is a variable that holds a database table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            //creating a while loop to "loop" through the database
            //and read the data
            while (rs.next()) {
                String userName = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String addressLine1 = rs.getString("AddressLine1");
                String addressLine2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode");
                //creating Customer object
                Customer customer = new Customer(userName, password, firstName, lastName, addressLine1, addressLine2, town, postcode);
                //seeding loadedCustomers
                loadedCustomers.put(userName, customer);
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error loading zookeepers: " + ex.getMessage());
        } finally {
            //passing loadCustomersOrders hashmap to loadedCustomers
            loadedCustomers = loadCustomerOrders(loadedCustomers);
            return loadedCustomers;
        }
    }
    //creating a method to validate login
    public Customer customerLogin(String userNameIn, String passwordIn) 
    {   //initialising hashmap
        HashMap<String, Customer> allLoadedCustomers = loadCustomers();
        if(allLoadedCustomers.containsKey(userNameIn))
        {  //passing the parameters into customerWithThatUsername
           Customer customerWithThatUserName = allLoadedCustomers.get(userNameIn);
           if (customerWithThatUserName.getPassword().equals(passwordIn))
           {
               return customerWithThatUserName;
           }
           else
           {
               return null;
           }
        }
        else
        {
            return null;
        }
    }
    
    public void registerCustomer(Customer customer)
    {
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating sql statement 
            Statement stmt = conn.createStatement();
            //updating the database, adding the details entered by the user
            stmt.executeUpdate("INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode) VALUES (" +
                    "'" + customer.getUserName() + "'," +
                    "'" + customer.getPassword()+ "'," +
                    "'" + customer.getFirstName()+ "'," +
                    "'" + customer.getLastname()+ "'," +
                    "'" + customer.getAddressLine1()+ "'," +
                    "'" + customer.getAddressLine2()+ "'," +
                    "'" + customer.getTown()+ "'," +
                    "'" + customer.getPostCode()+ "')");
            
            //closing the connection
            conn.close();
        } 
        catch (Exception ex) 
        {
            System.out.println("Error writing Customer: " + ex.getMessage());
        }
    }
    //creating method for editing an Animal
    public void editProduct(Product product)
    {   
        String measurement = "";
        String size = "null";
        if(product.getClass().getName().equals("models.Clothing"))
        {
            //creating Clothing object, casting product
            Clothing clothing = (Clothing)product;
            //getting Measurement value
            measurement = String.valueOf(clothing.getMeasurement());
        }
        else
        {
            //creating Footwear object, casting product
            Footwear footwear = (Footwear)product;
            //getting Size value
            size = String.valueOf(footwear.getSize());
        }
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating sql statement 
            Statement stmt = conn.createStatement();
            //sql statement - UPDATE, productID will not change
            stmt.executeUpdate("UPDATE Products SET " + 
                    "ProductName = '" + product.getProductName() + "'," +
                    "Price = '" + product.getPrice() + "'," +
                    "StockLevel = '" + product.getStockLevel() + "'," +
                    "Measurement = '" + measurement + "'," +
                    "Size = " + size + " "+
                    "WHERE ProductId = '" + product.getProductId() + "'");
            //closing connection
            conn.close();
            
        } 
        catch (Exception ex) 
        {
            System.out.println("Error editing Product: " + ex.getMessage());
        }
    }
    public void deleteProduct(int productID)
    {
        try 
        {   //initialising connection to the database
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            //creating sql statement
            stmt.executeUpdate("DELETE FROM Products WHERE ProductId = '" + productID +"'");
        }
        //catching exception
        catch (Exception ex) 
        {
            System.out.println("Error deleting Product: " + ex.getMessage());
        }
    }
    //creating method for fullfilling an order and returning the orderId to the orderLines table
    public int writeOrder(Order order, String customerUserName)
    {
        int orderId = 0;
        try 
        {
            //initialising connection to the database
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating stmt statement 
            Statement stmt = conn.createStatement();
            //creating sql statement
            stmt.executeUpdate("INSERT INTO Orders (OrderId, OrderDate, Username, OrderTotal, Status) "+
                    "VALUES (" +
                    "'" + order.getOrderId() + "'," +
                    "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) +"'," +
                    "'" + customerUserName + "'," +
                    "'" + order.getOrderTotal() + "'," +
                    "'" + order.getStatus() +"')"
                    );
            //initialising ResultSet to retrieve the desired value
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
            {   //setting orderId as the primary key for the table we are inserting into
                orderId = rs.getInt(1);
            }
            //closing connection
            conn.close();
        }
        //catching exception
        catch (Exception ex) 
        {
            System.out.println("Error Writing Order: " + ex.getMessage());
        }
        //returning orderId
        return orderId;
    }
    //creating method for adding OrderLines to our database
    public void writeOrderLines(OrderLine orderLine, int orderId)
    {
        try {
            //initialising connection to the database
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating stmt statement 
            Statement stmt = conn.createStatement();
            //creating sql statement
            stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, ProductId, Quantity, LineTotal, OrderId) VALUES ("
                    + "'" + orderLine.getOrderLineId() + "', "
                    + "'" + orderLine.getProduct().getProductId()+ "', "
                    + "'" + orderLine.getQuantity() + "', "
                    + "'" + orderLine.getLineTotal() + "', "
                    + "'" + orderId + "')");
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error Writing orderLine: " + ex.getMessage());
        }
    }
    //creating method to update the stock availability
    public void updateStockAvailability(int productId, int quantity)
    {
        try {
            //initialising connection to the database
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating stmt statement 
            Statement stmt = conn.createStatement();
            //creating sql statement
            stmt.executeUpdate("UPDATE Products SET StockLevel = StockLevel - " + quantity + " WHERE ProductId = '" + productId +"'");
            //closing connection to the database
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error updating product availability: " + ex.getMessage());
        }
    }
    public HashMap<String, Customer> loadCustomerOrders(HashMap<String, Customer> customers)
    {
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating sql statement 
            Statement stmt = conn.createStatement();
            //creating sql select statement. It returns values
            //rs is a variable that holds a database table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
            //while Loop, to load the desired data
            while (rs.next()) {
                int orderId = rs.getInt("OrderId");
                String stringOrderDate = rs.getString("OrderDate");
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date orderDate = dateFormat.parse(stringOrderDate);
                String customerUsername = rs.getString("Username");
                double orderTotal = rs.getDouble("OrderTotal");
                String status = rs.getString("Status");
                //Initialising order Object:
                Order order = new Order(orderId, orderDate, orderTotal, status);
                //adding selected customer, checking condition first
                if(customers.containsKey(customerUsername))
                {
                    Customer customer= customers.get(customerUsername);
                    customer.getOrders().put(orderId, order);
                }
            }
            conn.close();
        }
        catch (Exception ex)
        {   //error message
            System.out.println("Error loading orders: "+ ex.getMessage());
        }
        finally
        {
            //calling loadCustomerOrderLines when loading loadCustomerOrders
            customers = loadCustomerOrderLines(customers);
            return customers;
        }
    }
    
    public HashMap<String, Customer> loadCustomerOrderLines(HashMap<String, Customer> customers)
    {
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            //creating sql statement 
            Statement stmt = conn.createStatement();
            //creating sql select statement. It returns values
            //rs is a variable that holds a database table
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines");
            //while loop
            while (rs.next()) 
            {   
                //getting values from the database
                int orderLineId = rs.getInt("OrderLineId");
                int productId = rs.getInt("ProductId");
                int quantity = rs.getInt("Quantity");
                double lineTotal = rs.getDouble("LineTotal");
                int orderId = rs.getInt("OrderId");
                //creating HashMap
                HashMap<Integer, Product> products = loadProducts();
                //getting Product object from our Hashmap
                Product productBought = products.get(productId);
                //creating new orderline
                OrderLine orderLine = new OrderLine(orderLineId, productBought, quantity, lineTotal);
                //looping through each Customer
                //checking which orders belong to them
                for(Map.Entry<String, Customer> customerEntry: customers.entrySet())
                {
                    //getting desired value from our Map
                    Customer customer = customerEntry.getValue();
                    //checking condition - order is related to the current Customer
                    if(customer.getOrders().containsKey(orderId))
                    {
                        //getting the related order
                        Order orderForOrderLine = customer.getOrders().get(orderId);
                        //adding order to the OrderLine
                        //by getting the HashMap or OrderLines
                        //from Order
                        orderForOrderLine.getOrderLines().put(orderLineId, orderLine);
                    }
                }
            }
        }
            catch (Exception ex)
        {
            System.out.println("Error loading orderLines: "+ ex.getMessage());
        }
        finally
        {
            return customers;
        }
    }
}