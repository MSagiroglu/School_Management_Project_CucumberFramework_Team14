package management_on_schools.step_definitions.US_12_13_14;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import management_on_schools.pages.Begum12_13_14.US_12Page;
import management_on_schools.pages.Begum12_13_14.US_13Page;
import management_on_schools.pages.Begum12_13_14.US_14Page;
import management_on_schools.pages.Home_Page;
import management_on_schools.pojos.Begum12_13_14.US13.TeacherPostPojo;
import management_on_schools.pojos.Begum12_13_14.US13.TeacherResponsePojo;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;
import static management_on_schools.utilities.JDBCUtils.executeQuery;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class US_13 {
    Home_Page homePage = new Home_Page();
    US_13Page us_13Page = new US_13Page();
    US_12Page us_12Page = new US_12Page();
    US_14Page us_14Page = new US_14Page();
    static Faker faker = new Faker();
    String nameEntered;
    String surnameEntered;
    String birthPlaceEntered;
    String emailEntered;
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    static String fakeName;
    static String fakeSurname;
    static String fakeBirthPlace;
    static String fakeEmail;
    static String fakePhone;
    static String fakeDateOfBirth;
    static String fakePassword;
    static String fakeUserName;
    static String fakeSSN;


    @Given("click to {string}")
    public void click_to(String string) {
        switch (string) {
            case "menu":
                homePage.menuButton.click();
                break;
            case "viceDeanManagementMenu":
                us_13Page.viceDeanMangement.click();
                break;
            case "teacherManagementMenu":
                us_13Page.teacherMangement.click();
                break;
            case "gender":
                us_13Page.genderFemale.click();
                break;
            case "isAdvisorTeacher":
                us_13Page.isAdvisorTeacher.click();
                break;
            case "submit":
                us_13Page.submitAddTeacher.click();
                break;
            case "lastPageButton":
                ReusableMethods.bekle(1);
                us_14Page.lastPageButton.click();
                break;
            case "lessonManagementMenu":
                us_13Page.lessonManagement.click();
                break;
            case "lessonProgramButton":
                us_12Page.lessonProgramButton.click();
                break;
            case "lessonProgramAssignmet":
                ReusableMethods.scroll(us_12Page.lessonProgramAssignmetButton);
                break;
            case "editButton":
                us_14Page.editButtonBox.click();
                break;

        }

    }

    @And("warning for {string}")
    public void warningFor(String warning) {

        boolean assrt = false;
        switch (warning) {
            case "nameRequired":
                assrt = us_13Page.nameRequired.isDisplayed();
                break;
            case "surNameRequired":
                assrt = us_13Page.surNameRequired.isDisplayed();
                break;
            case "birthPlaceRequired":
                assrt = us_13Page.birthPlaceRequired.isDisplayed();
                break;
            case "emailRequired":
                assrt = us_13Page.emailRequired.isDisplayed();
                break;
            case "phoneNumberRequired":
                assrt = us_13Page.phoneNumberRequired.isDisplayed();
                break;
            case "dateOfBirthRequired":
                assrt = us_13Page.birthDayRequired.isDisplayed();
                break;
            case "sSNRequired":
                assrt = us_13Page.sSNRequired.isDisplayed();
                break;
            case "passwordRequired":
                assrt = us_13Page.passwordRequired.isDisplayed();
                break;
            case "dersSecilmedi":
                assrt = us_13Page.dersSecilmediUyari.isEnabled();
                break;
            case "invalidNameWarning":
                assrt = us_13Page.invalidNameWarning.isEnabled();
                break;
            case "pleaseEnterValidEmailMessage":
                if (us_13Page.pleaseEnterValidEmailMessage.isEnabled() || us_13Page.emailShouldBe5_50.isEnabled()) {
                    assrt = true;
                }
                break;
            case "emailShouldBe5_50":
                if (us_13Page.pleaseEnterValidEmailMessage.isEnabled() || us_13Page.emailShouldBe5_50.isEnabled()) {
                    assrt = true;
                }
                break;
            case "phoneNumber12Message":
                assrt = us_13Page.phoneNumber12Message.isDisplayed();
                break;

            case "dogumGunuGecmisBirTarihOlmali":
                assrt = us_13Page.dogumGunuGecmisBirTarihOlmali.isEnabled();
                break;
            case "pleaseEnterValidSSNNumberMessage":
                assrt = us_13Page.pleaseEnterValidSSNNumberMessage.isEnabled();
                break;

            case "fullAuthenticationWanrning":
                assrt = us_13Page.fullAuthenticationWanrning.isEnabled();
                break;
            case "teacherSavedMessage":
                ReusableMethods.bekle(2);
                assrt = us_13Page.teacherSavedMessage.isEnabled();
                break;
            case "usernameRequired":
                assrt = us_13Page.usernameRequired.isDisplayed();
                break;

            case "teacherSavedMessage2":
                ReusableMethods.bekle(1);
                assrt = us_13Page.teacherSavedMessage2.isEnabled();
                break;

            case "invalidGender":
                assrt = us_13Page.invalidGenderSelectWarning.isEnabled();
                break;
            case "passwordAtLeast8Characters":
                assrt = us_13Page.passwordAtLeast8CharactersMessage.isDisplayed();
                break;
            case "passwordOneUpperCaseCharacter":
                assrt = us_13Page.passwordOneUpperCaseCharacterMessage.isDisplayed();
                break;
            case "passwordOneNumber":
                assrt = us_13Page.passwordOneNumberMessage.isDisplayed();
                break;
            case "passwordOneLowerCaseCharacter":
                assrt = us_13Page.passwordOneLowerCaseCharacterMessage.isDisplayed();
                break;
            case "ssnMin11Character":
                assrt = us_13Page.ssnMin11CharacterMessage.isEnabled();
                break;
            case "lessonAddedMessage":
                assrt = us_12Page.lessonAddedToTeacherMessage.isEnabled();
                break;
            case "lesson":
                assrt = us_12Page.lessonV.isDisplayed();
                break;
            case "teacherUpdatedSuccessfulMessage" :
                assrt = us_14Page.teacherUpdatedMessage.isEnabled();
                break;

        }
        Assert.assertTrue(assrt);
    }

    @And("enter random {string}")
    public void enterRandom(String data) {

        switch (data) {
            case "name":
                fakeName = faker.name().firstName();
                us_13Page.name.sendKeys(fakeName);
                ReusableMethods.bekle(2);
                break;
            case "surname":
                 fakeSurname = faker.name().lastName();
                us_13Page.surname.sendKeys(fakeSurname);
                ReusableMethods.bekle(2);
                break;
            case "birthPlace":
                fakeBirthPlace = faker.address().city().replaceAll("\\s", "").substring(0,9);
                us_13Page.birthPlace.sendKeys(fakeBirthPlace);
                ReusableMethods.bekle(2);
                break;
            case "email":
                fakeEmail = faker.internet().emailAddress();
                us_13Page.email.sendKeys(fakeEmail);
                break;
            case "phoneNumber":
                fakePhone =  "" + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) +
                        "-" + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + "-" +
                        faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9);
                us_13Page.phoneNumber.sendKeys(fakePhone);
                ReusableMethods.bekle(2);
                break;
            case "SSN":
                fakeSSN = "" + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) +
                        "-" + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + "-" + faker.number().numberBetween(1, 9) +
                        faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9) + faker.number().numberBetween(1, 9);
                us_13Page.ssn.sendKeys(fakeSSN);
                ReusableMethods.bekle(2);
                break;
            case "userName":
                fakeUserName = faker.name().username().replaceAll("[^A-Za-z]", "A").substring(0,9);
                us_13Page.userName.sendKeys(fakeUserName);
                ReusableMethods.bekle(2);
                break;
            case "password":
                fakePassword = faker.internet().password() + "A1";
                us_13Page.password.sendKeys(fakePassword);
                ReusableMethods.bekle(2);
                break;
            case "dateOfBirth":
                fakeDateOfBirth = "" + faker.number().numberBetween(0, 3) + faker.number().numberBetween(0, 9) + "" + faker.number().numberBetween(0, 1) +
                        faker.number().numberBetween(0, 1) + "" + 1 + 9 + faker.number().numberBetween(5, 9) + faker.number().numberBetween(0, 9);
                us_13Page.dateOfBirth.sendKeys(fakeDateOfBirth);
                ReusableMethods.bekle(2);
                break;
        }
    }
    @Given("Vice Dean olarak giris yapar")
    public void vice_dean_olarak_giris_yapar() {
        homePage.homePageLoginButton.click();
        homePage.loginEmailField.sendKeys("Team14vicedean");
        homePage.loginPasswordField.sendKeys("Team14vicedean" + Keys.TAB + Keys.ENTER);

    }

    @And("choose a lesson")
    public void chooseALesson() {
//        Actions actions = new Actions(Driver.getDriver());
//        us_13Page.ChooseLesson.click();
//        actions.sendKeys("Calculus",Keys.ARROW_DOWN,Keys.ENTER).build().perform();

        ReusableMethods.bekle(3);
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(3);
        actions.click(us_13Page.ChooseLesson).perform();
        ReusableMethods.bekle(3);
        actions.click(us_13Page.ChooseLesson).sendKeys("Calculus" + Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        ReusableMethods.bekle(3);


//     actions.click(us_13Page.ChooseLesson).perform();
//       actions.click(us_13Page.ChooseLesson).sendKeys("Calculus", Keys.ARROW_DOWN, Keys.ENTER).build().perform();

    }


    @Then("quit driver")
    public void quitDriver() {
        Driver.quitDriver();
    }

    @And("choose lessons")
    public void chooseLessons() {
        ReusableMethods.bekle(3);
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(3);
        actions.click(us_13Page.ChooseLesson).build().perform();
        ReusableMethods.bekle(3);
        actions.click(us_13Page.ChooseLesson).sendKeys("English" + Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        ReusableMethods.bekle(3);
    }

    @And("enter specific {string} to {string}")
    public void enterSpecificTo(String string, String string2) {
        switch (string2) {
            case "name":
                nameEntered = string;
                us_13Page.name.sendKeys(nameEntered);
                break;
            case "surname":
                surnameEntered = string;
                us_13Page.surname.sendKeys(surnameEntered);
                break;
            case "birthPlace":
                birthPlaceEntered = string;
                us_13Page.birthPlace.sendKeys(birthPlaceEntered);
                break;
            case "email":
                emailEntered = string + faker.number().numberBetween(1, 10000);
                us_13Page.email.sendKeys(emailEntered);
                break;
            case "phoneNumber":
                us_13Page.phoneNumber.sendKeys(string);
                break;
            case "SSN":
                us_13Page.ssn.sendKeys(string);
                break;
            case "userName":
                us_13Page.userName.sendKeys(string);
                break;
            case "password":
                us_13Page.password.sendKeys(string);
                break;
            case "DateOfBirth":
                us_13Page.dateOfBirth.sendKeys(string);
                break;

        }
    }

    @And("bekle {int} saniye")
    public void bekleSaniye(int saniye) {
        ReusableMethods.bekle(saniye);
    }


    @And("is advisor teacher")
    public void isAdvisorTeacher() {
        Assert.assertTrue(us_13Page.isAdvisorTeacher.isSelected());
    }

    // API

    TeacherPostPojo expectedData;
    TeacherResponsePojo actualData;
    Response response;
    JsonPath jsonPath;


    @Given("Post request ile ogretmen olusturulur")
    public void postRequestIleOgretmenOlusturulur() {
        spec.pathParams("first", "teachers", "second", "save");
    }

    @And("Gonderilecek Teacher bilgileri hazirlanir")
    public void gonderilecekTeacherBilgileriHazirlanir() {
      String fakeBirthDay2 = "1990-04-21";
        List<Long> lessonsIdList = new ArrayList<>();
        lessonsIdList.add(49L);
      expectedData = new TeacherPostPojo(fakeBirthDay2,fakeBirthPlace,fakeEmail,"FEMALE",true,lessonsIdList,fakeName,fakePassword,fakePhone,fakeSSN,fakeSurname,fakeUserName);
        System.out.println(expectedData);
    }

    @When("Teacher eklemek icin Post request gonderilir")
    public void teacherEklemekIcinPostRequestGonderilir() {
        response=given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();
        actualData = response.as(TeacherResponsePojo.class);

    }
    @Then("Teacher bilgileri dogrulanir")
    public void teacherBilgileriDogrulanir() {
        String message = "Teacher saved successfully";
        String httpStatus = "CREATED";
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getEmail(), actualData.getObject().getEmail());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.isIsAdvisorTeacher(), actualData.getObject().isAdvisorTeacher());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals(message,actualData.getMessage());
        assertEquals(httpStatus,actualData.getHttpStatus());

    }

    @Then("Ogretmenin istenen bilgilerinin goruntulendigi dogrulanir")
    public void ogretmeninIstenenBilgilerininGoruntulendigiDogrulanir() {
        String message = "Teacher saved successfully";
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());
        assertEquals(message,actualData.getMessage());

    }

    @Given("Put request ile guncellenecek ogretmen bilgileri gonderilir")
    public void putRequestIleGuncellenecekOgretmenBilgileriGonderilir() {
        spec.pathParams("first", "teachers", "second", "update","third",933);
        String fakeBirthDay2 = "1990-04-21";
        List<Long> lessonsIdList = new ArrayList<>();
        lessonsIdList.add(49L);
        expectedData = new TeacherPostPojo(fakeBirthDay2,fakeBirthPlace,fakeEmail,"FEMALE",true,lessonsIdList,fakeName,fakePassword,fakePhone,fakeSSN,fakeSurname,fakeUserName);
        System.out.println(expectedData);
        response=given(spec).body(expectedData).when().put("{first}/{second}/{third}");
        response.prettyPrint();
        actualData = response.as(TeacherResponsePojo.class);
    }

    @Then("guncellenen ogretmen bilgileri dogrulanir")
    public void guncellenenOgretmenBilgileriDogrulanir() {
        String message = "Teacher updated Successful";
        assertEquals(200, response.statusCode());
        assertEquals(message,actualData.getMessage());
        assertEquals(expectedData.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getEmail(), actualData.getObject().getEmail());
        assertEquals(expectedData.getGender(), actualData.getObject().getGender());
        assertEquals(expectedData.isIsAdvisorTeacher(), actualData.getObject().isAdvisorTeacher());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(), actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(), actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(), actualData.getObject().getUsername());


    }

    @And("Gonderilecek eksik Teacher bilgileri hazirlanir")
    public void gonderilecekEksikTeacherBilgileriHazirlanir() {
        String fakeBirthDay2 = "1990-04-21";
        String gecersizEmail = "123456";
        List<Long> lessonsIdList = new ArrayList<>();
        lessonsIdList.add(49L);
        expectedData = new TeacherPostPojo(fakeBirthDay2,fakeBirthPlace,gecersizEmail,"FEMALE",true,lessonsIdList,fakeName,fakePassword,fakePhone,fakeSSN,fakeSurname,fakeUserName);
        System.out.println(expectedData);
    }

    @Then("kayit olusturulamadigi dogrulanir")
    public void kayitOlusturulamadigiDogrulanir() {
        String message = "Please enter valid email";
        response.then().assertThat().statusCode(400).body("validations.email",equalTo(message));

    }

    @When("Eksik bilgilerle teacher eklemek icin Post request gonderilir")
    public void eksikBilgilerleTeacherEklemekIcinPostRequestGonderilir() {
        response=given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();


    }

    @Given("database dogrulamasi")
    public void databaseDogrulamasi() throws SQLException {
        String query = "select * from guest_user where username = '" + fakeUserName+ "'";
        resultSet = executeQuery(query);
        resultSet.next();

        String actualBirthPlace = resultSet.getString("birth_place");
        String actualGender = resultSet.getString("gender");
        String actualName = resultSet.getString("name");
        String actualPhoneNumber = resultSet.getString("phone_number");
        String actualSsn = resultSet.getString("ssn");
        String actualSurname = resultSet.getString("surname");
        String actualUsername = resultSet.getString("username");



        assertEquals(fakeUserName, actualUsername);
        assertEquals(fakePhone, actualPhoneNumber);

    }
}



