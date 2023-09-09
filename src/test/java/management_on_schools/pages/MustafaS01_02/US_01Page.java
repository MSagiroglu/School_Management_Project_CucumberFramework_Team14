package management_on_schools.pages.MustafaS01_02;

import management_on_schools.utilities.Driver;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_01Page {
    public US_01Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='surname']")//--> Register sayfasınfdaki Surname alanı
    public WebElement surname;
    @FindBy(xpath = "//input[@id='birthPlace']")//--> Register sayfasınfdaki Birth Place alanı
    public WebElement birthPlace;
    @FindBy(xpath = "//input[@id='phoneNumber']")//--> Register sayfasınfdaki Phone alanı
    public WebElement phoneNumber;
    @FindBy(xpath = "//input[@value='FEMALE']")//--> Register sayfasınfdaki Female alanı
    public WebElement female;
    @FindBy(xpath = "//input[@value='MALE']")//--> Register sayfasınfdaki Male alanı
    public WebElement male;
    @FindBy(xpath = "//input[@id='birthDay']")//--> Register sayfasınfdaki Birth Day alanı
    public WebElement birthDay;
    @FindBy(xpath = "//input[@id='ssn']")//--> Register sayfasınfdaki Ssn alanı
    public WebElement ssn;
    @FindBy(xpath = "//input[@id='username']")//--> Register sayfasınfdaki Username alanı
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")//--> Register sayfasınfdaki Password alanı
    public WebElement password;
    @FindBy(xpath = "//button[@class='fw-semibold btn btn-primary']")//--> Register sayfasınfdaki Register butonu
    public WebElement registerButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;
    @FindBy(xpath = "//div[normalize-space()='Required']")//--> Register sayfasınfdaki Required mseajı
    public WebElement requiredMessage;
    @FindBy(xpath = "//div[normalize-space()='Minimum 11 character (XXX-XX-XXXX)']")//--> Register sayfasınfdaki Minimum 11 character (XXX-XX-XXXX) mseajı
    public WebElement requiredMessageSSSmin;
    @FindBy(xpath = "//div[normalize-space()='Enter your password']")//--> Register sayfasınfdaki Enter your password mseajı
    public WebElement requiredPassword;
    @FindBy(xpath = "//div[normalize-space()='At least 8 characters']")//--> Register sayfasınfdaki At least 8 characters mesajı
    public WebElement requiredAtLeast8Password;

    @FindBy(xpath = "//div[normalize-space()='One uppercase character']")//--> Register sayfasınfdaki One uppercase character mesajı
    public WebElement requiredUpperCasePassword;
    @FindBy(xpath = "//div[normalize-space()='One lowercase character']")//--> Register sayfasınfdaki One lowercase character mesajı
    public WebElement requiredLowerCasePassword;
    @FindBy(xpath = "//div[normalize-space()='One number']")//--> Register sayfasınfdaki One number mesajı
    public WebElement requiredNumberPassword;


}
