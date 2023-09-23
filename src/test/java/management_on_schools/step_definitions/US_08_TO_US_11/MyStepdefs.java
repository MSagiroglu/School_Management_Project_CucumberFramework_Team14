package management_on_schools.step_definitions.US_08_TO_US_11;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static management_on_schools.utilities.Driver.getDriver;

public class MyStepdefs {
    Select select;
    public static String randomStartTime;
    public static String randomStopTime;
    public static int startHour;
    public static int startMinute;
    public static String ders_adi;
    public static String Credit_Score;
    Actions actions = new Actions(getDriver());

    Faker faker = new Faker();
   management_on_schools.pages.Ismail08_11.US_08_11Page us_08_11Page = new management_on_schools.pages.Ismail08_11.US_08_11Page();

    @Given("kullanici anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
    }


    @And("username alanina {string} girer")
    public void usernameAlaninaGirer(String username) {
        us_08_11Page.username.sendKeys(username);
    }

    @And("password alanina {string} girer")
    public void passwordAlaninaGirer(String password) {
        us_08_11Page.password.sendKeys(password);
    }


    @Given("lessons butonuna tiklar")
    public void lessonsButonunaTiklar() {
        us_08_11Page.Lesson_butonu.click();
    }

    @And("login butonuna tiklar")
    public void loginButonunaTiklar() {
        us_08_11Page.homePageLoginButton.click();
    }

    @And("login_butonuna_tiklar")
    public void login_butonuna_tiklar() {
        us_08_11Page.loginButton.click();
    }

    @And("lesson kutucuguna tiklar")
    public void lessonKutucugunaTiklar() {
        us_08_11Page.lesson_kutucugu.click();
    }

    @And("lesson kutucuguna ders adi girer")
    public void lessonKutucugunaDersAdiGirer() {
       ders_adi = faker.leagueOfLegends().champion();
        System.out.println(ders_adi);

        us_08_11Page.lesson_kutucugu.sendKeys(ders_adi);

    }

    @And("Zorunlu ders ise kısmını isaretler")
    public void zorunluDersIseKısmınıIsaretler() {
        us_08_11Page.CheckBox.click();
    }

    @And("Credit Score name kutucuğuna tıklar")
    public void creditScoreNameKutucuğunaTıklar() {
        int sayi = faker.number().numberBetween(2, 16);
        Credit_Score = String.valueOf(sayi);

        us_08_11Page.Credit_Score.sendKeys(Credit_Score);

    }

    @And("submit_butonuna_tiklar")
    public void submit_butonuna_tiklar() {
        us_08_11Page.Lesson_submit_butonu.click();
    }

    @And("lesson_created_mesajını görür")
    public void lesson_created_mesajınıGörür() {
        ReusableMethods.waitForVisibility(us_08_11Page.lesson_created, 5);
        Assert.assertEquals("Lesson Created", us_08_11Page.lesson_created.getText());
        System.out.println(us_08_11Page.lesson_created.getText());


    }

    @Given("Lessons Program butonuna tıklar")
    public void lessonsProgramButonunaTıklar() {
        us_08_11Page.lesson_program_kutucugu.click();
    }


    @Given("Choose Lessons kutucuguna tiklar ve Ders adini girer")
    public void chooseLessonsKutucugunaTiklarVeDersAdiniGirer() throws InterruptedException {
        us_08_11Page.Choose_Lesson.click();
        Thread.sleep(3);
        us_08_11Page.Choose_Lesson.sendKeys("Java", Keys.ENTER);
    }

    @And("Choose day kutucuguna tiklar ve day adini girer")
    public void chooseDayKutucugunaTiklarVeDayAdiniGirer() {
        select = new Select(us_08_11Page.Choose_Day);
        select.selectByValue("MONDAY");

    }

