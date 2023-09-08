package management_on_schools.pages.MehmetAli22_23;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Us_22_23Page {
    public Us_22_23Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@href='/login']")
    public WebElement anaSayfaloginButonu;
    @FindBy(xpath = "//*[@type='text']")
    public WebElement loginUserNameAlani;
    @FindBy(xpath = "//*[@type='password']")
    public WebElement loginPasswordAlani;
    @FindBy(xpath = "(//*[@type='button'])[3]")
    public WebElement loginButonu;
    @FindBy(xpath = "(//*[@type='text'])[1]")
    public WebElement nameAlani;
    @FindBy(xpath = "(//*[@type='text'])[2]")
    public WebElement surnameAlani;
    @FindBy(xpath = "(//*[@type='text'])[3]")
    public WebElement birthPlaceAlani;
    @FindBy(xpath = "//*[@id='birthDay']")
    public WebElement dateOfBirthAlani;
    @FindBy(xpath = "(//*[@type='text'])[6]")
    public WebElement usernameAlani;
    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordAlani;
    @FindBy(xpath = "(//*[@type='text'])[4]")
    public WebElement phoneNumberAlani;
    @FindBy(xpath = "(//*[@type='text'])[5]")
    public WebElement ssnAlani;
    @FindBy(xpath = "(//*[@name='gender'])[1]")
    public WebElement genderFemale;
    @FindBy(xpath = "(//*[@name='gender'])[2]")
    public WebElement genderMale;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert;
    @FindBy(xpath = "(//*[text()='Admin Management'])[2]")
    public WebElement adminLoginVerify;


    //Invalid Feedback Message Locates
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[1]")
    public WebElement nameInvalidFeedback;
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[2]")
    public WebElement surnameInvalidFeedback;
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[3]")
    public WebElement birthPlaceInvalidFeedback;
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[4]")
    public WebElement dateOfBirthInvalidFeedback;
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[5]")
    public WebElement phoneNumberInvalidFeedback;
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[6]")
    public WebElement ssnNumberInvalidFeedback;
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[7]")
    public WebElement usernameInvalidFeedback;
    @FindBy(xpath = "(//*[@class='invalid-feedback'])[8]")
    public WebElement passwordInvalidFeedback;

    //US23 Locates
    @FindBy(xpath = "//*[text()='Vice Dean Management']")
    public WebElement viceDeanManagementButton;
    @FindBy(xpath = "//*[@class='text-white']")
    public WebElement viceDeanVerify;

}
