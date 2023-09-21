package management_on_schools.pages.Ismail08_11;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_08_11Page {




    public US_08_11Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // US_08 *************************************************************************************************

    @FindBy(xpath = "//*[text()='Lessons']")
    public WebElement Lesson_butonu;
    @FindBy(id = "lessonName")
    public WebElement lesson_kutucugu ;
    @FindBy(xpath = "//input[@id='compulsory']")
    public WebElement CheckBox ;
    @FindBy(xpath = "//input[@id='creditScore']")
    public WebElement Credit_Score ;
    @FindBy(xpath = "(//*[text()='Submit'])[2]")
    public WebElement Lesson_submit_butonu ;

    @FindBy(xpath = "//*[text()='Required']")
    public WebElement Required_mesaj ;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement lesson_created;


    // US_08 ***************************************************************************************


    // US_09 ***************************************************************************************
    @FindBy (xpath ="//th[text()='Lesson Name']")
    public WebElement v_dean_lessonname;



    // US_09 ***************************************************************************************


    // US_10 ***************************************************************************************

    @FindBy(css = "input[id='react-select-2-input']")
    public WebElement Choose_Lesson;
    @FindBy(css="select[id='educationTermId']")
    public WebElement Choose_Education;
    @FindBy(css="select[id = 'day']")
    public WebElement Choose_Day ;
    @FindBy(css="[id = 'startTime']")
    public WebElement Start_Time ;
    @FindBy(css="[id = 'stopTime']")
    public WebElement Stop_Time ;
    @FindBy(xpath = "(//*[text()='Submit'])[3]")
    public WebElement Lesson_submit_addLesson ;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement lessonProgramSuccessMessage1;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement lessonProgramSuccessMessage;



    // US_10 ***************************************************************************************

    // US_11 ***************************************************************************************
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement lessonsNotSuccessMessage;



    // US_11 ***************************************************************************************


    @FindBy(xpath = "//a[@class='header_link ms-2']")
    public WebElement login1;

    @FindBy(xpath = "//button[normalize-space()='Menu']")
    public WebElement Anasayfa_Menu;

    @FindBy(xpath = "//*[text()='Lesson Management'])[2])")
    public WebElement AnaSayfadaki_L_Management;


    @FindBy(xpath = "//input[@id='lessonName']")
    public WebElement Lesson_Name;


    @FindBy(id = "username")
    public WebElement username ;

    @FindBy(id = "password")
    public WebElement password ;

    @FindBy(xpath = "//a[@class='header_link ms-2']")
    public WebElement homePageLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;


    @FindBy(id = "controlled-tab-example-tab-lessonProgram")
    public WebElement lesson_program_kutucugu ;

    @FindBy(xpath = "(//thead)[3]")
    public WebElement programListTable;

    @FindBy(xpath = "(//li[@class='page-item'])[11]")
    public WebElement sayfaAtlama;


}