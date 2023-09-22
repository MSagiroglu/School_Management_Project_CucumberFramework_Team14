package management_on_schools.pages.Suleyman_US15_21;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_21Page {
    public US_21Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button)[1]")
    public WebElement stdUs21MenuButonu;//--> Menu Butonu

    @FindBy(xpath = "//a[text()='Choose Lesson']")
    public WebElement stdUs21ChooseLessonButonu;//--> Choose Lesson Butonu

    @FindBy(xpath = "(//input[@id='lessonProgramId'])[48]")
    public WebElement stdUs21CheckBoxLessonButonu;//--> CheckBox Lesson Butonu
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement stdUs21SubmitButonu;//--> Submit Butonu

    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[2]")
    public WebElement stdUs21LessonProgramList;//--> Lesson Program List Butonu

    @FindBy(xpath = "(//h5[@class='fw-bold p-3 card-header'])[2]")
    public WebElement stdUs21LessonAddedAlertButonu;//--> Lesson Added To Student Alert Butonu

    @FindBy(xpath = "//a[text()='Grades and Announcements']")
    public WebElement stdUs21GradesAndAnnouncementsButonu;//--> Grades and Announcements Butonu

    @FindBy(xpath = "//h5[text()='Student Info List']")
    public WebElement stdUs21StudentInfoListButonu;//--> Student Info List Butonu

    @FindBy(xpath = "//h5[text()='Meet List']")
    public WebElement stdUs21MeetListButonu;//--> Meet List Butonu

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement stdUs21LogoutButonu;//--> Logout Butonu

    @FindBy(xpath = "//button[normalize-space()='Yes']")
    public WebElement stdUs21LogoutYesButton;//--> Logout Yes Butonu

//    @FindBy(xpath = "(//a)[33]")
//    public WebElement stdUs21LoginButton;//--> Student Management Butonu


}
