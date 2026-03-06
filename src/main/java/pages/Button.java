package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseLib;

public class Button extends BaseLib {
	
	public Button() {
		PageFactory.initElements(factory.DriverManager.getDriver(), this);
		
	}
	@FindBy(xpath="//*[@class='btn btn-block p-0 text-left']")
	private WebElement elementsbutton;
	@FindBy(xpath="//*[@href='#tab_5']")
	private WebElement Button;
	
	@FindBy(xpath="//*[@ondblclick='doubletext()']")
	private WebElement doubleclick;
	
	@FindBy(xpath="//*[@oncontextmenu='righttext()']")
	private WebElement rightclick;
	
	@FindBy(xpath="//*[@id=\"tab_5\"]/div[3]/button")
	private WebElement clickme;
	
	public void clickonElements() {
		elementsbutton.click();
	}
	
	public void clickonButton() {
		Button.click();
		
	}
	public void clickondoubleclick() {
		doubleclick(doubleclick);
	}
	
    public void clickonrightclick() {
    	rightclick(rightclick);
    	System.out.println(factory.DriverManager.getDriver().getCurrentUrl());
	}
    public void clickonclickme() {
    	clickme.click();
	}

}
