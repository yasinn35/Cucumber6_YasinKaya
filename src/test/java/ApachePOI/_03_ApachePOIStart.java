package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {

        // dosyanın olduğu yerle programın arasında bir dosya yolu bağlantısı oluşturmalıyım
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // java dosya okuma nesnesine bu yolu vererek bağlantı kuruyorum
        FileInputStream dosyaOkumaBaglantisi=new FileInputStream(path);


        //Dosya okuma işlemcisi üzerinden çalışma kitabını alıyorum
        // hafızada workbook u alıp oluşturdu
        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaBaglantisi);

        // istediğim isimdeki çalışma sayfasını alıyorum
        Sheet calismaSayfasi=calismaKitabi.getSheet("Sheet1");

        //istenen satırı alıyorum
        Row satir=calismaSayfasi.getRow(0); // 0. satırı aldım

        // istenen hücreyi alıyorum
        Cell hucre=satir.getCell(0); // satırın 0. hücresini aldım

        System.out.println("hucre = " + hucre); // hücre = lion

    }
}
