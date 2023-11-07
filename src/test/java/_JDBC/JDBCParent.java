package _JDBC;

import io.cucumber.java.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCParent {

    public static Connection baglanti;
    public static Statement sorguEkrani;

    @BeforeClass
    public void DBConnectionOpen(){
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String userName = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            baglanti = DriverManager.getConnection(hostUrl, userName, password);
             sorguEkrani = baglanti.createStatement();
        }catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }



    @AfterClass
    public void DBConnectionClose(){
        try {
            baglanti.close();
        }catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());

        }
    }












}