    @And("Choose Education Term açılır menüsünden eğitim dönemini seçer")
    public void chooseEducationTermAçılırMenüsündenEğitimDöneminiSeçer() {
        select = new Select(us_08_11Page.Choose_Education);
        select.selectByVisibleText("FALL_SEMESTER");
    }


    @And("Start Time menüsünden ders icin baslama saatini girer")
    public void startTimeMenüsündenDersIcinBaslamaSaatiniGirer() {
        startHour = faker.random().nextInt(12);
        startMinute = faker.random().nextInt(60);
        randomStartTime = String.format("%02d:%02d", startHour, startMinute);
        us_08_11Page.Start_Time.click();
        actions.sendKeys(randomStartTime, Keys.ENTER).perform();
    }

    @And("Stop Time menüsünden ders icin bitiş saatini girer")
    public void stopTimeMenüsündenDersIcinBitişSaatiniGirer() {
        int stopHour = faker.random().nextInt(12);
        int stopMinute = faker.random().nextInt(60);

        while (stopHour <= startHour) {
            stopHour = faker.random().nextInt(12);
        }

        randomStopTime = String.format("%02d:%02d", stopHour, stopMinute);
        ReusableMethods.bekle(2);
        us_08_11Page.Stop_Time.click();
        actions.sendKeys(randomStopTime, Keys.ENTER).perform();

    }

    @And("Submit butonuna tiklar")
    public void submitButonunaTiklar() {
        us_08_11Page.Lesson_submit_addLesson.click();
    }

    @And("\\(Created Lesson Program)_yazisini_goruntuler")
    public void createdLessonProgram_yazisini_goruntuler() {
        ReusableMethods.waitForVisibility(us_08_11Page.lessonProgramSuccessMessage, 5);
        Assert.assertEquals("Created Lesson Program", us_08_11Page.lessonProgramSuccessMessage.getText());
        System.out.println(us_08_11Page.lessonProgramSuccessMessage.getText());


    }


    @And("Vice Dean Lesson Name alanini gorur.")
    public void viceDeanLessonNameAlaniniGorur() {
        actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.bekle(3);

        us_08_11Page.v_dean_lessonname.click();
        Assert.assertTrue(us_08_11Page.v_dean_lessonname.isDisplayed());
        ReusableMethods.bekle(3);

    }

    @And("Lesson Program List`te Lesson,Day,Start Time ve Stop Time gorur")
    public void lessonProgramListTeLessonDayStartTimeVeStopTimeGorur() {
        actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);

        Assert.assertTrue(us_08_11Page.programListTable.isDisplayed());
        ReusableMethods.bekle(3);
        actions.clickAndHold(us_08_11Page.sayfaAtlama);
        ReusableMethods.click(us_08_11Page.sayfaAtlama);
        ReusableMethods.bekle(2);
        ReusableMethods.click(us_08_11Page.sayfaAtlama);
        ReusableMethods.bekle(2);
        ReusableMethods.click(us_08_11Page.sayfaAtlama);
        ReusableMethods.bekle(2);

        List<WebElement> tableList = Driver.getDriver().findElements(By.xpath("(//tbody)[3]//tr"));
        System.out.println("tableList.size() = " + tableList.size());

        for (WebElement element : tableList) {
            String cellText = element.getText();
            System.out.println(cellText);
        }


    }

    @And("\\(lessons must not empty)_yazisini_goruntuler")
    public void lessonsMustNotEmpty_yazisini_goruntuler() {
        ReusableMethods.waitForVisibility(us_08_11Page.lessonsNotSuccessMessage, 5);
        Assert.assertEquals("Created Lesson Program", us_08_11Page.lessonsNotSuccessMessage.getText());
        System.out.println(us_08_11Page.lessonsNotSuccessMessage.getText());
    }



    @And("Required mesajini görür")
    public void requiredMesajiniGörür() {
        Assert.assertEquals("Required", us_08_11Page.Required_mesaj.getText());
        System.out.println(us_08_11Page.Required_mesaj.getText());

    }



    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }
}
