package management_on_schools.step_definitions.US_15_AND_US_21;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_schools.pages.Home_Page;

import management_on_schools.pages.Suleyman_US15_21.US_15Page;
import management_on_schools.pojos.Suleyman15_21.US15.OgrenciPostPojo;
import management_on_schools.pojos.Suleyman15_21.US15.ResponsePojo;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.sql.*;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;
import static org.junit.Assert.assertEquals;

public class US15_StepDefinition {

    OgrenciPostPojo expectedData;
    ResponsePojo actualData;
    Response response;
    Connection connection;

    ResultSet resultSet;
    Statement statement;
    Home_Page home_page = new Home_Page();
    US_15Page us_15Page = new US_15Page();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    static Faker faker = new Faker();
    static String name = faker.name().firstName();
    static String surName = faker.name().lastName();
    static String birthPlace = faker.address().country();
    static String email = faker.internet().emailAddress();
    static String phone = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String dateOfBirth = faker.number().numberBetween(10,28) + "/" + faker.number().numberBetween(10,12) + "/" + faker.number().numberBetween(1985, 2010);
    static String dateOfBirthAPI = dateOfBirth.substring(6) + "-" + dateOfBirth.substring(3, 5) + "-" + dateOfBirth.substring(0, 2);
    static String ssn = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    static String userName = faker.name().username() + faker.number().numberBetween(10, 50);
    static String fatherName = faker.name().firstName();
    static String motherName = faker.name().firstName();
    static String password = "Izmir.*35";
    static String krkAzPassword = "Anton1";
    static String krkCokPassword = "@$!*=+_-*";
    static String bitisikSsn = "456985678";

    @Given("kullanici Managementonschools sayfasina gider")
    public void kullaniciManagementonschoolsSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
        ReusableMethods.bekle(1);
    }

    @Then("kullanici login butonuna tiklar")
    public void kullaniciLoginButonunaTiklar() {
        home_page.homePageLoginButton.click();
        ReusableMethods.bekle(1);
    }

    @Then("kullanici admin olarak giris yapar")
    public void kullaniciAdminOlarakGirisYapar() {
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"), Keys.TAB,
                (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        ReusableMethods.bekle(1);
    }

    @And("kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }

    @And("kullanici menu butonuna tiklar")
    public void kullaniciMenuButonunaTiklar() {
        home_page.menuButton.click();
    }

    @And("kullanici Student Management butonuna tiklar")
    public void kullaniciStudentManagementButonunaTiklar() {
        us_15Page.studentManagementButton.click();
    }

    @Then("kullanici danisman ogretmeni secer")
    public void kullanici_danisman_ogretmeni_secer() {
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(1);
    }

    @And("ogrenci kaydinin gerceklestigi dogrulanir")
    public void ogrenciKaydininGerceklestigiDogrulanir() {
        System.out.println(us_15Page.studentUpdatedSuccessfullyYazisi.getText());
        Assert.assertTrue(us_15Page.studentUpdatedSuccessfullyYazisi.isDisplayed());
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollBy(0,1450)");
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdsonSayfaButonu);
        ReusableMethods.bekle(1);
        js.executeScript("window.scrollBy(0,-850)");
        ReusableMethods.bekle(1);
        Assert.assertTrue(us_15Page.stdsonSayfaButonu.isDisplayed());
    }

    @And("kullanici yeniden menu butonuna tiklar")
    public void kullaniciYenidenMenuButonunaTiklar() {
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
    }

    @And("kullanici logout butonuna tiklar ve cikis yapar")
    public void kullaniciLogoutButonunaTiklarVeCikisYapar() {
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici name yazmadan tum bilgileri girer")
    public void kullaniciNameYazmadanTumBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredNameGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredNameGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\

    @When("kullanici surname yazmadan bilgileri girer")
    public void kullaniciSurnameYazmadanBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredSurnameGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredSurnameGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici birth place yazmadan bilgileri girer")
    public void kullaniciBirthPlaceYazmadanBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredBirthPlaceGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici birth email yazmadan bilgileri girer")
    public void kullaniciBirthEmailYazmadanBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredSEmailGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici birth telefon numarasi yazmadan bilgileri girer")
    public void kullaniciBirthTelefonNumarasiYazmadanBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredPhoneNumberGorunumu.isDisplayed());
        ReusableMethods.bekle(2);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici birth cinsiyeti secmeden bilgileri girer")
    public void kullaniciBirthCinsiyetiSecmedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB, Keys.TAB);
        ReusableMethods.bekle(1);
