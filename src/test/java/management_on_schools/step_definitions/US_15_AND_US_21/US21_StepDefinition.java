package management_on_schools.step_definitions.US_15_AND_US_21;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_schools.pages.Home_Page;

import management_on_schools.pages.Suleyman_US15_21.US_21Page;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class US21_StepDefinition {
    Home_Page home_page = new Home_Page();
    US_21Page us_21Page = new US_21Page();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Then("kullanici login butonuna basar")
    public void kullaniciLoginButonunaBasar() {
        home_page.homePageLoginButton.click();
    }

    @Then("kullanici ogrenci olarak giris yapar")
    public void kullanici_ogrenci_olarak_giris_yapar() {
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("studentUserName"),
                Keys.TAB, ConfigReader.getProperty("studentUserPassword"));
        ReusableMethods.click(home_page.loginButton);
        ReusableMethods.bekle(2);
    }

    @When("kullanici menu butonuna tiklayarak lesson management secenegine tiklar")
    public void kullaniciMenuButonunaTiklayarakLessonManagementSecenegineTiklar() {
        us_21Page.stdUs21MenuButonu.click();
        ReusableMethods.bekle(2);
        us_21Page.stdUs21ChooseLessonButonu.click();
        ReusableMethods.bekle(2);
    }

    @When("istedigi dersi secer ve submit butonuna tiklar")
    public void istedigiDersiSecerVeSubmitButonunaTiklar() {
        js.executeScript("window.scrollTo(0, 2000)", "");
        ReusableMethods.bekle(5);
        js.executeScript("arguments[0].click()", us_21Page.stdUs21CheckBoxLessonButonu);
        ReusableMethods.bekle(5);
        js.executeScript("window.scrollTo(0, 10200)", "");
        Assert.assertTrue(us_21Page.stdUs21LessonAddedAlertButonu.isDisplayed());
        ReusableMethods.bekle(5);
//        js.executeScript("arguments[0].click()", us_21Page.stdUs21SubmitButonu);// Bu aktive olmali
        ReusableMethods.bekle(5);
        js.executeScript("window.scrollTo(0, 10450)", "");
        //js.executeScript("arguments[0].scrollIntoView();", us_21Page.stdUs21LessonProgramList);
        ReusableMethods.bekle(5);
        Assert.assertTrue(us_21Page.stdUs21LessonProgramList.isDisplayed());
        ReusableMethods.bekle(2);
    }

    @When("ogrenci bir daha menuye gider ve grades and announcements segenegine tiklar")
    public void ogrenciBirDahaMenuyeGiderVeGradesAndAnnouncementsSegenegineTiklar() {
        js.executeScript("arguments[0].click()", us_21Page.stdUs21MenuButonu);
        ReusableMethods.bekle(2);
        js.executeScript("arguments[0].click()", us_21Page.stdUs21GradesAndAnnouncementsButonu);
        ReusableMethods.bekle(2);
        ReusableMethods.scrollHome();
        ReusableMethods.bekle(2);
    }

    @When("ogrenci student info list bolumunde kendi bilgilerini gorur")
    public void ogrenciStudentInfoListBolumundeKendiBilgileriniGorur() {
        Assert.assertTrue(us_21Page.stdUs21StudentInfoListButonu.isDisplayed());
        ReusableMethods.bekle(2);
    }

    @When("ogrenci meet list bolumunde danismanin kendisi icin olusturdugu gorusme saatini gorur")
    public void ogrenciMeetListBolumundeDanismaninKendisiIcinOlusturduguGorusmeSaatiniGorur() {
        js.executeScript("window.scrollTo(0, 150)");
        ReusableMethods.bekle(2);
        Assert.assertTrue(us_21Page.stdUs21StudentInfoListButonu.isDisplayed());
        ReusableMethods.bekle(2);
    }


    @When("ogrenci tekrardan yukari sagdaki menu butonuna basar")
    public void ogrenciTekrardanYukariSagdakiMenuButonunaBasar() {
        js.executeScript("arguments[0].click()", us_21Page.stdUs21MenuButonu);
        ReusableMethods.bekle(2);
    }

    @When("ogrenci soldaki logout butonuna tiklar ve cikis yapar")
    public void ogrenciSoldakiLogoutButonunaTiklarVeCikisYapar() {
        js.executeScript("arguments[0].click()", us_21Page.stdUs21LogoutButonu);
        ReusableMethods.bekle(2);
        js.executeScript("arguments[0].click()", us_21Page.stdUs21LogoutYesButton);
        ReusableMethods.bekle(2);
    }
}
