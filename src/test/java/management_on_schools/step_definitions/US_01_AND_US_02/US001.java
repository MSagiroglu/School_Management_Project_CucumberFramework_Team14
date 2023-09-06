package management_on_schools.step_definitions.US_01_AND_US_02;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.MustafaS01_02.US_01Page;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class US001 {
    Home_Page homePage=new Home_Page();
    static US_01Page us01Page = new US_01Page();
    static Actions action = new Actions(Driver.getDriver());
    static Faker faker = new Faker();
    static String name = "Team14" + faker.name().firstName()+faker.number().numberBetween(1,10);
    static String surname = name;
    static String birthPlace = name;
    static String userName = name;
    static String password = name + "1";
    static String birthDate = faker.number().numberBetween(1, 30) + "." + faker.number().numberBetween(1, 12) + "." + faker.number().numberBetween(1900, 2020);
    static String phoneNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String ssnNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    @Given("Kullanici Admin olarak giris yapar.")
    public void kullaniciAdminOlarakGirisYapar() {
        ReusableMethods.login("AdminUsername", "AdminPassword");
        //ReusableMethods.tumSayfaResmi("01","Admin Sayfası");
        //ReusableMethods.logout();
    }

    @Given("Guest User Anasayfada register butonuna tiklar")
    public void guest_user_anasayfada_register_butonuna_tiklar() {
        ReusableMethods.click(homePage.homePageRegisterButton);
    }
    @When("Guest User Register sayfasındaki gerekli alanları doldurur.")
    public void guest_user_register_sayfasındaki_gerekli_alanları_doldurur() {
        homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB,Keys.SPACE,Keys.TAB, birthDate, Keys.TAB,  ssnNumber, Keys.TAB, userName, Keys.TAB, password,Keys.TAB, Keys.ENTER);
    }

    @Then("Aday ogrencinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.")
    public void adayOgrencininKaydınınBasariliBirSekildeGerceklestigiDogrulanır() {
        String expectedMessage = "Guest User registered.";
        ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
        String actualMessage = us01Page.alertMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        ReusableMethods.tumSayfaResmi("01", "Guest User Register işlemi tamamlandı.");



    }

    @When("Guest User Register sayfasındaki gerekli datayi {string} girmeden alanları doldurur.")
    public void guestUserRegisterSayfasındakiGerekliDatayiGirmedenAlanlarıDoldurur(String data) {
        if (data.equalsIgnoreCase("name")) {
            homePage.registerNameField.sendKeys(Keys.TAB,surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB,Keys.SPACE,Keys.TAB, birthDate, Keys.TAB,  ssnNumber, Keys.TAB, userName, Keys.TAB, password,Keys.TAB, Keys.ENTER);
            ReusableMethods.scrollHome();
            ReusableMethods.tumSayfaResmi("01","Guest User name required.");
        } else if (data.equalsIgnoreCase("surname")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB,Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB,Keys.SPACE,Keys.TAB, birthDate, Keys.TAB,  ssnNumber, Keys.TAB, userName, Keys.TAB, password,Keys.TAB, Keys.ENTER);
            ReusableMethods.scrollHome();
            ReusableMethods.tumSayfaResmi("01","Guest User surname required.");
        }
        else if (data.equalsIgnoreCase("birth place")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB,surname,Keys.TAB, Keys.TAB, phoneNumber, Keys.TAB,Keys.SPACE,Keys.TAB, birthDate, Keys.TAB,  ssnNumber, Keys.TAB, userName, Keys.TAB, password,Keys.TAB, Keys.ENTER);
            ReusableMethods.scrollHome();
            ReusableMethods.tumSayfaResmi("01","Guest User birth place required.");
        }else if (data.equalsIgnoreCase("phone number")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB,surname,Keys.TAB,birthPlace, Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB, birthDate, Keys.TAB,  ssnNumber, Keys.TAB, userName, Keys.TAB, password,Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01","Guest User phone number required.");
        }else if (data.equalsIgnoreCase("birth date")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB,surname,Keys.TAB,birthPlace, Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB, birthDate, Keys.TAB,  ssnNumber, Keys.TAB, userName, Keys.TAB, password,Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01","Guest User phone number required.");
        }
    }


    @Then("Aday ogrencinin kaydının gerçeklesmedigi dogrulanır.")
    public void adayOgrencininKaydınınGerceklesmedigiDogrulanır() {
        String actualMessage = us01Page.requiredMessage.getText();
        String expectedMessage ;
        if (actualMessage.equalsIgnoreCase("required")) {
            expectedMessage = "Required";
            Assert.assertEquals(expectedMessage, actualMessage);
            ReusableMethods.tumSayfaResmi("01","Guest User Register işlemi tamamlanmadı.");
        } else if (actualMessage.equalsIgnoreCase("Enter your password")) {
            expectedMessage = "Enter your password";
            Assert.assertEquals(expectedMessage, actualMessage);
        } else if (actualMessage.equalsIgnoreCase("Minimum 12 character (XXX-XXX-XXXX)")) {
            expectedMessage = "Minimum 12 character (XXX-XXX-XXXX)";
            Assert.assertEquals(expectedMessage, actualMessage);
        }

    }

    }

