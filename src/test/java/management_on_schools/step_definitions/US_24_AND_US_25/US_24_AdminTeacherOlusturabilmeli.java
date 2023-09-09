package management_on_schools.step_definitions.US_24_AND_US_25;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_schools.pages.YektaUS24_25.YektaUS_24_25;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.Key;

import static management_on_schools.utilities.Driver.driver;

public class US_24_AdminTeacherOlusturabilmeli {
    YektaUS_24_25 us24_25Page = new YektaUS_24_25();
    Actions actions = new Actions(Driver.getDriver());


    @Given("Admin Login Olur")
    public void admin_login_olur() {
    ReusableMethods.login("AdminUsername","AdminPassword");
    }
    @When("Admin Teacher ile ilgili bilgileri girer")
    public void admin_teacher_ile_ilgili_bilgileri_girer() {
        us24_25Page.menu.click();
        us24_25Page.teacherManagement.click();
        ReusableMethods.bekle(3);

        //Dropdown menu check et
us24_25Page.chooseLessons.click();
ReusableMethods.bekle(4);
actions.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();



/*
String press = Keys.chord(Keys.SHIFT,Keys.ENTER); webelement.sendKeys(press);
 */
        //boş alanları doldur
        us24_25Page.name.sendKeys(ConfigReader.getProperty("nameY"),Keys.TAB,
                                  ConfigReader.getProperty("surnameY"),Keys.TAB,
                                  ConfigReader.getProperty("birthplaceY"),Keys.TAB,
                                  ConfigReader.getProperty("emailY"),Keys.TAB,
                                  ConfigReader.getProperty("phoneY"),Keys.TAB,Keys.TAB,Keys.TAB,
                                  ConfigReader.getProperty("birthdateY"),Keys.TAB,
                                  ConfigReader.getProperty("ssnY"),Keys.TAB,
                                  ConfigReader.getProperty("userNameY"),Keys.TAB,
                                  ConfigReader.getProperty("PasswordY")
                                   );
                                  us24_25Page.isAdvisorTeacher.click();
                                  us24_25Page.gender.click();







    }
    @When("Admin submit tuşuna basar")
    public void admin_submit_tuşuna_basar() {
    us24_25Page.submit.click();
        ReusableMethods.tumSayfaResmi("US24","TC01_TeacherSavedSuccessfully");
        ReusableMethods.visibleWait(us24_25Page.message,10);
        ReusableMethods.tumSayfaResmi("US24","TC01_TeacherSavedSuccessfully");
        String messageTeacher="Teacher saved successfully";
        Assert.assertEquals(us24_25Page.message.getText(),messageTeacher);
        ReusableMethods.tumSayfaResmi("US24","TC01_TeacherSavedSuccessfully");
        ReusableMethods.bekle(2);
        ReusableMethods.logout();




    }
    @Then("Admin teacher listin son sayfasına giderek öğretmenin oluştuğunu kontrol eder")
    public void admin_teacher_listin_son_sayfasına_giderek_öğretmenin_oluştuğunu_kontrol_eder() {

    }


    @When("Admin Teacher ile ilgili bilgileri ders seçimi yapmadan girer")

    public void admin_teacher_ile_ilgili_bilgileri_ders_seçimi_yapmadan_girer() {
        ReusableMethods.login("AdminUsername","AdminPassword");
        us24_25Page.menu.click();
        us24_25Page.teacherManagement.click();
        us24_25Page.name.sendKeys(ConfigReader.getProperty("nameY"),Keys.TAB,
                ConfigReader.getProperty("surnameY"),Keys.TAB,
                ConfigReader.getProperty("birthplaceY"),Keys.TAB,
                ConfigReader.getProperty("emailY"),Keys.TAB,
                ConfigReader.getProperty("phoneY"),Keys.TAB,Keys.TAB,Keys.TAB,
                ConfigReader.getProperty("birthdateY"),Keys.TAB,
                ConfigReader.getProperty("ssnY"),Keys.TAB,
                ConfigReader.getProperty("userNameY"),Keys.TAB,
                ConfigReader.getProperty("PasswordY")
        );
        us24_25Page.isAdvisorTeacher.click();
        us24_25Page.gender.click();

        us24_25Page.submit.click();
        ReusableMethods.tumSayfaResmi("US24","TC02_errorMessage");

        ReusableMethods.visibleWait(us24_25Page.errorMessage,5);
        String errorJson="JSON parse error";
        Assert.assertTrue(us24_25Page.errorMessage.getText().contains(errorJson));


    }
    @Then("Admin teacher listin son sayfasına giderek öğretmenin oluşmadığını kontrol eder")
    public void admin_teacher_listin_son_sayfasına_giderek_öğretmenin_oluşmadığını_kontrol_eder() {

    }



}
