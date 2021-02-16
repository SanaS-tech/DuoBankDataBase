package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SanaPage {

	public SanaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy (xpath = "//div[@class='text-center']//a")
	public WebElement LogInLink;

	@FindBy (xpath = "//input[@id='exampleInputEmail1']")
	public WebElement emailAddressLogIn;

	@FindBy (xpath = "//input[@id='exampleInputPassword1']")
	public WebElement passwordLogIn;

	@FindBy (xpath = "//button[@class='btn btn-primary glow w-100 position-relative']")
	public WebElement login;

	@FindBy (xpath = "//span[@class='user-name']")
	public WebElement userName;

	@FindBy (xpath = "//a[@href='mortagage.php']")
	public WebElement mortgageButton;

	@FindBy (xpath = "(//span[@class='menu-item'])[2]")
	public WebElement applicationListButton;

	@FindBy (xpath = "//a[@href='mortagageloandegtails.php?id=202']")
	public WebElement viewDetailsButton;

	@FindBy (xpath = "(//table[@class='table']//tbody//td)[1]")
	public WebElement bName;

	@FindBy (xpath = "(//table[@class='table']//tbody//td)[2]")
	public WebElement bEmail;

	@FindBy (xpath = "(//table[@class='table']//tbody//td)[3]")
	public WebElement bDateOfBirth;

	@FindBy (xpath = "(//table[@class='table']//tbody//td)[5]")
	public WebElement bMaritalStatus;

	@FindBy (xpath = "(//table[@class='table']//tbody//td)[8]")
	public WebElement bRentOwn;

	@FindBy (xpath = "(//table[@class='table']//tbody//td)[9]")
	public WebElement bMonthlyExpense;

}
