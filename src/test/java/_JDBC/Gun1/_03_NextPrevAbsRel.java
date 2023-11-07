package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from language");

        rs.next();// 1 adım ileri
        System.out.println("1. Satır :"+rs.getString(2)); // 2. column index değil   -ing

        rs.next();// 1 adım ileri
        System.out.println("2. Satır : "+rs.getString(2)); // 2. column index değil  - italy

        rs.previous(); // bir adım geri
        System.out.println("1. Satır : "+rs.getString(2)); // 2. column index değil   - ing
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from film");

        rs.absolute(10); // 10. satıra direk git
        System.out.println("10. satır Title : " + rs.getString("title")); // alaaddin

        rs.absolute(5); // 5. satıra direk git
        System.out.println("5. satır Title : "+rs.getString("title")); // african

        rs.relative(5); // en son neredeysen oradan itibaren 5 git
        System.out.println("10. Satır Title : "+rs.getString("title")); // alaaddin

        rs.next(); // 11 e gider
    }
    // rs.next() : sonraki satır
    // rs.previous : önceki satır
    // rs.absolute(10) : baştan itibaren 10.satıra ileri gider.
    // rs.relative(10) : bulunduğu yerden 10.satıra ileri gider.
    // rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satır
    // rs.relative(-5) :  - (eksi) bulundu yerden 5 satır geri
// city tablosundaki tüm satırlardaki şehir isimlerini next ile yazdırınız

}