//        if (!us_15Page.maleCheckBoxButonu.isSelected()) { us_15Page.maleCheckBoxButonu.click(); }
//        ReusableMethods.bekle(1);
        Assert.assertTrue(us_15Page.maleCheckBoxButonu.isDisplayed());
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici dogum tarihini girmeden bilgileri girer")
    public void kullaniciDogumTarihiniGirmedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredDateOfBirthGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici ucuncu ve besinci rakamdan sonra cizgi içermeyen SSN bilgileri girmeden bilgileri girer")
    public void kullaniciUcuncuVeBesinciRakamdanSonraCizgiIcermeyenSSNBilgileriGirmedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(bitisikSsn, Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15Minimum11CharacterSsnGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(5);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici gerekli sartlari yerine getirmeden bilgileri girer")
    public void kullaniciGerekliSartlariYerineGetirmedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredSsnGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici user name girmeden bilgileri girer")
    public void kullaniciUserNameGirmedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredUsernameGorunumu.isDisplayed());
        ReusableMethods.bekle(2);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollHome();
        ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici father name girmeden bilgileri girer")
    public void kullaniciFatherNameGirmedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredUsernameGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(password, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici mother name girmeden bilgileri girer")
    public void kullaniciMotherNameGirmedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15ReqiredMotherNameGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici passwordu en az sekiz karakterden olusturmadan bilgileri girer")
    public void kullaniciPassworduEnAzSekizKarakterdenOlusturmadanBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(krkAzPassword, Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15PasswordAtLeast8CharactersGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //====================================================================================\\
    @When("kullanici passwordu buyuk harf kucuk harf ve bir rakam icermeden bilgileri girer")
    public void kullaniciPassworduBuyukHarfKucukHarfVeBirRakamIcermedenBilgileriGirer() {
        home_page.homePageLoginButton.click();
        home_page.loginEmailField.sendKeys(ConfigReader.getProperty("viceDeanUsername"),
                Keys.TAB, (ConfigReader.getProperty("viceDeanPassword")));
        ReusableMethods.click(home_page.loginButton);
        home_page.menuButton.click();
        us_15Page.studentManagementButton.click();
        Select select = new Select(us_15Page.chooseAdvisorTeacherDdm);
        select.selectByValue("32");
        ReusableMethods.bekle(1);
        us_15Page.stdNameButonu.sendKeys(name, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSurnameButonu.sendKeys(surName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdBirthPlacenameButonu.sendKeys(birthPlace, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdEmailButonu.sendKeys(email, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdTelButonu.sendKeys(phone, Keys.TAB);
        ReusableMethods.bekle(1);
        if (!us_15Page.maleCheckBoxButonu.isSelected()) {
            us_15Page.maleCheckBoxButonu.click();
        }
        ReusableMethods.bekle(1);
        us_15Page.dateOfBirthButonu.sendKeys(dateOfBirth, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdSsnButonu.sendKeys(ssn, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdUSerNameButonu.sendKeys(userName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdFatherNameButonu.sendKeys(fatherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdMotherNameButonu.sendKeys(motherName, Keys.TAB);
        ReusableMethods.bekle(1);
        us_15Page.stdPasswordButonu.sendKeys(krkCokPassword, Keys.TAB);
        Assert.assertTrue(us_15Page.stdUs15PasswordOneLowercaseCharacterGorunumu.isDisplayed());
        ReusableMethods.bekle(1);
        us_15Page.stdSubmitButonu.click();
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(us_15Page.chooseAdvisorTeacherDdm);
        ReusableMethods.scrollHome();
        //ReusableMethods.waitForVisibility(us_15Page.stdUs15ReqiredBirthPlaceGorunumu, 15);
        ReusableMethods.tumSayfaResmi("15", "Name is Required");
        js.executeScript("arguments[0].click()", us_15Page.stdMenuButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdLogOutButonu);
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click()", us_15Page.stdUs15LogoutYesButton);
        ReusableMethods.bekle(1);
    }

    //*============================================== API ==============================================*\\

    @Given("Ogrenci eklemek icin Post request hazirligi yapilir")
    public void ogrenci_eklemek_icin_post_request_hazirligi_yapilir() {
        //https://managementonschools.com/app/students/save
        //Set the Url
        spec.pathParams("first", "students", "second", "save");
    }

    @Given("Gonderilecek ogrenci bilgileri hazirlanir")
    public void gonderilecek_ogrenci_bilgileri_hazirlanir() {
        //set the expected data
        expectedData = new OgrenciPostPojo(32,dateOfBirthAPI, birthPlace,
                email,
                fatherName, "MALE", motherName, name, password,
                phone, ssn, surName, userName);
        System.out.println("userName = " + userName);
        System.out.println("ssn = " + ssn);
        System.out.println(expectedData);
    }

    @When("Ogrenci eklemek icin Post request gonderilir")
    public void ogrenci_eklemek_icin_post_request_gonderilir() {
        //Send the request and get the response
        response = given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();
        actualData = response.as(ResponsePojo.class);
    }

    @Then("Ogrenci bilgileri dogrulanir")
    public void ogrenci_bilgileri_dogrulanir() {
        //Do assertion
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.getMotherName(), actualData.getObject().getMotherName());
        assertEquals(expectedData.getFatherName(), actualData.getObject().getFatherName());
        assertEquals(expectedData.getAdvisorTeacherId(), actualData.getObject().getAdvisorTeacherId());
        assertEquals(expectedData.getEmail(), actualData.getObject().getEmail());
    }

    //*============================================== DT ==============================================*\\

    @Given("ogrenci kaydi icn DataBase baglan")
    public void ogrenciKaydiIcnDataBaseBaglan() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
    }

    @When("username username ile ogrenci bilglerini getir")
    public void usernameUsernameIleOgrenciBilgleriniGetir() throws SQLException {
        statement = connection.createStatement();
        String query = "select * from student where username = '" + userName + "'";
        resultSet = statement.executeQuery(query);

    }

    String actualName;
    String actualSurname;
    String actualBirthPlace;
    String actualPhone;
    String actualSsn;


    @Then("Database bilgileri dogrulanir")
    public void databaseBilgileriDogrulanir() throws SQLException {
        resultSet.next();
        actualName = resultSet.getString("name");
        actualSurname = resultSet.getString("surname");
        actualBirthPlace = resultSet.getString("birth_place");
        actualPhone = resultSet.getString("phone_number");
        actualSsn = resultSet.getString("ssn");

        assertEquals(name, actualName);
        assertEquals(surName, actualSurname);
        assertEquals(birthPlace, actualBirthPlace);
        assertEquals(phone, actualPhone);
        assertEquals(ssn, actualSsn);
    }
}





