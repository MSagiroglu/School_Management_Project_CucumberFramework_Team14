package management_on_schools.step_definitions;


import io.cucumber.java.AfterAll;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp() throws Exception {
        Driver.getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
    }
    @After//import io.cucumber.java.After;
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {//-->Scenario fail olursa
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/jpeg",  scenario.getName());
            Driver.quitDriver();
        }
        //Driver.closeDriver();
    }

    @AfterAll
    public static void tearDownAll() {
        Driver.quitDriver();
    }


    //Bu method fail olan scenario'larda fail olan kısmın resmini rapora ekleyecektir.
}
