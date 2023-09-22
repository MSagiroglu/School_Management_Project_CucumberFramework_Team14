package management_on_schools.step_definitions.US_01_AND_US_02;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.MustafaS01_02.US_01Page;
import management_on_schools.pages.MustafaS01_02.US_02Page;
import management_on_schools.pojos.MustafaS01_02.US_01.GuestUserPostPojo;
import management_on_schools.pojos.MustafaS01_02.US_01.negative_post_response.NegativePostResponsePojo;
import management_on_schools.pojos.MustafaS01_02.US_01.positive_post_response.Responsepojo;
import management_on_schools.pojos.MustafaS01_02.US_02.deleteRequestPojos.DeleteResponsePojo;
import management_on_schools.pojos.MustafaS01_02.US_02.getRequestPojos.ContentPojo;
import management_on_schools.pojos.MustafaS01_02.US_02.getRequestPojos.GetRequestResponsePojo;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.JDBCUtils;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;
import static org.junit.Assert.assertEquals;


public class US001_US002 {
    Home_Page homePage = new Home_Page();
    US_01Page us01Page = new US_01Page();
    US_02Page us02Page = new US_02Page();
    Actions action = new Actions(Driver.getDriver());
    static Faker faker = new Faker();
    static String name =  faker.name().firstName() + faker.number().numberBetween(1, 10);
    static String surname = faker.name().lastName();
    static String birthPlace = name;
    static String userName = faker.name().firstName() + faker.number().numberBetween(1, 10);
    static String password = name + "1256aA";
    static String birthDate = faker.number().numberBetween(10, 28) + "-" + faker.number().numberBetween(10, 12) + "-" + faker.number().numberBetween(1900, 2020);
    static String birthDate2 = birthDate.substring(6) + "-" + birthDate.substring(3, 5) + "-" + birthDate.substring(0, 2);
    static String phoneNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String ssnNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    String registeredPhone = ConfigReader.getProperty("RegiteredPhone");
    String registeredSsn = ConfigReader.getProperty("RegiteredSsn");
    String phoneNumberWithLetter = ConfigReader.getProperty("PhoneNumberWithLetter");
    String invalidDateOfBirth = ConfigReader.getProperty("InvalidDateOfBirth");
    String ssnNumberWithCharacter = ConfigReader.getProperty("SsnNumberWithCharacter");
    String ssnNumberNo11Character = ConfigReader.getProperty("SsnNumberNo11Character");
    String ssnNumberMore11Character = ConfigReader.getProperty("SsnNumberMore11Character");
    String ssnNumberWithLetter = ConfigReader.getProperty("SsnNumberWithLetter");
    String registerdUserName = ConfigReader.getProperty("RegiteredUserName");
    String passwordLessThan8 = ConfigReader.getProperty("PasswordLessThan8");
    String passwordWithNoUpperCase = ConfigReader.getProperty("PasswordWithNoUpperCase");
    String passwordWithNoLowerCase = ConfigReader.getProperty("PasswordWithNoLowerCase");
    String passwordWithNoNumber = ConfigReader.getProperty("PasswordWithNoNumber");


    @Given("Guest User Anasayfada register butonuna tiklar")
    public void guest_user_anasayfada_register_butonuna_tiklar() {
        ReusableMethods.click(homePage.homePageRegisterButton);
    }

