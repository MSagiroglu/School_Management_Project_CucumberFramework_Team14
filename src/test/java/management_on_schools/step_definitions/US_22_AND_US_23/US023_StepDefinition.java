package management_on_schools.step_definitions.US_22_AND_US_23;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.MehmetAli22_23.Us_22_23Page;
import management_on_schools.pojos.MehmetAli22_23.US_22.US22_AddAdminPojo;
import management_on_schools.pojos.MehmetAli22_23.US_23.US23_AddViceDeanPojo;
import management_on_schools.pojos.MehmetAli22_23.US_23.US23_ViceDeanResponsepojo;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;
import static org.junit.Assert.assertEquals;

public class US023_StepDefinition {
    Home_Page homePage = new Home_Page();
    Us_22_23Page page = new Us_22_23Page();
    static Faker faker = new Faker();
    public void nameAlaniTemizleme(){
        page.nameAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void surnameAlaniTemizleme(){
        page.surnameAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void birthPlaceAlaniTemizleme(){
        page.birthPlaceAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void dateOfBirthAlaniTemizleme(){
        page.dateOfBirthAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void phoneAlaniTemizleme(){
        page.phoneNumberAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void ssnAlaniTemizleme(){
        page.ssnAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void usernameAlaniTemizleme(){
        page.usernameAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public void passwordAlaniTemizleme(){
        page.passwordAlani.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    static String usernameUs23Tc01 = faker.name().firstName() + faker.number().numberBetween(1, 50);
    static String phoneNumberUs23Tc01 = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String ssnNumberUs23Tc01 = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    static String usernameUs23Tc06 = faker.name().firstName() + faker.number().numberBetween(1, 50);
    static String phoneNumberUs23Tc06 = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String ssnNumberUs23Tc06 = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);

    @When("admin menuye tiklar ve ardindan vice dean managementa tiklar")
    public void adminMenuyeTiklarVeArdindanViceDeanManagementaTiklar() {
        homePage.menuButton.click();
        page.viceDeanManagementButton.click();
    }

    @And("admin vice dean eklemek icin verilen bilgileri girer")
    public void adminViceDeanEklemekIcinVerilenBilgileriGirer() {
        page.nameAlani.click();
        ReusableMethods.bekle(2);
        page.nameAlani.sendKeys(ConfigReader.getProperty("nameMAK"), Keys.TAB,
                ConfigReader.getProperty("surnameMAK"),Keys.TAB,
                ConfigReader.getProperty("birthPlaceMAK"),Keys.TAB,Keys.TAB,
                ConfigReader.getProperty("dateOfBirthMAK"),Keys.TAB,
                phoneNumberUs23Tc01,Keys.TAB,
                ssnNumberUs23Tc01,Keys.TAB,
                usernameUs23Tc01,Keys.TAB,
                ConfigReader.getProperty("passwordMAK") );
        page.genderMale.click();
        ReusableMethods.bekle(2);
    }

    @Then("admin vice deanin eklenip eklenmedigini dogrular")
    public void adminViceDeaninEklenipEklenmediginiDogrular() {
        //Dogrulama
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC01_ViceDeanSaved");
        Assert.assertEquals(page.alert.getText(),"Vice dean Saved");
        //Logout yapiyoruz...
        homePage.menuButton.click();
        homePage.logoutButton.click();
        homePage.logOutYesButton.click();
        ReusableMethods.bekle(2);
        //Girdigimiz bilgiler ile login oluyoruz
        page.anaSayfaloginButonu.click();
        page.loginUserNameAlani.sendKeys(usernameUs23Tc01);
        page.loginPasswordAlani.sendKeys(ConfigReader.getProperty("passwordMAK"));
        page.loginButonu.click();
        Assert.assertEquals(page.viceDeanVerify.getText(),ConfigReader.getProperty(usernameUs23Tc01));
    }

    @Then("admin vice dean telefon verilerini yanlis girer ve hata mesajlarini dogrular")
    public void adminViceDeanTelefonVerileriniYanlisGirerVeHataMesajlariniDogrular() {
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
        ReusableMethods.tumSayfaResmi("23","TC02_enterValidPhoneNumber01");
        Assert.assertTrue(page.alert.getText().toLowerCase().contains(enterValidPhoneNumberExpectedMessage));
        ReusableMethods.bekle(2);

        //2.Dogrulama
        phoneAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.phoneNumberAlani.sendKeys("555-321-14511");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC02_enterValidPhoneNumber02");
        Assert.assertTrue(page.alert.getText().toLowerCase().contains(enterValidPhoneNumberExpectedMessage));
        ReusableMethods.bekle(2);

        //3.Dogrulama
        String invalidFeedbackExpectedMessage = "Minimum 12 character (XXX-XXX-XXXX)";
        phoneAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.phoneNumberAlani.sendKeys("555-123-789");
        ReusableMethods.tumSayfaResmi("23","TC02_minimum12Character");
        Assert.assertEquals(page.phoneNumberInvalidFeedback.getText(),invalidFeedbackExpectedMessage);
        ReusableMethods.bekle(2);

        //4.Dogrulama
        String alreadyRegisterExpectedMessage = "555-555-9999 already register";
        phoneAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.phoneNumberAlani.sendKeys("555-555-9999");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC02_alreadyRegister");
        Assert.assertTrue(page.alert.getText().contains(alreadyRegisterExpectedMessage));
    }

    @Then("admin vice dean ssn verilerini yanlis girer ve hata mesajlarini dogrular")
    public void adminViceDeanSsnVerileriniYanlisGirerVeHataMesajlariniDogrular() {
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
        ReusableMethods.tumSayfaResmi("23","TC03_enterValidSsnNumber01");
        Assert.assertEquals(page.alert.getText(),enterValidSsnNumberExpectedMessage);

        //2.Dogrulama
        ssnAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.ssnAlani.sendKeys("432-98-12344");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC03_enterValidSsnNumber02");
        Assert.assertEquals(page.alert.getText(),enterValidSsnNumberExpectedMessage);

        //3.Dogrulama
        String invalidFeedbackExpectedMessage ="Minimum 11 character (XXX-XX-XXXX)";
        ssnAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.ssnAlani.sendKeys("432-98-123");
        ReusableMethods.tumSayfaResmi("23","TC03_minimum11Character");
        Assert.assertEquals(page.ssnNumberInvalidFeedback.getText(),invalidFeedbackExpectedMessage);

        //4.Dogrulama
        String alreadyRegisterExpectedMessage = "555-22-9999 already register";
        ssnAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.ssnAlani.sendKeys("555-22-9999");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC03_alreadyRegister");
        Assert.assertTrue(page.alert.getText().contains(alreadyRegisterExpectedMessage));
    }

    @Then("admin vice dean dogum tarihini ileri bir tarih girer ve hata mesajini dogrular")
    public void adminViceDeanDogumTarihiniIleriBirTarihGirerVeHataMesajiniDogrular() {
        String gecmisTarihExpectedMessage ="geçmiş bir tarih olmalı";
        dateOfBirthAlaniTemizleme();
        ReusableMethods.bekle(2);
        page.dateOfBirthAlani.sendKeys("24.01.2028");
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC04_gecmisTarih");
        Assert.assertEquals(page.alert.getText(),gecmisTarihExpectedMessage);
    }

    @Then("admin vice dean username e kayitli username girer ve hata mesajini dogrular")
    public void adminViceDeanUsernameEKayitliUsernameGirerVeHataMesajiniDogrular() {
        //Daha once kayitli olmayan phone, ssn number giriyoruz ve kayitli bir username giriyoruz...
        phoneAlaniTemizleme();
        ssnAlaniTemizleme();
        usernameAlaniTemizleme();
        page.phoneNumberAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanPhone"));
        page.ssnAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanSsn"));
        page.usernameAlani.sendKeys(ConfigReader.getProperty("ViceDeanUsername")); //Kayitli bir vice dean username
        //Dogrulama...
        String usernameAlreadyRegisterExpectedMessage = "Error: User with username Team_14 V-Dean already register";
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC05_usernameAlreadyRegister");
        Assert.assertEquals(page.alert.getText(),usernameAlreadyRegisterExpectedMessage);
    }

    @Then("admin vice dean eklemek icin uygun olmayan passwordlar girer hata mesajlarini dogrular")
    public void adminViceDeanEklemekIcinUygunOlmayanPasswordlarGirerHataMesajlariniDogrular() {
        //Daha once kayitli olmayan phone, ssn number giriyoruz ve username giriyoruz...
        phoneAlaniTemizleme();
        ssnAlaniTemizleme();
        usernameAlaniTemizleme();
        page.phoneNumberAlani.sendKeys(phoneNumberUs23Tc06);
        page.ssnAlani.sendKeys(ssnNumberUs23Tc06);
        page.usernameAlani.sendKeys(usernameUs23Tc06);
        ReusableMethods.bekle(2);

        //1.Dogrulama
        String invalidFeedbackExpectedMessage01 = "At least 8 characters";
        passwordAlaniTemizleme();
        page.passwordAlani.sendKeys("admin12");
        ReusableMethods.tumSayfaResmi("23","TC06_passwordAtLeast8Characters");
        Assert.assertEquals(page.passwordInvalidFeedback.getText(),invalidFeedbackExpectedMessage01);
        ReusableMethods.bekle(2);

        //2.Dogrulama
        String invalidFeedbackExpectedMessage02 ="One uppercase character";
        passwordAlaniTemizleme();
        page.passwordAlani.sendKeys("adminsifre");
        ReusableMethods.tumSayfaResmi("23","TC06_passwordOneUppercaseCharacter");
        Assert.assertEquals(page.passwordInvalidFeedback.getText(),invalidFeedbackExpectedMessage02);
        ReusableMethods.bekle(2);

        //3.Dogrulama
        String invalidFeedbackExpectedMessage03 ="One number";
        passwordAlaniTemizleme();
        page.passwordAlani.sendKeys("Adminsifre");
        ReusableMethods.tumSayfaResmi("23","TC06_passwordOneNumber");
        Assert.assertEquals(page.passwordInvalidFeedback.getText(),invalidFeedbackExpectedMessage03);
        ReusableMethods.bekle(2);
    }

    @And("admin vice dean eklemek icin uygun bir password ile admin ekler ve dogrular")
    public void adminViceDeanEklemekIcinUygunBirPasswordIleAdminEklerVeDogrular() {
        //Yanlis girilen password'u silip uygun password ile admin ekleyip dogruluyoruz...
        passwordAlaniTemizleme();
        page.passwordAlani.sendKeys(ConfigReader.getProperty("passwordMAK")); //Uygun bir sifre
        page.submitButton.click();
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC06_uygunPasswordViceDeanSaved");
        Assert.assertEquals(page.alert.getText(),"Vice dean Saved");
    }

    @When("admin vice dean eklemek icin veri girilecek alanlari bos birakir ve hata mesajlarini dogrular sonra gender haric verileri girer")
    public void adminViceDeanEklemekIcinVeriGirilecekAlanlariBosBirakirVeHataMesajlariniDogrularSonraGenderHaricVerileriGirer() {
        //Dogrulama verilerini giriyoruz
        String requiredMessage = "Required";
        String enterYourPasswordMessage = "Enter your password"; //Password icin farkli bir mesaj cikiyor!!!

        //1.Dogrulama
        page.surnameAlani.click();//Once surname'e click yapıyoruz ki name'e click yaptigimizda required mesajlari goruntulensin
        page.nameAlani.click();
        ReusableMethods.tumSayfaResmi("23","TC07_nameRequired");
        Assert.assertEquals(page.nameInvalidFeedback.getText(),requiredMessage);
        page.nameAlani.sendKeys(ConfigReader.getProperty("nameMAK"));

        //2.Dogrulama
        ReusableMethods.tumSayfaResmi("23","TC07_surnameRequired");
        Assert.assertEquals(page.surnameInvalidFeedback.getText(),requiredMessage);
        page.surnameAlani.sendKeys(ConfigReader.getProperty("surnameMAK"));

        //3.Dogrulama
        ReusableMethods.tumSayfaResmi("23","TC07_birthPlaceRequired");
        Assert.assertEquals(page.birthPlaceInvalidFeedback.getText(),requiredMessage);
        page.birthPlaceAlani.sendKeys(ConfigReader.getProperty("birthPlaceMAK"));

        //4.Dogrulama
        ReusableMethods.tumSayfaResmi("23","TC07_dateOfBirthRequired");
        Assert.assertEquals(page.dateOfBirthInvalidFeedback.getText(),requiredMessage);
        page.dateOfBirthAlani.sendKeys(ConfigReader.getProperty("dateOfBirthMAK"));

        //5.Dogrulama
        ReusableMethods.tumSayfaResmi("23","TC07_phoneNumberRequired");
        Assert.assertEquals(page.phoneNumberInvalidFeedback.getText(),requiredMessage);
        page.phoneNumberAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanPhone"));

        //6.Dogrulama
        ReusableMethods.tumSayfaResmi("23","TC07_ssnNumberRequired");
        Assert.assertEquals(page.ssnNumberInvalidFeedback.getText(),requiredMessage);
        page.ssnAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanSsn"));

        //7.Dogrulama
        ReusableMethods.tumSayfaResmi("23","TC07_usernameRequired");
        Assert.assertEquals(page.usernameInvalidFeedback.getText(),requiredMessage);
        page.usernameAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanUsername"));

        //8.Dogrulama
        ReusableMethods.tumSayfaResmi("23","TC07_passwordRequired");
        Assert.assertEquals(page.passwordInvalidFeedback.getText(),enterYourPasswordMessage);
        page.passwordAlani.sendKeys(ConfigReader.getProperty("passwordMAK"));
    }

    @Then("admin cikis yapip girdigi verilerle vice dean olarak login olmayi dener ve hata alip dogrular")
    public void adminCikisYapipGirdigiVerilerleViceDeanOlarakLoginOlmayiDenerVeHataAlipDogrular() {
        //Cikis yapip girilen bilgilerle login oluyoruz
        String errorLoginMessage = "Bad credentials";

        //Cikis yapar
        homePage.menuButton.click();
        homePage.logoutButton.click();
        homePage.logOutYesButton.click();

        //Login olmayi dener
        ReusableMethods.bekle(2);
        page.anaSayfaloginButonu.click();
        page.loginUserNameAlani.sendKeys(ConfigReader.getProperty("kayitliOlmayanUsername"));
        page.loginPasswordAlani.sendKeys(ConfigReader.getProperty("passwordMAK"));
        page.loginButonu.click();
        //ReusableMethods.login("kayitliOlmayanUsername","passwordMAK");

        //Hata mesajını Dogrulama
        ReusableMethods.visibleWait(page.alert,10);
        ReusableMethods.tumSayfaResmi("23","TC07_errorLogin");
        Assert.assertEquals(page.alert.getText(),errorLoginMessage);
    }

    //---------------------- API TESTS -------------------------
    US23_AddViceDeanPojo expectedData;
    Response response;
    US23_ViceDeanResponsepojo actualData;
    @Given("Vice dean eklemek icin Post request hazirligi yapilir")
    public void viceDeanEklemekIcinPostRequestHazirligiYapilir() {
        //https://managementonschools.com/app/vicedean/save
        //Set the url
        spec.pathParams("first", "vicedean", "second", "save");
    }

    @And("Gonderilecek Vice dean bilgileri hazirlanir")
    public void gonderilecekViceDeanBilgileriHazirlanir() {
        //Set the expected data
        expectedData = new US23_AddViceDeanPojo("2002-01-24","izmir","MALE","mehmet ali","Admin123", phoneNumberUs23Tc01, ssnNumberUs23Tc01,"karasu", usernameUs23Tc01);
        System.out.println(expectedData);
    }

    @When("Vice dean eklemek icin Post request gonderilir")
    public void viceDeanEklemekIcinPostRequestGonderilir() {
        //Send req and get resp
        response=given(spec).body(expectedData).when().post("{first}/{second}");
        //Response'u Dogrulama kisminda alacagaiz...(Hata aldigimizda farkli bir Json dondugu icin)
    }

    @Then("Vice dean Bilgileri dogrulanir")
    public void viceDeanBilgileriDogrulanir() {
        //Get response
        actualData = response.as(US23_ViceDeanResponsepojo.class);
        //Do assertion
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

    @And("Gonderilecek Vice dean bilgilerinde gelecek tarihli date of birth girilir")
    public void gonderilecekViceDeanBilgilerindeGelecekTarihliDateOfBirthGirilir() {
        //Set the expected data
        expectedData = new US23_AddViceDeanPojo("2028-01-24","izmir","MALE","mehmet ali","Admin123", phoneNumberUs23Tc01, ssnNumberUs23Tc01,"karasu", usernameUs23Tc01);
        System.out.println(expectedData);
    }
    @Then("Responsedaki status Kodunun {int} oldugu dogrulanir")
    public void responsedakiStatusKodununOlduguDogrulanir(int statusCode) {
        //Do assertion
        Assert.assertEquals(response.statusCode(),statusCode);
    }

    @And("Gonderilecek Vice dean bilgilerinde onceden girilmis ssn no girilir")
    public void gonderilecekViceDeanBilgilerindeOncedenGirilmisSsnNoGirilir() {
        //Set the expected data
        expectedData = new US23_AddViceDeanPojo("2002-01-24","izmir","MALE","mehmet ali","Admin123", phoneNumberUs23Tc01, "555-22-9999","karasu", usernameUs23Tc01);
        System.out.println(expectedData);
    }
}
