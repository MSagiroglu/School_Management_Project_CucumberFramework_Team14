package management_on_schools.pages.Suleyman_US15_21;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_15Page {
    public US_15Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button)[1]")
    public WebElement stdMenuButonu;//--> Menu Butonu

    @FindBy(xpath = "//a[normalize-space()='Student Management']")
    public WebElement studentManagementButton;//--> Student Management Butonu

    @FindBy(id = "advisorTeacherId") //"//select//option[text()='Team 14 at']"
    public WebElement chooseAdvisorTeacherDdm; //--> Choose Advisor Teacher Butonu

    @FindBy(xpath = "//*[@id='name']")
    public WebElement stdNameButonu;//--> Name Butonu

    @FindBy(xpath = "//*[@id='surname']")
    public WebElement stdSurnameButonu;//--> Surname Butonu

    @FindBy(xpath = "//*[@id='birthPlace']")
    public WebElement stdBirthPlacenameButonu;//--> Birth Place Butonu

    @FindBy(xpath = "//input[@id='email']")
    public WebElement stdEmailButonu;//--> Email Butonu

    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement stdTelButonu;//--> Telefon Butonu

    @FindBy(xpath = "//input[@value='FEMALE']")//(//input)[6]
    public WebElement femaleCheckBoxButonu;//--> Female CheckBox Butonu

    @FindBy(xpath = "//input[@value='MALE']") //(//input)[7]
    public WebElement maleCheckBoxButonu;//--> Male CheckBox Butonu
    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement dateOfBirthButonu;//--> Date Of Birth Butonu
    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement stdSsnButonu;//--> Ssn Butonu
    @FindBy(xpath = "//input[@id='username']")
    public WebElement stdUSerNameButonu;//--> User Name Butonu

    @FindBy(xpath = "//input[@id='fatherName']")
    public WebElement stdFatherNameButonu;//--> Father Name Butonu

    @FindBy(xpath = "//input[@id='motherName']")
    public WebElement stdMotherNameButonu;//--> Mother Name  Butonu

    @FindBy(xpath = "//input[@id='password']")
    public WebElement stdPasswordButonu;//--> Password Butonu
    @FindBy(xpath = "(//button)[5]")
    public WebElement stdSubmitButonu;//--> Submit Butonu

    @FindBy(xpath = "//*[@role='alert']")//"//div[text()='Student updated Successfully']"
    public WebElement studentUpdatedSuccessfullyYazisi;//--> Student updated Successfully Butonu


    @FindBy(xpath = "(//li[@class='page-item'])[1]")
    public WebElement stdilkSayfaButonu;//--> Ilk Sayfa Butonu

    @FindBy(xpath = "(//li//a[@class='page-link'])[4]")
    public WebElement stdsonSayfaButonu;//--> Son Sayfa Butonu

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement stdLogOutButonu;//--> Log Out Butonu

    @FindBy(xpath = "//button[normalize-space()='Yes']")
    public WebElement stdUs15LogoutYesButton;//--> Logout Yes Butonu

    @FindBy(xpath = "//input[@id='name']")
    public WebElement stdUs15ReqiredNameGorunumu;//--> Name Required

    @FindBy(xpath = "//input[@id='surname']")
    public WebElement stdUs15ReqiredSurnameGorunumu;//--> Surname Required

    @FindBy(xpath = "//input[@id='birthPlace']")
    public WebElement stdUs15ReqiredBirthPlaceGorunumu;//--> Birth Place  Required

    @FindBy(xpath = "//input[@id='email']")
    public WebElement stdUs15ReqiredSEmailGorunumu;//--> Email Required

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement stdUs15ReqiredPhoneNumberGorunumu;//--> Phone Number Required

    @FindBy(xpath = "//input[@value='FEMALE']")
    public WebElement femaleCheckBoxGorunumu;//--> Female CheckBox Butonu

    @FindBy(xpath = "//input[@value='MALE']")
    public WebElement maleCheckBoxGorunumu;//--> Male CheckBox Butonu

    @FindBy(xpath = "//input[@id='birthDay']")
    public WebElement stdUs15ReqiredDateOfBirthGorunumu;//--> Date Of Birth Required

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement stdUs15ReqiredSsnGorunumu;//--> SSN Required
    @FindBy(xpath = "//*[text()='Minimum 11 character (XXX-XX-XXXX)']")
    public WebElement stdUs15Minimum11CharacterSsnGorunumu;//--> SSN Minimum 11 Character Required

    @FindBy(xpath = "//input[@id='username']")
    public WebElement stdUs15ReqiredUsernameGorunumu;//--> Username Required

    @FindBy(xpath = "//input[@id='fatherName']")
    public WebElement stdUs15ReqiredFatherNameGorunumu;//--> Father Name Required

    @FindBy(xpath = "//input[@id='motherName']")
    public WebElement stdUs15ReqiredMotherNameGorunumu;//--> Mother Name Required

    @FindBy(xpath = "//input[@id='password']")
    public WebElement stdUs15PasswordAtLeast8CharactersGorunumu;//--> At Least 8 Characters Password Required

    @FindBy(xpath = "//*[text()='One lowercase character']")
    public WebElement stdUs15PasswordOneLowercaseCharacterGorunumu;//--> One lowercase Character Required
}
