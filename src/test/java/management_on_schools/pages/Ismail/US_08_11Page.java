package management_on_schools.pages.Ismail;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_08_11Page {

    public US_08_11Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='header_link ms-2']")
    public WebElement login1;

    @FindBy(xpath = "//button[normalize-space()='Menu']")
    public WebElement Anasayfa_Menu;

    @FindBy(xpath = "//*[text()='Lesson Management'])[2])")
    public WebElement AnaSayfadaki_L_Management;

    @FindBy(xpath = "//*[text()='Lessons']")
    public WebElement Lesson_butonu;

    @FindBy(xpath = "//input[@id='lessonName']")
    public WebElement Lesson_Name;

    @FindBy(xpath = "//input[@id='compulsory']")
    public WebElement CheckBox ;

    @FindBy(xpath = "//input[@id='creditScore']")
    public WebElement Credit_Score ;

    @FindBy(id = "username")
    public WebElement username ;

    @FindBy(id = "password")
    public WebElement password ;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    public WebElement login2 ;

    @FindBy(id = "lessonName")
    public WebElement lesson_kutucugu ;

    @FindBy(xpath = "(//*[text()='Submit'])[2]")
    public WebElement Lesson_submit_butonu ;

    @FindBy(xpath = "//*[text()='Lesson Created']")
        public WebElement lesson_created;


    @FindBy(id = "controlled-tab-example-tab-lessonProgram")
    public WebElement lesson_program_kutucugu ;

    @FindBy(css = "input[id='react-select-2-input']")
    public WebElement Choose_Lesson;

    @FindBy(css="select[id = 'day']")
    public WebElement Choose_Day ;

    @FindBy(css="select[id='educationTermId']")
    public WebElement Choose_Education;

    @FindBy(css="[id = 'startTime']")
    public WebElement Start_Time ;

    @FindBy(css="[id = 'stopTime']")
    public WebElement Stop_Time ;

    @FindBy(xpath = "(//*[text()='Submit'])[3]")
    public WebElement Lesson_submit_addLesson ;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement lessonProgramSuccessMessage;

    @FindBy (xpath ="//th[text()='Lesson Name']")
    public WebElement v_dean_lessonname;


}