package management_on_schools.step_definitions.US_24_25;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import management_on_schools.pojos.Yekta_US24_25.US25.NegativeScenarios.US25NegativeResponsePojo;
import management_on_schools.pojos.Yekta_US24_25.US25.PositiveScenarios.US25StudentPostPojo;
import management_on_schools.pojos.Yekta_US24_25.US25.PositiveScenarios.US25StudentResponsePojo;
import management_on_schools.utilities.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;
import static management_on_schools.step_definitions.US_24_25.US25.*;
import static org.junit.Assert.assertEquals;

public class US25APIa {
    static US25StudentPostPojo expectedData;
    static US25StudentResponsePojo actualData;
    Response response;
    static Faker faker = new Faker();
    static String nameApiS=nameYS;
    static String surnameApiS=surnameYS;
    static String apiBirthdayS="1953-01-01";
    static String birthPlaceS =birthPlaceYS;
    static String emailS=emailYS;
    static String fatherNameS=fatherYS;
    static String motherNameS=motherYS;
    static String genderS="MALE";
    static String apiphoneNumberS = phoneYS;
    static String apiSsnNumberS =ssnYS;
    static String apiPasswordS=passwordYS;
    static String apiUsernameS=userNameYS;
    static Integer isAdvisorTeacher =2;
    static Integer getIsAdvisorTeacherFalse=0;
    @Given("Student eklemek için post request hazirligi yapilir")
    public void student_eklemek_için_post_request_hazirligi_yapilir() {
        //https://managementonschools.com/app/students/save
        //Set the URL
        spec.pathParams("first","students","second","save");

    }
    @Given("Gonderilecek student bilgileri hazirlanir")
    public void gonderilecek_student_bilgileri_hazirlanir() {
//Set the expected Data
        expectedData=new US25StudentPostPojo(isAdvisorTeacher,apiBirthdayS,birthPlaceS,
                emailS,fatherNameS,genderS,
                motherNameS,nameApiS,apiPasswordS,
                apiphoneNumberS,apiSsnNumberS,surnameApiS,
                apiUsernameS);
        System.out.println(expectedData);

    }
    @When("Student eklemek icin Post request gonderilir")
    public void student_eklemek_icin_post_request_gonderilir() {
//Send request get response
        response=given(spec).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();
        actualData =response.as(US25StudentResponsePojo.class);
        System.out.println(actualData);
    }
    @Then("Kaydedilen student'a ait bilgiler dogrulanir")
    public void kaydedilen_student_a_ait_bilgiler_dogrulanir() {
assertEquals(200,response.statusCode());
assertEquals("Student saved Successfully",actualData.getMessage());
assertEquals(expectedData.getBirthDay(),actualData.getObject().getBirthDay());
assertEquals(expectedData.getAdvisorTeacherId(),actualData.getObject().getAdvisorTeacherId());
assertEquals(expectedData.getBirthPlace(),actualData.getObject().getBirthPlace());
assertEquals(expectedData.getEmail(),actualData.getObject().getEmail());
assertEquals(expectedData.getName(),actualData.getObject().getName());
assertEquals(expectedData.getSurname(),actualData.getObject().getSurname());
assertEquals(expectedData.getFatherName(),actualData.getObject().getFatherName());
assertEquals(expectedData.getMotherName(),actualData.getObject().getMotherName());
assertEquals(expectedData.getGender(),actualData.getObject().getGender());
assertEquals(expectedData.getPhoneNumber(),actualData.getObject().getPhoneNumber());
assertEquals(expectedData.getSsn(),actualData.getObject().getSsn());
assertEquals(expectedData.getUsername(),actualData.getObject().getUsername());

    }
/*
static US24TeacherPostPOJO getExpectedDataYK1 =new US24TeacherPostPOJO(apiBirthday,apiBirthplace,
            apiEmail,
            apiGender,apiIsAdvisorTeacher,
            null,apiName,apiPassword,apiphoneNumber,apiSsnNumber,
            apiSurname,apiUserName);
    US24NegativeResponsePojo us24Negative;
    isAdvisorTeacher,apiBirthdayS,birthPlaceS,
                emailS,fatherNameS,genderS,
                motherNameS,nameApiS,apiPasswordS,
                apiphoneNumberS,apiSsnNumberS,surnameApiS,
                apiUsernameS)
 */

    static US25StudentPostPojo getExpectedData1= new US25StudentPostPojo(0,apiBirthdayS,birthPlaceS,emailS,fatherNameS,
            genderS,motherNameS,nameApiS,apiPasswordS,apiphoneNumberS,apiSsnNumberS,surnameApiS,apiUsernameS);
US25NegativeResponsePojo us25Negative;
    @And("Advisor Teacher seçimi yapılmadan öğrenci bilgileri hazırlanır")
    public void advisorTeacherSeçimiYapılmadanÖğrenciBilgileriHazırlanır() {
        /*
        response = given(spec).body(getExpectedDataYK1).when().post("/{first}/{second}");
        response.prettyPrint();
        us24Negative = response.as(US24NegativeResponsePojo.class);
        assertEquals(400,response.statusCode());
        assertEquals("Please select lesson",us24Negative.getValidations().getLessonsIdList());
        System.out.println(response.statusCode());
        System.out.println(us24Negative.getValidations().getLessonsIdList());
        System.out.println("Yekta");
         */
        response =given(spec).body(getExpectedData1).when().post("/{first}/{second}");
        response.prettyPrint();
        us25Negative=response.as(US25NegativeResponsePojo.class);
        assertEquals(404,response.statusCode());
        System.out.println(response.statusCode());
        
    }

    @When("Öğrenci eklemek icin Post request gonderilir")
    public void öğrenciEklemekIcinPostRequestGonderilir() {
        
    }

    @Then("Status kodunun {int} olduğu doğrulaması yapılır")
    public void statusKodununOlduğuDoğrulamasıYapılır(int arg0) {
    }
    static Connection connection;
    @When("Admin öğrenci database bilgileri icin baglantı kurulur.")
    public void adminÖğrenciDatabaseBilgileriIcinBaglantıKurulur() {
        connection= JDBCUtils.connectToDatabase();
    }
    static String dataBaseUsername1;
    static String dataBaseName1;
    static String databaseSurname1;
    static String databasePhoneNumber1;
    static String databaseSsn1;

    static Statement statement;
    static ResultSet resultSet;
    @Then("Admin öğrenci bilgilerinin database icinde olup olmadigi dogrulanir.")
    public void adminÖğrenciBilgilerininDatabaseIcindeOlupOlmadigiDogrulanir() throws SQLException {
        statement =connection.createStatement();
        resultSet= JDBCUtils.executeQuery("select * from student where username = '" + apiUsernameS  + "'");
        resultSet.next();
        databasePhoneNumber1=resultSet.getString("phone_number");
        dataBaseName1 =resultSet.getString("name");
        databaseSurname1=resultSet.getString("surname");
        databaseSsn1=resultSet.getString("ssn");
        assertEquals(apiphoneNumberS, databasePhoneNumber1);
        assertEquals(apiSsnNumberS, databaseSsn1);
        assertEquals(nameApiS, dataBaseName1);
        assertEquals(surnameApiS,databaseSurname1);
        System.out.println(databasePhoneNumber1);
        System.out.println(databaseSsn1);
        System.out.println(dataBaseName1);
        System.out.println(databaseSurname1);


    }
}
