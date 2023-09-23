package management_on_schools.step_definitions.US_24_25;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.YektaUS24_25.YektaUS_24_25;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class US24 {
    YektaUS_24_25 us24_25Page = new YektaUS_24_25();
    Actions actions = new Actions(Driver.getDriver());
    Home_Page homePage = new Home_Page();
    static Faker faker = new Faker();
    static String nameY = "Yekta" + faker.number().numberBetween(1,100);
    //static String surname= faker.name().lastName();
    static String surnameY =nameY + "1";

    static String birthplaceY =nameY +"istan";
    static String email=nameY + surnameY+"@gmail.com";
    static String phoneNumberY = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String ssnNumberY = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    static String userNameY =faker.name().firstName().toLowerCase()+faker.name().lastName().toUpperCase();
    static String passwordY = nameY+"P43";
    static String birthDateY = "01-01-1953";

    @Given("Admin Login Olur")
    public void admin_login_olur() {
       // ReusableMethods.login("AdminUsername", "AdminPassword");
        ReusableMethods.click(homePage.homePageLoginButton);
        homePage.loginEmailField.sendKeys(ConfigReader.getProperty("AdminUsername"));
        homePage.loginPasswordField.sendKeys(ConfigReader.getProperty("AdminPassword"));
        homePage.loginButton.click();

    }
    @When("Admin Teacher ile ilgili bilgileri girer")
    public void admin_teacher_ile_ilgili_bilgileri_girer() {
        us24_25Page.menu.click();
        us24_25Page.teacherManagement.click();
        ReusableMethods.bekle(3);
//Dropdown menu check et
        us24_25Page.chooseLessons.click();
        ReusableMethods.bekle(4);
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
        us24_25Page.name.sendKeys(nameY,Keys.TAB,
                surnameY,Keys.TAB,
                birthplaceY,Keys.TAB,
                email,Keys.TAB,
                phoneNumberY,Keys.TAB,Keys.TAB,Keys.TAB,
                birthDateY,Keys.TAB,
                ssnNumberY,Keys.TAB,
                userNameY,Keys.TAB,
                passwordY
        );
        System.out.println(nameY+surnameY+birthplaceY+email+passwordY+birthDateY+ssnNumberY+userNameY+passwordY);
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
        //us24_25Page.lastPage.click();
        System.out.println("YEKTA");

    }



    @When("Admin Teacher ile ilgili bilgileri ders seçimi yapmadan girer")
    public void adminTeacherIleIlgiliBilgileriDersSeçimiYapmadanGirer() {
        ReusableMethods.bekle(2);
        us24_25Page.menu.click();
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






    }

    @Then("Kaydın oluşmadığına dair hata ve ekran görüntüsü alınır.")
    public void kaydınOluşmadığınaDairHataVeEkranGörüntüsüAlınır() {
    }
}
