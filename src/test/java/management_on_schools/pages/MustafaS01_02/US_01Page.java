package management_on_schools.pages.MustafaS01_02;

import management_on_schools.utilities.Driver;
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
    @FindBy(xpath = "//div[@class='invalid-feedback']")//--> Register sayfasınfdaki Required mseajı
    public WebElement requiredMessage;



}
