package management_on_schools.step_definitions.US_03_07_16;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import management_on_schools.pages.Home_Page;
import management_on_schools.pages.Sema03_07_16.US_03_07_16;
import management_on_schools.pojos.Sema03_07_16.US_03.MesajPostPojo;
import management_on_schools.pojos.Sema03_07_16.US_03.ResponsePojo;
import management_on_schools.pojos.Sema03_07_16.US_03.ResponsenegativePojo;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



import static io.restassured.RestAssured.given;
import static management_on_schools.base_url.ManagementOnSchool.spec;

import static org.testng.Assert.assertEquals;

public class US_03 {
    Home_Page homePage = new Home_Page();
    US_03_07_16 ManagementonSchool = new US_03_07_16();


    @Given("kullanici Managementon School sayfasina gider")
    public void kullaniciManagementonSchoolSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
    }

    @Then("kullanici Contact ikonuna tiklar")
    public void kullaniciContactIkonunaTiklar() {
        homePage.contactButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(1, 400);
        actions.perform();

    }

    @And("kullanici Name Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar")
    public void kullaniciNameEmailSubjectMessageKutusunaGecerliVerileriGirerVeSendIkonunaTiklar() {
        homePage.contactNameField.sendKeys(ConfigReader.getProperty("Name"), Keys.TAB,
                ConfigReader.getProperty("Email"), Keys.TAB, ConfigReader.getProperty("Subject"),
                Keys.TAB, ConfigReader.getProperty("Message"), Keys.TAB, Keys.ENTER);

    }

    @And("kullanici Contact Message Created Successfully textinin gorundugunu dogrular")
    public void kullaniciContactMessageCreatedSuccessfullyTextininGorundugunuDogrular() {
        Assert.assertFalse(ManagementonSchool.verifyMessage.isDisplayed());
    }

    @And("kullanici Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar")
    public void kullaniciEmailSubjectMessageKutusunaGecerliVerileriGirerVeSendIkonunaTiklar() {
        ManagementonSchool.eMail.sendKeys(ConfigReader.getProperty("Email"), Keys.TAB,
                ConfigReader.getProperty("Subject"), Keys.TAB, ConfigReader.getProperty("Message"),
                Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(2);
    }

    @And("kullanici Required uyarisinin gorundugunu dogrular")
    public void kullaniciRequiredUyarisininGorundugunuDogrular() {
        Assert.assertTrue(ManagementonSchool.requiredName.isDisplayed());
    }

    @And("kullanici Name Gecersiz Email Subject Message kutusuna gecerli verileri girer ve Send ikonuna tiklar")
    public void kullaniciNameGecersizEmailSubjectMessageKutusunaGecerliVerileriGirerVeSendIkonunaTiklar() {
        homePage.contactNameField.sendKeys(ConfigReader.getProperty("Name"), Keys.TAB,
                ConfigReader.getProperty("invalidMail"), Keys.TAB, ConfigReader.getProperty("Subject"),
                Keys.TAB, ConfigReader.getProperty("Message"), Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(2);
    }

    @And("kullanici Please enter Valid email textinin gorundugunu dogrular")
    public void kullaniciPleaseEnterValidEmailTextininGorundugunuDogrular() {
        Assert.assertTrue(ManagementonSchool.alertEmail.isDisplayed());
    }



    //*************** API *************************
    MesajPostPojo expectedData;
    Response response;
    ResponsePojo actualData;

    @Given("Mesaj gondermek icin Post request hazirligi yapilir")
    public void mesajGondermekIcinPostRequestHazirligiYapilir() {
        // https://managementonschools.com/app/contactMessages/save
        //Set the URL
        spec.pathParams("first", "contactMessages", "second", "save");
    }

    @And("Gonderilecek mesaj bilgileri hazırlanır")
    public void gonderilecekMesajBilgileriHazırlanır() {
        //Set the expected data
        expectedData = new MesajPostPojo
                ("semamalkoc01@gmail.com", "Ders_Saati_10'da_mi?", "Sema ", "Ders_Saati");

    }

    @When("Mesaj eklemek icin Post request gonderilir")
    public void mesajEklemekIcinPostRequestGonderilir() {
        //Send the request and get the response
        response = given(spec).body(expectedData).when().post("{first}/{second}");
        actualData = response.as(ResponsePojo.class);


    }

    @Then("Mesaj Bilgileri dogrulanir")
    public void mesajBilgileriDogrulanir() {
        //Do assertion
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getSubject(), actualData.getObject().getSubject());
        assertEquals(expectedData.getEmail(), actualData.getObject().getEmail());
        assertEquals(expectedData.getName(), actualData.getObject().getName());
        assertEquals(expectedData.getMessage(), actualData.getObject().getMessage());
        ReusableMethods.tumSayfaResmi("03", "mesaj_bilgileri_doğrulandı");
    }


    @Given("AMesaj gondermek icin Post request hazirligi yapilir")
    public void amesajGondermekIcinPostRequestHazirligiYapilir() {
       spec.pathParams ("first", "contactMessages", "second", "save");
    }
    MesajPostPojo expNegData;
    @And("AGonderilecek mesaj bilgileri hazırlanır")
    public void agonderilecekMesajBilgileriHazırlanır() {
        expNegData=new MesajPostPojo("semamalkoc01@gmail.com","Ders_Saati_10'da_mi?","Ders_Saati");
    }

    @When("AMesaj eklemek icin Post request gonderilir")
    public void amesajEklemekIcinPostRequestGonderilir() {
        response = given(spec).body(expNegData).when().post("{first}/{second}");
        ResponsenegativePojo actNegData=response.as(ResponsenegativePojo.class);

    }

    @Then("{string} dogrulanir")
    public void dogrulanir(String arg0) {
        //Do assertion
        assertEquals(400, response.statusCode());
    }
}























