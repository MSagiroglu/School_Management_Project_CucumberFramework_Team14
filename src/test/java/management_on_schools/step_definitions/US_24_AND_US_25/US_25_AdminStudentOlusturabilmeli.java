package management_on_schools.step_definitions.US_24_AND_US_25;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import management_on_schools.pages.YektaUS24_25.YektaUS_24_25;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class US_25_AdminStudentOlusturabilmeli {
    YektaUS_24_25 us24_25Page = new YektaUS_24_25();
    Actions actions = new Actions(Driver.getDriver());
    static Faker faker = new Faker();

    static String nameYS=faker.name().firstName();
    static String surnameYS=faker.name().lastName();
    static String birthPlaceYS= surnameYS +nameYS;
    static String emailYS=nameYS.toLowerCase()+surnameYS.toLowerCase()+"@gmail.com";
    static String phoneYS=faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(1000,9999);
    static String birthdateYS=faker.number().numberBetween(1, 30) + "." + faker.number().numberBetween(1, 12) + "." + faker.number().numberBetween(1950, 2022);
    static String ssnYS=faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
    static String userNameYS=nameYS.toLowerCase()+surnameYS.toLowerCase();
    static String passwordYS=nameYS+"P43";
    static String motherYS=faker.name().firstName();
    static String fatherYS=faker.name().lastName();

    @Given("Admin sisteme admin olarak giriş yapar")
    public void admin_sisteme_admin_olarak_giriş_yapar() {
        ReusableMethods.login("AdminUsername","AdminPassword");

    }
    @Then("Student ile ilgili gerekli bilgileri doldurur.")
    public void student_ile_ilgili_gerekli_bilgileri_doldurur() {
        us24_25Page.menu.click();
        us24_25Page.studentManagement.click();
        ReusableMethods.bekle(3);

        us24_25Page.studentAdvisorTeacher.click();

        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_UP,Keys.ARROW_UP,Keys.ENTER).perform();

        us24_25Page.studentName.sendKeys(nameYS,Keys.TAB,
                                         surnameYS,Keys.TAB,
                                         birthPlaceYS,Keys.TAB,
                                         emailYS,Keys.TAB,
                                          phoneYS,Keys.TAB,Keys.TAB,
                                          birthdateYS,Keys.TAB,
                                          ssnYS,Keys.TAB,
                                           userNameYS,Keys.TAB,
                                           fatherYS,Keys.TAB,
                                            motherYS,Keys.TAB,
                                             passwordYS);
                                             us24_25Page.studentMale.click();
                                            us24_25Page.studentSubmit.click();




    }
    @Then("Olusturulan Student'ın sisteme kaydının gerçekleştirildiği doğrulanır.")
    public void olusturulan_student_ın_sisteme_kaydının_gerçekleştirildiği_doğrulanır() {
        ReusableMethods.visibleWait(us24_25Page.studentMessage,5);
        String messageStudent="Student saved Successfully";
        Assert.assertEquals(us24_25Page.studentMessage.getText(),messageStudent);
        ReusableMethods.bekle(2);
        ReusableMethods.logout();


    }


    @Then("Student ile ilgili bilgileri advisor teacher seçmeden doldurur.")
    public void studentIleIlgiliBilgileriAdvisorTeacherSeçmedenDoldurur() {


    }

    @And("Student kaydının oluşmadığını kontrol eder.")
    public void studentKaydınınOluşmadığınıKontrolEder() {

        us24_25Page.menu.click();
        us24_25Page.studentManagement.click();
    }
}
