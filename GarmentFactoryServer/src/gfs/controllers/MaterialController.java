/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Material;
import gfs.db_utilities.DBConnection;
import gfs.db_utilities.DBHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Gimhani Uthpala
 */
public class MaterialController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    public int addNewMaterial(Material material) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into Material Values('" + material.getMat_id() + "','" + material.getMat_name() + "','" + material.getMat_type() + "','"+material.getIn_stock()+"')";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String getLastMaterialId() throws ClassNotFoundException, SQLException {

        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select mat_id From Material order by mat_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("mat_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<Material> getSimilarMaterials(String item) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From material where mat_name like '" + item + "%'  order by mat_name limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Material> list = new ArrayList<>();
            while (rst.next()) {
                Material material=new Material(rst.getString("mat_id"),rst.getString("mat_name"), rst.getString("mat_type"),rst.getDouble("mat_in_stock"));
                list.add(material);
            }
            return list;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static Material searchMaterial(String mat_id) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From material where mat_id='" + mat_id + "'";
            ResultSet rst = DBHandler.getData(conn, sql);
           Material material = null;
            if (rst.next()) {
                material=new Material(mat_id, rst.getString("mat_name"), rst.getString("mat_type"), rst.getDouble("mat_in_stock"));
            }
            return material;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<Material> getSimilarCloths(String item) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From material where mat_name like '" + item + "%' and mat_type='Cloth' order by mat_name limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Material> list = new ArrayList<>();
            while (rst.next()) {
                Material material=new Material(rst.getString("mat_id"),rst.getString("mat_name"), rst.getString("mat_type"),rst.getDouble("mat_in_stock"));
                list.add(material);
            }
            return list;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<Material> getSimilarOtherMaterials(String item) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From material where mat_name like '" + item + "%' and mat_type!='Cloth' order by mat_name limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Material> list = new ArrayList<>();
            while (rst.next()) {
                Material material=new Material(rst.getString("mat_id"),rst.getString("mat_name"), rst.getString("mat_type"),rst.getDouble("mat_in_stock"));
                list.add(material);
            }
            return list;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<Material> getAllMaterialsOfType(String type) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From material where mat_type='" + type + "' order by mat_name";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Material> list = new ArrayList<>();
            while (rst.next()) {
                Material material=new Material(rst.getString("mat_id"),rst.getString("mat_name"), rst.getString("mat_type"),rst.getDouble("mat_in_stock"));
                list.add(material);
            }
            return list;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
