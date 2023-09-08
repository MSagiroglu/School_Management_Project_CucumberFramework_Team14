package management_on_schools.pages.Begum12_13_14;
import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_13Page {
    public US_13Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "react-select-3-placeholder")
    public WebElement ChooseLesson;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "surname")
    public WebElement surname;
    @FindBy(id = "birthPlace")
    public WebElement birthPlace;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(id = "phoneNumber")
    public WebElement phoneNumber;
    @FindBy(id = "ssn")
    public WebElement ssn;
    @FindBy(xpath = "//input[@value='FEMALE']")
    public WebElement genderFemale;
    @FindBy(css = "[class='form-check']")
    public WebElement isAdvisorTeacher;
    @FindBy(id = "birthDay")
    public WebElement dateOfBirth;
    @FindBy(id = "username")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//a[text()='Vice Dean Management']")
    public WebElement viceDeanMangement;
    @FindBy(xpath = "//a[text()='Teacher Management']")
    public WebElement teacherMangement;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement submitAddTeacher;

    //Required
    @FindBy(xpath = "//*[@id='name' and @class='form-control is-invalid']")
    public WebElement nameRequired;
    @FindBy(xpath = "//*[@id='surname' and @class='form-control is-invalid']")
    public WebElement surNameRequired;
    @FindBy(xpath = "//*[@id='birthPlace' and @class='form-control is-invalid']")
    public WebElement birthPlaceRequired;
    @FindBy(xpath = "//*[@id='email' and @class='form-control is-invalid']")
    public WebElement emailRequired;
    @FindBy(xpath = "//*[@id='phoneNumber' and @class='form-control is-invalid']")
    public WebElement phoneNumberRequired;
    @FindBy(xpath = "//*[@id='birthDay' and @class='form-control is-invalid']")
    public WebElement birthDayRequired;
    @FindBy(xpath = "//*[@id='ssn' and @class='form-control is-invalid']")
    public WebElement sSNRequired;
    @FindBy(xpath = "//*[@id='password' and @class='form-control is-invalid']")
    public WebElement passwordRequired;
    @FindBy(css = "div[role='alert'] div:nth-child(2)")
    public WebElement dersSecilmediUyari;
    @FindBy(xpath = "//div[text()='Your name should be at least 2 characters']")
    public WebElement invalidNameWarning;
    @FindBy(xpath = "//div[text()='You have entered an invalid value. Valid values are: MALE, FEMALE']")
    public WebElement invalidGenderSelectWarning;
    @FindBy(xpath = "//div[text()='Please enter valid email']")
    public WebElement pleaseEnterValidEmailMessage;
    @FindBy(xpath = "//div[text()='Your email should be between 5 and 50 characters']")
    public WebElement emailShouldBe5_50;
    @FindBy(xpath = "//div[normalize-space()='Minimum 12 character (XXX-XXX-XXXX)']")
    public WebElement phoneNumber12Message;
    @FindBy(xpath = "//div[text()='geçmiş bir tarih olmalı']")
    public WebElement dogumGunuGecmisBirTarihOlmali;
    @FindBy(xpath = "//div[text()='Please enter valid SSN number']")
    public WebElement pleaseEnterValidSSNNumberMessage;
    @FindBy(xpath = "//div[text()='Full authentication is required to access this resource']")
    public WebElement fullAuthenticationWanrning;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement teacherSavedMessage;
    @FindBy(xpath = "//*[@id='username' and @class='form-control is-invalid']")
    public WebElement usernameRequired;
    @FindBy(xpath = "//*[text()='Teacher saved successfully']")
    public WebElement teacherSavedMessage2;
    @FindBy(xpath = "//div[normalize-space()='At least 8 characters']")
    public WebElement passwordAtLeast8CharactersMessage;
    @FindBy(xpath = "//div[normalize-space()='One uppercase character']")
    public WebElement passwordOneUpperCaseCharacterMessage;
    @FindBy(xpath = "//div[normalize-space()='One number']")
    public WebElement passwordOneNumberMessage;
    @FindBy(xpath = "//div[normalize-space()='One lowercase character']")
    public WebElement passwordOneLowerCaseCharacterMessage;
    @FindBy(xpath = "//div[normalize-space()='Minimum 11 character (XXX-XX-XXXX)']")
    public WebElement ssnMin11CharacterMessage;
    @FindBy(xpath = "//a[text()='Lesson Management']")
    public WebElement lessonManagement;



}
