package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD_old {

    private static WebDriver driver;


    public static WebDriver getDriver(){

        // extend report türkçe bilg çalışmaması sebebiyle eklendi
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");


        if (driver==null) {// ilk kez bir defa çalış
            driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış
            driver.manage().window().maximize(); // Ekranı max yapıyor.
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet

        }
        return driver;
    }

    public static void quitDriver(){
        // test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // driver kapat
        if (driver!=null) {// driver var ise
            driver.quit();
            driver=null;

        }

    }


}
