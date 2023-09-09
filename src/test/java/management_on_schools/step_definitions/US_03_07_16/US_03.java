package management_on_schools.step_definitions.US_03_07_16;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.Sema03_07_16.ManagementonSchool;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class US_03 {
    Home_Page homePage=new Home_Page();
    ManagementonSchool ManagementonSchool=new ManagementonSchool();


    @Given("kullanici Managementon School sayfasina gider")
    public void kullaniciManagementonSchoolSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
    }

    @Then("kullanici Contact ikonuna tiklar")
    public void kullaniciContactIkonunaTiklar() {
        homePage.contactButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(1,400);
        actions.perform();

    }
    @And("kullanici Name Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar")
    public void kullaniciNameEmailSubjectMessageKutusunaGecerliVerileriGirerVeSendIkonunaTiklar() {
        homePage.contactNameField.sendKeys(ConfigReader.getProperty("Name"), Keys.TAB,
                ConfigReader.getProperty("Email"),Keys.TAB,ConfigReader.getProperty("Subject"),
                Keys.TAB, ConfigReader.getProperty("Message"),Keys.TAB,Keys.ENTER);

    }

    @And("kullanici Contact Message Created Successfully textinin gorundugunu dogrular")
    public void kullaniciContactMessageCreatedSuccessfullyTextininGorundugunuDogrular() {
        Assert.assertFalse(ManagementonSchool.verifyMessage.isDisplayed());
    }

    @And("kullanici Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar")
    public void kullaniciEmailSubjectMessageKutusunaGecerliVerileriGirerVeSendIkonunaTiklar() {
        ManagementonSchool.eMail.sendKeys(ConfigReader.getProperty("Email"), Keys.TAB,
                ConfigReader.getProperty("Subject"),Keys.TAB,ConfigReader.getProperty("Message"),
                Keys.TAB,Keys.ENTER);
        ReusableMethods.bekle(2);
    }

    @And("kullanici Required uyarisinin gorundugunu dogrular")
    public void kullaniciRequiredUyarisininGorundugunuDogrular() {
        Assert.assertTrue(ManagementonSchool.requiredName.isDisplayed());
    }

    @And("kullanici Name Gecersiz Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar")
    public void kullaniciNameGecersizEmailSubjectMessageKutusunaGecerliVerileriGirerVeSendIkonunaTiklar() {
        homePage.contactNameField.sendKeys(ConfigReader.getProperty("Name"), Keys.TAB,
                ConfigReader.getProperty("invalidMail"),Keys.TAB,ConfigReader.getProperty("Subject"),
                Keys.TAB, ConfigReader.getProperty("Message"),Keys.TAB,Keys.ENTER);
        ReusableMethods.bekle(2);
    }

    @And("kullanici Please enter Valid email textinin gorundugunu dogrular")
    public void kullaniciPleaseEnterValidEmailTextininGorundugunuDogrular() {
        Assert.assertTrue(ManagementonSchool.alertEmail.isDisplayed());
    }

    @And("kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }
}
