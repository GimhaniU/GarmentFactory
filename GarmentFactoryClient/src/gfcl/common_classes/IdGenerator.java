/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.common_classes;

/**
 *
 * @author Gimhani Uthpala
 */
public class IdGenerator {

    public static String generateNextCustomerID(String lastCustID) {
        if(lastCustID==null){
            return "C001";
        }
        String nextCustID = "C";
        String substring = lastCustID.substring(1);
        int parseInt = Integer.parseInt(substring);
        parseInt++;
        String valueOf = String.valueOf(parseInt);
        if (parseInt > 10 && parseInt < 100) {
            nextCustID += "0" + valueOf;
        } else if (parseInt > 100) {
            nextCustID += valueOf;
        } else {
            nextCustID += "00" + valueOf;
        }
        return nextCustID;
    }

    public static String generateNextMaterialID(String lastMatID) {
        if(lastMatID==null){
            return "M001";
        }
        String nextMatID = "M";
        String substring = lastMatID.substring(1);
        int parseInt = Integer.parseInt(substring);
        parseInt++;
        String valueOf = String.valueOf(parseInt);
        if (parseInt > 10 && parseInt < 100) {
            nextMatID += "0" + valueOf;
        } else if (parseInt > 100) {
            nextMatID += valueOf;
        } else {
            nextMatID += "00" + valueOf;
        }
        return nextMatID;
    }
    
    public static String generateNextEmployeeID(String lastEmpID) {
        if(lastEmpID==null){
            return "E001";
        }
        String nextEmpID = "E";
        String substring = lastEmpID.substring(1);
        int parseInt = Integer.parseInt(substring);
        parseInt++;
        String valueOf = String.valueOf(parseInt);
        if (parseInt > 10 && parseInt < 100) {
            nextEmpID += "0" + valueOf;
        } else if (parseInt > 100) {
            nextEmpID += valueOf;
        } else {
            nextEmpID += "00" + valueOf;
        }
        return nextEmpID;
    }
    
    
    
    
    
    
}
