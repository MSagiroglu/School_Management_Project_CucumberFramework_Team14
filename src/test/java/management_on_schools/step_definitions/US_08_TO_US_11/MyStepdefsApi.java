package management_on_schools.step_definitions.US_08_TO_US_11;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_schools.pojos.Ismail08_11.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec_vice_dean;



public class MyStepdefsApi {

   LessonCreateRequestPojo expectedDataPojo;
    LessonProgram_CreatePojo expectedDataLSPojo;
    LessonProgram_Response_Objepojo lessonProgramActualData;
    Response response;
    String lesson_id;
    String lessonprogram_id;

    @Given("kulanici api icin base url olusturur")
    public void kulaniciApiIcinBaseUrlOlusturur() {
        spec_vice_dean.pathParams("first","lessons","second","save");

    }

    @And("kullanici expected data yi olusturur")
    public void kullaniciExpectedDataYiOlusturur() {
        int randomlesson=Faker.instance().number().numberBetween(1,100);

        expectedDataPojo=new LessonCreateRequestPojo(true,8,"Postman"+randomlesson);

    }

    @And("kullanici vice dean ile post request yaparak bir lesson olusturur")
    public void kullaniciViceDeanIlePostRequestYaparakBirLessonOlusturur() {
        response=given(spec_vice_dean).body(expectedDataPojo).post("{first}/{second}");
        response.prettyPrint();

    }

    @Then("kullanici dogrulama yapar")
    public void kullaniciDogrulamaYapar() {
        Response_LessonCreat_Pojo actualdata=response.as(Response_LessonCreat_Pojo.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedDataPojo.getLessonName(), actualdata.getObject().getLessonName());
        Assert.assertEquals(expectedDataPojo.getCreditScore(), actualdata.getObject().getCreditScore());
        Assert.assertEquals(expectedDataPojo.getCompulsory(), actualdata.getObject().getCompulsory());
        Assert.assertEquals("Lesson Created", actualdata.getMessage());


    }

    @Then("kullanici olusturdugu dersi görür")
    public void kullaniciOlusturduguDersiGörür() {
        lesson_id = response.jsonPath().getString("object.lessonId");
        spec_vice_dean.pathParams("first","lessons","second","getAllLessonByLessonId").queryParams("lessonId",lesson_id);
        response = given(spec_vice_dean).get("{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<LessonGetResponsePojo> lessons = jsonPath.getList("", LessonGetResponsePojo.class);

        Assert.assertEquals(expectedDataPojo.getLessonName(),lessons.get(0).getLessonName());
        Assert.assertEquals(expectedDataPojo.getCreditScore(),lessons.get(0).getCreditScore());
        Assert.assertEquals(expectedDataPojo.getCompulsory(),lessons.get(0).isCompulsory());

        System.out.println(lessons.get(0).getLessonName());
        System.out.println(lessons.get(0).getCreditScore());
        System.out.println(lessons.get(0).isCompulsory());

    }

    @Then("kullanici olusturdugu dersi programını görür")
    public void kullaniciOlusturduguDersiProgramınıGörür() {

        spec_vice_dean.pathParams("first", "lessonPrograms", "second", "getById").queryParams("lessonprogram_id", lessonprogram_id);
        response = given(spec_vice_dean).get("{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<LessonProgram_CreatePojo> lessons = jsonPath.getList("", LessonProgram_CreatePojo.class);
        Assert.assertEquals(expectedDataLSPojo.getStopTime(), lessons.get(0).getStopTime());
        System.out.println(lessons.get(0).getStopTime());

    }
    @Given("kulanici lesson program api icin base url olusturur")
    public void kulaniciLessonProgramApiIcinBaseUrlOlusturur() {
        spec_vice_dean.pathParams("first", "lessonPrograms", "second", "save");
    }

    @And("kullanici lesson pragram expected data yi olusturur")
    public void kullaniciLessonPragramExpectedDataYiOlusturur() {
        List<String> lessonid_List=new ArrayList<>();
        lessonid_List.add("1249");

        expectedDataLSPojo=new LessonProgram_CreatePojo("SUNDAY","1",lessonid_List,"13:00","15:00");
    }

    @And("kullanici vice dean ile post request yaparak bir lesson program olusturur")
    public void kullaniciViceDeanIlePostRequestYaparakBirLessonProgramOlusturur() {
        response = given(spec_vice_dean).body(expectedDataLSPojo).post("{first}/{second}");
        lessonprogram_id = response.jsonPath().getString("object.lessonProgramId");
        response.prettyPrint();
    }

    @Then("kullanici lesson programi dogrulama yapar")
    public void kullaniciLessonProgramiDogrulamaYapar() {
        lessonProgramActualData =response.as(LessonProgram_Response_Objepojo.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedDataLSPojo.getDay(),lessonProgramActualData.getObject().getDay());
        Assert.assertEquals(expectedDataLSPojo.getStartTime(),lessonProgramActualData.getObject().getStartTime().substring(0,5));
        Assert.assertEquals(expectedDataLSPojo.getStopTime(),lessonProgramActualData.getObject().getStopTime().substring(0,5));
    }


}
