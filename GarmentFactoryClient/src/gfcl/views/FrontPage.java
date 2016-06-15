/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.views;

import gfc.controller.BackUP;
import gfc.controller.UserController;
import gfc.models.User;
import gfcl.common_classes.GUIitemsValidator;
import gfcl.connector.Connector;
import gfcl.views.user_views.LoginForm;
import gfcl.views.user_views.NewUserCreator;
import gfcl.views.user_views.PasswordManager;
import gfcl.views.user_views.ViewAllUsers;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Gimhani
 */
public class FrontPage extends javax.swing.JFrame {

    UserController UserController;
    BackUP backUP;
    private String curruser;

    private JDialog reminderDialog = new JDialog(this, "Reminders", false);

    private static FrontPage frontpage = null;

    /**
     * Creates new form FrontPage
     */
    FrontPage() {
        initComponents();

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/gfcl/images/iconc.jpg"));
        setIconImage(icon1.getImage());
        try {
            Connector sConnector = Connector.getSConnector();
            UserController = sConnector.getUserController();
            backUP = sConnector.getbBackUPController();

        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException | InterruptedException ex) {
            Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        desktopPane.removeAll();
        EmployeeDetailFrame employeeForm = new EmployeeDetailFrame();
        employeeForm.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(employeeForm);
        employeeForm.setVisible(true);
        employeeForm.requestFoucsForm();
        //set reminders
        setDate();
        setPreferredSize(new Dimension(1366, 768));
    }

    FrontPage(String user) {
        this();
        try {
            this.curruser = user;
            username.setText(user);
            User currentuser = UserController.searchUser(user);
            //for sales
            if (currentuser.getPower() == 3) {
                employeeDetailsButton.setEnabled(false);
                stockDetailsButton.setEnabled(false);
                productionDetailsButton.setEnabled(false);
                paySalaryButton.setEnabled(false);
                addNewEmployeeButton.setEnabled(false);
                createNewUserMenu.setEnabled(false);
            } //for stock
            else if (currentuser.getPower() == 2) {
                createNewUserMenu.setEnabled(false);
                otherExpensesButton.setEnabled(false);
            }
        } catch (ClassNotFoundException | SQLException | RemoteException ex) {
            Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    public void setRemainders() {

        try {

            ArrayList<Permit> permits = PermitController.getAllPermitsReadytoGrant();

            for (Permit permit : permits) {
                if (DateChecker.isValid(permit.getPermitIssueDate())) {

                    this.reminderPermits.add(permit);

                }

            }
            if (reminderPermits.isEmpty()) {
                ImageIcon icon1 = new ImageIcon(getClass().getResource("/las/icons/no_reminders_1.png"));
                this.REminderButton.setDisabledIcon(icon1);
                this.REminderButton.setEnabled(false);

            } else {
                ImageIcon icon1 = new ImageIcon(getClass().getResource("/las/icons/reminders_1.png"));
                this.REminderButton.setIcon(icon1);
                this.REminderButton.setEnabled(true);

            }

        } catch (ClassNotFoundException | SQLException | RemoteException ex) {
            Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     */
    public static FrontPage getInstance() {
        return frontpage;
    }

    public static FrontPage getInstance(String str) {
        FrontPage fp = new FrontPage(str);
        frontpage = fp;
        //frontpage = new FrontPage(str);
        return frontpage;
    }

    private void setDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateLabel.setText(dateFormat.format(date));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        importantButtonSet = new javax.swing.ButtonGroup();
        searchButtonSet = new javax.swing.ButtonGroup();
        applicantSearchSet = new javax.swing.ButtonGroup();
        permitSearchSet = new javax.swing.ButtonGroup();
        grantSearchSet = new javax.swing.ButtonGroup();
        landSearchSet = new javax.swing.ButtonGroup();
        searchPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        jMenuItem1 = new javax.swing.JMenuItem();
        desktopJPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userLogPanel = new javax.swing.JPanel();
        userpanel = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LogOutButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        todayLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        internalFrameAreaPanel = new javax.swing.JPanel();
        desktopPane = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        search_employee_button = new javax.swing.JButton();
        search_garment_button = new javax.swing.JButton();
        search_material_button = new javax.swing.JButton();
        search_customer_button = new javax.swing.JButton();
        shortcutAccessPanel = new javax.swing.JPanel();
        employeeDetailsButton = new javax.swing.JButton();
        stockDetailsButton = new javax.swing.JButton();
        salesDetailsButton = new javax.swing.JButton();
        productionDetailsButton = new javax.swing.JButton();
        otherExpensesButton = new javax.swing.JButton();
        addNewEmployeeButton = new javax.swing.JButton();
        paySalaryButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        employeeMenu = new javax.swing.JMenu();
        addEmployeeMenu = new javax.swing.JMenuItem();
        editEmployeeMenu = new javax.swing.JMenuItem();
        searchEmployeeMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        markEmployeeAttendanceMenu = new javax.swing.JMenuItem();
        paySalaryMenu = new javax.swing.JMenuItem();
        materialMenu = new javax.swing.JMenu();
        addNewMatMenu = new javax.swing.JMenuItem();
        addNewStockMenu = new javax.swing.JMenuItem();
        addDailyUsageMenu = new javax.swing.JMenuItem();
        viewStocksMenu = new javax.swing.JMenuItem();
        salesMenu = new javax.swing.JMenu();
        addCustomerMenu = new javax.swing.JMenuItem();
        editCustomerMenu = new javax.swing.JMenuItem();
        viewCustHistoryMenu = new javax.swing.JMenuItem();
        addSaleMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        addDailyProdMenu = new javax.swing.JMenuItem();
        viewProdStatMenu = new javax.swing.JMenuItem();
        incomeSummaryMenu = new javax.swing.JMenu();
        addExpenseMenu = new javax.swing.JMenuItem();
        viewAllExpensesMenu = new javax.swing.JMenuItem();
        viewIncomeSummaryMenu = new javax.swing.JMenuItem();
        systemMenu = new javax.swing.JMenu();
        changePasswordMenu = new javax.swing.JMenuItem();
        createNewUserMenu = new javax.swing.JMenuItem();
        viewAllUsersMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        backUpMenu = new javax.swing.JMenuItem();
        restoreMenu = new javax.swing.JMenuItem();

        searchPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Search ");

        searchButtonSet.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton6.setText("1.Applicant");

        searchButtonSet.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton7.setText("2.Permit");

        searchButtonSet.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton8.setText("3.Grant");

        searchButtonSet.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton9.setText("4.Grama Niladari Division");

        searchButtonSet.add(jRadioButton10);
        jRadioButton10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jRadioButton10.setText("5.Available lands");

        applicantSearchSet.add(jCheckBox13);
        jCheckBox13.setText("By name");

        applicantSearchSet.add(jCheckBox14);
        jCheckBox14.setText("By NIC");

        applicantSearchSet.add(jCheckBox15);
        jCheckBox15.setText("By GND");

        permitSearchSet.add(jCheckBox16);
        jCheckBox16.setText("By permit number");

        permitSearchSet.add(jCheckBox17);
        jCheckBox17.setText("By applicant name");

        permitSearchSet.add(jCheckBox18);
        jCheckBox18.setText("By NIC");

        grantSearchSet.add(jCheckBox19);
        jCheckBox19.setText("By permit number");

        grantSearchSet.add(jCheckBox20);
        jCheckBox20.setText("By grant number");

        grantSearchSet.add(jCheckBox21);
        jCheckBox21.setText("By applicant name");

        grantSearchSet.add(jCheckBox22);
        jCheckBox22.setText("By NIC");

        landSearchSet.add(jCheckBox23);
        jCheckBox23.setText("All lands");

        landSearchSet.add(jCheckBox24);
        jCheckBox24.setText("By A Division");

        javax.swing.GroupLayout searchPanel1Layout = new javax.swing.GroupLayout(searchPanel1);
        searchPanel1.setLayout(searchPanel1Layout);
        searchPanel1Layout.setHorizontalGroup(
            searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanel1Layout.createSequentialGroup()
                .addGroup(searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8)
                            .addComponent(jRadioButton9)
                            .addGroup(searchPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox14)
                                    .addComponent(jCheckBox13)
                                    .addComponent(jCheckBox15)
                                    .addComponent(jCheckBox18)
                                    .addComponent(jCheckBox16)
                                    .addComponent(jCheckBox17)
                                    .addComponent(jCheckBox19)
                                    .addComponent(jCheckBox20)
                                    .addComponent(jCheckBox21)
                                    .addComponent(jCheckBox22))))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(searchPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton10)
                    .addGroup(searchPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox23)
                            .addComponent(jCheckBox24))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPanel1Layout.setVerticalGroup(
            searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gfcl/images/iconc.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("LEKHA BATHIK GARMENT FACTORY");

        jLabel3.setFont(new java.awt.Font("Vani", 1, 18)); // NOI18N
        jLabel3.setText("Welihinda,Warakapitiya. TP: 041-2234567  ");

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel4.setText("Quality Products at affordable prices");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        userpanel.setBackground(new java.awt.Color(0, 153, 204));

        username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("User Name and Icon");

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        LogOutButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        LogOutButton.setText("Log off");
        LogOutButton.setToolTipText("Log-off");
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });
        jPanel2.add(LogOutButton);

        ExitButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.setToolTipText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(ExitButton);

        todayLabel.setBackground(new java.awt.Color(204, 204, 255));
        todayLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        todayLabel.setForeground(new java.awt.Color(255, 255, 255));
        todayLabel.setText("Today:");

        dateLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout userpanelLayout = new javax.swing.GroupLayout(userpanel);
        userpanel.setLayout(userpanelLayout);
        userpanelLayout.setHorizontalGroup(
            userpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userpanelLayout.createSequentialGroup()
                        .addComponent(todayLabel)
                        .addGap(18, 18, 18)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(userpanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        userpanelLayout.setVerticalGroup(
            userpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(userpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(todayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout userLogPanelLayout = new javax.swing.GroupLayout(userLogPanel);
        userLogPanel.setLayout(userLogPanelLayout);
        userLogPanelLayout.setHorizontalGroup(
            userLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userLogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        userLogPanelLayout.setVerticalGroup(
            userLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        desktopPane.setOpaque(false);
        desktopPane.setPreferredSize(new java.awt.Dimension(581, 581));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        desktopPane.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 50, 50));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QUick Search:");
        jPanel4.add(jLabel5);

        search_employee_button.setBackground(new java.awt.Color(0, 153, 255));
        search_employee_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        search_employee_button.setForeground(new java.awt.Color(255, 255, 255));
        search_employee_button.setText("SEARCH EMPLOYEE");
        search_employee_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search_employee_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_employee_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(search_employee_button);

        search_garment_button.setBackground(new java.awt.Color(0, 153, 255));
        search_garment_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        search_garment_button.setForeground(new java.awt.Color(255, 255, 255));
        search_garment_button.setText("SEARCH GARMENT");
        search_garment_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search_garment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_garment_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(search_garment_button);

        search_material_button.setBackground(new java.awt.Color(0, 153, 255));
        search_material_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        search_material_button.setForeground(new java.awt.Color(255, 255, 255));
        search_material_button.setText("SEARCH MATERIAL");
        search_material_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search_material_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_material_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(search_material_button);

        search_customer_button.setBackground(new java.awt.Color(0, 153, 255));
        search_customer_button.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        search_customer_button.setForeground(new java.awt.Color(255, 255, 255));
        search_customer_button.setText("SEARCH CUSTOMER");
        search_customer_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search_customer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_customer_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(search_customer_button);

        javax.swing.GroupLayout internalFrameAreaPanelLayout = new javax.swing.GroupLayout(internalFrameAreaPanel);
        internalFrameAreaPanel.setLayout(internalFrameAreaPanelLayout);
        internalFrameAreaPanelLayout.setHorizontalGroup(
            internalFrameAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalFrameAreaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(internalFrameAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE))
                .addContainerGap())
        );
        internalFrameAreaPanelLayout.setVerticalGroup(
            internalFrameAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(internalFrameAreaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        shortcutAccessPanel.setBackground(new java.awt.Color(0, 153, 204));
        shortcutAccessPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        shortcutAccessPanel.setLayout(new java.awt.GridLayout(7, 1, 50, 10));

        employeeDetailsButton.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        employeeDetailsButton.setText("1-Employee Details");
        importantButtonSet.add(employeeDetailsButton);
        employeeDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeDetailsButtonActionPerformed(evt);
            }
        });
        shortcutAccessPanel.add(employeeDetailsButton);

        stockDetailsButton.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        stockDetailsButton.setText("2-Stock Details");
        importantButtonSet.add(stockDetailsButton);
        stockDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockDetailsButtonActionPerformed(evt);
            }
        });
        shortcutAccessPanel.add(stockDetailsButton);

