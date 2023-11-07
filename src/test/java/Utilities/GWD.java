package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();

    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();


    //threadDriver.get() -> bulunduğum thread deki driver ı al
    //threadDriver.set(driver) -> bulunduğum threade driver set et

    public static WebDriver getDriver(){

        // extend report türkçe bilg çalışmaması sebebiyle eklendi
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get()==null)// xml den çalıştırılmayan diğer bölümler için
            threadBrowserName.set("chrome");

        if (threadDriver.get()==null) {// ilk kez bir defa çalış

            switch (threadBrowserName.get()) {
                case "firefox": threadDriver.set(new FirefoxDriver());break;// ilgili threade bir driver set ettim
                case "safari": threadDriver.set(new SafariDriver());break;// ilgili threade bir driver set ettim
                case "edge": threadDriver.set(new EdgeDriver());break;
                default:  //Jenkins için Chrome memory maximize
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                    threadDriver.set(new ChromeDriver(options)); // ilgili threade bir driver set ettim


            }



        }
        threadDriver.get().manage().window().maximize(); // Ekranı max yapıyor.
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        return threadDriver.get(); // bulunduğum thread e driver ver
    }

    public static void quitDriver(){
        // test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // driver kapat
        if (threadDriver.get()!=null) {// driver var ise
            threadDriver.get().quit();

            WebDriver driver=threadDriver.get();
            driver=null;


            threadDriver.set(driver); // kendisine null olarak ver , bu hatta bir dolu driver yok

        }

    }


}