    @When("Guest User Register sayfasındaki gerekli alanları doldurur.")
    public void guest_user_register_sayfasındaki_gerekli_alanları_doldurur() {
        homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("ssnNumber = " + ssnNumber);
        System.out.println("userName = " + userName);


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
            homePage.registerNameField.sendKeys(Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            ReusableMethods.scrollHome();
            ReusableMethods.tumSayfaResmi("01", "Guest User name required.");
        } else if (data.equalsIgnoreCase("surname")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            ReusableMethods.scrollHome();
            ReusableMethods.tumSayfaResmi("01", "Guest User surname required.");
        } else if (data.equalsIgnoreCase("birth place")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            ReusableMethods.scrollHome();
            ReusableMethods.tumSayfaResmi("01", "Guest User birth place required.");
        } else if (data.equalsIgnoreCase("phone number")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Guest User phone number required.");
        } else if (data.equalsIgnoreCase("birth date")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            ReusableMethods.waitForVisibility(us01Page.requiredMessage, 5);
            action.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.tumSayfaResmi("01", "Guest User birth date required.");
        } else if (data.equalsIgnoreCase("Ssn Number")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            action.sendKeys(Keys.PAGE_UP).perform();
            ReusableMethods.tumSayfaResmi("01", "Guest User Ssn Number required.");
        } else if (data.equalsIgnoreCase("Ssn Number tam karakter")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumberNo11Character, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Minimum 11 character (XXX-XX-XXXX)");
        } else if (data.equalsIgnoreCase("User Name")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, Keys.TAB, password, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Guest User User Name required.");
        } else if (data.equalsIgnoreCase("Password")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Guest User Password required.");
        } else if (data.equalsIgnoreCase("Password 8 karakter")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, passwordLessThan8, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Guest User Password at least 8 characters.");
        } else if (data.equalsIgnoreCase("Password'e buyuk harf")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, passwordWithNoUpperCase, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Guest User Password without upper case.");
        } else if (data.equalsIgnoreCase("Password'e kucuk harf")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, passwordWithNoLowerCase, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Guest User Password without lower case.");
        } else if (data.equalsIgnoreCase("Password'e rakam")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, passwordWithNoNumber, Keys.TAB, Keys.ENTER);
            ReusableMethods.tumSayfaResmi("01", "Guest User Password without number.");
        }

    }

    //-->Aday ogrencinin kaydının gerçeklesmedigi dogrulanır.
    @Then("Aday ogrencinin kaydinin gerçeklesmedigi dogrulanir.")
    public void adayOgrencininKaydininGerceklesmedigiDogrulanir() {
        String actualMessage;
        try {
            actualMessage = us01Page.requiredMessage.getText();
            System.out.println("actualMessage = " + actualMessage);
        } catch (Exception e) {
            try {
                actualMessage = us01Page.requiredMessageSSSmin.getText();
                System.out.println("actualMessage = " + actualMessage);
            } catch (Exception ex) {
                try {
                    actualMessage = us01Page.requiredPassword.getText();
                    System.out.println("actualMessage = " + actualMessage);
                } catch (Exception exc) {
                    try {
                        actualMessage = us01Page.requiredAtLeast8Password.getText();
                        System.out.println("actualMessage = " + actualMessage);
                    } catch (Exception exception) {
                        try {
                            actualMessage = us01Page.requiredUpperCasePassword.getText();
                            System.out.println("actualMessage = " + actualMessage);
                        } catch (Exception e1) {
                            try {
                                actualMessage = us01Page.requiredLowerCasePassword.getText();
                                System.out.println("actualMessage = " + actualMessage);
                            } catch (Exception e2) {
                                actualMessage = us01Page.requiredNumberPassword.getText();
                                System.out.println("actualMessage = " + actualMessage);
                            }
                        }
                    }
                }
            }
        }


        String expectedMessage;
        if (actualMessage.equalsIgnoreCase("required")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "Required";
            Assert.assertEquals(expectedMessage, actualMessage, "Required");
        } else if (actualMessage.equalsIgnoreCase("Enter your password")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "Enter your password";
            Assert.assertEquals(expectedMessage, actualMessage, "Enter your password");
        } else if (actualMessage.equalsIgnoreCase("Minimum 12 character (XXX-XXX-XXXX)")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "Minimum 12 character (XXX-XXX-XXXX)";
            Assert.assertEquals(expectedMessage, actualMessage, "Minimum 12 character (XXX-XXX-XXXX)");
        } else if (actualMessage.equalsIgnoreCase("Minimum 11 character (XXX-XX-XXXX)")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "Minimum 11 character (XXX-XX-XXXX)";
            Assert.assertEquals(expectedMessage, actualMessage, "Minimum 11 character (XXX-XX-XXXX)");
        } else if (actualMessage.equalsIgnoreCase("At least 8 characters")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "At least 8 characters";
            Assert.assertEquals(expectedMessage, actualMessage, "At least 8 characters");
        } else if (actualMessage.equalsIgnoreCase("One uppercase character")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "One uppercase character";
            Assert.assertEquals(expectedMessage, actualMessage, "One uppercase character");
        } else if (actualMessage.equalsIgnoreCase("One lowercase character")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "One lowercase character";
            Assert.assertEquals(expectedMessage, actualMessage, "One lowercase character");
        } else if (actualMessage.equalsIgnoreCase("One number")) {
            System.out.println("actualMessage = " + actualMessage);
            expectedMessage = "One number";
            Assert.assertEquals(expectedMessage, actualMessage, "One number");
        }


    }


    @When("Guest User Register sayfasındaki gerekli datalari daha once kullanilmis  bir data  {string} ile girerek alanları doldurur.")
    public void guestUserRegisterSayfasındakiGerekliDatalariDahaOnceKullanilmisBirDataIleGirerekAlanlarıDoldurur(String data) {
        if (data.equalsIgnoreCase("registered phone")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, ConfigReader.getProperty("RegiteredPhone"), Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        } else if (data.equalsIgnoreCase("Registered Ssn number")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, registeredSsn, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        } else if (data.equalsIgnoreCase("Registered User Name")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, registerdUserName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        }
    }

    @Then("Aday ogrencinin kaydinin  daha once kullanilmiş bir data {string} ile gerceklesmedigi dogrulanir.")
    public void adayOgrencininKaydininDahaOnceKullanilmisBirDataIleGerceklesmedigiDogrulanir(String data) {
        ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
        String actualMessage = us01Page.alertMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        String expectedMessage;
        if (data.equalsIgnoreCase("registered phone")) {
            ReusableMethods.tumSayfaResmi("01", "Guest User used Registered Phone number.");
            expectedMessage = "Error: User with phone number " + registeredPhone + " already register";
            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        } else if (data.equalsIgnoreCase("registered Ssn number")) {
            ReusableMethods.tumSayfaResmi("01", "Guest User used Registered Ssn number.");
            expectedMessage = "Error: User with ssn " + registeredSsn + " already register";
            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        } else if (data.equalsIgnoreCase("Registered User Name")) {
            ReusableMethods.tumSayfaResmi("01", "Guest User used Registered User Name.");
            expectedMessage = "Error: User with username " + registerdUserName + " already register";
            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }
    }

    @When("Guest User Register sayfasındaki gerekli datalar ile birlikte data olarak  {string} ile girerek alanları doldurur.")
    public void guestUserRegisterSayfasındakiGerekliDatalarIleBirlikteDataOlarakIleGirerekAlanlarıDoldurur(String data) {
        if (data.equalsIgnoreCase("Phone number'da  rakamdan farkli karakter")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumberWithLetter, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        } else if (data.equalsIgnoreCase("gecmis olamyan bir tarih")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, invalidDateOfBirth, Keys.TAB, ssnNumber, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        } else if (data.equalsIgnoreCase("Ssn number'da  (-)'den farkli karakter")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumberWithCharacter, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        } else if (data.equalsIgnoreCase("Ssn Number fazla karakter")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumberMore11Character, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        } else if (data.equalsIgnoreCase("Ssn number'da  rakamdan farkli karakter")) {
            homePage.registerNameField.sendKeys(name, Keys.TAB, surname, Keys.TAB, birthPlace, Keys.TAB, phoneNumber, Keys.TAB, Keys.SPACE, Keys.TAB, birthDate, Keys.TAB, ssnNumberWithLetter, Keys.TAB, userName, Keys.TAB, password, Keys.TAB, Keys.ENTER);
        }


    }

    @Then("Aday ogrencinin {string} dataya farkli karakter girdiginden kaydinin gerceklesmedigi dogrulanir.")
    public void adayOgrencininDatayaFarkliKarakterGirdigindenKaydininGerceklesmedigiDogrulanir(String data) {
        ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
        String actualMessage = us01Page.alertMessage.getText();

        if (data.equalsIgnoreCase("Ssn number")) {
            String expectedMessage = "Please enter valid SSN number";
            ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
            ReusableMethods.tumSayfaResmi("01", "Guest User Ssn Number'da  (-)'den farkli karakter girmiştir.");
            Assert.assertEquals(expectedMessage, actualMessage);
        } else if (data.equalsIgnoreCase("Phone Number")) {
            ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
            ReusableMethods.tumSayfaResmi("01", "Guest User Phone Number'da  rakamdan farkli karakter girmiştir.");
            String expectedMessage = "Please enter valid phone number";
            Assert.assertEquals(expectedMessage, actualMessage);
        } else if (data.equalsIgnoreCase("birth date")) {
            ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
            ReusableMethods.tumSayfaResmi("01", "Guest User geçerli bir birth date girmemiştir.");
            String expectedMessage = "geçmiş bir tarih olmalı";
            Assert.assertEquals(expectedMessage, actualMessage);
        } else if (data.equalsIgnoreCase("Ssn Number 11'den fazla karakter")) {
            ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
            ReusableMethods.tumSayfaResmi("01", "Ssn Number more 11 character (XXX-XX-XXXX)");
            String expectedMessage = "Please enter valid SSN number";
            Assert.assertEquals(expectedMessage, actualMessage);
        } else if (data.equalsIgnoreCase("Ssn Number'a harf ile girer")) {
            ReusableMethods.waitForVisibility(us01Page.alertMessage, 5);
            ReusableMethods.tumSayfaResmi("01", "Ssn Number'a harf ile data girer");
            String expectedMessage = "Please enter valid SSN number";
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

    @And("Sayfayi Kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }


    @When("Admin Guest User Sayfasina giris yapar")
    public void adminGuestUserSayfasinaGirisYapar() {
        homePage.menuButton.click();
        us02Page.guestUserButton.click();
    }

    List<WebElement> guestUserTable;
    String actualName;
    String actualPhone;
    String actualSsn;
    String actualUserName;
    static String arananName = userName;
    String expectedName, expectedPhone, expectedSsn, expectedUserName;
    WebElement actualName1, actualPhone1, actualSsn1, actualUserName1;
    static String pagenumber;

    @Then("Admin Kayıt olan Guest user'a ait bilgileri görebilir.")
    public void adminKayıtOlanGuestUserAAitBilgileriGorebilir() {
        ReusableMethods.bekle(2);
        ReusableMethods.visibleWait(us02Page.guestUserTableCount, 10);
        int pageCount = Integer.parseInt(us02Page.guestUserTableCount.getAttribute("textContent").split(" ")[3]);
        guestUserTable = us02Page.guestUserTable;
        System.out.println("guestUserTable.get(i) = " + guestUserTable.get(1).getText());
        arananName = userName;
        System.out.println("arananName = " + arananName);

        for (int i = 0; i < pageCount; i++) {
            int t = 1;
            for (int j = 1; j < guestUserTable.size(); j++) {
                guestUserTable = us02Page.guestUserTable;
                if (guestUserTable.get(j).getText().equals(arananName)) {
                    System.out.println("DAta bulundu ve assertion başladı");
                    guestUserTable = us02Page.guestUserTable;
                    ReusableMethods.tumSayfaResmi("01", "Admin Guest User'a ait bilgileri görebilir.");
                    expectedName = name + " " + surname;
                    expectedPhone = phoneNumber;
                    expectedSsn = ssnNumber;
                    expectedUserName = userName;
                    actualName1 = guestUserTable.get(j - 3);
                    ReusableMethods.waitForVisibility(actualName1, 5);
                    actualName = actualName1.getText();
                    actualPhone1 = guestUserTable.get(j - 2);
                    ReusableMethods.waitForVisibility(actualPhone1, 5);
                    actualPhone = actualPhone1.getText();
                    actualSsn1 = guestUserTable.get(j - 1);
                    ReusableMethods.waitForVisibility(actualSsn1, 5);
                    actualSsn = actualSsn1.getText();
                    actualUserName1 = guestUserTable.get(j);
                    ReusableMethods.waitForVisibility(actualUserName1, 5);
                    actualUserName = actualUserName1.getText();
                    Assert.assertEquals(expectedName, actualName);
                    Assert.assertEquals(expectedPhone, actualPhone);
                    Assert.assertEquals(expectedSsn, actualSsn);
                    Assert.assertEquals(expectedUserName, actualUserName);
                    pagenumber = us02Page.guestUserTableCount.getAttribute("textContent").split(" ")[3];
                    System.out.println("pagenumber = " + pagenumber);
                    j = guestUserTable.size();
                    i = pageCount;

                    //t = j;
                    break;

                } else {
                    System.out.println(guestUserTable.get(j).getText());
                }
                //t = j;
            }
            if (guestUserTable.get(t).getText().equals(arananName)) {
                break;
            } else {
                ReusableMethods.click(us02Page.guestUserIleriButton);
                ReusableMethods.bekle(1);

            }


        }


    }

    @Then("Admin Kayıt olan Guest user'a ait bilgileri silebilir.")
    public void adminKayıtOlanGuestUserAAitBilgileriSilebilir() {
        ReusableMethods.bekle(2);
        ReusableMethods.visibleWait(us02Page.guestUserTableCount, 10);
        int pageCount = Integer.parseInt(us02Page.guestUserTableCount.getAttribute("textContent").split(" ")[3]);
        guestUserTable = us02Page.guestUserTable;
        System.out.println("guestUserTable.get(i) = " + guestUserTable.get(1).getText());
        arananName = userName;
        System.out.println("arananName = " + arananName);
        String expectedMessage = "Guest User deleted Successful";

        for (int i = 0; i < pageCount; i++) {
            for (int j = 1; j < guestUserTable.size(); j++) {
                guestUserTable = us02Page.guestUserTable;
                if (guestUserTable.get(j).getText().equals(arananName)) {
                    System.out.println("Data bulundu ve silme başladı");
                    guestUserTable = us02Page.guestUserTable;
                    WebElement deleteButton = guestUserTable.get(j + 1);
                    ReusableMethods.bekle(2);
                    ReusableMethods.click(deleteButton);
                    ReusableMethods.visibleWait(us01Page.alertMessage, 5);
                    Assert.assertEquals(expectedMessage, us01Page.alertMessage.getText());
                    System.out.println("Mesaj doğrulandı");
                    j = guestUserTable.size();
                    i = pageCount;
                    break;
                }
            }
            ReusableMethods.click(us02Page.guestUserIleriButton);
            ReusableMethods.bekle(1);

        }

    }

    @Given("Kullanici Admin olarak giris yapar.")
    public void kullaniciAdminOlarakGirisYapar() {
        ReusableMethods.waitForVisibility(homePage.homePageLoginButton, 5);
        ReusableMethods.click(homePage.homePageLoginButton);
        homePage.loginEmailField.sendKeys(ConfigReader.getProperty("AdminUsername"));
        homePage.loginPasswordField.sendKeys(ConfigReader.getProperty("AdminPassword"));
        homePage.loginButton.click();
        //ReusableMethods.login("AdminUsername", "AdminPassword");
    }

    //-----------       API             ---------------\\
    static GuestUserPostPojo expectedData;
    static Response response;
    static Responsepojo actualData;

    @Given("Guest User eklemek icin Post request hazirligi yapilir")
    public void guest_user_eklemek_icin_post_request_hazirligi_yapilir() {
        //https://managementonschools.com/app/guestUser/register
        //Set the url
        spec.pathParams("first", "guestUser", "second", "register");


    }

    @Given("Gonderilecek Guest User bilgileri hazırlanır")
    public void gonderilecek_guest_user_bilgileri_hazırlanır() {
        //Set the expected data
        expectedData = new GuestUserPostPojo(birthDate2, birthPlace, "FEMALE", name, password, phoneNumber, ssnNumber, surname, userName);
        System.out.println("expectedData = " + expectedData);


    }

    @When("Guest User eklemek icin Post request gonderilir")
    public void guest_user_eklemek_icin_post_request_gonderilir() {
        response = given(spec).body(expectedData).when().post("/{first}/{second}");
        response.prettyPrint();
        actualData = response.as(Responsepojo.class);
    }

    @Then("Guest User Post Response Bilgileri dogrulanir")
    public void guest_user_post_responsebilgileri_dogrulanir() {
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());

    }


    @Given("Guest User icin Get request hazirligi yapilir")
    public void guestUserIcinGetRequestHazirligiYapilir() {
        //https://managementonschools.com/app/guestUser/getAll?page=60&size=5&sort=name&type=desc
        spec.pathParams("first", "guestUser", "second", "getAll").queryParam("size", 1000);
    }

    ContentPojo expectedGuestUserData;

    @And("Sorgulanacak Guest User bilgileri hazırlanır")
    public void sorgulanacakGuestUserBilgileriHazırlanır() {
        expectedGuestUserData = new ContentPojo(userName, ssnNumber, name, surname, birthDate2, birthPlace, phoneNumber, "FEMALE");
        System.out.println("expectedGuestUserData = " + expectedGuestUserData);
    }

    @When("Sorgulamak icin Get request gonderilir")
    public void sorgulamakIcinGetRequestGonderilir() {
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    GetRequestResponsePojo actualGuestUserData;

    @Then("Guest User Get Response Bilgileri dogrulanir")
    public void guestUserGetResponseBilgileriDogrulanir() {
        actualGuestUserData = response.as(GetRequestResponsePojo.class);
        for (int i = 0; i < actualGuestUserData.getContent().size(); i++) {
            if (actualGuestUserData.getContent().get(i).getUsername().equals(arananName)) {
                assertEquals(expectedGuestUserData.getUsername(), actualGuestUserData.getContent().get(i).getUsername());
                assertEquals(expectedGuestUserData.getSsn(), actualGuestUserData.getContent().get(i).getSsn());
                assertEquals(expectedGuestUserData.getName(), actualGuestUserData.getContent().get(i).getName());
                assertEquals(expectedGuestUserData.getSurname(), actualGuestUserData.getContent().get(i).getSurname());
                assertEquals(expectedGuestUserData.getBirthDay(), actualGuestUserData.getContent().get(i).getBirthDay());
                assertEquals(expectedGuestUserData.getBirthPlace(), actualGuestUserData.getContent().get(i).getBirthPlace());
                assertEquals(expectedGuestUserData.getPhoneNumber(), actualGuestUserData.getContent().get(i).getPhoneNumber());
                assertEquals(expectedGuestUserData.getGender(), actualGuestUserData.getContent().get(i).getGender());
                System.out.println("Doğrulama yapıldı");
                break;

            }
        }
    }

    static GuestUserPostPojo expectedWithoutNameData = new GuestUserPostPojo(birthDate2, birthPlace, "FEMALE", password, phoneNumber, ssnNumber, surname, userName);

    @And("Gonderilecek Guest User {string} olmadan bilgileri hazırlanır")
    public void gonderilecekGuestUserOlmadanBilgileriHazırlanır(String data) {
        if (data.equalsIgnoreCase("name")) {
            expectedWithoutNameData = new GuestUserPostPojo(birthDate2, birthPlace, "FEMALE", password, phoneNumber, ssnNumber, surname, userName);
            System.out.println("expectedWithoutNameData = " + expectedWithoutNameData.getUsername());
        }

    }




    @Then("Guest User {string} girmeden Post Response Bilgilerinin getirilemedigi dogrulanir")
    public void guestUserGirmedenPostResponseBilgilerininGetirilemedigiDogrulanir(String data) {
        if (data.equalsIgnoreCase("name")) {
            NegativePostResponsePojo actualNegativePostResponse = response.as(NegativePostResponsePojo.class);
            assertEquals(400, response.statusCode());
            assertEquals("Validation failed for object='guestUserRequest'. Error count: 1", actualNegativePostResponse.getMessage());
            assertEquals("Please enter your name", actualNegativePostResponse.getValidations().getName());
            System.out.println("doğrulama yapıldı");

        }
    }

    NegativePostResponsePojo actualNegativePostResponse;

    @When("Guest User eklemek icin {string} olmadan Post request gonderilir")
    public void guestUserEklemekIcinOlmadanPostRequestGonderilir(String data) {
        if (data.equalsIgnoreCase("name")) {
            response = given(spec).body(expectedWithoutNameData).when().post("/{first}/{second}");
            response.prettyPrint();
            actualNegativePostResponse = response.as(NegativePostResponsePojo.class);
        }
    }


    @And("Site kapatilir.")
    public void siteKapatilir() {
        Driver.closeDriver();
    }

    @Given("Guest User icin Delete request hazirligi yapilir")
    public void guestUserIcinDeleteRequestHazirligiYapilir() {
        //https://managementonschools.com/app/guestUser/delete/1510
        spec.pathParams("first", "guestUser", "second", "delete","third",actualData.getObject().getUserId());
        System.out.println("Guest user id = "+actualData.getObject().getUserId());

    }

    @When("Silmek icin Delete request gonderilir")
    public void silmekIcinDeleteRequestGonderilir() {
        response = given(spec).when().delete("{first}/{second}/{third}");
        response.prettyPrint();
    }
    DeleteResponsePojo actualDeleteResponse;

    String expectedDeleteMessage=" Guest User deleted Successful";

    @Then("Guest User Delete Response Bilgileri dogrulanir")
    public void guestUserDeleteResponseBilgileriDogrulanir() {
        actualDeleteResponse = response.as(DeleteResponsePojo.class);
        Assert.assertEquals(expectedDeleteMessage, actualDeleteResponse.getMessage());
        Assert.assertEquals(200, response.statusCode());
        System.out.println("Silme işlemi başarıyla gerçekleşti.");

    }


static Connection connection;

    @When("Guest User Database bilgileri icin baglantı kurulur.")
    public void guest_user_database_bilgileri_icin_baglantı_kurulur() {
        connection=JDBCUtils.connectToDatabase();
    }
    String actualDatabaseUsername;
    String actualDatabaseName;
    String actualDatabaseSurname;
    String actualDatabasePhoneNumber;
    String actualDatabaseSsn;
    String actualDatabaseBirthDay;
    String actualDatabaseBirthPlace;
   static Statement statement;
   static ResultSet resultSet;
    static String expectedDatabaseUserName=expectedWithoutNameData.getUsername();


    @Then("Guest User bilgilerinin database icinde olup olmadigi dogrulanir.")
    public void guestUserBilgilerininDatabaseIcindeOlupOlmadigiDogrulanir() throws SQLException {
        statement=JDBCUtils.createStatement();
         resultSet= JDBCUtils.executeQuery("select * from guest_user where username = '" + expectedDatabaseUserName + "'");

        if (resultSet.next()==true) {
            actualDatabaseUsername= resultSet.getString("username");
            System.out.println("actualDatabaseUsername = " + actualDatabaseUsername);
            actualDatabaseName= resultSet.getString("name");
            actualDatabaseSurname= resultSet.getString("surname");
            actualDatabasePhoneNumber= resultSet.getString("phone_number");
            actualDatabaseSsn= resultSet.getString("ssn");
            actualDatabaseBirthDay= resultSet.getString("birth_day");
            actualDatabaseBirthPlace= resultSet.getString("birth_place");
            Assert.assertEquals(actualData.getObject().getUsername(), actualDatabaseUsername);
            Assert.assertEquals(actualData.getObject().getName(), actualDatabaseName);
            Assert.assertEquals(actualData.getObject().getSurname(), actualDatabaseSurname);
            Assert.assertEquals(actualData.getObject().getPhoneNumber(), actualDatabasePhoneNumber);
            Assert.assertEquals(actualData.getObject().getSsn(), actualDatabaseSsn);
            Assert.assertEquals(actualData.getObject().getBirthDay(), actualDatabaseBirthDay);
            Assert.assertEquals(actualData.getObject().getBirthPlace(), actualDatabaseBirthPlace);
            System.out.println("Database bilgileri dogrulandı.");
        } else {
            System.out.println("Database bilgileri dogrulamadı.");
        }


        JDBCUtils.closeConnection();

    }



}





