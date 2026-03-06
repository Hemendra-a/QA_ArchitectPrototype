package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseLib;

public class Frame_page extends BaseLib {
	public Frame_page() {
		PageFactory.initElements(factory.DriverManager.getDriver(), this);
	}
	@FindBy(xpath="//*[@id='headingOne']/h2/button")
	private WebElement alertframebutton;
	
	@FindBy(xpath="//*[@href='#tab_13']")
	private WebElement clickonframe;
	
	@FindBy(xpath="//*[@id='tab_13']/iframe[1]")
	private WebElement frame;
	@FindBy(xpath="/html/body/h1")
	private WebElement gettext;
	@FindBy(xpath="//*[@id=\"tab_13\"]/iframe[2]")
	private WebElement frame2;
	@FindBy(xpath="/html/body/h1")
	private WebElement gettext2;
	
	public void clickonframe() throws Exception {
		waitForElement(clickonframe, 50);
		clickonframe.click();
	}
	public void clickonalertframebutton() throws Exception {
		waitForElement(alertframebutton, 50);
		alertframebutton.click();
	}
	public void enterinparentframe1() throws Exception {
		waitForElement(frame, 50);
		factory.DriverManager.getDriver().switchTo().frame(frame);
		String text=gettext.getText();
		System.out.println( "Text "+text);
		factory.DriverManager.getDriver().switchTo().defaultContent();
	}
	public void enterinchildframe2() throws Exception {
		waitForElement(frame2, 50);
		factory.DriverManager.getDriver().switchTo().frame(frame2);
		String text2=gettext2.getText();
		System.out.println( "Text2 "+text2);
		factory.DriverManager.getDriver().switchTo().defaultContent();
	}

}
