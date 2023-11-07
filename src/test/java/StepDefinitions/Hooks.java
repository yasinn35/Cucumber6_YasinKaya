package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void before(){

        System.out.println("senaryo başladı mı");

    }

    @After
    public void after(Scenario senaryo){

        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",senaryo);

        if (senaryo.isFailed()){
            TakesScreenshot ts=((TakesScreenshot) GWD.getDriver());
            byte[] hafizadakiHali=ts.getScreenshotAs(OutputType.BYTES);
            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
        }



       // System.out.println("senaryo bitti mi ");
        // doğru çalıştıysa quiti çağırıcam
        GWD.quitDriver();


    }


}
