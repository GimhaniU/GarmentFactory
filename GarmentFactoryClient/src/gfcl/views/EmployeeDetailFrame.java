/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.views;

import gfc.controller.EmployeeController;
import gfc.controller.GarmentController;
import gfc.models.Employee;
import gfc.models.Garment;
import gfcl.common_classes.GUIitemsValidator;
import gfcl.common_classes.IdGenerator;
import gfcl.common_classes.PatternChecker;
import gfcl.connector.Connector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Nuwantha
 */
public class EmployeeDetailFrame extends javax.swing.JInternalFrame {

    private EmployeeController employeeController;
    private GarmentController garmentController;

    /**
     * Creates new form EmployeeDetailFrame
     */
    public EmployeeDetailFrame() {
        try {
            initComponents();

            name_text.requestFocus();
            Connector sConnector = Connector.getSConnector();
            employeeController = sConnector.getEmployeeController();
            garmentController = sConnector.getGarmentController();
            
            System.out.println(IdGenerator.generateNextEmployeeID(employeeController.getLastEmpId()));
            regno_text.setText(IdGenerator.generateNextEmployeeID(employeeController.getLastEmpId()));

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            date_text.setText(dateFormat.format(date));

            tel_no_invalid_label.setVisible(false);
            nic_invalid_label.setVisible(false);

            //to autoadd names to combo box
            this.employee_name_combo.setEditable(true);
            JTextComponent editCombo = (JTextComponent) employee_name_combo.getEditor().getEditorComponent();
            editCombo.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        String item = (String) employee_name_combo.getEditor().getItem();
                        ArrayList<Object> list = new ArrayList();

                        ArrayList<Employee> similar = employeeController.getSimilarEmployeeNames(item);
                        for (int i = 0; i < similar.size(); i++) {
                            list.add(similar.get(i).getName() + " " + similar.get(i).getEmp_id());
                        }
                        GUIitemsValidator.addItemToCombo(list, employee_name_combo);
                    } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                        Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            this.employee_attend_name_combo.setEditable(true);
            JTextComponent editAttendCombo = (JTextComponent) employee_attend_name_combo.getEditor().getEditorComponent();
            editAttendCombo.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        String item = (String) employee_attend_name_combo.getEditor().getItem();
                        ArrayList<Object> list = new ArrayList();

                        ArrayList<Employee> similar = employeeController.getSimilarEmployeeNames(item);
                        for (int i = 0; i < similar.size(); i++) {
                            list.add(similar.get(i).getName() + " " + similar.get(i).getEmp_id());
                        }
                        GUIitemsValidator.addItemToCombo(list, employee_attend_name_combo);
                    } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                        Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            this.garment_type_combo.setEditable(true);
            JTextComponent garmentCombo = (JTextComponent) garment_type_combo.getEditor().getEditorComponent();
            garmentCombo.addKeyListener(new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        String item = (String) garment_type_combo.getEditor().getItem();
                        ArrayList<Object> list = new ArrayList();

                        ArrayList<Garment> similar = garmentController.getSimilarGarmentNames(item);
                        for (int i = 0; i < similar.size(); i++) {
                            list.add(similar.get(i).getGarment_name()+" "+similar.get(i).getGarment_id());
                        }
                        GUIitemsValidator.addItemToCombo(list, garment_type_combo);
                    } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                        Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    EmployeeDetailFrame(String nic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pre_ab_group = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabpane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        regno_text = new javax.swing.JTextField();
        reg_no_label = new javax.swing.JLabel();
        name_text = new javax.swing.JTextField();
        namelabel = new javax.swing.JLabel();
        nic_text = new javax.swing.JTextField();
        niclabel = new javax.swing.JLabel();
        addresslabel = new javax.swing.JLabel();
        telephone_text = new javax.swing.JTextField();
        telephonelabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        address_text = new javax.swing.JTextArea();
        dutylabel = new javax.swing.JLabel();
        duty_combo = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        save_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        tel_no_invalid_label = new javax.swing.JLabel();
        nic_invalid_label = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        reg_no_label1 = new javax.swing.JLabel();
        name_text_e = new javax.swing.JTextField();
        namelabel1 = new javax.swing.JLabel();
        nic_text_e = new javax.swing.JTextField();
        niclabel1 = new javax.swing.JLabel();
        addresslabel1 = new javax.swing.JLabel();
        telephone_text_e = new javax.swing.JTextField();
        telephonelabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        address_text_e = new javax.swing.JTextArea();
        dutylabel1 = new javax.swing.JLabel();
        duty_combo_e = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        edit_button = new javax.swing.JButton();
        cancel_button_e = new javax.swing.JButton();
        tel_no_invalid_label1 = new javax.swing.JLabel();
        nic_invalid_label1 = new javax.swing.JLabel();
        employee_name_combo = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        wagepanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        no_of_pieces_text = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        garment_type_combo = new javax.swing.JComboBox<>();
        add_pieces_button = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        no_of_pieces_table = new javax.swing.JTable();
        salarypanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        present_radio = new javax.swing.JRadioButton();
        absent_radio = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        ot_hour_spinner = new javax.swing.JSpinner();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date_text = new javax.swing.JTextField();
        employee_attend_name_combo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        duty_text = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        save_attend_button = new javax.swing.JButton();
        cancel_button3 = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        regno_text.setEditable(false);
        regno_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regno_textActionPerformed(evt);
            }
        });

        reg_no_label.setText("Reg.No:");

        name_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_textKeyReleased(evt);
            }
        });

        namelabel.setText("Name:");

        nic_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nic_textKeyReleased(evt);
            }
        });

        niclabel.setText("NIC :");

        addresslabel.setText("Address :");

        telephone_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telephone_textKeyReleased(evt);
            }
        });

        telephonelabel.setText("Telephone:");

        address_text.setColumns(20);
        address_text.setRows(5);
        address_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_textKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(address_text);

        dutylabel.setText("Duty:");

        duty_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Store", "Cutting", "Sewing 1 in", "Sewing 1 out", "Waxing in", "Waxing out", "Dyeing", "DryWashing", "Sewing 2", "Finishing", "Sales" }));

        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        cancel_button.setText("Cancel");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_button)
                .addGap(18, 18, 18)
                .addComponent(cancel_button)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_button)
                    .addComponent(cancel_button))
                .addGap(22, 22, 22))
        );

        tel_no_invalid_label.setForeground(new java.awt.Color(255, 0, 0));
        tel_no_invalid_label.setText("invalid");

        nic_invalid_label.setForeground(new java.awt.Color(255, 0, 0));
        nic_invalid_label.setText("invalid");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namelabel)
                            .addComponent(niclabel)
                            .addComponent(addresslabel)
                            .addComponent(telephonelabel))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dutylabel)
                        .addGap(70, 70, 70)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nic_invalid_label))
                    .addComponent(regno_text, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(telephone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(tel_no_invalid_label))
                    .addComponent(duty_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_text))
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(reg_no_label)
                    .addContainerGap(636, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(regno_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namelabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nic_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(niclabel)
                    .addComponent(nic_invalid_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addresslabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephonelabel)
                    .addComponent(tel_no_invalid_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duty_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dutylabel))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(reg_no_label)
                    .addContainerGap(384, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );

        tabpane.addTab("Add New Employee", jPanel2);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        reg_no_label1.setText("Enter name:");

        name_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_text_eKeyReleased(evt);
            }
        });

        namelabel1.setText("Name:");

        nic_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nic_text_eKeyReleased(evt);
            }
        });

        niclabel1.setText("NIC :");

        addresslabel1.setText("Address :");

        telephone_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telephone_text_eKeyReleased(evt);
            }
        });

        telephonelabel1.setText("Telephone:");

        address_text_e.setColumns(20);
        address_text_e.setRows(5);
        address_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_text_eKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(address_text_e);

        dutylabel1.setText("Duty:");

        duty_combo_e.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Store", "Cutting", "Sewing 1 in", "Sewing 1 out", "Waxing in", "Waxing out", "Dyeing", "DryWashing", "Sewing 2", "Finishing", "Sales" }));

        edit_button.setText("Update");
        edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_buttonActionPerformed(evt);
            }
        });

        cancel_button_e.setText("Cancel");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edit_button)
                .addGap(18, 18, 18)
                .addComponent(cancel_button_e)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_button)
                    .addComponent(cancel_button_e))
                .addGap(22, 22, 22))
        );

        tel_no_invalid_label1.setForeground(new java.awt.Color(255, 0, 0));
        tel_no_invalid_label1.setText("invalid");

        nic_invalid_label1.setForeground(new java.awt.Color(255, 0, 0));
        nic_invalid_label1.setText("invalid");

        employee_name_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employee_name_comboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namelabel1)
                            .addComponent(niclabel1)
                            .addComponent(addresslabel1)
                            .addComponent(telephonelabel1))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(dutylabel1)
                        .addGap(70, 70, 70)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(nic_text_e, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nic_invalid_label1))
                    .addComponent(name_text_e, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(telephone_text_e, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(tel_no_invalid_label1))
                    .addComponent(duty_combo_e, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employee_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(reg_no_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(656, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employee_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_text_e, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namelabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nic_text_e, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(niclabel1)
                    .addComponent(nic_invalid_label1))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addresslabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephone_text_e, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephonelabel1)
                    .addComponent(tel_no_invalid_label1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duty_combo_e, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dutylabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(reg_no_label1)
                    .addContainerGap(384, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        tabpane.addTab("Edit employee details", jPanel6);

        wagepanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee with wage"));

        jLabel3.setText("No. of Pieces covered:");

        no_of_pieces_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_of_pieces_textKeyReleased(evt);
            }
        });

        jLabel4.setText("Type of Garment:");

        add_pieces_button.setText("Add");
        add_pieces_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_pieces_buttonActionPerformed(evt);
            }
        });

        no_of_pieces_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GID", "Garment", "No.Of Pieces"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        no_of_pieces_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(no_of_pieces_table);

        javax.swing.GroupLayout wagepanelLayout = new javax.swing.GroupLayout(wagepanel);
        wagepanel.setLayout(wagepanelLayout);
        wagepanelLayout.setHorizontalGroup(
            wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(wagepanelLayout.createSequentialGroup()
                        .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(wagepanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(garment_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(add_pieces_button)
                                .addGroup(wagepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(no_of_pieces_text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        wagepanelLayout.setVerticalGroup(
            wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wagepanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(garment_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(no_of_pieces_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(add_pieces_button)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        salarypanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee with salary"));

        jLabel5.setText("Presence:");

        pre_ab_group.add(present_radio);
        present_radio.setText("Present");

        pre_ab_group.add(absent_radio);
        absent_radio.setText("Absent");

        jLabel6.setText("OT hours:");

        javax.swing.GroupLayout salarypanelLayout = new javax.swing.GroupLayout(salarypanel);
        salarypanel.setLayout(salarypanelLayout);
        salarypanelLayout.setHorizontalGroup(
            salarypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salarypanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salarypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salarypanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(present_radio)
                        .addGap(18, 18, 18)
                        .addComponent(absent_radio))
                    .addGroup(salarypanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(ot_hour_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        salarypanelLayout.setVerticalGroup(
            salarypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salarypanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(salarypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(salarypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(present_radio)
                        .addComponent(absent_radio)))
                .addGap(18, 18, 18)
                .addGroup(salarypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ot_hour_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Employee name:");

        jLabel2.setText("Date:");

        employee_attend_name_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employee_attend_name_comboItemStateChanged(evt);
            }
        });

        jLabel7.setText("Task:");

        duty_text.setEditable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(employee_attend_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(date_text, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(duty_text, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(date_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employee_attend_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(duty_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        save_attend_button.setText("Save");
        save_attend_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_attend_buttonActionPerformed(evt);
            }
        });

        cancel_button3.setText("Cancel");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_attend_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel_button3)
                .addGap(61, 61, 61))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_attend_button)
                    .addComponent(cancel_button3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(wagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salarypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(526, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salarypanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wagepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel9);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        tabpane.addTab("Mark Attendance", jPanel7);

        jScrollPane1.setViewportView(tabpane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regno_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regno_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regno_textActionPerformed

    private void name_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_textKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && name_text.getText().trim().length() != 0) {
            nic_text.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            nic_text.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            name_text.requestFocus();
        }
    }//GEN-LAST:event_name_textKeyReleased

    private void nic_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nic_textKeyReleased
        nic_invalid_label.setVisible(false);
        String newtext = PatternChecker.checkNIC(nic_text.getText());
        nic_text.setText(newtext);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (PatternChecker.checkNICdirect(nic_text.getText())) {
                address_text.requestFocus();
            } else {
                nic_invalid_label.setVisible(true);
            }
        }
    }//GEN-LAST:event_nic_textKeyReleased

    private void telephone_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephone_textKeyReleased
        tel_no_invalid_label.setVisible(false);
        String newtext = PatternChecker.checkTelNum(telephone_text.getText());
        telephone_text.setText(newtext);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (PatternChecker.checkTelNumdirect(telephone_text.getText())) {
                duty_combo.requestFocus();
            } else {
                tel_no_invalid_label.setVisible(true);
            }
        }
    }//GEN-LAST:event_telephone_textKeyReleased

    private void address_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_textKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && name_text.getText().trim().length() != 0) {
            telephone_text.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            telephone_text.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            nic_text.requestFocus();
        }
    }//GEN-LAST:event_address_textKeyReleased

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed

        try {
            String emp_id = regno_text.getText();
            String name = name_text.getText();
            String address = address_text.getText();
            String telephone = telephone_text.getText();
            String nic = nic_text.getText();
            String duty = duty_combo.getSelectedItem().toString();
            Employee employee = new Employee(emp_id, name, address, telephone, nic, duty);
            int addNewEmployee = employeeController.addNewEmployee(employee);
            if (addNewEmployee > 0) {
                JOptionPane.showMessageDialog(this, "Employee added");
                createNewForm();
            } else {
                JOptionPane.showMessageDialog(this, "Employee not added");
                createNewForm();
            }
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_save_buttonActionPerformed

    private void name_text_eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_text_eKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_name_text_eKeyReleased

    private void nic_text_eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nic_text_eKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nic_text_eKeyReleased

    private void telephone_text_eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephone_text_eKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_telephone_text_eKeyReleased

    private void address_text_eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_text_eKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_address_text_eKeyReleased

    private void edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_buttonActionPerformed
        try {
            String text = employee_name_combo.getSelectedItem().toString();
            String emp_id = text.substring(text.length() - 4, text.length());
            String name = name_text_e.getText();
            String address = address_text_e.getText();
            String telephone = telephone_text_e.getText();
            String nic = nic_text_e.getText();
            String duty = duty_combo_e.getSelectedItem().toString();
            Employee employee = new Employee(emp_id, name, address, telephone, nic, duty);
            int updateEmployee = employeeController.updateEmployee(employee);
            if (updateEmployee > 0) {
                JOptionPane.showMessageDialog(this, "Employee updated");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not updated");
            }
            showEmployeeDetails();
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edit_buttonActionPerformed

    private void employee_name_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employee_name_comboItemStateChanged
        try {
            showEmployeeDetails();
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_employee_name_comboItemStateChanged

    private void employee_attend_name_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employee_attend_name_comboItemStateChanged
        if (employee_attend_name_combo.getSelectedItem() != null) {
            try {
                String text = employee_attend_name_combo.getSelectedItem().toString();
                String id = text.substring(text.length() - 4, text.length());
                Employee searchEmployee = employeeController.searchEmployee(id);
                duty_text.setText(searchEmployee.getDuty());
                
                if ("Waxing in".equals(searchEmployee.getDuty()) | "Waxing out".equals(searchEmployee.getDuty())|"Sewing 1 in".equals(searchEmployee.getDuty()) | "Sewing 1 out".equals(searchEmployee.getDuty())) {
                    salarypanel.setEnabled(false);
                    present_radio.setEnabled(false);
                    absent_radio.setEnabled(false);
                    ot_hour_spinner.setEnabled(false);
                    
                    wagepanel.setEnabled(true);
                    garment_type_combo.setEnabled(true);
                    no_of_pieces_text.setEnabled(true);
                    no_of_pieces_text.setEnabled(true);
                    add_pieces_button.setEnabled(true);
                } else {
                    wagepanel.setEnabled(false);
                    garment_type_combo.setEnabled(false);
                    no_of_pieces_text.setEnabled(false);
                    no_of_pieces_text.setEnabled(false);
                    add_pieces_button.setEnabled(false);
                    
                    salarypanel.setEnabled(true);
                    present_radio.setEnabled(true);
                    absent_radio.setEnabled(true);
                    ot_hour_spinner.setEnabled(true);
                    
                }
            } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_employee_attend_name_comboItemStateChanged

    private void add_pieces_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_pieces_buttonActionPerformed
        String text=garment_type_combo.getSelectedItem().toString();
        String[] two=text.split(" ");
        String type=two[0];
        String type_id=two[1];
        int no_of_pieces=Integer.valueOf(no_of_pieces_text.getText());
        
        
        DefaultTableModel tableModel = (DefaultTableModel) no_of_pieces_table.getModel();
        boolean added=false;
        //to check if 1 type is adding again
        for(int i=0;i<tableModel.getRowCount();i++){
            if(tableModel.getValueAt(i, 0).toString().equals(type_id)){
                JOptionPane.showMessageDialog(this, "Already Added! Edit in table.");
                added=true;
                break;
            }
        }
        if(!added){
        Object[] rawdata = {type_id, type, no_of_pieces};
        tableModel.addRow(rawdata);
        }
        no_of_pieces_text.setText("");
        add_pieces_button.setEnabled(false);
        
    }//GEN-LAST:event_add_pieces_buttonActionPerformed

    private void no_of_pieces_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_of_pieces_textKeyReleased
        String newtext = PatternChecker.checkInteger(no_of_pieces_text.getText());
        no_of_pieces_text.setText(newtext);
        if(no_of_pieces_text.getText().trim().length()!=0 && garment_type_combo.getSelectedItem()!=""){
            add_pieces_button.setEnabled(true);
        }else{
            add_pieces_button.setEnabled(false);
        }
        
    }//GEN-LAST:event_no_of_pieces_textKeyReleased

    private void save_attend_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_attend_buttonActionPerformed
        try {
            String text=employee_attend_name_combo.getSelectedItem().toString();
            String emp_id=text.substring(text.length()-4, text.length());
            Employee searchEmployee=employeeController.searchEmployee(emp_id);
            if ("Waxing in".equals(searchEmployee.getDuty()) | "Waxing out".equals(searchEmployee.getDuty())|"Sewing 1 in".equals(searchEmployee.getDuty()) | "Sewing 1 out".equals(searchEmployee.getDuty())) {
            
            }
        } catch (RemoteException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_save_attend_buttonActionPerformed
    //private method to auto update details of selected Employee
    private void showEmployeeDetails() throws RemoteException, SQLException, ClassNotFoundException {
        if (employee_name_combo.getSelectedItem() != null) {
            String text = employee_name_combo.getSelectedItem().toString();
            String id = text.substring(text.length() - 4, text.length());
            Employee searchEmployee = employeeController.searchEmployee(id);
            if (searchEmployee != null) {
                name_text_e.setText(searchEmployee.getName());
                address_text_e.setText(searchEmployee.getAddress());
                nic_text_e.setText(searchEmployee.getNic());
                telephone_text_e.setText(searchEmployee.getTelephone());
                duty_combo_e.setSelectedItem(searchEmployee.getDuty());
            } else {
                name_text_e.setText("");
                address_text_e.setText("");
                nic_text_e.setText("");
                telephone_text_e.setText("");
                duty_combo_e.setSelectedItem("");
            }
        }
    }

    private void createNewForm() throws RemoteException, SQLException, ClassNotFoundException {
        name_text.setText("");
        address_text.setText("");
        telephone_text.setText("");
        nic_text.setText("");
        duty_combo.setSelectedIndex(0);
        regno_text.setText(IdGenerator.generateNextEmployeeID(employeeController.getLastEmpId()));
    }

    public void requestFoucsForm() {
        name_text.requestFocus();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton absent_radio;
    private javax.swing.JButton add_pieces_button;
    private javax.swing.JTextArea address_text;
    private javax.swing.JTextArea address_text_e;
    private javax.swing.JLabel addresslabel;
    private javax.swing.JLabel addresslabel1;
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton cancel_button3;
    private javax.swing.JButton cancel_button_e;
    private javax.swing.JTextField date_text;
    private javax.swing.JComboBox<String> duty_combo;
    private javax.swing.JComboBox<String> duty_combo_e;
    private javax.swing.JTextField duty_text;
    private javax.swing.JLabel dutylabel;
    private javax.swing.JLabel dutylabel1;
    private javax.swing.JButton edit_button;
    private javax.swing.JComboBox<String> employee_attend_name_combo;
    private javax.swing.JComboBox<String> employee_name_combo;
    private javax.swing.JComboBox<String> garment_type_combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField name_text_e;
    private javax.swing.JLabel namelabel;
    private javax.swing.JLabel namelabel1;
    private javax.swing.JLabel nic_invalid_label;
    private javax.swing.JLabel nic_invalid_label1;
    private javax.swing.JTextField nic_text;
    private javax.swing.JTextField nic_text_e;
    private javax.swing.JLabel niclabel;
    private javax.swing.JLabel niclabel1;
    private javax.swing.JTable no_of_pieces_table;
    private javax.swing.JTextField no_of_pieces_text;
    private javax.swing.JSpinner ot_hour_spinner;
    private javax.swing.ButtonGroup pre_ab_group;
    private javax.swing.JRadioButton present_radio;
    private javax.swing.JLabel reg_no_label;
    private javax.swing.JLabel reg_no_label1;
    private javax.swing.JTextField regno_text;
    private javax.swing.JPanel salarypanel;
    private javax.swing.JButton save_attend_button;
    private javax.swing.JButton save_button;
    private javax.swing.JTabbedPane tabpane;
    private javax.swing.JLabel tel_no_invalid_label;
    private javax.swing.JLabel tel_no_invalid_label1;
    private javax.swing.JTextField telephone_text;
    private javax.swing.JTextField telephone_text_e;
    private javax.swing.JLabel telephonelabel;
    private javax.swing.JLabel telephonelabel1;
    private javax.swing.JPanel wagepanel;
    // End of variables declaration//GEN-END:variables

    void focustabbedpane(int num) {
        tabpane.setSelectedIndex(num);
    }
}