        salesDetailsButton.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        salesDetailsButton.setText("3-Sales Details");
        importantButtonSet.add(salesDetailsButton);
        salesDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesDetailsButtonActionPerformed(evt);
            }
        });
        shortcutAccessPanel.add(salesDetailsButton);

        productionDetailsButton.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        productionDetailsButton.setText("4-Prodcution Details");
        importantButtonSet.add(productionDetailsButton);
        productionDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productionDetailsButtonActionPerformed(evt);
            }
        });
        shortcutAccessPanel.add(productionDetailsButton);

        otherExpensesButton.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        otherExpensesButton.setText("5-Other Expenses");
        importantButtonSet.add(otherExpensesButton);
        otherExpensesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherExpensesButtonActionPerformed(evt);
            }
        });
        shortcutAccessPanel.add(otherExpensesButton);

        addNewEmployeeButton.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        addNewEmployeeButton.setText("6-Garment Details");
        importantButtonSet.add(addNewEmployeeButton);
        addNewEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewEmployeeButtonActionPerformed(evt);
            }
        });
        shortcutAccessPanel.add(addNewEmployeeButton);

        paySalaryButton.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        paySalaryButton.setText("7-Pay Salary");
        importantButtonSet.add(paySalaryButton);
        paySalaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paySalaryButtonActionPerformed(evt);
            }
        });
        shortcutAccessPanel.add(paySalaryButton);

        javax.swing.GroupLayout desktopJPanelLayout = new javax.swing.GroupLayout(desktopJPanel);
        desktopJPanel.setLayout(desktopJPanelLayout);
        desktopJPanelLayout.setHorizontalGroup(
            desktopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopJPanelLayout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(userLogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(desktopJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(internalFrameAreaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shortcutAccessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        desktopJPanelLayout.setVerticalGroup(
            desktopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopJPanelLayout.createSequentialGroup()
                .addGroup(desktopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userLogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(desktopJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(internalFrameAreaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shortcutAccessPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        employeeMenu.setText("Employee");

        addEmployeeMenu.setText("Add new employee");
        addEmployeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeMenuActionPerformed(evt);
            }
        });
        employeeMenu.add(addEmployeeMenu);

        editEmployeeMenu.setText("Edit employee");
        editEmployeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmployeeMenuActionPerformed(evt);
            }
        });
        employeeMenu.add(editEmployeeMenu);

        searchEmployeeMenu.setText("Search employee");
        searchEmployeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmployeeMenuActionPerformed(evt);
            }
        });
        employeeMenu.add(searchEmployeeMenu);
        employeeMenu.add(jSeparator2);

        markEmployeeAttendanceMenu.setText("Mark attendance");
        markEmployeeAttendanceMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markEmployeeAttendanceMenuActionPerformed(evt);
            }
        });
        employeeMenu.add(markEmployeeAttendanceMenu);

        paySalaryMenu.setText("Pay Salary");
        employeeMenu.add(paySalaryMenu);

        jMenuBar1.add(employeeMenu);

        materialMenu.setText("Material");

        addNewMatMenu.setText("Add new material");
        addNewMatMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewMatMenuActionPerformed(evt);
            }
        });
        materialMenu.add(addNewMatMenu);

        addNewStockMenu.setText("Add new stock");
        addNewStockMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStockMenuActionPerformed(evt);
            }
        });
        materialMenu.add(addNewStockMenu);

        addDailyUsageMenu.setText("Add daily usage");
        addDailyUsageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDailyUsageMenuActionPerformed(evt);
            }
        });
        materialMenu.add(addDailyUsageMenu);

        viewStocksMenu.setText("View stocks");
        viewStocksMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStocksMenuActionPerformed(evt);
            }
        });
        materialMenu.add(viewStocksMenu);

        jMenuBar1.add(materialMenu);

        salesMenu.setText("Sales");

        addCustomerMenu.setText("Add new Customer");
        addCustomerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerMenuActionPerformed(evt);
            }
        });
        salesMenu.add(addCustomerMenu);

        editCustomerMenu.setText("Edit Customer");
        editCustomerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerMenuActionPerformed(evt);
            }
        });
        salesMenu.add(editCustomerMenu);

        viewCustHistoryMenu.setText("View Customer History");
        viewCustHistoryMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustHistoryMenuActionPerformed(evt);
            }
        });
        salesMenu.add(viewCustHistoryMenu);

        addSaleMenu.setText("Add a sale");
        addSaleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleMenuActionPerformed(evt);
            }
        });
        salesMenu.add(addSaleMenu);

        jMenuBar1.add(salesMenu);

        jMenu3.setText("Production");

        addDailyProdMenu.setText("Add Daily Production");
        addDailyProdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDailyProdMenuActionPerformed(evt);
            }
        });
        jMenu3.add(addDailyProdMenu);

        viewProdStatMenu.setText("View Producttion Stats");
        viewProdStatMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProdStatMenuActionPerformed(evt);
            }
        });
        jMenu3.add(viewProdStatMenu);

        jMenuBar1.add(jMenu3);

        incomeSummaryMenu.setText("Income-summary");

        addExpenseMenu.setText("Add an expense");
        addExpenseMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpenseMenuActionPerformed(evt);
            }
        });
        incomeSummaryMenu.add(addExpenseMenu);

        viewAllExpensesMenu.setText("View all expenses");
        viewAllExpensesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllExpensesMenuActionPerformed(evt);
            }
        });
        incomeSummaryMenu.add(viewAllExpensesMenu);

        viewIncomeSummaryMenu.setText("View summary");
        viewIncomeSummaryMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewIncomeSummaryMenuActionPerformed(evt);
            }
        });
        incomeSummaryMenu.add(viewIncomeSummaryMenu);

        jMenuBar1.add(incomeSummaryMenu);

        systemMenu.setText("System");

        changePasswordMenu.setText("Change password");
        changePasswordMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordMenuActionPerformed(evt);
            }
        });
        systemMenu.add(changePasswordMenu);

        createNewUserMenu.setText("Create new user");
        createNewUserMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewUserMenuActionPerformed(evt);
            }
        });
        systemMenu.add(createNewUserMenu);

        viewAllUsersMenu.setText("View all users");
        viewAllUsersMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllUsersMenuActionPerformed(evt);
            }
        });
        systemMenu.add(viewAllUsersMenu);
        systemMenu.add(jSeparator1);

        backUpMenu.setText("Create a backup");
        backUpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backUpMenuActionPerformed(evt);
            }
        });
        systemMenu.add(backUpMenu);

        restoreMenu.setText("Restore backup");
        restoreMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreMenuActionPerformed(evt);
            }
        });
        systemMenu.add(restoreMenu);

        jMenuBar1.add(systemMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktopJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeDetailsButtonActionPerformed
        EmployeeDetailFrame employeeForm = new EmployeeDetailFrame();
        employeeForm.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(employeeForm);
        employeeForm.setVisible(true);
        employeeForm.requestFoucsForm();
    }//GEN-LAST:event_employeeDetailsButtonActionPerformed

    public void setDesktopPaneForSales(SalesDetailFrame form, int num) {
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
        form.focustabbedpane(num);
        form.requestFoucsForm();
    }

    public void setDesktopPaneForStock(StockDetailFrame form, int num) {
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
        form.focustabbedpane(num);
        form.requestFoucsForm();
    }

    public void setDesktopPaneForProduction(ProductionDetailFrame form, int num) {
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
        form.focustabbedpane(num);
        form.requestFoucsForm();
    }

    public void setDesktopPaneForIncome(IncomeSummaryFrame form, int num) {
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
        form.focustabbedpane(num);
        form.requestFoucsForm();
    }

    public void setDesktopPaneForEmployee(EmployeeDetailFrame form, int num) {
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
        form.focustabbedpane(num);
        form.requestFoucsForm();
    }
    
    public void setDesktopPaneForGarment(GarmentDetailFrame form, int num) {
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
        form.focustabbedpane(num);
        form.requestFoucsForm();
    }

    public void addEmployeeForm(String nic) {
        EmployeeDetailFrame form = new EmployeeDetailFrame(nic);
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
    }

    private void addNewEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewEmployeeButtonActionPerformed
        GarmentDetailFrame form = new GarmentDetailFrame();
        form.setSize(desktopPane.getSize());
        desktopPane.removeAll();
        desktopPane.add(form);
        form.setVisible(true);
        form.requestFoucsForm();
    }//GEN-LAST:event_addNewEmployeeButtonActionPerformed

    private void productionDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productionDetailsButtonActionPerformed
        ProductionDetailFrame form = new ProductionDetailFrame();
        setDesktopPaneForProduction(form, 0);

    }//GEN-LAST:event_productionDetailsButtonActionPerformed

    private void stockDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockDetailsButtonActionPerformed
        StockDetailFrame form = new StockDetailFrame();
        setDesktopPaneForStock(form, 0);
    }//GEN-LAST:event_stockDetailsButtonActionPerformed

    private void salesDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesDetailsButtonActionPerformed
        SalesDetailFrame form = new SalesDetailFrame();
        setDesktopPaneForSales(form, 0);
    }//GEN-LAST:event_salesDetailsButtonActionPerformed

    private void otherExpensesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherExpensesButtonActionPerformed
        setDesktopPaneForIncome(new IncomeSummaryFrame(), 0);
    }//GEN-LAST:event_otherExpensesButtonActionPerformed

    private void addNewStockMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewStockMenuActionPerformed
        setDesktopPaneForStock(new StockDetailFrame(), 0);
    }//GEN-LAST:event_addNewStockMenuActionPerformed

    private void viewStocksMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStocksMenuActionPerformed
        setDesktopPaneForStock(new StockDetailFrame(), 0);
    }//GEN-LAST:event_viewStocksMenuActionPerformed

    private void viewCustHistoryMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustHistoryMenuActionPerformed
        setDesktopPaneForSales(new SalesDetailFrame(), 3);
    }//GEN-LAST:event_viewCustHistoryMenuActionPerformed

    private void editCustomerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerMenuActionPerformed
        setDesktopPaneForSales(new SalesDetailFrame(), 2);
    }//GEN-LAST:event_editCustomerMenuActionPerformed

    private void backUpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backUpMenuActionPerformed
        /*try {
            int writeBackup = BackUp.writeBackup();
            if(writeBackup==0){
                JOptionPane.showMessageDialog(this,"Backup  successfully");
            }else{
                JOptionPane.showMessageDialog(this,"Backup is not successfully");
            
            }
        } catch (IOException ex) {
                   Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_backUpMenuActionPerformed

    private void restoreMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreMenuActionPerformed
        try {
            int restoreBackup = backUP.restoreBackup();
            if (restoreBackup == 0) {
                JOptionPane.showMessageDialog(this, "Backup restored successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Backup is not restored successfully");

            }

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_restoreMenuActionPerformed

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed

        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?");
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void changePasswordMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordMenuActionPerformed
        new PasswordManager(this, true, curruser).setVisible(true);
    }//GEN-LAST:event_changePasswordMenuActionPerformed

    private void createNewUserMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewUserMenuActionPerformed
        new NewUserCreator(this, true).setVisible(true);
    }//GEN-LAST:event_createNewUserMenuActionPerformed

    private void viewAllUsersMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllUsersMenuActionPerformed
        new ViewAllUsers(this, true).setVisible(true);
    }//GEN-LAST:event_viewAllUsersMenuActionPerformed

    private void addCustomerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerMenuActionPerformed
        SalesDetailFrame form = new SalesDetailFrame();
        setDesktopPaneForSales(form, 1);
    }//GEN-LAST:event_addCustomerMenuActionPerformed

    private void addDailyProdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDailyProdMenuActionPerformed
        setDesktopPaneForProduction(new ProductionDetailFrame(), 0);
    }//GEN-LAST:event_addDailyProdMenuActionPerformed

    private void addEmployeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeMenuActionPerformed
        setDesktopPaneForEmployee(new EmployeeDetailFrame(), 0);
    }//GEN-LAST:event_addEmployeeMenuActionPerformed

    private void editEmployeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmployeeMenuActionPerformed
        setDesktopPaneForEmployee(new EmployeeDetailFrame(), 1);
    }//GEN-LAST:event_editEmployeeMenuActionPerformed

    private void searchEmployeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmployeeMenuActionPerformed
        setDesktopPaneForEmployee(new EmployeeDetailFrame(), 1);
    }//GEN-LAST:event_searchEmployeeMenuActionPerformed

    private void addNewMatMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewMatMenuActionPerformed
        setDesktopPaneForStock(new StockDetailFrame(), 2);
    }//GEN-LAST:event_addNewMatMenuActionPerformed

    private void viewProdStatMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProdStatMenuActionPerformed
        setDesktopPaneForProduction(new ProductionDetailFrame(), 0);
    }//GEN-LAST:event_viewProdStatMenuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //as if cancel option clicked before,
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?");
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_1:
                employeeDetailsButton.doClick();
                break;
            case KeyEvent.VK_2:
                stockDetailsButton.doClick();
                break;
            case KeyEvent.VK_3:
                salesDetailsButton.doClick();
                break;
            case KeyEvent.VK_4:
                productionDetailsButton.doClick();
                break;
            case KeyEvent.VK_5:
                otherExpensesButton.doClick();
                break;
            case KeyEvent.VK_6:
                addNewEmployeeButton.doClick();
                break;
            case KeyEvent.VK_7:
                paySalaryButton.doClick();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_formKeyReleased


    private void paySalaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paySalaryButtonActionPerformed
        setDesktopPaneForEmployee(new EmployeeDetailFrame(), 3);
    }//GEN-LAST:event_paySalaryButtonActionPerformed

    private void markEmployeeAttendanceMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markEmployeeAttendanceMenuActionPerformed
        setDesktopPaneForEmployee(new EmployeeDetailFrame(), 2);
    }//GEN-LAST:event_markEmployeeAttendanceMenuActionPerformed

    private void addDailyUsageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDailyUsageMenuActionPerformed
        setDesktopPaneForStock(new StockDetailFrame(), 1);
    }//GEN-LAST:event_addDailyUsageMenuActionPerformed

    private void addSaleMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleMenuActionPerformed
        setDesktopPaneForSales(new SalesDetailFrame(), 0);
    }//GEN-LAST:event_addSaleMenuActionPerformed

    private void addExpenseMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpenseMenuActionPerformed
        setDesktopPaneForIncome(new IncomeSummaryFrame(), 0);
    }//GEN-LAST:event_addExpenseMenuActionPerformed

    private void viewAllExpensesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllExpensesMenuActionPerformed
        
    }//GEN-LAST:event_viewAllExpensesMenuActionPerformed

    private void viewIncomeSummaryMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewIncomeSummaryMenuActionPerformed
        setDesktopPaneForIncome(new IncomeSummaryFrame(),1 );
    }//GEN-LAST:event_viewIncomeSummaryMenuActionPerformed

    private void search_employee_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_employee_buttonActionPerformed
        EmployeeDetailFrame employeeDetailFrame = new EmployeeDetailFrame();
        employeeDetailFrame.setDisabledTabs(false, true, false, false);
        employeeDetailFrame.setUpdateButton(false);
        setDesktopPaneForEmployee(employeeDetailFrame, 1);
    }//GEN-LAST:event_search_employee_buttonActionPerformed

    private void search_garment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_garment_buttonActionPerformed
        GarmentDetailFrame garmentDetailFrame = new GarmentDetailFrame();
        garmentDetailFrame.setDisabledTabs(true, false, false);
        setDesktopPaneForGarment(garmentDetailFrame, 0);
    }//GEN-LAST:event_search_garment_buttonActionPerformed

    private void search_material_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_material_buttonActionPerformed
        StockDetailFrame stockDetailFrame = new StockDetailFrame();
        stockDetailFrame.setDisabledTabs(false, false, false,true);
        setDesktopPaneForStock(stockDetailFrame, 3);
    }//GEN-LAST:event_search_material_buttonActionPerformed

    private void search_customer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_customer_buttonActionPerformed
        SalesDetailFrame salesDetailFrame = new SalesDetailFrame();
        salesDetailFrame.setDisabledTabs(false, false,true, false, false);
        salesDetailFrame.setUpdateButton(false);
        setDesktopPaneForSales(salesDetailFrame, 2);
    }//GEN-LAST:event_search_customer_buttonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrontPage fp = new FrontPage();
                fp.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JMenuItem addCustomerMenu;
    private javax.swing.JMenuItem addDailyProdMenu;
    private javax.swing.JMenuItem addDailyUsageMenu;
    private javax.swing.JMenuItem addEmployeeMenu;
    private javax.swing.JMenuItem addExpenseMenu;
    private javax.swing.JButton addNewEmployeeButton;
    private javax.swing.JMenuItem addNewMatMenu;
    private javax.swing.JMenuItem addNewStockMenu;
    private javax.swing.JMenuItem addSaleMenu;
    private javax.swing.ButtonGroup applicantSearchSet;
    private javax.swing.JMenuItem backUpMenu;
    private javax.swing.JMenuItem changePasswordMenu;
    private javax.swing.JMenuItem createNewUserMenu;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel desktopJPanel;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem editCustomerMenu;
    private javax.swing.JMenuItem editEmployeeMenu;
    private javax.swing.JButton employeeDetailsButton;
    private javax.swing.JMenu employeeMenu;
    private javax.swing.ButtonGroup grantSearchSet;
    private javax.swing.ButtonGroup importantButtonSet;
    private javax.swing.JMenu incomeSummaryMenu;
    private javax.swing.JPanel internalFrameAreaPanel;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.ButtonGroup landSearchSet;
    private javax.swing.JMenuItem markEmployeeAttendanceMenu;
    private javax.swing.JMenu materialMenu;
    private javax.swing.JButton otherExpensesButton;
    private javax.swing.JButton paySalaryButton;
    private javax.swing.JMenuItem paySalaryMenu;
    private javax.swing.ButtonGroup permitSearchSet;
    private javax.swing.JButton productionDetailsButton;
    private javax.swing.JMenuItem restoreMenu;
    private javax.swing.JButton salesDetailsButton;
    private javax.swing.JMenu salesMenu;
    private javax.swing.ButtonGroup searchButtonSet;
    private javax.swing.JMenuItem searchEmployeeMenu;
    private javax.swing.JPanel searchPanel1;
    private javax.swing.JButton search_customer_button;
    private javax.swing.JButton search_employee_button;
    private javax.swing.JButton search_garment_button;
    private javax.swing.JButton search_material_button;
    private javax.swing.JPanel shortcutAccessPanel;
    private javax.swing.JButton stockDetailsButton;
    private javax.swing.JMenu systemMenu;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel todayLabel;
    private javax.swing.JPanel userLogPanel;
    private javax.swing.JLabel username;
    private javax.swing.JPanel userpanel;
    private javax.swing.JMenuItem viewAllExpensesMenu;
    private javax.swing.JMenuItem viewAllUsersMenu;
    private javax.swing.JMenuItem viewCustHistoryMenu;
    private javax.swing.JMenuItem viewIncomeSummaryMenu;
    private javax.swing.JMenuItem viewProdStatMenu;
    private javax.swing.JMenuItem viewStocksMenu;
    // End of variables declaration//GEN-END:variables
}
