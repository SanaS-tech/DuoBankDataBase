package pages;

import javafx.scene.input.InputMethodTextRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class KaterinaApplicationPage {


	public KaterinaApplicationPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath = "//a[@href='applications.php']")
	public WebElement applicationList;

	public void clickOnBorrower(String borrower) {

		String xpath = "//td[.='"+borrower+"']/following-sibling::td/a";
		Driver.getDriver().findElement(By.xpath(xpath)).click();
	}

	@FindBy (xpath = "//table[4]/tbody/tr/td")
	public WebElement employerName;

	@FindBy (xpath = "//table[4]/tbody/tr/td/following-sibling::td")
	public WebElement position;

	@FindBy (xpath = "//table[4]/tbody/tr/following-sibling::tr/td")
	public WebElement city;

	@FindBy (xpath = "//table[5]/tbody/tr/td")
	public WebElement grossMonthlyIncome;

	@FindBy (xpath = "//table[5]/tbody/tr/td/following-sibling::td")
	public WebElement monthlyOvertime;

	@FindBy (xpath = "//table[5]/tbody/tr/td/following-sibling::td[2]")
	public WebElement monthlyBonuses;

	@FindBy (xpath = "//table[5]/tbody/tr[2]/td")
	public WebElement monthlyCommission;

	@FindBy (xpath = "//table[5]/tbody/tr[2]/td/following-sibling::td")
	public WebElement monthlyDividends;

	@FindBy (xpath = "//table[7]/tbody/tr/td")
	public WebElement declarer;

	@FindBy (xpath = "//table[7]/tbody/tr/td[2]")
	public WebElement declarerFirstName;

	@FindBy (xpath = "//table[7]/tbody/tr/td[3]")
	public WebElement declarerLastName;

	@FindBy (xpath = "//table[7]/tbody/tr[2]/td")
	public WebElement declarerEmail;



}
