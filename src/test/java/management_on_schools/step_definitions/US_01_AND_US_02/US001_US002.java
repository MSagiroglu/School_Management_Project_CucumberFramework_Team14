package management_on_schools.step_definitions.US_01_AND_US_02;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.MustafaS01_02.US_01Page;
import management_on_schools.pages.MustafaS01_02.US_02Page;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class US001_US002 {
    Home_Page homePage = new Home_Page();
    US_01Page us01Page = new US_01Page();
    US_02Page us02Page = new US_02Page();
    Actions action = new Actions(Driver.getDriver());
    static Faker faker = new Faker();
    static String name = "Team14 " + faker.number().numberBetween(1, 10);
    static String surname = faker.name().lastName();
    String birthPlace = name;
    static String userName = "Team14" + faker.name().firstName() + faker.number().numberBetween(1, 10);
    String password = name + "1";
    String birthDate = faker.number().numberBetween(1, 28) + "." + faker.number().numberBetween(1, 12) + "." + faker.number().numberBetween(1900, 2020);
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


    @Given("Admin Guest User Sayfasina giris yapar")
    public void adminGuestUserSayfasinaGirisYapar() {
        homePage.menuButton.click();
        us02Page.guestUserButton.click();
    }

    List<WebElement> guestUserTable;
    String actualName;
    String actualPhone;
    String actualSsn;
    String actualUserName;
    String arananName;
    String expectedName, expectedPhone, expectedSsn, expectedUserName;
    WebElement actualName1, actualPhone1, actualSsn1, actualUserName1;

    @And("Admin Kayıt olan Guest user'a ait bilgileri görebilir.")
    public void adminKayıtOlanGuestUserAAitBilgileriGorebilir() {

        int pageCount = Integer.parseInt(us02Page.guestUserTableCount.getAttribute("textContent").split(" ")[3]);
        System.out.println("pageCount = " + pageCount);
        guestUserTable = us02Page.guestUserTable;
        System.out.println("guestUserTable.get(i) = " + guestUserTable.get(1).getText());
        arananName = userName;
        System.out.println("arananName = " + arananName);

        for (int i = 0; i < pageCount; i++) {
            int t=1;
            for (int j = 1; j < guestUserTable.size(); j++) {
                guestUserTable = us02Page.guestUserTable;
                if (guestUserTable.get(j).getText().equals(arananName)) {
                    System.out.println("DAta bulundu ve assertion başladı");
                    guestUserTable = us02Page.guestUserTable;
                    ReusableMethods.tumSayfaResmi("01", "Admin Guest User'a ait bilgileri görebilir.");
                    expectedName = name + " " + surname;
                    System.out.println("expectedName = " + expectedName);
                    expectedPhone = phoneNumber;
                    System.out.println("expectedPhone = " + expectedPhone);
                    expectedSsn = ssnNumber;
                    System.out.println("expectedSsn = " + expectedSsn);
                    expectedUserName = userName;
                    System.out.println("expectedUserName = " + expectedUserName);
                    actualName1 = guestUserTable.get(j - 3);
                    ReusableMethods.waitForVisibility(actualName1, 5);
                    actualName = actualName1.getText();
                    System.out.println("actualName = " + actualName);
                    actualPhone1 = guestUserTable.get(j - 2);
                    ReusableMethods.waitForVisibility(actualPhone1, 5);
                    actualPhone = actualPhone1.getText();
                    System.out.println("actualPhone = " + actualPhone);
                    actualSsn1 = guestUserTable.get(j - 1);
                    ReusableMethods.waitForVisibility(actualSsn1, 5);
                    actualSsn = actualSsn1.getText();
                    System.out.println("actualSsn = " + actualSsn);
                    actualUserName1 = guestUserTable.get(j);
                    ReusableMethods.waitForVisibility(actualUserName1, 5);
                    actualUserName = actualUserName1.getText();
                    System.out.println("actualUserName = " + actualUserName);
                    Assert.assertEquals(expectedName, actualName);
                    System.out.println("NAME DOĞRULANDI");
                    Assert.assertEquals(expectedPhone, actualPhone);
                    System.out.println("PHONE DOĞRULANDI");
                    Assert.assertEquals(expectedSsn, actualSsn);
                    System.out.println("SSN DOĞRULANDI");
                    Assert.assertEquals(expectedUserName, actualUserName);
                    System.out.println("USERNAME DOĞRULANDI");
                    t=j;
                    break;


                } else {
                    System.out.println(guestUserTable.get(j).getText());
                }

            }
            if (us02Page.guestUserTable.get(t).equals(arananName)) {
                break;
            }else {
                ReusableMethods.click(us02Page.guestUserIleriButton);
                ReusableMethods.bekle(1);
                System.out.println("Page Number = " + (i + 2) + " .sayfa");
            }

        }


    }

    @Given("Kullanici Admin olarak giris yapar.")
    public void kullaniciAdminOlarakGirisYapar() {
        ReusableMethods.login("AdminUsername", "AdminPassword");
    }
}


