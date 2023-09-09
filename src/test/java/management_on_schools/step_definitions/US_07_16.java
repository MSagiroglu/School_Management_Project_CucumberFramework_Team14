package management_on_schools.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.Sema03_07_16.ManagementonSchool;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class US_07_16 {
    Home_Page homePage=new Home_Page();
    management_on_schools.pages.Sema03_07_16.ManagementonSchool ManagementonSchool=new ManagementonSchool();
    @Given("kullanici Managementon School sayfasina gider ve login butonuna tiklar")
    public void kullaniciManagementonSchoolSayfasinaGiderVeLoginButonunaTiklar() {
        Driver.getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
        homePage.homePageLoginButton.click();


    }

    @Then("kullanici Dean hesabiyla giris yapar")
    public void kullaniciDeanHesabiylaGirisYapar() {
        homePage.loginEmailField.sendKeys(ConfigReader.getProperty("DeanUsername"), Keys.TAB,
                ConfigReader.getProperty("DeanPassword"),Keys.TAB,Keys.ENTER);
    }

    @And("kullanici Menu ikonunu tiklar")
    public void kullaniciMenuIkonunuTiklar() {
        homePage.menuButton.click();
    }

    @And("kullanici Contact Get All textine tıklar")
    public void kullaniciContactGetAllTextineTıklar() {
        ManagementonSchool.contacts.click();
    }

    @And("kullanici mesaj bilgilerinin gorundugunu dogrular")
    public void kullaniciMesajBilgilerininGorundugunuDogrular() {
       Assert.assertTrue(ManagementonSchool.contactMessages.isDisplayed());

    }

    @And("kullanici silme ikonunun gorundugunu dogrular")
    public void kullaniciSilmeIkonununGorundugunuDogrular() {
        Assert.assertFalse(ManagementonSchool.verifyMessage.isDisplayed());
    }

    @Then("kullanici Vice Dean hesabiyla giris yapar")
    public void kullaniciViceDeanHesabiylaGirisYapar() {
        homePage.loginEmailField.sendKeys(ConfigReader.getProperty("ViceDeanUsername"), Keys.TAB,
                ConfigReader.getProperty("ViceDeanPassword"),Keys.TAB,Keys.ENTER);
    }
}
