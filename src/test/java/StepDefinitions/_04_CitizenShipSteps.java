package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_CitizenShipSteps  {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to Citizenship")
    public void navigateToCitizenship() {

        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenShip);
    }

    @When("Create a Citizenship")
    public void createACitizenship() {
        String citizenShipName= RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenShortCo=RandomStringUtils.randomNumeric(4);// 4 numara

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,citizenShipName);
        dc.mySendKeys(dc.shortName,citizenShortCo);
        dc.myClick(dc.saveButton);
    }

    @When("Create a Citizenship name as {string} short name as {string}")
    public void createACitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.shortName,shortName);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {

        dc.verifyContainsText(dc.alradyexist,"already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String name) {

      dc.deleteItem(name);



    }
}
