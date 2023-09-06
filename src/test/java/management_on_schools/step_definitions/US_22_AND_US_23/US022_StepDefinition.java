package management_on_schools.step_definitions.US_22_AND_US_23;

import io.cucumber.java.en.Given;
import management_on_schools.utilities.ReusableMethods;

public class US022_StepDefinition {
    @Given("admin login olur")
    public void adminLoginOlur() {
        ReusableMethods.login("AdminUsername","AdminPassword");
    }
}
