package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseLib;

public class mousehower_click_page extends BaseLib{

	public mousehower_click_page() {
		PageFactory.initElements(factory.DriverManager.getDriver(), this);
	}
	
	@FindBy(xpath="//*[@data-target='#widget']")
	private WebElement widgets;
	
	@FindBy(xpath="//*[@href='#tab_23']")
	private WebElement menu;
	
	@FindBy(xpath="//*[@id=\"navbar\"]/ul/li[4]/i")
	private WebElement blog;
	
	public void clickonwidgets() {
		widgets.click();
	}
	public void clickonmenu() {
		menu.click();
	}
	public void mousehower() {
		actMoveToElement(blog);
	}
    public void mousehowerandclick() {
    	mousehower_click(blog,"HTML");
    	mousehower_click(blog,"CSS");
    	mousehower_click(blog,"JavaScript");
    	mousehower_click(blog,"Python");
    	mousehower_click(blog,"PHP");
    	mousehower_click(blog,"Design");
	}
	

}
