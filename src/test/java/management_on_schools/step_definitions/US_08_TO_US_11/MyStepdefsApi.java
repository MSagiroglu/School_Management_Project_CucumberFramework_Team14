package management_on_schools.step_definitions.US_08_TO_US_11;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import management_on_schools.pojos.Ismail08_11.Lesson_CreatePojo;
import management_on_schools.pojos.Ismail08_11.Response_LessonCreat_Pojo;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static management_on_schools.pojos.base_url.ManagementOnSchool.spec_vice_dean;




public class MyStepdefsApi {
    Lesson_CreatePojo expectedDataPojo;
    Response response;

    @Given("kulanici api icin base url olusturur")
    public void kulaniciApiIcinBaseUrlOlusturur() {
        spec_vice_dean.pathParams("first","lessons","second","save");



    }

    @And("kullanici expected data yi olusturur")
    public void kullaniciExpectedDataYiOlusturur() {
        int randomlesson=Faker.instance().number().numberBetween(1,100);

        expectedDataPojo=new Lesson_CreatePojo(true,"12","Jmeter"+randomlesson);


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
        Assert.assertEquals(expectedDataPojo.isCompulsory(), actualdata.getObject().isCompulsory());
        Assert.assertEquals("Lesson Created", actualdata.getMessage());






    }
}
