/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.common_classes;

import gfc.controller.CustomerController;
import gfc.controller.EmployeeController;
import gfc.controller.ExpenseController;
import gfc.controller.GarmentController;
import gfc.controller.MaterialController;
import gfc.models.Customer;
import gfc.models.Employee;
import gfc.models.Expense;
import gfc.models.Garment;
import gfc.models.Material;
import gfcl.connector.Connector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Gimhani Uthpala
 */
public class ComboItemsAdder {

    private GarmentController garmentController;
    private MaterialController materialController;
    private EmployeeController employeeController;
    private CustomerController customerController;
    private ExpenseController expenseController;

    public ComboItemsAdder() {
        try {
            Connector sConnector = new Connector();
            garmentController = sConnector.getGarmentController();
            materialController = sConnector.getMaterialController();
            employeeController = sConnector.getEmployeeController();
            customerController = sConnector.getCustomerController();
            expenseController = sConnector.getExpenseController();
        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ComboItemsAdder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addSimilarGarmentNames(JComboBox combo) {
        JTextComponent garmentInCombo = (JTextComponent) combo.getEditor().getEditorComponent();
        garmentInCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String item = (String) combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();

                    ArrayList<Garment> similar = garmentController.getSimilarGarmentNames(item);
                    for (int i = 0; i < similar.size(); i++) {
                        list.add(similar.get(i).getGarment_name() + " " + similar.get(i).getGarment_id());
                    }
                    GUIitemsValidator.addItemToCombo(list, combo);
                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    public void addSimilarClothnames(JComboBox combo) {
        JTextComponent clothCombo = (JTextComponent) combo.getEditor().getEditorComponent();
        clothCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String item = (String) combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    ArrayList<Material> similar = materialController.getSimilarCloths(item);
                    for (int i = 0; i < similar.size(); i++) {
                        list.add(similar.get(i).getMat_name() + " " + similar.get(i).getMat_id());
                    }
                    GUIitemsValidator.addItemToCombo(list, combo);
                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    public void addSimilarEmployeenames(JComboBox combo) {
        JTextComponent editCombo = (JTextComponent) combo.getEditor().getEditorComponent();
        editCombo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String item = (String) combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();

                    ArrayList<Employee> similar = employeeController.getSimilarEmployeeNames(item);
                    for (int i = 0; i < similar.size(); i++) {
                        list.add(similar.get(i).getName() + " " + similar.get(i).getEmp_id());
                    }
                    GUIitemsValidator.addItemToCombo(list, combo);
                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    public void addSimilarCustomernames(JComboBox combo) {
        JTextComponent custCombo = (JTextComponent) combo.getEditor().getEditorComponent();
        custCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String item = (String) combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    ArrayList<Customer> similar = customerController.getSimilarCustomerNames(item);
                    for (int i = 0; i < similar.size(); i++) {
                        list.add(similar.get(i).getName() + " " + similar.get(i).getCust_id());
                    }
                    GUIitemsValidator.addItemToCombo(list, combo);
                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    public void addSimilarMaterialnames(JComboBox combo) {
        JTextComponent matCombo = (JTextComponent) combo.getEditor().getEditorComponent();
        matCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String item = (String) combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    ArrayList<Material> similar = materialController.getSimilarMaterials(item);
                    for (int i = 0; i < similar.size(); i++) {
                        list.add(similar.get(i).getMat_name() + "-" + similar.get(i).getMat_type() + "-" + similar.get(i).getMat_id());
                    }
                    GUIitemsValidator.addItemToCombo(list, combo);
                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    public void addSimilarExpensenames(JComboBox combo) {
        JTextComponent matCombo = (JTextComponent) combo.getEditor().getEditorComponent();
        matCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String item = (String) combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    ArrayList<Expense> similar = expenseController.getSimilarExpenseNames(item);
                    if (similar != null) {
                        for (int i = 0; i < similar.size(); i++) {
                            list.add(similar.get(i).getExpense());
                        }
                        GUIitemsValidator.addItemToCombo(list, combo);
                    }
                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    public void addSimilarOtherMaterialnames(JComboBox combo) {
        JTextComponent matCombo = (JTextComponent) combo.getEditor().getEditorComponent();
        matCombo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    String item = (String) combo.getEditor().getItem();
                    ArrayList<Object> list = new ArrayList();
                    ArrayList<Material> similar = materialController.getSimilarOtherMaterials(item);
                    for (int i = 0; i < similar.size(); i++) {
                        list.add(similar.get(i).getMat_name() + "-" + similar.get(i).getMat_type() + "-" + similar.get(i).getMat_id());
                    }
                    GUIitemsValidator.addItemToCombo(list, combo);
                } catch (ClassNotFoundException | SQLException | RemoteException ex) {
                    Logger.getLogger(GUIitemsValidator.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }
}
