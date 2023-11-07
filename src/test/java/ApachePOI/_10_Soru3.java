package ApachePOI;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO:
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  YENİ bir excel dosyasına
 *  1 den 10 kadar çarpımları YAN YANA yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */

public class _10_Soru3 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        int yeniAcilacakSatirIndexi= 0;
        int s=0;


        for (int k = 1; k <= 10; k++) {

            for (int i = 1; i <= 10; i++) {

                // ++ her bır ıslemı yenı satıra yaz demek

                    Row satir = sheet.createRow(yeniAcilacakSatirIndexi++);


                    Cell hucre1 = satir.createCell(0);hucre1.setCellValue(k);
                    Cell hucre2 = satir.createCell(1);hucre2.setCellValue("x");
                    Cell hucre3 = satir.createCell(2);hucre3.setCellValue(i);
                    Cell hucre4 = satir.createCell(3);hucre4.setCellValue("=");
                    Cell hucre5 = satir.createCell(4);hucre5.setCellValue(k * i);
                    Cell hucre6 = satir.createCell(5);hucre6.setCellValue(" ");

            }


        }


        String path = "src/test/java/ApachePOI/resource/YanYanaCarpim.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();


        System.out.println("işlem tamamlandı");



    }

}
