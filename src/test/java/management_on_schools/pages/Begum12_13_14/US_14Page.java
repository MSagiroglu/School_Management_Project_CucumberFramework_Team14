package management_on_schools.pages.Begum12_13_14;

import management_on_schools.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_14Page {
    public US_14Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table[@class='table table-striped table-bordered table-hover']")
    public WebElement table;
    @FindBy(xpath = "(//li[@class='page-item'])[4]")
    public WebElement lastPageButton;

    @FindBy(xpath = "//table//tr//th[1]")
    public WebElement confirmName;
    @FindBy(xpath = "//table//tr//th[2]")
    public WebElement confirmPhoneNumber;
    @FindBy(xpath = "//table//tr//th[3]")
    public WebElement confirmSSN;
    @FindBy(xpath = "//table//tr//th[4]")
    public WebElement confirmUserName;

    @FindBy(xpath = "((//button[@class='text-dark btn btn-outline-info'])[17]")
    public WebElement editButton;


}
