package database;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBMain {
    public static String propADR = "src/database/UserDB.properties";
    //read apart of String
    public static String[] getUserList() {
        try {        
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            Properties prop = new Properties();
            prop.load(in);
            int count = 0;
            Set<Object> keys = prop.keySet();//返回属性key的集合
            for (Object key : keys) {
                if(prop.get(key).toString().length()==18) {
                    ++count;
                }
            }
            String[] userlist = new String[count];
            count = 0;
            for (Object key : keys) {
                if(prop.get(key).toString().length()==18) {
                    userlist[count] = key.toString();
                    ++count;
                }
            }
            return userlist;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//find properties
        return null;
    }
    
    public static void addUser(String username) {
        Properties prop = new Properties();
        FileOutputStream oFile;
        try {
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            prop.load(in);
            Set<Object> keys = prop.keySet();//返回属性key的集合
            int count = 0;
            boolean check = false;
            for (Object key : keys) {
                if(key.toString()==username)check=true;
                if(prop.get(key).toString().length()==18)++count;
            }
            if(check) {
                return;
            }else {
                in.close();
                int passwordid = count*6;
                String _password=null;
                if(passwordid<10)_password = "00"+passwordid;
                if(passwordid>=10)_password = "0"+passwordid;
                if(passwordid>=100)_password = ""+passwordid;
                int firstnameid = count*6+1;
                String _firstname=null;
                if(firstnameid<10)_firstname = "00"+firstnameid;
                if(firstnameid>=10)_firstname = "0"+firstnameid;
                if(firstnameid>=100)_firstname = ""+firstnameid;
                int surnameid = count*6+2;
                String _surname=null;
                if(surnameid<10)_surname = "00"+surnameid;
                if(surnameid>=10)_surname = "0"+surnameid;
                if(surnameid>=100)_surname = ""+surnameid;
                int winid = count*6+3;
                String _win=null;
                if(winid<10)_win = "00"+winid;
                if(winid>=10)_win = "0"+winid;
                if(winid>=100)_win = ""+winid;
                int lossid = count*6+4;
                String _loss=null;
                if(lossid<10)_loss = "00"+lossid;
                if(lossid>=10)_loss = "0"+lossid;
                if(lossid>=100)_loss = ""+lossid;
                int admid = count*6+5;
                String _adm=null;
                if(admid<10)_adm = "00"+admid;
                if(admid>=10)_adm = "0"+admid;
                if(admid>=100)_adm = ""+admid;
                String index = _password+_firstname+_surname+_win+_loss+_adm;
                oFile = new FileOutputStream(propADR, true);
                prop.setProperty(username, index);
                prop.store(oFile,"Changed");
                oFile.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
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
    public static String getadm(String username){
        try {        
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            Properties prop = new Properties();
            prop.load(in);
            String adm = prop.getProperty(username).substring(15,18);
            adm = prop.getProperty(adm);
            in.close();
            return adm;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//find properties
        return null;
    }
    public static void setadm(String username,String adm) {
        Properties prop = new Properties();
        FileOutputStream oFile;
        try {
            InputStream in;
            in = new BufferedInputStream (new FileInputStream(propADR));
            prop.load(in);
            String admid = prop.getProperty(username).substring(15,18);
            in.close();
            oFile = new FileOutputStream(propADR, true);
            prop.setProperty(admid, adm);
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
        addUser("andy");
        String[] a = getUserList();
        for(int i=0;i<a.length;++i) {
            System.out.println(a[i]);
        }
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
