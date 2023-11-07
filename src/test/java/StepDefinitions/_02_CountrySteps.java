package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps  {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to country")
    public void navigateToCountry() {

        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.country);


    }

    @When("Create a country")
    public void createACountry() {
        String ulkeAdi= RandomStringUtils.randomAlphanumeric(8);//8 harf
        String ulkeKodu=RandomStringUtils.randomNumeric(4);// 4 numara

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,ulkeAdi);
        dc.mySendKeys(dc.codeInput,ulkeKodu);
        dc.myClick(dc.saveButton);



    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {


        dc.verifyContainsText(dc.successMessage,"success");
    }

    @When("Create a country name as {string}  code as {string}")
    public void createACountryNameAsCodeAs(String name, String kod) {

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.codeInput,kod);
        dc.myClick(dc.saveButton);

    }
}
