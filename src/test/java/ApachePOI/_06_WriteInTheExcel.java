package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class _06_WriteInTheExcel {
    public static void main(String[] args) throws IOException {

        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        // hafızada yazma işlemlerine başlıyorum
        int sonSatirIndex=sheet.getPhysicalNumberOfRows();
        Row yeniSatir=sheet.createRow(sonSatirIndex);
        Cell yeniHucre=yeniSatir.createCell(0);
        yeniHucre.setCellValue("Merhaba Dünya");

        // yazma işim bitti
        // okuma kanalını kapat
        inputStream.close();

        // dosyayı kaydetmeye geçiyorum
        // bunun için dosyayı yazma yönünde aç

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();// hafızayı boşalt
        fileOutputStream.close();// yazma kanalını kapat

        System.out.println("işlem bitti");
    }
}
