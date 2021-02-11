package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class KaterinaPage {
	
	public KaterinaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}


}
