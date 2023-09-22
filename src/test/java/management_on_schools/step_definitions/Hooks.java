package management_on_schools.step_definitions;


import io.cucumber.java.AfterAll;
import management_on_schools.base_url.ManagementOnSchool;
import management_on_schools.utilities.ConfigReader;
import management_on_schools.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static management_on_schools.base_url.ManagementOnSchool.*;


public class Hooks {
    @Before
    public void setUp() throws Exception {
        System.out.println("Scenariolar çalışmaya başladı");

    }

    @Before("@UI")
    public void beforeUI() throws Exception {
        System.out.println("UI testi başladı");
        Driver.getDriver().get(ConfigReader.getProperty("managementOnSchoolsUrl"));
    }

    @Before("@admin")
    public void beforeApiAdmin() throws Exception {
        System.out.println("admin api before çalıştı.");
        adminSetUp();

    }

    @Before("@dean")
    public void beforeApiDean() throws Exception {
        deanSetUp();

    }

    @Before("@viceDean")
    public void beforeApiViceDean() throws Exception {
        viceDeanSetUp();

    }

    @Before("@adviceTeacher")
    public void beforeApiAdviceTeacher() throws Exception {
        adviceTeacherSetUp();
    }

    @Before("@student")
    public void beforeApiStudent() throws Exception {
        studentSetUp();

    }


    @After//import io.cucumber.java.After;
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {//-->Scenario fail olursa
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/jpeg", scenario.getName());
            Driver.quitDriver();
        }
        Driver.closeDriver();


    }
    //Bu method fail olan scenario'larda fail olan kısmın resmini rapora ekleyecektir.

    @AfterAll
    public static void tearDownAll() {
        Driver.closeDriver();
    }
}
