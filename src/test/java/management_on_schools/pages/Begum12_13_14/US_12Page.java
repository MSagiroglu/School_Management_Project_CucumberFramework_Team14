package management_on_schools.pages.Begum12_13_14;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_12Page {
    public US_12Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(text(),'Lesson added to Teacher')]")
    public WebElement lessonAddedToTeacherMessage;
    @FindBy(xpath = "(//*[@id='lessonProgramId'])[1]")
    public WebElement selectALessonProgram;
    @FindBy(id = "teacherId")
    public WebElement chooseTeacherDDM;
    @FindBy(xpath = "//*[text()='team14 teacher']")
    public WebElement chooseTeacherLessonProgramViceDean;
    @FindBy(xpath = "//button[@id='controlled-tab-example-tab-lessonProgram']")
    public WebElement lessonProgramButton;

    @FindBy(xpath = "//h5[normalize-space()='Lesson Program Assignment']")
    public WebElement lessonProgramAssignmetButton;
    @FindBy(xpath = "//div[@class='mt-5 ms-3 me-3 mb-5 text-center border border-3 shadow-sm bg-body rounded card border-warning']//th[2]")
    public WebElement lessonV;
}
