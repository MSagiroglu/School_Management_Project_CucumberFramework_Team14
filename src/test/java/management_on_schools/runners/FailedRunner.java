package management_on_schools.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)//-->Test çalıştırıcı Notasyon(Cucumber ile JUnit i entegre olmasını sağlar)
@CucumberOptions(
        plugin = {"pretty",
                "html:projectReports/default-cucumber-reports.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:failedScenarios/failedRerun.txt"},
        features = "@failedScenarios/failedRerun.txt",// @ işareti koyuyoruz dosya yolunun başında olmalı
        glue = {"management_on_schools/step_definitions"},
        dryRun = false, //-->true seçersek scenarioları kontrol eder browser'ı çalıştırmaz
        monochrome = false
)
public class FailedRunner {
    //"html:projectReports/US_01/default-cucumber-reports.html",


}
