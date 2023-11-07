package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    public static Connection connection;
    public static Statement statement;

    public static List<List<String>> getDataList(String sorgu){
        DBConnectionOpen();

        List<List<String>> dataList=new ArrayList<>();


        try {

            ResultSet rs = statement.executeQuery(sorgu);
            ResultSetMetaData rsdm = rs.getMetaData();
            while (rs.next()){
                List<String> rowList=new ArrayList<>();
                for (int i = 1; i <=rsdm.getColumnCount() ; i++) {
                    rowList.add(rs.getString(i));
                }
                dataList.add(rowList);
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        DBConnectionClose();
        return dataList;
    }

    public static void DBConnectionOpen(){
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String userName = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(hostUrl, userName, password);
            statement = connection.createStatement();
        }catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose(){
        try {
            connection.close();
        }catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());

        }
    }


}
