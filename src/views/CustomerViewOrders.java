/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import models.DBManager;
import models.Order;
import models.Customer;
import models.ViewUtils;

/**
 *
 * @author manue
 */
public class CustomerViewOrders extends javax.swing.JFrame {
    
    private Customer loggedInCustomer;

    /**
     * Creates new form StaffViewOrders
     */
    public CustomerViewOrders(Customer customerIn) {
        loggedInCustomer = customerIn;
        //initialising HashMap
        HashMap<String, Customer> loggedInCustomerHashMap = new HashMap();
        //seeding the HashMap with the selected object
        loggedInCustomerHashMap.put(loggedInCustomer.getUserName(), loggedInCustomer);
        //initialising DBManager class
        DBManager db = new DBManager();
        //calling selected method
        loggedInCustomerHashMap = db.loadCustomerOrders(loggedInCustomerHashMap);
        initComponents();
        ViewUtils.setStandardSize(this);
        this.pack();
        //initialising a DefaultTableModel object
        DefaultTableModel ordersModel = (DefaultTableModel)tblOrder.getModel();
            for(Map.Entry<Integer, Order> cEntry : loggedInCustomer.getOrders().entrySet())
            {
                Order actualOrder= cEntry.getValue();
                ordersModel.addRow(new Object[]{
                    actualOrder.getOrderId(),
                    new SimpleDateFormat("dd/MM/yyyy").format(actualOrder.getOrderDate()),
                    "£" + String.format("%.02f", actualOrder.getOrderTotal()),
                    actualOrder.getStatus()
                    });
            }
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnViewOrderDetails = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Date", "Total", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblOrder);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnViewOrderDetails.setText("View Order Details for Selected Order");
        btnViewOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewOrderDetails)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnBack)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnViewOrderDetails)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //intializing StaffHome object
        CustomerHome customerHome  = new CustomerHome(loggedInCustomer);
        customerHome.setVisible(true); //setting desired page as Visible
        this.dispose(); //closing current page
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderDetailsActionPerformed
        //getting the index of the selected row
        int selectedRow = tblOrder.getSelectedRow();
        //error case: no animal has been selected
        if (selectedRow == -1)
        {
            lblErrorMessage.setText("Error: no Order selected");
        }
        else
        {
            //we get the id we want: we need to convert the object into a value
            int orderId = (int)tblOrder.getValueAt(selectedRow, 0);
            //calling the desired page, passing the required parameters
            CustomerPreviousOrderLines customerPreviousOrderLines = new CustomerPreviousOrderLines(loggedInCustomer, orderId);
            this.dispose(); //closing the current page
            customerPreviousOrderLines.setVisible(true); //showing the desired page
        }
    }//GEN-LAST:event_btnViewOrderDetailsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new CustomerViewOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewOrderDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}