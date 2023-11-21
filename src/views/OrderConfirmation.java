/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import java.text.SimpleDateFormat;
import models.Order;
import models.Customer;
import models.ViewUtils;
/**
 *
 * @author manue
 */
public class OrderConfirmation extends javax.swing.JFrame {
    
    //initializing loggedInZooKeeper;
    private Customer loggedInCustomer;
    //initializing currentOrder
    private Order currentOrder;
    /**
     * Creates new form OrderConfirmation
     */
    public OrderConfirmation(Customer customer, Order order) {
        //creating new loggedInCustomer object
        loggedInCustomer = customer;
        //creating new currentOrder object
        currentOrder = order;
        initComponents();
        ViewUtils.setStandardSize(this);
        this.pack();
        //setting text for confirmationMessage string
        String confirmationMessage = "<html>" + "Dear " + customer.getFirstName() + " " + customer.getLastname()
                + ", your order status is " + order.getStatus() + "." + "<br><br>" 
                + "Your order was placed at " +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) + "<br><br>"
                + "and cost £" + String.format("%.02f", order.getOrderTotal()) +"." + "</html>";        
        
        //setting text for lalbel lblConfirmationMessage
        lblConfirmationMessage.setText(confirmationMessage);
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConfirmationMessage = new javax.swing.JLabel();
        btnReturntoCustomerHomePage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblConfirmationMessage.setText("jLabel1");

        btnReturntoCustomerHomePage.setText("Return to Customer Home Page");
        btnReturntoCustomerHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturntoCustomerHomePageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnReturntoCustomerHomePage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblConfirmationMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblConfirmationMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnReturntoCustomerHomePage)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturntoCustomerHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturntoCustomerHomePageActionPerformed
        //initialising customerHome
        CustomerHome customerHome = new CustomerHome(loggedInCustomer);
        //closing current windows
        this.dispose();
        //showing the desired page
        customerHome.setVisible(true);
        
    }//GEN-LAST:event_btnReturntoCustomerHomePageActionPerformed
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
            java.util.logging.Logger.getLogger(OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new OrderConfirmation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturntoCustomerHomePage;
    private javax.swing.JLabel lblConfirmationMessage;
    // End of variables declaration//GEN-END:variables
}