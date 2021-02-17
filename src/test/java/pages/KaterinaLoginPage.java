package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class KaterinaLoginPage {

    public KaterinaLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "exampleInputEmail1")
    public WebElement email;

    @FindBy (id = "exampleInputPassword1")
    public WebElement password;

    @FindBy (name = "login")
    public WebElement loginButton;

}
