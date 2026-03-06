package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import base.BaseLib;

public class SelectMenu_page extends BaseLib {

	public SelectMenu_page () {
		PageFactory.initElements(factory.DriverManager.getDriver(), this);
	}
	
	@FindBy(xpath="//*[@data-target='#widget']")
	private WebElement widget;
	
	@FindBy(xpath="//*[@href='#tab_24']")
	private WebElement selectmenu;
	
	@FindBy(xpath="//*[@id='tab_24']/form/div/div[1]/select")
	private WebElement selectbyvalue;
	
	@FindBy(xpath="//*[@id='tab_24']/form/div/div[2]/select")
	private WebElement selectbyone;
	
	@FindBy(xpath="//*[@id='tab_24']/form/div/div[5]/div/select")
	private WebElement multiselect;
	public void clickonwidget() {
		widget.click();
	}
	public void clickonselectmenu() {
		selectmenu.click();
	}
	public void clickonselectbyvalue() {
		selectByValue(selectbyvalue,"Group 1, Option 1");
		selectByValue(selectbyvalue,"Group 1, Option 2");
		selectByValue(selectbyvalue,"Group 2, Option 1");
		selectByValue(selectbyvalue,"Group 2, Option 2");
	
	}
	public void clickonselectbyone() {
		selectByValue(selectbyone,"HTML");
		selectByValue(selectbyone,"CSS");
		selectByValue(selectbyone,"PHP");
		selectByValue(selectbyone,"Bootstrap");
		selectByValue(selectbyone,"Java");
		selectByValue(selectbyone,"HTTPS");
		
	}
	public void clickonmultiselect() {
		selectByValue(multiselect,"HTML");
		selectByValue(multiselect,"CSS");
		selectByValue(multiselect,"PHP");
		selectByValue(multiselect,"javascript");
	}
	public void clickonmultiselectrobotclass() {
	    multiselect.click();
	    multiselect(multiselect);
	}
}
