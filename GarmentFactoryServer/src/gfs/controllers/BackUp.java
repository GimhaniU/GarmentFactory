/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import java.io.IOException;

/**
 *
 * @author Gimhani Uthpala
 */
public class BackUp {

    public static int  writeBackup() throws IOException,InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        Process exec = runTime.exec("mysqldump Lekhabathikfactory -h localhost -u root -pgimhani -r database.sql");
        return exec.waitFor();
    }

    public static int restoreBackup() throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "--user=root", "--password=gimhani","lekhabathik", "-e", " source  E:\\Semester 05\\Software Engineering Project\\Gimhani\\Project\\GarmentFactory\\GarmentFactoryServer\\src\\gfs\\database.sql"};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int waitFor = runtimeProcess.waitFor();
        return  waitFor;
    }

   /*
    public static int writeBackup(String path) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        Process runtimeProcess = runTime.exec("mysqldump DrivingSchool -h localhost -u root -p0213 -r " + path + ".txt");
        int res = runtimeProcess.waitFor();
        return res;
        
        
    }

    public static int restoreBackup(String path) throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "DrivingSchool", "--user=root", "--password=0213", "-e", " source " + path};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int res = runtimeProcess.waitFor();
        return res;
    }

    */
}
