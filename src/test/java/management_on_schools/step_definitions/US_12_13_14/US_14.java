package management_on_schools.step_definitions.US_12_13_14;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import management_on_schools.pages.Begum12_13_14.US_14Page;
import management_on_schools.pages.Home_Page;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class US_14 {
    Home_Page homePage = new Home_Page();
    US_14Page us_14Page = new US_14Page();


    @And("confirm {string}")
    public void confirm(String variable) {
        boolean assrt = false;
            switch (variable) {
                case "name":
                    assrt = us_14Page.confirmName.isDisplayed();
                    break;
                case "userName":
                    assrt =  us_14Page.confirmUserName.isDisplayed();
                    break;
                case "phoneNumber":
                    assrt = us_14Page.confirmPhoneNumber.isDisplayed();
                    break;
                case "SSN":
                    assrt =  us_14Page.confirmSSN.isDisplayed();
                    break;

            }
            Assert.assertTrue(assrt);
    }


    @And("go to {string} page")
    public void goToPage(String yol) {
        String path = "//body";
        switch (yol) {
            case "End":
                Driver.getDriver().findElement(By.xpath(path)).sendKeys(Keys.CONTROL, Keys.END);
                break;
            case "Home":
                Driver.getDriver().findElement(By.xpath(path)).sendKeys(Keys.CONTROL, Keys.HOME);
                break;
            case "down":
                Driver.getDriver().findElement(By.xpath(path)).sendKeys(Keys.PAGE_DOWN);
                break;
            case "up":
                Driver.getDriver().findElement(By.xpath(path)).sendKeys(Keys.PAGE_UP);
                break;
            case "tableUp":
                WebElement tableElement = Driver.getDriver().findElement(By.tagName("table"));
                ReusableMethods.scroll(tableElement);
                break;
            case "tableDown":
                us_14Page.table.sendKeys(Keys.CONTROL, Keys.END);
                break;
            case "mainEnd":
                WebElement mainElement = Driver.getDriver().findElement(By.xpath("//main[@class='content']"));
                ReusableMethods.scroll(mainElement);
                mainElement.sendKeys(Keys.CONTROL, Keys.END);
                break;

        }
    }
}

