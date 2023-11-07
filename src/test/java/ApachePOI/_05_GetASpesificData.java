package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
 * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
 * yani metoda "Password" kelimesi gönderilecek, dönen değer Password un değeri olacak.
 * bulup ve sonucun döndürülmesi için metod kullanınız.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpesificData {
    public static void main(String[] args) throws IOException {

        String donenSonuc=exceldenGetir("password");
        System.out.println("donenSonuc = " + donenSonuc);


    }

    public static String exceldenGetir(String aranacakKelime) throws IOException {

        String donecek="";

        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(aranacakKelime.toLowerCase())){

                for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    donecek+=sheet.getRow(i).getCell(j);

                }

            }

        }

        return donecek;
    }
}
