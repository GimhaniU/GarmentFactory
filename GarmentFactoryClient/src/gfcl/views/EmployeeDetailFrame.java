/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.views;

import gfc.controller.EmpWageController;
import gfc.controller.EmployeeController;
import gfc.controller.GarmentController;
import gfc.controller.PieceCoverageController;
import gfc.models.EmpWage;
import gfc.models.Employee;
import gfc.models.PieceCoverage;
import gfcl.common_classes.ComboItemsAdder;
import gfcl.common_classes.IdGenerator;
import gfcl.common_classes.PatternChecker;
import gfcl.connector.Connector;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gimhani Uthpala
 */
public class EmployeeDetailFrame extends javax.swing.JInternalFrame {

    private EmployeeController employeeController;
    private GarmentController garmentController;
    private PieceCoverageController pieceCoverageController;
    private EmpWageController empWageController;

    private ComboItemsAdder cia;

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
            pieceCoverageController = sConnector.getPieceCoverageController();
            empWageController = sConnector.getEmpWageController();
            cia = new ComboItemsAdder();

            System.out.println(IdGenerator.generateNextEmployeeID(employeeController.getLastEmpId()));
            regno_text.setText(IdGenerator.generateNextEmployeeID(employeeController.getLastEmpId()));

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            date_text.setText(dateFormat.format(date));
            today_text.setText(dateFormat.format(date));

