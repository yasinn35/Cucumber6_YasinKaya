package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

/*  bir sorgunun çalışması için yapılanlar:
1- baglantı bilgilerini girdik, connection bilgilerini set ettik
2- db seçtik
3- sorgu ekranını açtık
4- sorguyu yazdım, çalıştırdım
5- altta sonuçlar göründü */
public class _01_Giris {
    @Test
    public void test1() throws SQLException {

        // /sakila yazarak db ye geçtim // jdbc:mysql://  yazarak mysql olduğunu belirttim
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String userName = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        Connection baglanti = DriverManager.getConnection(hostUrl, userName, password);

        Statement sorguEkrani = baglanti.createStatement(); // çalışma ekranını aktif ettik

        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from customer");
        // ilgili veri girilerek execute yaptık

        sonucTablosu.next(); // şu anda ilk satırı al demek iterator görevi görür

        String ad=sonucTablosu.getString("first_name");
        String soyad=sonucTablosu.getString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        sonucTablosu.next(); // şu anda ilk satırı al demek iterator görevi görür

         ad=sonucTablosu.getString("first_name");
         soyad=sonucTablosu.getNString("last_name");
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        baglanti.close();










    }


}
