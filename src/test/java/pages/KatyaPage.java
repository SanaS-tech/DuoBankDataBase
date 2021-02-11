package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Driver;

public class KatyaPage {
	
	public KatyaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	

}
