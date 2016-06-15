/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.views;

import gfc.controller.CustomerController;
import gfc.controller.CustomerOrderController;
import gfc.controller.GarmentController;
import gfc.models.Customer;
import gfc.models.CustomerOrder;
import gfcl.common_classes.ComboItemsAdder;
import gfcl.common_classes.IdGenerator;
import gfcl.connector.Connector;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gimhani Uthpala
 */
public class SalesDetailFrame extends javax.swing.JInternalFrame {
    
    private CustomerController customerController;
    private GarmentController garmentController;
    private CustomerOrderController customerOrderController;
    DefaultTableModel tableModel;
    private ComboItemsAdder cia;

    /**
     * Creates new form SalesDetailFrame
     */
    public SalesDetailFrame() {
        try {
            initComponents();
            
            tableModel = (DefaultTableModel) sales_table.getModel();
            
            Connector sConnector = Connector.getSConnector();
            customerController = sConnector.getCustomerController();
            garmentController = sConnector.getGarmentController();
            customerOrderController = sConnector.getCustomerOrderController();
            cia = new ComboItemsAdder();
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            date_text.setText(dateFormat.format(date));
            
            regno_text.setText(IdGenerator.generateNextCustomerID(customerController.getLastCustId()));
            order_id_text.setText(IdGenerator.generateNextOrderID(customerOrderController.getLastOrderId()));
            add_to_list_button.setEnabled(false);
            
            this.customerCombo.setEditable(true);
            cia.addSimilarCustomernames(customerCombo);
            
            this.garment_type_combo.setEditable(true);
            cia.addSimilarGarmentNames(garment_type_combo);
            
            this.edit_customer_combo.setEditable(true);
            cia.addSimilarCustomernames(edit_customer_combo);
            
            this.customer_history_combo.setEditable(true);
            cia.addSimilarCustomernames(customer_history_combo);
            
            this.customer_co_combo.setEditable(true);
            cia.addSimilarCustomernames(customer_co_combo);

            //adding right click to customer view table
            final JPopupMenu popupMenu = new JPopupMenu();
            JMenuItem viewOrderItem = new JMenuItem("View Order");
            viewOrderItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowAtPoint = customer_history_table.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), customer_history_table));
                    DefaultTableModel dtm = (DefaultTableModel) customer_history_table.getModel();
                    String order_id = dtm.getValueAt(rowAtPoint+1, 0).toString();
                    if (customer_history_combo.getSelectedItem() != null) {
                        String selected = customer_history_combo.getSelectedItem().toString();
                        if (selected.length() > 4) {
                            String cust_id = selected.substring(selected.length() - 4);
                            tabpane.setSelectedIndex(4);
                            customer_co_combo.setSelectedItem(selected);
                            cus_order_combo.setSelectedItem(order_id);
                        }
                    }
                    
                }
            });
            popupMenu.add(viewOrderItem);
            popupMenu.addPopupMenuListener(new PopupMenuListener() {
                
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            int rowAtPoint = customer_history_table.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), customer_history_table));
                            if (rowAtPoint > -1) {
                                customer_history_table.setRowSelectionInterval(rowAtPoint, rowAtPoint);
                            }
                        }
                    });
                }
                
                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                    // TODO Auto-generated method stub

                }
                
                @Override
                public void popupMenuCanceled(PopupMenuEvent e) {
                    // TODO Auto-generated method stub

                }
                
            });
            
            customer_history_table.setComponentPopupMenu(popupMenu);
        } catch (RemoteException | SQLException | ClassNotFoundException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(SalesDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        tabpane = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        customerCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        date_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        order_id_text = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        garment_type_combo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        no_of_garment_spinner = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        unit_price_text = new javax.swing.JTextField();
        add_to_list_button = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        sales_table = new javax.swing.JTable();
        total_payement_text = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        save_sale_button = new javax.swing.JButton();
        cancel_sale_button = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        regno_text = new javax.swing.JTextField();
        reg_no_label1 = new javax.swing.JLabel();
        name_text = new javax.swing.JTextField();
        namelabel1 = new javax.swing.JLabel();
        nic_text = new javax.swing.JTextField();
        niclabel1 = new javax.swing.JLabel();
        addresslabel1 = new javax.swing.JLabel();
        telephone_text = new javax.swing.JTextField();
        telephonelabel1 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        address_text = new javax.swing.JTextArea();
        jPanel22 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        reg_no_label2 = new javax.swing.JLabel();
        name_text1 = new javax.swing.JTextField();
        namelabel2 = new javax.swing.JLabel();
        nic_text1 = new javax.swing.JTextField();
        niclabel2 = new javax.swing.JLabel();
        addresslabel2 = new javax.swing.JLabel();
        telephone_text1 = new javax.swing.JTextField();
        telephonelabel2 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        address_text1 = new javax.swing.JTextArea();
        jPanel24 = new javax.swing.JPanel();
        save_button1 = new javax.swing.JButton();
        cancel_button1 = new javax.swing.JButton();
        edit_customer_combo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        customer_history_combo = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        customer_history_table = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        customer_co_combo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cus_order_combo = new javax.swing.JComboBox<>();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        view_customer_order_table = new javax.swing.JTable();
        view_total_payement_text = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        not_found_label = new javax.swing.JLabel();

        tabpane.setForeground(new java.awt.Color(0, 0, 204));
        tabpane.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N

        jLabel7.setText("Customer:");

        customerCombo.setEditable(true);

        jLabel8.setText("Date:");

        jLabel1.setText("Order ID:");

        order_id_text.setEditable(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date_text, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(date_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(order_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Garment Type:");

        garment_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garment_type_comboActionPerformed(evt);
            }
        });

        jLabel10.setText("No. of Garments:");

        no_of_garment_spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                no_of_garment_spinnerStateChanged(evt);
            }
        });

        jLabel11.setText("Unit price: Rs.");

        unit_price_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unit_price_textKeyReleased(evt);
            }
        });

        add_to_list_button.setText("Add to List");
        add_to_list_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_to_list_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(garment_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no_of_garment_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unit_price_text, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(add_to_list_button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(garment_type_combo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no_of_garment_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(unit_price_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add_to_list_button)
                .addGap(75, 75, 75))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        sales_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GID", "Garment", "No.of Garments", "Unit Price", "Price"
            }
        ));
        sales_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(sales_table);

        jLabel12.setText("Total payment:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(total_payement_text, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_payement_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        save_sale_button.setText("Save");
        save_sale_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_sale_buttonActionPerformed(evt);
            }
        });

        cancel_sale_button.setText("Cancel");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_sale_button)
                .addGap(18, 18, 18)
                .addComponent(cancel_sale_button)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_sale_button)
                    .addComponent(save_sale_button))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jScrollPane7.setViewportView(jPanel14);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tabpane.addTab("Add a sale", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/shopping_cart.png")), jPanel13); // NOI18N

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        regno_text.setEditable(false);
        regno_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regno_textActionPerformed(evt);
            }
        });

        reg_no_label1.setText("Reg.No:");

        namelabel1.setText("Name:");

        niclabel1.setText("NIC :");

        addresslabel1.setText("Address :");

        telephonelabel1.setText("Telephone:");

        address_text.setColumns(20);
        address_text.setRows(5);
        jScrollPane10.setViewportView(address_text);

        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(save_button)
                .addGap(18, 18, 18)
                .addComponent(cancel_button)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button)
                    .addComponent(cancel_button))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namelabel1)
                            .addComponent(niclabel1)
                            .addComponent(addresslabel1)
                            .addComponent(telephonelabel1)
                            .addComponent(reg_no_label1))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regno_text, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telephone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regno_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reg_no_label1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namelabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(niclabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addresslabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephonelabel1))
                .addGap(57, 57, 57)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel20);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabpane.addTab("Add new customer", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/customer_add_s.png")), jPanel19); // NOI18N

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        reg_no_label2.setText("Select customer:");

        namelabel2.setText("Name:");

        niclabel2.setText("NIC :");

        addresslabel2.setText("Address :");

        telephonelabel2.setText("Telephone:");

        address_text1.setColumns(20);
        address_text1.setRows(5);
        jScrollPane11.setViewportView(address_text1);

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        save_button1.setText("Save");
        save_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_button1ActionPerformed(evt);
            }
        });

        cancel_button1.setText("Cancel");
        cancel_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(save_button1)
                .addGap(18, 18, 18)
                .addComponent(cancel_button1)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button1)
                    .addComponent(cancel_button1))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namelabel2)
                            .addComponent(niclabel2)
                            .addComponent(addresslabel2)
                            .addComponent(telephonelabel2)
                            .addComponent(reg_no_label2))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nic_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telephone_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_customer_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reg_no_label2)
                    .addComponent(edit_customer_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(namelabel2))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niclabel2)
                    .addComponent(nic_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addresslabel2)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephone_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephonelabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel23);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        tabpane.addTab("Search Customer Details", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/customer_search_s.png")), jPanel3); // NOI18N

        jLabel2.setText("Select Customer:");

        customer_history_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customer_history_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customer_history_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customer_history_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        customer_history_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Date Of Order", "Total Payement"
            }
        ));
        jScrollPane4.setViewportView(customer_history_table);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabpane.addTab("View Customer History", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/Folder History.png")), jPanel4); // NOI18N

        jLabel3.setText("Select Customer:");

        customer_co_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customer_co_comboItemStateChanged(evt);
            }
        });

        jLabel4.setText("Select order:");

        cus_order_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cus_order_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customer_co_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cus_order_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(customer_co_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cus_order_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        view_customer_order_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GID", "Garment", "No.of Garments", "Unit Price", "Price"
            }
        ));
        view_customer_order_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(view_customer_order_table);

        jLabel13.setText("Total payment:");

        not_found_label.setText("No order details found!");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(not_found_label, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(view_total_payement_text, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(view_total_payement_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(not_found_label)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel10);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabpane.addTab("View Customer Order", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/report_user.png")), jPanel9); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabpane)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(tabpane, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void garment_type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garment_type_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_garment_type_comboActionPerformed

    private void no_of_garment_spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_no_of_garment_spinnerStateChanged
        enableAddButton();
    }//GEN-LAST:event_no_of_garment_spinnerStateChanged

    private void unit_price_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unit_price_textKeyReleased
        enableAddButton();
    }//GEN-LAST:event_unit_price_textKeyReleased

    private void add_to_list_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_to_list_buttonActionPerformed
        String text = garment_type_combo.getSelectedItem().toString();
        String[] two = text.split(" ");
        String type = two[0];
        String type_id = two[1];
        int no_of_garments = Integer.valueOf(no_of_garment_spinner.getValue().toString());
        double unit_price = Double.valueOf(unit_price_text.getText());
        double price = unit_price * no_of_garments;
        
        DefaultTableModel tableModel = (DefaultTableModel) sales_table.getModel();
        boolean added = false;
        //to check if 1 type is adding again
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equals(type_id)) {
                if (unit_price == Double.valueOf(tableModel.getValueAt(i, 3).toString())) {
                    int new_no = Integer.valueOf(tableModel.getValueAt(i, 2).toString()) + no_of_garments;
                    tableModel.setValueAt(new_no, i, 2);
                    double new_price = Double.valueOf(tableModel.getValueAt(i, 4).toString()) + (no_of_garments * unit_price);
                    tableModel.setValueAt(new_price, i, 4);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Different unit prices for same garment");
                }
                added = true;
                break;
            }
            
        }
        
        if (!added) {
            Object[] rawdata = {type_id, type, no_of_garments, unit_price, price};
            tableModel.addRow(rawdata);
        }

        //calculating total
        double sum = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            sum += Double.valueOf(tableModel.getValueAt(i, 4).toString());
        }
        total_payement_text.setText(String.valueOf(sum));
        
        unit_price_text.setText("");
        no_of_garment_spinner.setValue(0);
        add_to_list_button.setEnabled(false);
    }//GEN-LAST:event_add_to_list_buttonActionPerformed

    private void save_sale_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_sale_buttonActionPerformed
        try {
            String text = customerCombo.getSelectedItem().toString();
            String order_id = order_id_text.getText();
            String cust_id = text.substring(text.length() - 4, text.length());
            ArrayList<CustomerOrder> sale_order = new ArrayList<>();
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                CustomerOrder order = new CustomerOrder(order_id, cust_id, tableModel.getValueAt(i, 0).toString(), date_text.getText(), Integer.valueOf(tableModel.getValueAt(i, 2).toString()), Double.valueOf(tableModel.getValueAt(i, 3).toString()));
                sale_order.add(order);
            }
            boolean saleAdded = customerOrderController.addSale(sale_order);
            if (saleAdded) {
                System.out.println("Order added successfully");
            } else {
                System.out.println("Order failed to add");
            }
            //rearrange the form
            customerCombo.setSelectedItem(null);
            garment_type_combo.setSelectedItem(null);
            order_id_text.setText(IdGenerator.generateNextOrderID(customerOrderController.getLastOrderId()));
            add_to_list_button.setEnabled(false);
            ((DefaultTableModel) sales_table.getModel()).setRowCount(0);
            
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalesDetailFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_save_sale_buttonActionPerformed

    private void regno_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regno_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regno_textActionPerformed

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_save_buttonActionPerformed

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        try {
            createNewForm();
            
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SalesDetailFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void save_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_button1ActionPerformed
        String selected = edit_customer_combo.getSelectedItem().toString();
        if (selected.length() > 4) {
            try {
                String cust_id = selected.substring(selected.length() - 4);
                String c_name = name_text1.getText();
                String c_address = address_text1.getText();
                String c_nic = nic_text1.getText();
                String c_telephone = telephone_text1.getText();
                Customer customer = new Customer(cust_id, c_name, c_address, c_telephone, c_nic);
                int updateCustomer = customerController.updateCustomer(customer);
                if (updateCustomer > 0) {
                    JOptionPane.showMessageDialog(this, "Customer updated successfully");
                    createNewEditForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Customer update failed!");
                    
                }
                
            } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(SalesDetailFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "A valid customer is not selected!");
            createNewEditForm();
        }
    }//GEN-LAST:event_save_button1ActionPerformed
    
    private void createNewEditForm() {
        edit_customer_combo.setSelectedItem(null);
        name_text1.setText("");
        address_text1.setText("");
        nic_text1.setText("");
        telephone_text1.setText("");
    }
    private void cancel_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_button1ActionPerformed
        createNewEditForm();
    }//GEN-LAST:event_cancel_button1ActionPerformed

    private void customer_co_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customer_co_comboItemStateChanged
        if (customer_co_combo.getSelectedItem() != null) {
            String selected = customer_co_combo.getSelectedItem().toString();
            if (selected.length() > 4) {
                try {
                    String cust_id = selected.substring(selected.length() - 4);
                    if (customerController.searchCustomer(cust_id) != null) {
                        this.cus_order_combo.setEditable(true);
                        cia.addSimilarOrderIDs(cus_order_combo, cust_id);
                        
                    }
                } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(SalesDetailFrame.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        

    }//GEN-LAST:event_customer_co_comboItemStateChanged

    private void cus_order_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cus_order_comboItemStateChanged
        if (customer_co_combo.getSelectedItem() != null && cus_order_combo.getSelectedItem() != null) {
            String selected = customer_co_combo.getSelectedItem().toString();
            String order_id = cus_order_combo.getSelectedItem().toString();
            if (selected.length() > 4 && order_id.length() == 4) {
                try {
                    ArrayList<CustomerOrder> list = new ArrayList<>();
                    list = customerOrderController.searchOrder(order_id);
                    if (list.size() > 0) {
                        not_found_label.setVisible(false);
                        DefaultTableModel dtm = (DefaultTableModel) view_customer_order_table.getModel();
                        double sum = 0;
                        for (CustomerOrder co : list) {
                            String garment_name = garmentController.searchGarment(co.getGarment_id()).getGarment_name();
                            Object[] rawdata = {co.getGarment_id(), garment_name, co.getAmount(), co.getUnit_price(), co.getAmount() * co.getUnit_price()};
                            dtm.addRow(rawdata);
                            sum += co.getAmount() * co.getUnit_price();
                        }
                        view_total_payement_text.setText(String.valueOf(sum));
                    } else {
                        not_found_label.setVisible(true);
                        
                    }
                } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(SalesDetailFrame.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        

    }//GEN-LAST:event_cus_order_comboItemStateChanged

    private void customer_history_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customer_history_comboItemStateChanged
        if (customer_history_combo.getSelectedItem() != null) {
            String selected = customer_history_combo.getSelectedItem().toString();
            if (selected.length() > 4) {
                try {
                    String cust_id = selected.substring(selected.length() - 4);
                    ArrayList<CustomerOrder> ordersOfCustomer = new ArrayList<>();
                    ordersOfCustomer = customerOrderController.getOrdersOfCustomer(cust_id);
                    DefaultTableModel dtm = (DefaultTableModel) customer_history_table.getModel();
                    for (CustomerOrder co : ordersOfCustomer) {
                        Object[] rawdata = {co.getOrder_id(), co.getDateOfOrder(), co.getOrder_price()};
                        dtm.addRow(rawdata);
                        
                    }
                } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(SalesDetailFrame.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_customer_history_comboItemStateChanged
    
    private void enableAddButton() {
        if (garment_type_combo.getSelectedItem().toString().trim().length() != 0 && Integer.valueOf(no_of_garment_spinner.getValue().toString()) > 0 && unit_price_text.getText().trim().length() != 0) {
            add_to_list_button.setEnabled(true);
        } else {
            add_to_list_button.setEnabled(false);
        }
    }
    
    private void createNewForm() throws RemoteException, SQLException, ClassNotFoundException {
        name_text.setText("");
        address_text.setText("");
        telephone_text.setText("");
        nic_text.setText("");
        regno_text.setText(IdGenerator.generateNextCustomerID(customerController.getLastCustId()));
    }
    
    void focustabbedpane(int num) {
        tabpane.setSelectedIndex(num);
    }
    
    void requestFoucsForm() {
        customerCombo.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_to_list_button;
    private javax.swing.JTextArea address_text;
    private javax.swing.JTextArea address_text1;
    private javax.swing.JLabel addresslabel1;
    private javax.swing.JLabel addresslabel2;
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton cancel_button1;
    private javax.swing.JButton cancel_sale_button;
    private javax.swing.JComboBox<String> cus_order_combo;
    private javax.swing.JComboBox<String> customerCombo;
    private javax.swing.JComboBox<String> customer_co_combo;
    private javax.swing.JComboBox<String> customer_history_combo;
    private javax.swing.JTable customer_history_table;
    private javax.swing.JTextField date_text;
    private javax.swing.JComboBox<String> edit_customer_combo;
    private javax.swing.JComboBox<String> garment_type_combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField name_text1;
    private javax.swing.JLabel namelabel1;
    private javax.swing.JLabel namelabel2;
    private javax.swing.JTextField nic_text;
    private javax.swing.JTextField nic_text1;
    private javax.swing.JLabel niclabel1;
    private javax.swing.JLabel niclabel2;
    private javax.swing.JSpinner no_of_garment_spinner;
    private javax.swing.JLabel not_found_label;
    private javax.swing.JTextField order_id_text;
    private javax.swing.JLabel reg_no_label1;
    private javax.swing.JLabel reg_no_label2;
    private javax.swing.JTextField regno_text;
    private javax.swing.JTable sales_table;
    private javax.swing.JButton save_button;
    private javax.swing.JButton save_button1;
    private javax.swing.JButton save_sale_button;
    private javax.swing.JTabbedPane tabpane;
    private javax.swing.JTextField telephone_text;
    private javax.swing.JTextField telephone_text1;
    private javax.swing.JLabel telephonelabel1;
    private javax.swing.JLabel telephonelabel2;
    private javax.swing.JTextField total_payement_text;
    private javax.swing.JTextField unit_price_text;
    private javax.swing.JTable view_customer_order_table;
    private javax.swing.JTextField view_total_payement_text;
    // End of variables declaration//GEN-END:variables

    void setDisabledTabs(boolean tab1,boolean tab2,boolean tab3,boolean tab4,boolean tab5){
        tabpane.setEnabledAt(0,tab1 );
        tabpane.setEnabledAt(1,tab2 );
        tabpane.setEnabledAt(2,tab3 );
        tabpane.setEnabledAt(3,tab4 );
        tabpane.setEnabledAt(4,tab5 );
    }

    void setUpdateButton(boolean b) {
        save_button1.setEnabled(b);
    }
}
