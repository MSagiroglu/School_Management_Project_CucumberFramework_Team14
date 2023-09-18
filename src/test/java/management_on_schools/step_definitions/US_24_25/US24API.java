package management_on_schools.step_definitions.US_24_25;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import management_on_schools.pojos.Yekta_US24_25.US24.US24TeacherPostPOJO;
import management_on_schools.pojos.Yekta_US24_25.US24.US24TeacherResponsePojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;

import static org.junit.Assert.assertEquals;

public class US24API {
    static US24TeacherPostPOJO expectedDataYK;
    static US24TeacherResponsePojo actualDataYK;
    Response response;
    static Faker faker = new Faker();
    static String apiName=faker.name().firstName();
    static String apiSurname =faker.name().lastName();
    static String apiphoneNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
    static String apiSsnNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
    static String apiUserName =faker.name().firstName().toLowerCase()+faker.name().lastName().toUpperCase();
    static String apiBirthday="1953-01-01";
    static String apiBirthplace=apiName+"istan";
    static String apiGender="MALE";
    static String apiIsAdvisorTeacher ="true";
    static String apiEmail=apiName + apiSurname + "@gmail.com";
    static String apiPassword=apiName+apiSurname.toUpperCase()+"1994";


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
        assertEquals(expectedDataYK.getUsername(),actualDataYK.getObject().getSurname());
        assertEquals(expectedDataYK.getPhoneNumber(),actualDataYK.getObject().getPhoneNumber());
        assertEquals(expectedDataYK.getSsn(),actualDataYK.getObject().getSsn());



        /*
         expectedDataYK= new US24TeacherPostPOJO(

                ,apiphoneNumber,apiSsnNumber,

         */

    }

}

