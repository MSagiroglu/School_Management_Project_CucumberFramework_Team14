package management_on_schools.step_definitions.US_01_AND_US_02;

import com.github.javafaker.Faker;
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
        ReusableMethods.tumSayfaResmi("01","Admin Sayfası");
        ReusableMethods.logout();
    }

    @Given("Guest User Anasayfada register butonuna tiklar")
    public void guest_user_anasayfada_register_butonuna_tiklar() {
        ReusableMethods.click(homePage.homePageRegisterButton);
    }
    @When("Guest User Register sayfasındaki gerekli alanları doldurur.")
    public void guest_user_register_sayfasındaki_gerekli_alanları_doldurur() {
        homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB,Keys.SPACE,Keys.TAB, birthDate, Keys.TAB,  ssnNumber, Keys.TAB, userName, Keys.TAB, password,Keys.TAB, Keys.ENTER);
    }

    @Then("Aday ogrncinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.")
    public void adayOgrncininKaydınınBasariliBirSekildeGerceklestigiDogrulanır() {
        String expectedMessage = "Guest User registered.";
        ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
        String actualMessage = us01Page.alertMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        ReusableMethods.tumSayfaResmi("01", "Guest User Register işlemi tamamlandı.");



    }
}
