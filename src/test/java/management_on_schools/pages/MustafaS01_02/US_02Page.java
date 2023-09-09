package management_on_schools.pages.MustafaS01_02;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_02Page {
    public US_02Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[normalize-space()='Guest User']")//--> Admin sayfasındaki Guest User butonun
    public WebElement guestUserButton;
    @FindBy(xpath = "//table/tbody/tr/td")//---> Admin sayfasındaki Guest User tablosu.
    public List<WebElement>  guestUserTable;
    @FindBy(xpath = "//span[contains(text(),'›')]")//--> Guest User Sayfasındaki ileri butonun
    public WebElement guestUserIleriButton;
    @FindBy(xpath = "//div[@class='d-flex justify-content-start ps-5 col']")//--> Guest User Sayfasındaki tablo sayısı
    public WebElement guestUserTableCount;
}
