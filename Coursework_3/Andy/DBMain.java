package database;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBMain {
    public static String propADR = "src/database/UserDB.properties";
    //read apart of String

    public static String getPassword(String username){
        try {        
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            Properties prop = new Properties();
            prop.load(in);
            String password = prop.getProperty(username).substring(0, 3);
            password = prop.getProperty(password);
            in.close();
            return password;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//find properties
        return null;
    }
    public static void setPassword(String username,String password) {
        Properties prop = new Properties();
        FileOutputStream oFile;
        try {
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            prop.load(in);
            String passwordid = prop.getProperty(username).substring(0, 3);
            in.close();
            oFile = new FileOutputStream(propADR, true);
            prop.setProperty(passwordid, password);
            prop.store(oFile,"Changed");
            oFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static String getFirstname(String username){
        try {        
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            Properties prop = new Properties();
            prop.load(in);
            String firstname = prop.getProperty(username).substring(3, 6);
            firstname = prop.getProperty(firstname);
            in.close();
            return firstname;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//find properties
        return null;
    }
    public static void setFirstname(String username,String firstname) {
        Properties prop = new Properties();
        FileOutputStream oFile;
        try {
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            prop.load(in);
            String firstnameid = prop.getProperty(username).substring(3, 6);
            in.close();
            oFile = new FileOutputStream(propADR, true);
            prop.setProperty(firstnameid, firstname);
            prop.store(oFile,"Changed");
            oFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static String getSurname(String username){
        try {        
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            Properties prop = new Properties();
            prop.load(in);
            String surname = prop.getProperty(username).substring(6, 9);
            surname = prop.getProperty(surname);
            in.close();
            return surname;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//find properties
        return null;
    }
    public static void setSurname(String username,String surname) {
        Properties prop = new Properties();
        FileOutputStream oFile;
        try {
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            prop.load(in);
            String surnameid = prop.getProperty(username).substring(6, 9);
            in.close();
            oFile = new FileOutputStream(propADR, true);
            prop.setProperty(surnameid, surname);
            prop.store(oFile,"Changed");
            oFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static String getWin(String username){
        try {        
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            Properties prop = new Properties();
            prop.load(in);
            String win = prop.getProperty(username).substring(9,12);
            win = prop.getProperty(win);
            in.close();
            return win;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//find properties
        return null;
    }
    public static void setWin(String username,String win) {
        Properties prop = new Properties();
        FileOutputStream oFile;
        try {
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            prop.load(in);
            String winid = prop.getProperty(username).substring(9,12);
            in.close();
            oFile = new FileOutputStream(propADR, true);
            prop.setProperty(winid, win);
            prop.store(oFile,"Changed");
            oFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static String getLoss(String username){
        try {        
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            Properties prop = new Properties();
            prop.load(in);
            String loss = prop.getProperty(username).substring(12,15);
            loss = prop.getProperty(loss);
            in.close();
            return loss;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//find properties
        return null;
    }
    public static void setLoss(String username,String loss) {
        Properties prop = new Properties();
        FileOutputStream oFile;
        try {
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            prop.load(in);
            String lossid = prop.getProperty(username).substring(12,15);
            in.close();
            oFile = new FileOutputStream(propADR, true);
            prop.setProperty(lossid, loss);
            prop.store(oFile,"Changed");
            oFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        Properties prop = new Properties();
        //initialize a admin as username = admin, password = 123
        FileOutputStream oFile;
        try {
            oFile = new FileOutputStream(propADR, true);
            if(prop.getProperty("admin")==null) {
                String username = "admin";
                String index = "000001002003004005";//1-3=password,4-6=firstname,7-9=surname,10-12=wins,13-15=loss
                prop.setProperty(username,index);
                String password = index.substring(0,3);
                prop.setProperty(password, "123");
                prop.store(oFile,"Changed");
                oFile.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //main part
        setLoss("admin", "321");
        System.out.println(getLoss("admin"));
        
        //true表示追加打开
//        try{
//            InputStream in = new BufferedInputStream (new FileInputStream(propADR));//find a.properties
//            prop.load(in);     //load properties
//            //traverse properties
//            Iterator<String> it=prop.stringPropertyNames().iterator();
//            String key = "9";
//            System.out.println(key+prop.getProperty(key));
//            in.close();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
    }
}
