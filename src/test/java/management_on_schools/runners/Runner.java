package management_on_schools.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)//-->Test çalıştırıcı Notasyon(Cucumber ile JUnit i entegre olmasını sağlar)
@CucumberOptions(
        plugin = {"pretty",
                "html:projectReports/US_01/default-cucumber-reports.html",

                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:failedScenarios/failedRerun.txt"},
        features = "src/test/resources/features",
        glue = {"management_on_schools/step_definitions"},
        tags = "@All",//-->  and kulansaydık her iki tag'a sahip olan Scenario yu çalıştırır.


        //--> Eğer Feature'ın tag'ini @all yaparsak o featurenin tüm testlerini çalıştırır ise
        dryRun = false, //-->true seçersek scenarioları kontrol eder browser'ı çalıştırmaz
        monochrome = false
)
public class Runner {
    //"html:projectReports/US_01/default-cucumber-reports.html",


}
