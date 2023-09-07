package management_on_schools.step_definitions.US_22_AND_US_23;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_schools.pages.MehmetAli22_23.Us_22_23Page;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class US022_StepDefinition {
    Us_22_23Page page = new Us_22_23Page();
    Actions actions = new Actions(Driver.getDriver());

    public void phoneAlaniTemizleme(){
        page.phoneNumberAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void usernameAlaniTemizleme(){
        page.usernameAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void ssnAlaniTemizleme(){
        page.ssnAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void dateOfBirthAlaniTemizleme(){
        page.dateOfBirthAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    @Given("admin login olur")
    public void adminLoginOlur() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.login("AdminUsername","AdminPassword");

        //Sayfa otomatik asagi indigi icin Keys.PAGE_UP ile yukari cektik...
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @When("admin verilen bilgileri girer")
    public void adminVerilenBilgileriGirer() {

        page.nameAlani.sendKeys(ConfigReader.getProperty("nameMAK"), Keys.TAB,
                                           ConfigReader.getProperty("surnameMAK"),Keys.TAB,
                                           ConfigReader.getProperty("birthPlaceMAK"),Keys.TAB,Keys.TAB,
                                           ConfigReader.getProperty("dateOfBirthMAK"),Keys.TAB,
                                           "987-654-3210",Keys.TAB,
                                           "123-45-9876",Keys.TAB,
                                           ConfigReader.getProperty("us22tc01username"),Keys.TAB,
                                           ConfigReader.getProperty("passwordMAK") );
                                           page.genderMale.click();
        ReusableMethods.bekle(2);
    }

    @And("admin submit butonuna basar")
    public void adminSubmitButonunaBasar() {
        page.submitButton.click();
    }

    @Then("admin adminin eklenip eklenmedigini dogrular")
    public void adminAdmininEklenipEklenmediginiDogrular() {
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC01");
        Assert.assertEquals(page.alert.getText(),"Admin Saved");
        ReusableMethods.bekle(2);
        ReusableMethods.logout();
        ReusableMethods.bekle(2);
        ReusableMethods.login("us22tc01username","passwordMAK");

        page.adminLoginVerify.isDisplayed();
    }

    @Then("admin telefon verilerini yanlis girer ve hata mesajlarini dogrular")
    public void adminTelefonVerileriniYanlisGirerVeHataMesajlariniDogrular() {

        //Onceki Step'deki girilen verileri degistiriyoruz...(Kayıtlı olmayan veriler girmemiz gerekiyor)
        usernameAlaniTemizleme();
        ssnAlaniTemizleme();
        page.usernameAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanUsername"));
        page.ssnAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanSsn"));

        //1.Dogrulama
        String enterValidPhoneNumberExpectedMessage = "phone number"; //toLowerCase() kullanmamizin sebebi bir alert'de P buyuk digerinde kucuk !!!
        ReusableMethods.bekle(2);
        phoneAlaniTemizleme(); //Dogru veri onceki step'de girilmisti onu temizledik
        ReusableMethods.bekle(3);
        page.phoneNumberAlani.sendKeys("555123456789");
        ReusableMethods.bekle(2);
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC02_enterValidPhoneNumber01");
        Assert.assertTrue(page.alert.getText().toLowerCase().contains(enterValidPhoneNumberExpectedMessage));
        ReusableMethods.bekle(2);

        //2.Dogrulama
        phoneAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.phoneNumberAlani.sendKeys("555-321-14511");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC02_enterValidPhoneNumber02");
        Assert.assertTrue(page.alert.getText().toLowerCase().contains(enterValidPhoneNumberExpectedMessage));
        ReusableMethods.bekle(2);

        //3.Dogrulama
        String invalidFeedbackExpectedMessage = "Minimum 12 character (XXX-XXX-XXXX)";
        phoneAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.phoneNumberAlani.sendKeys("555-123-789");
        ReusableMethods.tumSayfaResmi("22","TC02_minimum12Character");
        Assert.assertEquals(page.phoneNumberInvalidFeedback.getText(),invalidFeedbackExpectedMessage);
        ReusableMethods.bekle(2);

        //4.Dogrulama
        String alreadyRegisterExpectedMessage = "555-555-9999 already register";
        phoneAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.phoneNumberAlani.sendKeys("555-555-9999");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC02_alreadyRegister");
        Assert.assertTrue(page.alert.getText().contains(alreadyRegisterExpectedMessage));
    }

    @Then("admin ssn verilerini yanlis girer ve hata mesajlarini dogrular")
    public void adminSsnVerileriniYanlisGirerVeHataMesajlariniDogrular() {

        //Onceki Step'deki girilen verileri degistiriyoruz...(Kayıtlı olmayan veriler girmemiz gerekiyor)
        usernameAlaniTemizleme();
        phoneAlaniTemizleme();
        page.usernameAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanUsername"));
        page.phoneNumberAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanPhone"));

        //1.Dogrulama
        String enterValidSsnNumberExpectedMessage = "Please enter valid SSN number";
        ssnAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.ssnAlani.sendKeys("12341234123");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC03_enterValidSsnNumber01");
        Assert.assertEquals(page.alert.getText(),enterValidSsnNumberExpectedMessage);

        //2.Dogrulama
        ssnAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.ssnAlani.sendKeys("432-98-12344");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC03_enterValidSsnNumber02");
        Assert.assertEquals(page.alert.getText(),enterValidSsnNumberExpectedMessage);

        //3.Dogrulama
        String invalidFeedbackExpectedMessage ="Minimum 11 character (XXX-XX-XXXX)";
        ssnAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.ssnAlani.sendKeys("432-98-123");
        ReusableMethods.tumSayfaResmi("22","TC03_minimum11Character");
        Assert.assertEquals(page.ssnNumberInvalidFeedback.getText(),invalidFeedbackExpectedMessage);

        //4.Dogrulama
        String alreadyRegisterExpectedMessage = "555-22-9999 already register";
        ssnAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.ssnAlani.sendKeys("555-22-9999");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC03_alreadyRegister");
        Assert.assertTrue(page.alert.getText().contains(alreadyRegisterExpectedMessage));
    }

    @Then("admin dogum tarihini ileri bir tarih girer ve hata mesajini dogrular")
    public void adminDogumTarihiniIleriBirTarihGirerVeHataMesajiniDogrular() {
        String gecmisTarihExpectedMessage ="geçmiş bir tarih olmalı";
        dateOfBirthAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.dateOfBirthAlani.sendKeys("24.01.2028");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("22","TC04_gecmisTarih");
        Assert.assertEquals(page.alert.getText(),gecmisTarihExpectedMessage);
    }
}
