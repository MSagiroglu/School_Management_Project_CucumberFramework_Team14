package management_on_schools.step_definitions.US_12_13_14;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import management_on_schools.pages.Begum12_13_14.US_12Page;
import management_on_schools.pojos.Begum12_13_14.US12.ChooseLessonPojo;
import management_on_schools.pojos.Begum12_13_14.US12.ChooseLessonResponsePojo;
import management_on_schools.utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;
import static org.junit.Assert.assertEquals;


public class US_12 {

    US_12Page us_12Page = new US_12Page();
    Faker faker = new Faker();

    @And("Vice Dean choose lesson")
    public void viceDeanChooseLesson() {

        ReusableMethods.scroll(us_12Page.selectALessonProgram);
        ReusableMethods.bekle(3);
       us_12Page.selectALessonProgram.click();
    }


    @And("Vice Dean choose teacher")
    public void viceDeanChooseTeacher() {

        ReusableMethods.scroll(us_12Page.chooseTeacherDDM);
        us_12Page.chooseTeacherDDM.click();
        us_12Page.chooseTeacherLessonProgramViceDean.click();
    }



    ChooseLessonPojo chooseLessonPojo;
    ChooseLessonResponsePojo chooseLessonResponsePojo;
    Response response;


    @Given("ders icin ogretmen secilir")
    public void dersIcinOgretmenSecilir() {
        spec.pathParams("first", "teachers", "second", "chooseLesson");

    }

    @Then("ders secimi dogrulamasi yapilir")
    public void dersSecimiDogrulamasiYapilir() {
        int lessonIdNum =faker.number().numberBetween(1,1000) ;
        List<Integer> lessonId = new ArrayList<>();
        lessonId.add(lessonIdNum);
        chooseLessonPojo = new ChooseLessonPojo(lessonId,933);
        response = given(spec).body(chooseLessonPojo).when().post("{first}/{second}");
        response.prettyPrint();
        chooseLessonResponsePojo = response.as(ChooseLessonResponsePojo.class);
         String message = "Lesson added to Teacher";
         assertEquals(200,response.statusCode());
         assertEquals(message,chooseLessonResponsePojo.getMessage());


    }
}
