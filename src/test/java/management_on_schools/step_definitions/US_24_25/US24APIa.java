package management_on_schools.step_definitions.US_24_25;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import management_on_schools.pojos.Yekta_US24_25.US24.NegativeScenarios.US24NegativeResponsePojo;
import management_on_schools.pojos.Yekta_US24_25.US24.PositiveScenarios.US24TeacherPostPOJO;
import management_on_schools.pojos.Yekta_US24_25.US24.PositiveScenarios.US24TeacherResponsePojo;
import management_on_schools.utilities.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;

import static management_on_schools.step_definitions.US_24_25.US24.*;
import static org.junit.Assert.assertEquals;

public class US24APIa {
    static US24TeacherPostPOJO expectedDataYK;
    static US24TeacherResponsePojo actualDataYK;
    Response response;
    static Faker faker = new Faker();
    static String apiName=nameY;
    static String apiSurname =surnameY;
    static String apiphoneNumber = phoneNumberY;
    static String apiSsnNumber = ssnNumberY;
    static String apiUserName =userNameY;
    static String apiBirthday="1953-01-01";
    static String apiBirthplace=birthplaceY;
    static String apiGender="MALE";
    static String apiIsAdvisorTeacher ="true";
    static String apiEmail=email;
    static String apiPassword=passwordY;


    @Given("Teacher eklemek için post request hazirligi yapilir")
    public void teacher_eklemek_için_post_request_hazirligi_yapilir() {
        //https://managementonschools.com/app/teachers/save swagger dökümanı
        spec.pathParams("first","teachers","second","save");


    }
    @Given("Gonderilecek teacher bilgileri hazirlanir")
    public void gonderilecek_teacher_bilgileri_hazirlanir() {
        //Set the expecyed data
        US24TeacherPostPOJO lessonsID = new US24TeacherPostPOJO();
        lessonsID.setLessonsIdList(new ArrayList<>());
        lessonsID.getLessonsIdList().add("1");
        lessonsID.getLessonsIdList().add("2");
        lessonsID.getLessonsIdList().add("6");



        expectedDataYK= new US24TeacherPostPOJO(apiBirthday,apiBirthplace,
                apiEmail,
                apiGender,apiIsAdvisorTeacher,
                lessonsID.getLessonsIdList(),apiName,apiPassword,apiphoneNumber,apiSsnNumber,
                apiSurname,apiUserName);
        System.out.println(expectedDataYK);


    }
    @When("Teacher eklemek icin Post request gonderilir")
    public void teacher_eklemek_icin_post_request_gonderilir() {
        //Send request get response
        response=given(spec).body(expectedDataYK).when().post("{first}/{second}");
        response.prettyPrint();
        actualDataYK=response.as(US24TeacherResponsePojo.class);

    }


    @Then("Kaydedilen teacher'a ait bilgiler dogrulanir")
    public void kaydedilen_teacher_a_ait_bilgiler_dogrulanir() {
        //Do the assertion
        assertEquals(200,response.statusCode());
        assertEquals("CREATED",actualDataYK.getHttpStatus());
        assertEquals("Teacher saved successfully",actualDataYK.getMessage());
        assertEquals(expectedDataYK.getBirthDay(),actualDataYK.getObject().getBirthDay());
        assertEquals(expectedDataYK.getBirthPlace(),actualDataYK.getObject().getBirthPlace());
        assertEquals(expectedDataYK.getEmail(),actualDataYK.getObject().getEmail());
        assertEquals(expectedDataYK.getGender(),actualDataYK.getObject().getGender());
        assertEquals(expectedDataYK.getName(),actualDataYK.getObject().getName());
        assertEquals(expectedDataYK.getSurname(),actualDataYK.getObject().getSurname());
        assertEquals(expectedDataYK.getPhoneNumber(),actualDataYK.getObject().getPhoneNumber());
        assertEquals(expectedDataYK.getSsn(),actualDataYK.getObject().getSsn());



        /*
         expectedDataYK= new US24TeacherPostPOJO(

                ,apiphoneNumber,apiSsnNumber,

         */

    }
    static US24TeacherPostPOJO getExpectedDataYK1 =new US24TeacherPostPOJO(apiBirthday,apiBirthplace,
            apiEmail,
            apiGender,apiIsAdvisorTeacher,
            null,apiName,apiPassword,apiphoneNumber,apiSsnNumber,
            apiSurname,apiUserName);
    US24NegativeResponsePojo us24Negative;
    @And("Ders seçimi yapılmadan öğretmen bilgileri gönderilir")
    public void dersSeçimiYapılmadanÖğretmenBilgileriGönderilir() {
        response = given(spec).body(getExpectedDataYK1).when().post("/{first}/{second}");
        response.prettyPrint();
        us24Negative = response.as(US24NegativeResponsePojo.class);
        assertEquals(400,response.statusCode());
        assertEquals("Please select lesson",us24Negative.getValidations().getLessonsIdList());
        System.out.println(response.statusCode());
        System.out.println(us24Negative.getValidations().getLessonsIdList());
        System.out.println("Yekta");
    }

    @When("Öğretmen eklemek icin Post request gonderilir")
    public void öğretmenEklemekIcinPostRequestGonderilir() {
        
    }

    @Then("Status kodunun {int} olduğu doğrulanır.")
    public void statusKodununOlduğuDoğrulanır(int arg0) {
    }


    static Connection connection;
    @When("Admin Database bilgileri icin baglantı kurulur.")
    public void adminDatabaseBilgileriIcinBaglantıKurulur() throws SQLException {

        connection= JDBCUtils.connectToDatabase();
    }

    static String dataBaseUsername;
    static String dataBaseName;
    static String databaseSurname;
    static String databasePhoneNumber;
    static String dataBaseSsn;

    static Statement statement;
    static ResultSet resultSet;
    @Then("Admin bilgilerinin database icinde olup olmadigi dogrulanir.")
    public void adminBilgilerininDatabaseIcindeOlupOlmadigiDogrulanir() throws SQLException {
        statement =connection.createStatement();
        resultSet= JDBCUtils.executeQuery("select * from teacher where username = '" + apiUserName  + "'");
        resultSet.next();
        databaseSurname=resultSet.getString("surname");
        databasePhoneNumber=resultSet.getString("phone_number");
        dataBaseName=resultSet.getString("name");
        dataBaseSsn =resultSet.getString("ssn");

        assertEquals(apiphoneNumber, databasePhoneNumber);
        assertEquals(apiName,dataBaseName);
        assertEquals(apiSurname,databaseSurname);
        assertEquals(apiSsnNumber,dataBaseSsn);
        System.out.println(dataBaseName);
        System.out.println(databaseSurname);
        System.out.println(databasePhoneNumber);
        System.out.println(dataBaseSsn);

    }
}

