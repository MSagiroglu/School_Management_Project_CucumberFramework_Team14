package management_on_schools.pages.YektaUS24_25;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YektaUS_24_25 {
    public YektaUS_24_25() {PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//button[.='Menu']")
    public WebElement menu;
    @FindBy(xpath = "//a[.='Teacher Management']")
    public WebElement teacherManagement;
    @FindBy(xpath = "//h3[.='Teacher Management']")
    public WebElement gettoTeacherManagement;
    @FindBy (xpath = "//div[@class=' css-19bb58m']")
    public WebElement chooseLessons;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement name;
    @FindBy(xpath = "//input[@id='isAdvisorTeacher']")
    public WebElement isAdvisorTeacher;
    @FindBy(xpath = "(//input[@name='gender'])[2]")
    public WebElement gender;
    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary btn-lg']")
    public WebElement submit;
    @FindBy(xpath = "//div[@class=' css-19bb58m']")
    public WebElement lessons;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement message;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement errorMessage;
    @FindBy(xpath = "//a[.='Student Management']")
    public WebElement studentManagement;

    //Student
    @FindBy(xpath = "//input[@id='name']")
    public WebElement studentName;
    @FindBy(xpath = "//input[@id='surname']")
    public WebElement studentSurname;
    @FindBy(xpath = "//input[@id='birthPlace']")
    public WebElement studentBirthPlace;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement studentEmail;
    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement studentPhoneNumber;
    @FindBy(xpath = "(//input[@class='form-check-input'])[2]")
    public WebElement studentMale;
    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement studentBirthDay;
    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement studentSsn;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement studentUsername;
    @FindBy(xpath = "//input[@id='fatherName']")
    public WebElement studentFathername;
    @FindBy(xpath = "//input[@id='motherName']")
    public WebElement studentMothername;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement studentPassword;
    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary btn-lg']")
    public WebElement studentSubmit;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement studentMessage;
    @FindBy(xpath = "//select[@id='advisorTeacherId']")
    public WebElement studentAdvisorTeacher;




}
