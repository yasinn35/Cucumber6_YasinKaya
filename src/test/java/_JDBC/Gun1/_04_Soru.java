package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet sonuc=sorguEkrani.executeQuery("select * from city");

        while (sonuc.next())
            System.out.println(sonuc.getString("city"));

    }
}
