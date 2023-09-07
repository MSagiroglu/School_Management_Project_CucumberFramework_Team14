package management_on_schools.pages;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
    public Home_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //--> Ana sayfa ve Logout için gerekli tüm web elementler
    @FindBy(xpath = "//a[@class='header_link me-2']")
    public WebElement homePageRegisterButton;//--> Anasayfadaki Register butonu
    @FindBy(xpath = "//input[@id='name']")
    public WebElement registerNameField;//--> Register sayfasındaki Name alanı
    @FindBy(xpath = "//a[@class='header_link ms-2']")
    public WebElement homePageLoginButton;//--> Anasayfadaki Login butonu
    @FindBy(xpath = "//input[@id='username']")
    public WebElement loginEmailField;//--> Login sayfasındaki Email alanı
    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginPasswordField;//--> Login sayfasındaki Password alanı
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;//--> Login sayfasındaki Login butonu
    @FindBy(xpath = "//a[normalize-space()='Contact']")
    public WebElement contactButton;//--> Anasayfadaki Contact butonu
    @FindBy(xpath = "//input[@id='name']")
    public WebElement contactNameField;//--> Anasayfadaki Contact Kısmındaki Name alanı
    @FindBy(xpath = "//button[normalize-space()='Menu']")
    public WebElement menuButton;//--> Anasayfadaki Menu butonu
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement logoutButton;//--> Anasayfadaki Logout butonu
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    public WebElement logOutYesButton;//--> Logout sayfasındaki Yes butonu







    //-->



}
