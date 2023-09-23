package management_on_schools.step_definitions.US_24_25;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import management_on_schools.pages.YektaUS24_25.YektaUS_24_25;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class US25 {
    YektaUS_24_25 us24_25Page = new YektaUS_24_25();
    Actions actions = new Actions(Driver.getDriver());
    static Faker faker = new Faker();
    static String nameYS = "Yekta" + faker.number().numberBetween(1,100);
    //static String surname= faker.name().lastName();

    static String surnameYS =nameYS + "1";
    static String birthPlaceYS =nameYS +"istan";
    static String emailYS=nameYS + surnameYS+"@gmail.com";
    static String phoneYS = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String ssnYS = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    static String userNameYS =faker.name().firstName().toLowerCase()+faker.name().lastName().toUpperCase();
    static String passwordYS = nameYS+"P43";
    static String fatherYS =faker.name().firstName();
    static String motherYS=faker.name().firstName();
    static String birthdateYS = faker.number().numberBetween(1, 30) + "." + faker.number().numberBetween(1, 12) + "." +faker.number().numberBetween(1950, 2022);
    @Given("Admin sisteme admin olarak giriş yapar")
    public void admin_sisteme_admin_olarak_giriş_yapar() {
        ReusableMethods.login("AdminUsername","AdminPassword");

    }

    @Then("Student ile ilgili gerekli bilgileri doldurur.")
    public void student_ile_ilgili_gerekli_bilgileri_doldurur() {
        System.out.println("Yekta");
        us24_25Page.menu.click();
        us24_25Page.studentManagement.click();
        ReusableMethods.bekle(3);

        us24_25Page.studentAdvisorTeacher.click();
        ReusableMethods.bekle(3);
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_UP,Keys.ENTER).perform();
        ReusableMethods.bekle(3);

        us24_25Page.studentName.sendKeys(nameYS,Keys.TAB,
                surnameYS,Keys.TAB,
                birthPlaceYS,Keys.TAB,
                emailYS,Keys.TAB,
                phoneYS,Keys.TAB,Keys.TAB,
                birthdateYS,Keys.TAB,
                ssnYS,Keys.TAB,
                userNameYS,Keys.TAB,
                fatherYS,Keys.TAB,
                motherYS, Keys.TAB,
                passwordYS);
        us24_25Page.studentMale.click();
        us24_25Page.studentSubmit.click();



    }

    @Then("Olusturulan Student'ın sisteme kaydının gerçekleştirildiği doğrulanır.")
    public void olusturulan_student_ın_sisteme_kaydının_gerçekleştirildiği_doğrulanır() {
        ReusableMethods.visibleWait(us24_25Page.studentMessage,5);
        ReusableMethods.tumSayfaResmi("US25","TC01_StudentSavedSuccessfully");
        String messageStudent="Student saved Successfully";
        ReusableMethods.tumSayfaResmi("US25","TC01_StudentSavedSuccessfully");
        Assert.assertEquals(us24_25Page.studentMessage.getText(),messageStudent);
        ReusableMethods.tumSayfaResmi("US25","TC01_StudentSavedSuccessfully");
        ReusableMethods.bekle(2);
        ReusableMethods.logout();
        System.out.println("Yekta");


    }

    @Then("Student ile ilgili bilgileri advisor teacher seçmeden doldurur.")
    public void studentIleIlgiliBilgileriAdvisorTeacherSeçmedenDoldurur() {
        ReusableMethods.login("AdminUsername","AdminPassword");
        ReusableMethods.bekle(2);
        us24_25Page.menu.click();
        us24_25Page.studentManagement.click();
        ReusableMethods.bekle(3);
        us24_25Page.studentName.sendKeys(nameYS,Keys.TAB,
                surnameYS,Keys.TAB,
                birthPlaceYS,Keys.TAB,
                emailYS,Keys.TAB,
                phoneYS,Keys.TAB,Keys.TAB,
                birthdateYS,Keys.TAB,
                ssnYS,Keys.TAB,
                userNameYS,Keys.TAB,
                fatherYS,Keys.TAB,
                motherYS, Keys.TAB,
                passwordYS);
        us24_25Page.studentMale.click();
        us24_25Page.studentSubmit.click();

    }

    @And("Student kaydının oluşmadığını kontrol eder.")
    public void studentKaydınınOluşmadığınıKontrolEder() {
        ReusableMethods.visibleWait(us24_25Page.studentError,8);
        ReusableMethods.tumSayfaResmi("US25","TC02_StudentSavedUNSuccessfully");
        String errorMessageStudent1="Please select advisor teacher";
        ReusableMethods.tumSayfaResmi("US25","TC02_StudentSavedUNSuccessfully");
        Assert.assertEquals(us24_25Page.studentError.getText(),errorMessageStudent1);
        ReusableMethods.tumSayfaResmi("US25","TC02_StudentSavedUNSuccessfully");
        ReusableMethods.bekle(2);
        ReusableMethods.logout();
        System.out.println("Yekta");
    }
}
/*
        us24_25Page.teacherManagement.click();
        ReusableMethods.bekle(2);
        us24_25Page.name.sendKeys(ConfigReader.getProperty("nameYs"), Keys.TAB,
                ConfigReader.getProperty("surnameYs"), Keys.TAB,
                ConfigReader.getProperty("birthplaceYs"), Keys.TAB,
                ConfigReader.getProperty("emailYs"), Keys.TAB,
                ConfigReader.getProperty("phoneYs"), Keys.TAB, Keys.TAB, Keys.TAB,
                ConfigReader.getProperty("birthdateYs"), Keys.TAB,
                ConfigReader.getProperty("ssnYs"), Keys.TAB,
                ConfigReader.getProperty("userNameYs"), Keys.TAB,
                ConfigReader.getProperty("PasswordYs"));
               us24_25Page.isAdvisorTeacher.click();
               us24_25Page.gender.click();
               ReusableMethods.bekle(2);
                 us24_25Page.submit.click();
        ReusableMethods.tumSayfaResmi("US24","TC02_TeacherNotSaved");
        ReusableMethods.visibleWait(us24_25Page.errorMessage,5);
        ReusableMethods.tumSayfaResmi("US24","TC02_TeacherNotSaved");
        String errorJson="JSON parse error";
        ReusableMethods.tumSayfaResmi("US24","TC02_TeacherNotSaved");
        Assert.assertTrue(us24_25Page.errorMessage.getText().contains(errorJson));
        System.out.println("Yekta");


 */