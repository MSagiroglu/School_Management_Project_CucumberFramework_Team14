package management_on_schools.step_definitions.US_12_13_14;

import io.cucumber.java.en.And;
import management_on_schools.pages.Begum12_13_14.US_12Page;
import management_on_schools.pages.Begum12_13_14.US_13Page;
import management_on_schools.pages.Begum12_13_14.US_14Page;
import management_on_schools.pages.Home_Page;
import management_on_schools.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class US_12 {

    US_12Page us_12Page = new US_12Page();


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
}