            Calendar now = Calendar.getInstance();   // Get the current date and time
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH) + 1;
            month_combo.setSelectedItem(PatternChecker.getMonthName(month));
            for (int i = 0; i < 50; i++) {
                year_combo.addItem(String.valueOf(year));
                year--;
            }

            tel_no_invalid_label.setVisible(false);
            nic_invalid_label.setVisible(false);
            tel_no_invalid_label1.setVisible(false);
            nic_invalid_label1.setVisible(false);
            invalid_date_format_label.setVisible(false);
            invalid_date_format_label1.setVisible(false);
            additions_invalid_label.setVisible(false);
            deductions_invalid_label.setVisible(false);

            //to autoadd names to combo box
            this.employee_name_combo.setEditable(true);
            cia.addSimilarEmployeenames(employee_name_combo);

            this.employee_attend_name_combo.setEditable(true);
            cia.addSimilarEmployeenames(employee_attend_name_combo);

            this.garment_type_combo.setEditable(true);
            cia.addSimilarGarmentNames(garment_type_combo);

            this.sal_employee_combo.setEditable(true);
            cia.addSimilarEmployeenames(sal_employee_combo);

            attendance_tab.setEnabled(false);
            salary_tabpane.setEnabled(false);
            //disabling in pay salary
            calculate_gross_sal_button.setEnabled(false);
            calculate_net_salary_button.setEnabled(false);

            //setting default values
            additions_text.setText("0");
            deductions_text.setText("0");
            additions_piece_text.setText("0");
            deductions_piece_text.setText("0");

        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    EmployeeDetailFrame(String nic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDisabledTabs(boolean tab1,boolean tab2,boolean tab3,boolean tab4){
        tabpane.setEnabledAt(0,tab1 );
        tabpane.setEnabledAt(1,tab2 );
        tabpane.setEnabledAt(2,tab3 );
        tabpane.setEnabledAt(3,tab4 );
    }
    public void setUpdateButton(boolean update){
        edit_button.setEnabled(update);
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
        main_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabpane = new javax.swing.JTabbedPane();
        add_new_employee_panel = new javax.swing.JPanel();
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
        search_employee_panel = new javax.swing.JPanel();
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
        mark_attendance_panel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date_text = new javax.swing.JTextField();
        employee_attend_name_combo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        duty_text = new javax.swing.JTextField();
        invalid_date_format_label = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        save_attend_button = new javax.swing.JButton();
        cancel_button3 = new javax.swing.JButton();
        attendance_tab = new javax.swing.JTabbedPane();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        wagepanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        no_of_pieces_text = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        garment_type_combo = new javax.swing.JComboBox<>();
        add_pieces_button = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        no_of_pieces_table = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        salarypanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        present_radio = new javax.swing.JRadioButton();
        absent_radio = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        ot_hour_spinner = new javax.swing.JSpinner();
        pay_salary_panel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        today_text = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        month_combo = new javax.swing.JComboBox<>();
        year_combo = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        sal_employee_combo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        duty_label = new javax.swing.JTextField();
        invalid_date_format_label1 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        salary_tabpane = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        piece_coverage_table = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        calculated_stipend_text = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        additions_piece_text = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        deductions_piece_text = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        cancel_sal_pieces_button = new javax.swing.JButton();
        save_sal_pieces_button = new javax.swing.JButton();
        cal_net_sal_pieces_button = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        salary_pieces_text = new javax.swing.JTextField();
        deductions_invalid_label = new javax.swing.JLabel();
        additions_invalid_label = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel24 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        no_of_days_text = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        no_of_ot_hours_text = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        additions_text = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        net_salary_text = new javax.swing.JTextField();
        deductions_text = new javax.swing.JTextField();
        salary_text = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        daily_wage_text = new javax.swing.JTextField();
        hourly_rate_text = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        calculate_net_salary_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        calculate_gross_sal_button = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        calcel_btn_sal = new javax.swing.JButton();
        update_Salary = new javax.swing.JButton();

        tabpane.setForeground(new java.awt.Color(0, 51, 255));
        tabpane.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        regno_text.setEditable(false);
        regno_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        regno_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regno_textActionPerformed(evt);
            }
        });

        reg_no_label.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        reg_no_label.setText("Reg.No:");

        name_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        name_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_textKeyReleased(evt);
            }
        });

        namelabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        namelabel.setText("Name:");

        nic_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        nic_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nic_textKeyReleased(evt);
            }
        });

        niclabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        niclabel.setText("NIC :");

        addresslabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        addresslabel.setText("Address :");

        telephone_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        telephone_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telephone_textKeyReleased(evt);
            }
        });

        telephonelabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        telephonelabel.setText("Telephone:");

        address_text.setColumns(20);
        address_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        address_text.setRows(5);
        address_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_textKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(address_text);

        dutylabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        dutylabel.setText("Duty:");

        duty_combo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        duty_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Store", "Cutting", "Sewing 1 in", "Sewing 1 out", "Waxing in", "Waxing out", "Dyeing", "DryWashing", "Sewing 2", "Finishing", "Sales" }));

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        save_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/save_small.png"))); // NOI18N
        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        cancel_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        cancel_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/cancel_icon.png"))); // NOI18N
        cancel_button.setText("Cancel");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addComponent(save_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel_button)
                .addGap(55, 55, 55))
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

        tel_no_invalid_label.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        tel_no_invalid_label.setForeground(new java.awt.Color(255, 0, 0));
        tel_no_invalid_label.setText("invalid");

        nic_invalid_label.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        nic_invalid_label.setForeground(new java.awt.Color(255, 0, 0));
        nic_invalid_label.setText("invalid");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dutylabel)
                                    .addComponent(reg_no_label))
                                .addGap(57, 57, 57)))
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
                            .addComponent(name_text)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regno_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reg_no_label))
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
        );

        javax.swing.GroupLayout add_new_employee_panelLayout = new javax.swing.GroupLayout(add_new_employee_panel);
        add_new_employee_panel.setLayout(add_new_employee_panelLayout);
        add_new_employee_panelLayout.setHorizontalGroup(
            add_new_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_new_employee_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(642, Short.MAX_VALUE))
        );
        add_new_employee_panelLayout.setVerticalGroup(
            add_new_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_new_employee_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(516, Short.MAX_VALUE))
        );

        tabpane.addTab("Add New Employee", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/employee_add_s.png")), add_new_employee_panel); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reg_no_label1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        reg_no_label1.setText("Enter name:");

        name_text_e.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        name_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_text_eKeyReleased(evt);
            }
        });

        namelabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        namelabel1.setText("Name:");

        nic_text_e.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        nic_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nic_text_eKeyReleased(evt);
            }
        });

        niclabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        niclabel1.setText("NIC :");

        addresslabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        addresslabel1.setText("Address :");

        telephone_text_e.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        telephone_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telephone_text_eKeyReleased(evt);
            }
        });

        telephonelabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        telephonelabel1.setText("Telephone:");

        address_text_e.setColumns(20);
        address_text_e.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        address_text_e.setRows(5);
        address_text_e.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_text_eKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(address_text_e);

        dutylabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        dutylabel1.setText("Duty:");

        duty_combo_e.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        duty_combo_e.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Store", "Cutting", "Sewing 1 in", "Sewing 1 out", "Waxing in", "Waxing out", "Dyeing", "DryWashing", "Sewing 2", "Finishing", "Sales" }));

        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        edit_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        edit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/update_small.png"))); // NOI18N
        edit_button.setText("Update");
        edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_buttonActionPerformed(evt);
            }
        });

        cancel_button_e.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        cancel_button_e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/cancel_icon.png"))); // NOI18N
        cancel_button_e.setText("Cancel");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(328, Short.MAX_VALUE)
                .addComponent(edit_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel_button_e)
                .addGap(56, 56, 56))
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

        tel_no_invalid_label1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        tel_no_invalid_label1.setForeground(new java.awt.Color(255, 0, 0));
        tel_no_invalid_label1.setText("invalid");

        nic_invalid_label1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        nic_invalid_label1.setForeground(new java.awt.Color(255, 0, 0));
        nic_invalid_label1.setText("invalid");

        employee_name_combo.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
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
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
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
                            .addComponent(employee_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(reg_no_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(742, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employee_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
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

        javax.swing.GroupLayout search_employee_panelLayout = new javax.swing.GroupLayout(search_employee_panel);
        search_employee_panel.setLayout(search_employee_panelLayout);
        search_employee_panelLayout.setHorizontalGroup(
            search_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_employee_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        search_employee_panelLayout.setVerticalGroup(
            search_employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_employee_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );

        tabpane.addTab("Search employee ", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/employee_search_s.png")), search_employee_panel); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel1.setText("Employee name:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel2.setText("Date:");

        date_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        date_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                date_textKeyReleased(evt);
            }
        });

        employee_attend_name_combo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        employee_attend_name_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employee_attend_name_comboItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel7.setText("Task:");

        duty_text.setEditable(false);
        duty_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        invalid_date_format_label.setForeground(new java.awt.Color(255, 0, 0));
        invalid_date_format_label.setText("Invalid date format");

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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(duty_text, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_text, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalid_date_format_label, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(duty_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalid_date_format_label))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        save_attend_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        save_attend_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/save_small.png"))); // NOI18N
        save_attend_button.setText("Save");
        save_attend_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_attend_buttonActionPerformed(evt);
            }
        });

        cancel_button3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        cancel_button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/cancel_icon.png"))); // NOI18N
        cancel_button3.setText("Cancel");
        cancel_button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_attend_button, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        attendance_tab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        attendance_tab.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N

        wagepanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paid for no. of pieces completed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 2, 11))); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setText("No. of Pieces covered:");

        no_of_pieces_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        no_of_pieces_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_of_pieces_textKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel4.setText("Type of Garment:");

        garment_type_combo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        add_pieces_button.setFont(new java.awt.Font("Perpetua Titling MT", 3, 11)); // NOI18N
        add_pieces_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/Add.png"))); // NOI18N
        add_pieces_button.setText("Add");
        add_pieces_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_pieces_buttonActionPerformed(evt);
            }
        });

        no_of_pieces_table.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
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
        no_of_pieces_table.setToolTipText("You cam edit no. of pieces in the table column");
        no_of_pieces_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(no_of_pieces_table);

        javax.swing.GroupLayout wagepanelLayout = new javax.swing.GroupLayout(wagepanel);
        wagepanel.setLayout(wagepanelLayout);
        wagepanelLayout.setHorizontalGroup(
            wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(wagepanelLayout.createSequentialGroup()
                        .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(wagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(add_pieces_button)
                                .addGroup(wagepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(no_of_pieces_text, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(wagepanelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(garment_type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(wagepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        attendance_tab.addTab("Salary", jPanel29);

        salarypanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paid for attendance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 2, 11))); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel5.setText("Presence:");

        pre_ab_group.add(present_radio);
        present_radio.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        present_radio.setText("Present");

        pre_ab_group.add(absent_radio);
        absent_radio.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        absent_radio.setText("Absent");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
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
                .addContainerGap(317, Short.MAX_VALUE))
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
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(salarypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 116, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addComponent(salarypanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        attendance_tab.addTab("Wage", jPanel30);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(attendance_tab)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attendance_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mark_attendance_panelLayout = new javax.swing.GroupLayout(mark_attendance_panel);
        mark_attendance_panel.setLayout(mark_attendance_panelLayout);
        mark_attendance_panelLayout.setHorizontalGroup(
            mark_attendance_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mark_attendance_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mark_attendance_panelLayout.setVerticalGroup(
            mark_attendance_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mark_attendance_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabpane.addTab("Mark Attendance", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/mark_attendance_s.png")), mark_attendance_panel); // NOI18N

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel8.setText("Date:");

        today_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        today_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                today_textKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel9.setText("Select month:");

        month_combo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        month_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        year_combo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel10.setText("Select employee:");

        sal_employee_combo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        sal_employee_combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sal_employee_comboItemStateChanged(evt);
            }
        });
        sal_employee_combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sal_employee_comboKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel11.setText("Duty:");

        duty_label.setEditable(false);
        duty_label.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sal_employee_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duty_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(sal_employee_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(duty_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        invalid_date_format_label1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        invalid_date_format_label1.setForeground(new java.awt.Color(255, 0, 0));
        invalid_date_format_label1.setText("Invalid date format");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(month_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(year_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(today_text, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalid_date_format_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(today_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(month_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(year_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(invalid_date_format_label1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        salary_tabpane.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Piece Coverage for this month", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 2, 11))); // NOI18N

        piece_coverage_table.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        piece_coverage_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "GarmentID", "No. of Pieces", "Stipend"
            }
        ));
        jScrollPane10.setViewportView(piece_coverage_table);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel20.setText("Total calculated stipend for pieces:");

        calculated_stipend_text.setEditable(false);
        calculated_stipend_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel21.setText("Additions:");

        additions_piece_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        additions_piece_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                additions_piece_textKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel22.setText("Deductions:");

        deductions_piece_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        deductions_piece_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deductions_piece_textKeyReleased(evt);
            }
        });

        jPanel27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cancel_sal_pieces_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        cancel_sal_pieces_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/cancel_icon.png"))); // NOI18N
        cancel_sal_pieces_button.setText("Cancel");

        save_sal_pieces_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        save_sal_pieces_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/save_small.png"))); // NOI18N
        save_sal_pieces_button.setText("Save");
        save_sal_pieces_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_sal_pieces_buttonActionPerformed(evt);
            }
        });
        save_sal_pieces_button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                save_sal_pieces_buttonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_sal_pieces_button, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel_sal_pieces_button)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_sal_pieces_button)
                    .addComponent(save_sal_pieces_button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cal_net_sal_pieces_button.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        cal_net_sal_pieces_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/calculator.png"))); // NOI18N
        cal_net_sal_pieces_button.setText("Calculate net salary");
        cal_net_sal_pieces_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cal_net_sal_pieces_buttonActionPerformed(evt);
            }
        });
        cal_net_sal_pieces_button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cal_net_sal_pieces_buttonKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel23.setText("Salary:");

        salary_pieces_text.setEditable(false);
        salary_pieces_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        deductions_invalid_label.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        deductions_invalid_label.setForeground(new java.awt.Color(255, 0, 0));
        deductions_invalid_label.setText("Please add the deductions in rupees");

        additions_invalid_label.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        additions_invalid_label.setForeground(new java.awt.Color(255, 0, 0));
        additions_invalid_label.setText("Please add the additions in rupees");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salary_pieces_text, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calculated_stipend_text, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(additions_piece_text, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cal_net_sal_pieces_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(deductions_piece_text, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(additions_invalid_label)
                                    .addComponent(deductions_invalid_label))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(calculated_stipend_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(additions_piece_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(deductions_piece_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deductions_invalid_label))
                        .addGap(18, 18, 18)
                        .addComponent(cal_net_sal_pieces_button)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(salary_pieces_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(additions_invalid_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel23);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        salary_tabpane.addTab("Salary", jPanel21);

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel12.setText("No. of Days:");

        no_of_days_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        no_of_days_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_of_days_textKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel13.setText("Total OT hours:");

        no_of_ot_hours_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        no_of_ot_hours_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_of_ot_hours_textKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel14.setText("Net salary:");

        additions_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        additions_text.setForeground(new java.awt.Color(102, 102, 102));
        additions_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                additions_textKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel15.setText("Additions:");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel16.setText("Deductions:");

        net_salary_text.setEditable(false);
        net_salary_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        deductions_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        deductions_text.setForeground(new java.awt.Color(102, 102, 102));
        deductions_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deductions_textKeyReleased(evt);
            }
        });

        salary_text.setEditable(false);
        salary_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel17.setText("Salary:");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel18.setText("Add daily wage:");

        daily_wage_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        daily_wage_text.setForeground(new java.awt.Color(102, 102, 102));
        daily_wage_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                daily_wage_textKeyReleased(evt);
            }
        });

        hourly_rate_text.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        hourly_rate_text.setForeground(new java.awt.Color(102, 102, 102));
        hourly_rate_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hourly_rate_textKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel19.setText("Add hourly rate:");

        calculate_net_salary_button.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        calculate_net_salary_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/calculator.png"))); // NOI18N
        calculate_net_salary_button.setText("Calculate net salary");
        calculate_net_salary_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate_net_salary_buttonActionPerformed(evt);
            }
        });

        calculate_gross_sal_button.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        calculate_gross_sal_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/calculator.png"))); // NOI18N
        calculate_gross_sal_button.setText("Calculate gross  salary");
        calculate_gross_sal_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculate_gross_sal_buttonActionPerformed(evt);
            }
        });
        calculate_gross_sal_button.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calculate_gross_sal_buttonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salary_text, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deductions_text, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calculate_net_salary_button, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(net_salary_text, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(additions_text)
                                    .addComponent(no_of_days_text)
                                    .addComponent(daily_wage_text))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hourly_rate_text)
                                    .addComponent(no_of_ot_hours_text, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                            .addComponent(calculate_gross_sal_button, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 246, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(no_of_days_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(no_of_ot_hours_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(daily_wage_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hourly_rate_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(24, 24, 24)
                .addComponent(calculate_net_salary_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(net_salary_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(additions_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(deductions_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calculate_gross_sal_button)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(salary_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        calcel_btn_sal.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        calcel_btn_sal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/cancel_icon.png"))); // NOI18N
        calcel_btn_sal.setText("Cancel");

        update_Salary.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        update_Salary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/save_small.png"))); // NOI18N
        update_Salary.setText("SAVE");
        update_Salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_SalaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(update_Salary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calcel_btn_sal)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcel_btn_sal)
                    .addComponent(update_Salary))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel24);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
        );

        salary_tabpane.addTab("Wage", jPanel22);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salary_tabpane)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salary_tabpane, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pay_salary_panelLayout = new javax.swing.GroupLayout(pay_salary_panel);
        pay_salary_panel.setLayout(pay_salary_panelLayout);
        pay_salary_panelLayout.setHorizontalGroup(
            pay_salary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pay_salary_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        pay_salary_panelLayout.setVerticalGroup(
            pay_salary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pay_salary_panelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        tabpane.addTab("Pay Salary", new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/table_money_s.png")), pay_salary_panel); // NOI18N

        jScrollPane1.setViewportView(tabpane);

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                .addContainerGap())
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && address_text.getText().trim().length() != 0) {
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
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && name_text_e.getText().trim().length() != 0) {
            nic_text_e.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            nic_text_e.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            employee_name_combo.requestFocus();
        }
    }//GEN-LAST:event_name_text_eKeyReleased

    private void nic_text_eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nic_text_eKeyReleased
        nic_invalid_label1.setVisible(false);
        String newtext = PatternChecker.checkNIC(nic_text_e.getText());
        nic_text_e.setText(newtext);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (PatternChecker.checkNICdirect(nic_text_e.getText())) {
                address_text_e.requestFocus();
            } else {
                nic_invalid_label1.setVisible(true);
            }
        }
    }//GEN-LAST:event_nic_text_eKeyReleased

    private void telephone_text_eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephone_text_eKeyReleased
        tel_no_invalid_label1.setVisible(false);
        String newtext = PatternChecker.checkTelNum(telephone_text_e.getText());
        telephone_text_e.setText(newtext);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (PatternChecker.checkTelNumdirect(telephone_text_e.getText())) {
                duty_combo_e.requestFocus();
            } else {
                tel_no_invalid_label1.setVisible(true);
            }
        }
    }//GEN-LAST:event_telephone_text_eKeyReleased

    private void address_text_eKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_text_eKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && address_text_e.getText().trim().length() != 0) {
            telephone_text_e.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            telephone_text_e.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            nic_text_e.requestFocus();
        }
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
                if (text.length() > 4) {
                    String id = text.substring(text.length() - 4, text.length());
                    Employee searchEmployee = employeeController.searchEmployee(id);
                    duty_text.setText(searchEmployee.getDuty());

                    if ("Waxing in".equals(searchEmployee.getDuty()) | "Waxing out".equals(searchEmployee.getDuty()) | "Sewing 1 in".equals(searchEmployee.getDuty()) | "Sewing 1 out".equals(searchEmployee.getDuty())) {
                        attendance_tab.setSelectedIndex(0);
                        attendance_tab.setEnabledAt(1, false);
                    } else {
                        attendance_tab.setSelectedIndex(1);
                        attendance_tab.setEnabledAt(0, false);
                    }
                }
            } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_employee_attend_name_comboItemStateChanged

    private void add_pieces_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_pieces_buttonActionPerformed
        String text = garment_type_combo.getSelectedItem().toString();
        String[] two = text.split(" ");
        String type = two[0];
        String type_id = two[1];
        int no_of_pieces = Integer.valueOf(no_of_pieces_text.getText());

        DefaultTableModel tableModel = (DefaultTableModel) no_of_pieces_table.getModel();
        boolean added = false;
        //to check if 1 type is adding again
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equals(type_id)) {
                JOptionPane.showMessageDialog(this, "Already Added! Edit in table.");
                added = true;
                break;
            }
        }
        if (!added) {
            Object[] rawdata = {type_id, type, no_of_pieces};
            tableModel.addRow(rawdata);
        }
        no_of_pieces_text.setText("");
        add_pieces_button.setEnabled(false);

    }//GEN-LAST:event_add_pieces_buttonActionPerformed

    private void no_of_pieces_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_of_pieces_textKeyReleased
        String newtext = PatternChecker.checkInteger(no_of_pieces_text.getText());
        no_of_pieces_text.setText(newtext);
        if (no_of_pieces_text.getText().trim().length() != 0 && garment_type_combo.getSelectedItem() != "") {
            add_pieces_button.setEnabled(true);
        } else {
            add_pieces_button.setEnabled(false);
        }

    }//GEN-LAST:event_no_of_pieces_textKeyReleased

    private void save_attend_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_attend_buttonActionPerformed
        boolean dateFormatChecker = PatternChecker.dateFormatChecker(date_text.getText());
        if (!dateFormatChecker) {
            invalid_date_format_label.setVisible(true);
            date_text.requestFocus();
        } else {
            try {
                String text = employee_attend_name_combo.getSelectedItem().toString();
                String emp_id = text.substring(text.length() - 4, text.length());
                String date = date_text.getText();
                DefaultTableModel dtm = (DefaultTableModel) no_of_pieces_table.getModel();
                Employee searchEmployee = employeeController.searchEmployee(emp_id);
                if ("Waxing in".equals(searchEmployee.getDuty()) | "Waxing out".equals(searchEmployee.getDuty()) | "Sewing 1 in".equals(searchEmployee.getDuty()) | "Sewing 1 out".equals(searchEmployee.getDuty())) {
                    ArrayList<PieceCoverage> pcs = new ArrayList<>();
                    for (int i = 0; i < no_of_pieces_table.getRowCount(); i++) {
                        String garment_id = dtm.getValueAt(i, 0).toString();
                        int no_ofpieces = Integer.valueOf(dtm.getValueAt(i, 2).toString());
                        PieceCoverage pc = new PieceCoverage(emp_id, garment_id, date, no_ofpieces);
                        pcs.add(pc);
                    }
                    int addPieceCoverage = pieceCoverageController.addPieceCoverage(pcs);

                    if (addPieceCoverage > 0) {
                        JOptionPane.showMessageDialog(this, "Marked successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Marked failed!");
                    }

                } else {
                    int presence = 0;
                    if (present_radio.isSelected()) {
                        presence = 1;
                    }
                    int ot_hours = Integer.valueOf(ot_hour_spinner.getValue().toString());
                    String day[] = date.split("-");
                    int dat[] = new int[3];
                    for (int i = 0; i < 3; i++) {
                        dat[i] = Integer.valueOf(day[i]);
                    }
                    EmpWage employee = empWageController.getEmployeeAttendance(emp_id, dat[1], dat[0]);
                    EmpWage new_employee;
                    if (employee != null) {
                        new_employee = new EmpWage(emp_id, dat[1], dat[0], employee.getNo_of_days() + presence, employee.getOt_hours() + ot_hours);
                    } else {
                        new_employee = new EmpWage(emp_id, dat[1], dat[0], presence, ot_hours);
                    }

                    int addEmployeeAttendance = empWageController.addEmployeeAttendance(new_employee);
                    if (addEmployeeAttendance > 0) {
                        JOptionPane.showMessageDialog(this, "Marked successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Marked failed!");
                    }
                }

                //clearing the form
                employee_attend_name_combo.setSelectedItem(null);
                duty_text.setText("");
                garment_type_combo.setSelectedItem(null);
                no_of_pieces_text.setText("");
                ((DefaultTableModel) no_of_pieces_table.getModel()).setRowCount(0);
                present_radio.setSelected(false);
                absent_radio.setSelected(false);
                ot_hour_spinner.setValue(0);

            } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_save_attend_buttonActionPerformed

    private void cancel_button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_button3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel_button3ActionPerformed

    private void sal_employee_comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sal_employee_comboItemStateChanged
        if (sal_employee_combo.getSelectedItem() != null) {
            try {
                //setting common components
                String selected = sal_employee_combo.getSelectedItem().toString();
                if (selected.length() > 4) {
                    String emp_id = selected.substring(selected.length() - 4);
                    int month = PatternChecker.getMonthNumber(month_combo.getSelectedItem().toString());
                    int year = Integer.valueOf(year_combo.getSelectedItem().toString());
                    Employee searchEmployee = employeeController.searchEmployee(emp_id);
                    if (searchEmployee != null) {
                        duty_label.setText(searchEmployee.getDuty());
                        if ("Waxing in".equals(searchEmployee.getDuty()) | "Waxing out".equals(searchEmployee.getDuty()) | "Sewing 1 in".equals(searchEmployee.getDuty()) | "Sewing 1 out".equals(searchEmployee.getDuty())) {
                            //for waxing ans sewing
                            salary_tabpane.setSelectedIndex(0);
                            salary_tabpane.setEnabledAt(1, false);
                            EmpWage employeePieceSalary = empWageController.getEmployeePieceSalary(emp_id, month, year);
                            //if already added salary present
                            if (employeePieceSalary != null) {
                                calculated_stipend_text.setText(String.valueOf(employeePieceSalary.getTotal_stipend()));
                                additions_piece_text.setText(String.valueOf(employeePieceSalary.getAdditions()));
                                deductions_piece_text.setText(String.valueOf(employeePieceSalary.getDeductions()));

                                double salary = employeePieceSalary.getTotal_stipend() + employeePieceSalary.getAdditions() - employeePieceSalary.getDeductions();
                                salary_pieces_text.setText(String.valueOf(salary));
                            }
                            ArrayList<PieceCoverage> pieceCoverage = pieceCoverageController.getPieceCoverage(emp_id, month, year);
                            DefaultTableModel dtm = (DefaultTableModel) piece_coverage_table.getModel();
                            dtm.setRowCount(0);
                            double total_stipend = 0;
                            //adding covered pieces information to table
                            for (PieceCoverage pc : pieceCoverage) {
                                double stipend = 0;
                                if ("Waxing in".equals(searchEmployee.getDuty()) | "Waxing out".equals(searchEmployee.getDuty())) {
                                    stipend = pc.getWaxing_stipend();
                                } else {
                                    stipend = pc.getSewing_stipend();
                                }
                                Object[] rawdata = {pc.getDateOfWork(), pc.getGarment_id(), pc.getNo_of_pieces(), stipend};
                                dtm.addRow(rawdata);
                                total_stipend += stipend * pc.getNo_of_pieces();
                            }
                            total_stipend = PatternChecker.round(total_stipend, 2);
                            calculated_stipend_text.setText(String.valueOf(total_stipend));
                            additions_piece_text.requestFocus();
                        } else {
                            //if for daily paid jobs
                            salary_tabpane.setSelectedIndex(1);
                            salary_tabpane.setEnabledAt(0, false);
                            EmpWage wage_emp = empWageController.getEmployeeWage(emp_id, month, year);
                            //filling currently available data
                            if (wage_emp != null) {
                                no_of_days_text.setText(String.valueOf(wage_emp.getNo_of_days()));
                                no_of_ot_hours_text.setText(String.valueOf(wage_emp.getOt_hours()));
                                daily_wage_text.setText(String.valueOf(wage_emp.getDailywage()));
                                hourly_rate_text.setText(String.valueOf(wage_emp.getOt_rate()));
                                calculate_net_salary_button.doClick();
                                additions_text.setText(String.valueOf(wage_emp.getAdditions()));
                                deductions_text.setText(String.valueOf(wage_emp.getDeductions()));
                                calculate_gross_sal_button.doClick();
                            }
                            daily_wage_text.requestFocus();
                        }
                    }
                }
            } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_sal_employee_comboItemStateChanged

    private void calculate_net_salary_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculate_net_salary_buttonActionPerformed
        if (no_of_days_text.getText().trim().length() == 0) {
            no_of_days_text.setText("0");
        }
        if (no_of_ot_hours_text.getText().trim().length() == 0) {
            no_of_ot_hours_text.setText("0");
        }
        if (daily_wage_text.getText().trim().length() == 0) {
            daily_wage_text.setText("0");
        }
        if (hourly_rate_text.getText().trim().length() == 0) {
            hourly_rate_text.setText("0");
        }

        int no_of_days = Integer.valueOf(no_of_days_text.getText());
        int ot_hours = Integer.valueOf(no_of_ot_hours_text.getText());
        double daily_wage = Double.valueOf(daily_wage_text.getText());
        double hourly_rate = Double.valueOf(hourly_rate_text.getText());
        double net_salary = PatternChecker.round((no_of_days * daily_wage) + (ot_hours * hourly_rate), 2);
        net_salary_text.setText(String.valueOf(net_salary));
        calculate_gross_sal_button.setEnabled(true);
    }//GEN-LAST:event_calculate_net_salary_buttonActionPerformed

    private void calculate_gross_sal_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculate_gross_sal_buttonActionPerformed
        if (!"".equals(additions_text.getText()) && !"".equals(deductions_text.getText()) && !"".equals(net_salary_text.getText())) {
            double net_salary = Double.valueOf(net_salary_text.getText());
            double additions = Double.valueOf(additions_text.getText());
            double deductions = Double.valueOf(deductions_text.getText());
            double salary = net_salary + additions - deductions;
            salary_text.setText(String.valueOf(salary));
        } else if ("".equals(additions_text.getText())) {
            JOptionPane.showMessageDialog(this, "Set the additions value in rupees");
        } else if ("".equals(deductions_text.getText())) {
            JOptionPane.showMessageDialog(this, "Set the deductions value in rupees");
        } else if ("".equals(net_salary_text.getText())) {
            JOptionPane.showMessageDialog(this, "Click net salary button again");
        }

    }//GEN-LAST:event_calculate_gross_sal_buttonActionPerformed

    private void daily_wage_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daily_wage_textKeyReleased
        String checkDecimal = PatternChecker.checkDecimal(daily_wage_text.getText());
        daily_wage_text.setText(checkDecimal);

        daily_wage_text.setForeground(Color.black);
        if (!"".equals(daily_wage_text.getText()) && !"".equals(hourly_rate_text.getText())) {  //check for empty string
            if (Double.valueOf(daily_wage_text.getText()) != 0 && Double.valueOf(hourly_rate_text.getText()) != 0) { //check for value
                calculate_net_salary_button.setEnabled(true);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            no_of_days_text.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            calculate_net_salary_button.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            hourly_rate_text.requestFocus();
        }
    }//GEN-LAST:event_daily_wage_textKeyReleased

    private void hourly_rate_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hourly_rate_textKeyReleased
        String checkDecimal = PatternChecker.checkDecimal(hourly_rate_text.getText());
        hourly_rate_text.setText(checkDecimal);

        hourly_rate_text.setForeground(Color.black);
        if (Double.valueOf(daily_wage_text.getText()) != 0 && Double.valueOf(hourly_rate_text.getText()) != 0) {
            calculate_net_salary_button.setEnabled(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            no_of_ot_hours_text.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            calculate_net_salary_button.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            daily_wage_text.requestFocus();
        }
    }//GEN-LAST:event_hourly_rate_textKeyReleased

    private void update_SalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_SalaryActionPerformed
        try {
            String selected = sal_employee_combo.getSelectedItem().toString();
            String emp_id = selected.substring(selected.length() - 4);
            int month = PatternChecker.getMonthNumber(month_combo.getSelectedItem().toString());
            int year = Integer.valueOf(year_combo.getSelectedItem().toString());
            int no_of_days = Integer.valueOf(no_of_days_text.getText());
            int no_of_ot = Integer.valueOf(no_of_ot_hours_text.getText());
            double daily_wage = Double.valueOf(daily_wage_text.getText());
            double ot_rate = Double.valueOf(hourly_rate_text.getText());
            double additions = Double.valueOf(additions_text.getText());
            double deductions = Double.valueOf(deductions_text.getText());

            EmpWage employee = new EmpWage(emp_id, month, year, no_of_days, no_of_ot, daily_wage, ot_rate, additions, deductions);
            int addEmployeeSalary = empWageController.addEmployeeSalary(employee);
            if (addEmployeeSalary > 0) {
                JOptionPane.showMessageDialog(this, "Salary Added successfully");

            } else {
                JOptionPane.showMessageDialog(this, "Failed to add salary!");
            }
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_update_SalaryActionPerformed

    private void cal_net_sal_pieces_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cal_net_sal_pieces_buttonActionPerformed

        if (deductions_piece_text.getText().trim().length() == 0) {
            deductions_piece_text.setText("0");
        }
        if (additions_piece_text.getText().trim().length() == 0) {
            additions_piece_text.setText("0");
        }
        boolean check_deductions = PatternChecker.checkDecimaldirect(deductions_piece_text.getText());
        boolean check_additions = PatternChecker.checkDecimaldirect(additions_piece_text.getText());

        if (check_additions && check_deductions) {
            double calculated_salary = Double.valueOf(calculated_stipend_text.getText());
            double additions = Double.valueOf(additions_piece_text.getText());
            double deductions = Double.valueOf(deductions_piece_text.getText());
            double net_salary = calculated_salary + additions - deductions;
            salary_pieces_text.setText(String.valueOf(net_salary));
        } else {
            if (!check_additions) {
                additions_invalid_label.setVisible(true);
            }
            if (!check_deductions) {
                deductions_invalid_label.setVisible(true);
            }
        }
    }//GEN-LAST:event_cal_net_sal_pieces_buttonActionPerformed

    private void save_sal_pieces_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_sal_pieces_buttonActionPerformed
        boolean dateFormatChecker = PatternChecker.dateFormatChecker(today_text.getText());
        if (!dateFormatChecker) {
            invalid_date_format_label1.setVisible(true);
            today_text.requestFocus();
        } else {
            try {
                String selected = sal_employee_combo.getSelectedItem().toString();
                String emp_id = selected.substring(selected.length() - 4);
                int month = PatternChecker.getMonthNumber(month_combo.getSelectedItem().toString());
                int year = Integer.valueOf(year_combo.getSelectedItem().toString());
                double total_stipend = Double.valueOf(calculated_stipend_text.getText());
                double additions = Double.valueOf(additions_piece_text.getText());
                double deductions = Double.valueOf(deductions_piece_text.getText());
                EmpWage empwage = new EmpWage(emp_id, month, year, total_stipend, additions, deductions);
                int addEmployeePieceSalary = empWageController.addEmployeePieceSalary(empwage);
                if (addEmployeePieceSalary > 0) {
                    JOptionPane.showMessageDialog(this, "Salary added successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Salary failed to add!");
                }
            } catch (RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeeDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_save_sal_pieces_buttonActionPerformed

    private void additions_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_additions_textKeyReleased
        additions_text.setForeground(Color.black);

    }//GEN-LAST:event_additions_textKeyReleased

    private void deductions_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deductions_textKeyReleased
        deductions_text.setForeground(Color.black);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            calculate_gross_sal_button.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            additions_text.requestFocus();
        }
    }//GEN-LAST:event_deductions_textKeyReleased

    private void date_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_date_textKeyReleased
        invalid_date_format_label.setVisible(false);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean dateFormatChecker = PatternChecker.dateFormatChecker(date_text.getText());
            if (!dateFormatChecker) {
                invalid_date_format_label.setVisible(true);
                date_text.requestFocus();
            }
        }

    }//GEN-LAST:event_date_textKeyReleased

    private void today_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_today_textKeyReleased
        invalid_date_format_label1.setVisible(false);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            boolean dateFormatChecker = PatternChecker.dateFormatChecker(today_text.getText());
            if (!dateFormatChecker) {
                invalid_date_format_label1.setVisible(true);
                today_text.requestFocus();
            }
        }
    }//GEN-LAST:event_today_textKeyReleased

    private void additions_piece_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_additions_piece_textKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (additions_piece_text.getText().trim().length() == 0) {
                if (deductions_piece_text.getText().trim().length() == 0) {
                    cal_net_sal_pieces_button.setEnabled(true);
                } else {
                    cal_net_sal_pieces_button.setEnabled(false);
                }
                additions_piece_text.setText("0");
                deductions_piece_text.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            deductions_piece_text.requestFocus();
        }
    }//GEN-LAST:event_additions_piece_textKeyReleased

    private void deductions_piece_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deductions_piece_textKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (deductions_piece_text.getText().trim().length() == 0) {
                if (additions_piece_text.getText().trim().length() == 0) {
                    cal_net_sal_pieces_button.setEnabled(true);
                } else {
                    cal_net_sal_pieces_button.setEnabled(false);
                }
                deductions_piece_text.setText("0");
                cal_net_sal_pieces_button.doClick();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            additions_piece_text.requestFocus();
        }
    }//GEN-LAST:event_deductions_piece_textKeyReleased

    private void cal_net_sal_pieces_buttonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cal_net_sal_pieces_buttonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            save_sal_pieces_button.requestFocus();
        }
    }//GEN-LAST:event_cal_net_sal_pieces_buttonKeyReleased

    private void save_sal_pieces_buttonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_save_sal_pieces_buttonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            cancel_sal_pieces_button.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            cal_net_sal_pieces_button.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            save_sal_pieces_button.doClick();
        }
    }//GEN-LAST:event_save_sal_pieces_buttonKeyReleased

    private void sal_employee_comboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sal_employee_comboKeyReleased

    }//GEN-LAST:event_sal_employee_comboKeyReleased

    private void no_of_days_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_of_days_textKeyReleased
        String checkInteger = PatternChecker.checkInteger(no_of_days_text.getText());
        no_of_days_text.setText(checkInteger);
    }//GEN-LAST:event_no_of_days_textKeyReleased

    private void no_of_ot_hours_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_of_ot_hours_textKeyReleased
        String checkInteger = PatternChecker.checkInteger(no_of_days_text.getText());
        no_of_days_text.setText(checkInteger);
    }//GEN-LAST:event_no_of_ot_hours_textKeyReleased

    private void calculate_gross_sal_buttonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calculate_gross_sal_buttonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            calculate_gross_sal_button.doClick();
            update_Salary.requestFocus();
        }
    }//GEN-LAST:event_calculate_gross_sal_buttonKeyReleased
    //private method to auto update details of selected Employee
    private void showEmployeeDetails() throws RemoteException, SQLException, ClassNotFoundException {
        if (employee_name_combo.getSelectedItem() != null) {
            String text = employee_name_combo.getSelectedItem().toString();
            if (text.length() > 4) {
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
    private javax.swing.JPanel add_new_employee_panel;
    private javax.swing.JButton add_pieces_button;
    private javax.swing.JLabel additions_invalid_label;
    private javax.swing.JTextField additions_piece_text;
    private javax.swing.JTextField additions_text;
    private javax.swing.JTextArea address_text;
    private javax.swing.JTextArea address_text_e;
    private javax.swing.JLabel addresslabel;
    private javax.swing.JLabel addresslabel1;
    private javax.swing.JTabbedPane attendance_tab;
    private javax.swing.JButton cal_net_sal_pieces_button;
    private javax.swing.JButton calcel_btn_sal;
    private javax.swing.JButton calculate_gross_sal_button;
    private javax.swing.JButton calculate_net_salary_button;
    private javax.swing.JTextField calculated_stipend_text;
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton cancel_button3;
    private javax.swing.JButton cancel_button_e;
    private javax.swing.JButton cancel_sal_pieces_button;
    private javax.swing.JTextField daily_wage_text;
    private javax.swing.JTextField date_text;
    private javax.swing.JLabel deductions_invalid_label;
    private javax.swing.JTextField deductions_piece_text;
    private javax.swing.JTextField deductions_text;
    private javax.swing.JComboBox<String> duty_combo;
    private javax.swing.JComboBox<String> duty_combo_e;
    private javax.swing.JTextField duty_label;
    private javax.swing.JTextField duty_text;
    private javax.swing.JLabel dutylabel;
    private javax.swing.JLabel dutylabel1;
    private javax.swing.JButton edit_button;
    private javax.swing.JComboBox<String> employee_attend_name_combo;
    private javax.swing.JComboBox<String> employee_name_combo;
    private javax.swing.JComboBox<String> garment_type_combo;
    private javax.swing.JTextField hourly_rate_text;
    private javax.swing.JLabel invalid_date_format_label;
    private javax.swing.JLabel invalid_date_format_label1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel mark_attendance_panel;
    private javax.swing.JComboBox<String> month_combo;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField name_text_e;
    private javax.swing.JLabel namelabel;
    private javax.swing.JLabel namelabel1;
    private javax.swing.JTextField net_salary_text;
    private javax.swing.JLabel nic_invalid_label;
    private javax.swing.JLabel nic_invalid_label1;
    private javax.swing.JTextField nic_text;
    private javax.swing.JTextField nic_text_e;
    private javax.swing.JLabel niclabel;
    private javax.swing.JLabel niclabel1;
    private javax.swing.JTextField no_of_days_text;
    private javax.swing.JTextField no_of_ot_hours_text;
    private javax.swing.JTable no_of_pieces_table;
    private javax.swing.JTextField no_of_pieces_text;
    private javax.swing.JSpinner ot_hour_spinner;
    private javax.swing.JPanel pay_salary_panel;
    private javax.swing.JTable piece_coverage_table;
    private javax.swing.ButtonGroup pre_ab_group;
    private javax.swing.JRadioButton present_radio;
    private javax.swing.JLabel reg_no_label;
    private javax.swing.JLabel reg_no_label1;
    private javax.swing.JTextField regno_text;
    private javax.swing.JComboBox<String> sal_employee_combo;
    private javax.swing.JTextField salary_pieces_text;
    private javax.swing.JTabbedPane salary_tabpane;
    private javax.swing.JTextField salary_text;
    private javax.swing.JPanel salarypanel;
    private javax.swing.JButton save_attend_button;
    private javax.swing.JButton save_button;
    private javax.swing.JButton save_sal_pieces_button;
    private javax.swing.JPanel search_employee_panel;
    private javax.swing.JTabbedPane tabpane;
    private javax.swing.JLabel tel_no_invalid_label;
    private javax.swing.JLabel tel_no_invalid_label1;
    private javax.swing.JTextField telephone_text;
    private javax.swing.JTextField telephone_text_e;
    private javax.swing.JLabel telephonelabel;
    private javax.swing.JLabel telephonelabel1;
    private javax.swing.JTextField today_text;
    private javax.swing.JButton update_Salary;
    private javax.swing.JPanel wagepanel;
    private javax.swing.JComboBox<String> year_combo;
    // End of variables declaration//GEN-END:variables

    void focustabbedpane(int num) {
        tabpane.setSelectedIndex(num);
    }
}
