package management_on_schools.step_definitions.US_01_AND_US_02;

import io.cucumber.java.en.Given;
import management_on_schools.pages.Home_Page;
import management_on_schools.utilities.ReusableMethods;

public class US001 {
    Home_Page homePage=new Home_Page();
    @Given("Kullanici Admin olarak giris yapar.")
    public void kullaniciAdminOlarakGirisYapar() {
        ReusableMethods.login("AdminUsername", "AdminPassword");
        ReusableMethods.logout();
    }
}
