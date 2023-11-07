package ApachePOI;

/*
Mainden bir metod çağırmak suretiyle path i ve sheetName i verilen excelden
istenilen sütun kadar veriyi okuyup bir liste atınız
Bu soruda kaynak excel için : ApacheExcel2.xlsx in 2. sheet ini kullanabilirsiniz
 */


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class _11_Soru {
    public static void main(String[] args) {

        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName="testCitizen";
        int sutunSayisi=1;

        ArrayList<ArrayList<String>> data =getData(path,sheetName,sutunSayisi);
        System.out.println("data = " + data);

    }

    public static ArrayList<ArrayList<String>> getData(String path,String sheetName,int sutunSayisi){
        ArrayList<ArrayList<String>> tablo=new ArrayList<>();


        Sheet sheet=null;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(inputStream);
            sheet=workbook.getSheet(sheetName);
        }catch (IOException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i <sheet.getPhysicalNumberOfRows() ; i++) {

            ArrayList<String> satir=new ArrayList<>();
            for (int j = 0; j <sutunSayisi ; j++) {
                 satir.add(sheet.getRow(i).getCell(j).toString());

            }
            tablo.add(satir);

        }



        return tablo;
    }
}
