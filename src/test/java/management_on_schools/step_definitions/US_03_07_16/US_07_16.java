package management_on_schools.step_definitions.US_03_07_16;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.Sema03_07_16.ManagementonSchool;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;
import static org.junit.Assert.assertEquals;

public class US_07_16 {
    Response response;
    Home_Page homePage=new Home_Page();
    management_on_schools.pages.Sema03_07_16.ManagementonSchool ManagementonSchool=new ManagementonSchool();
    @Given("kullanici Managementon School sayfasina gider ve login butonuna tiklar")
    public void kullaniciManagementonSchoolSayfasinaGiderVeLoginButonunaTiklar() {
        Driver.getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
        homePage.homePageLoginButton.click();


    }

    @Then("kullanici Dean hesabiyla giris yapar")
    public void kullaniciDeanHesabiylaGirisYapar() {
        homePage.loginEmailField.sendKeys(ConfigReader.getProperty("DeanUsername"), Keys.TAB,
                ConfigReader.getProperty("DeanPassword"),Keys.TAB,Keys.ENTER);
    }

    @And("kullanici Menu ikonunu tiklar")
    public void kullaniciMenuIkonunuTiklar() {
        homePage.menuButton.click();
    }

    @And("kullanici Contact Get All textine tıklar")
    public void kullaniciContactGetAllTextineTıklar() {
        ManagementonSchool.contacts.click();
    }

    @And("kullanici mesaj bilgilerinin gorundugunu dogrular")
    public void kullaniciMesajBilgilerininGorundugunuDogrular() {
       Assert.assertTrue(ManagementonSchool.contactMessages.isDisplayed());

    }

    @And("kullanici silme ikonunun gorundugunu dogrular")
    public void kullaniciSilmeIkonununGorundugunuDogrular() {
        Assert.assertFalse(ManagementonSchool.verifyMessage.isDisplayed());
    }

    @Then("kullanici Vice Dean hesabiyla giris yapar")
    public void kullaniciViceDeanHesabiylaGirisYapar() {
        homePage.loginEmailField.sendKeys(ConfigReader.getProperty("ViceDeanUsername"), Keys.TAB,
                ConfigReader.getProperty("ViceDeanPassword"),Keys.TAB,Keys.ENTER);
    }


    @Then("Body dogrulama : name={string},email={string},subject={string},message={string},date={string}")
    public void bodyDogrulamaNameEmailSubjectMessageDate(String name, String email, String subject, String message, String date) {
        JsonPath jsonPath=response.jsonPath();
        String actName = jsonPath.getList("content.findAll{it.email=='semamalkoc01@gmail.com'}.name").get(0).toString();
        String actEmail = jsonPath.getList("content.findAll{it.email=='semamalkoc01@gmail.com'}.email").get(0).toString();
        String actSubject = jsonPath.getList("content.findAll{it.email=='semamalkoc01@gmail.com'}.subject").get(0).toString();
        String actMessage = jsonPath.getList("content.findAll{it.email=='semamalkoc01@gmail.com'}.message").get(0).toString();
        String actDate = jsonPath.getList("content.findAll{it.email=='semamalkoc01@gmail.com'}.date").get(0).toString();

        assertEquals(200,response.statusCode());
        assertEquals(actName,name);
        assertEquals(actEmail,email);
        assertEquals(actSubject,subject);
        assertEquals(actMessage,message);
        assertEquals(actDate,date);
    }

    @Given("Get Request ile gelen tüm mesajlari al")
    public void getRequestIleGelenTümMesajlariAl() {
        spec.pathParams("first","contactMessages","second","getAll").
                queryParams("size","10000");

        response =given(spec).when().get("{first}/{second}");

    }
}
