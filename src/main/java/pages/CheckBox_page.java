package pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseLib;

public class CheckBox_page extends BaseLib{
	
	public CheckBox_page() {
		 PageFactory.initElements(factory.DriverManager.getDriver(), this);
	}
	@FindBy(xpath="//*[@class='btn btn-block p-0 text-left']")
	private WebElement elementsbutton;
	@FindBy(xpath="//*[text()='check box'] ")
	private WebElement CheckBoxButton;
	@FindBy(xpath="//*[@id='myCheck']")
	private WebElement mobileCheckBoxButton;
	@FindBy(xpath="//*[@id=\'tab_2\']/div/iframe")
	private WebElement frame;
	@FindBy(xpath="//*[@id='mylaptop']")
	private WebElement LaptopCheckBoxButton ;
	@FindBy(xpath="//*[@id='mydesktop']")
	private WebElement DesktopCheckBoxButton ;
	
	@FindBy(xpath="//*[@id='text']")
	private  WebElement mobileText;
	
	@FindBy(xpath="//*[@id='text1']")
	private  WebElement laptopText;
	
	@FindBy(xpath="//*[@id='text2']")
	private  WebElement desktopText;
	
	public void clickonElements() throws Exception {
		waitForElement(elementsbutton, 10);
		elementsbutton.click();
	}
	public void clickonCheckBox() throws Exception {
		waitForElement(CheckBoxButton, 10);
		CheckBoxButton.click();
	}

	public void mobileCheckBoxButton() throws Exception {
		factory.DriverManager.getDriver().switchTo().frame(frame);
		waitForElement(mobileCheckBoxButton, 10);
		mobileCheckBoxButton.click();
		String Text=mobileText.getText();
		assertEquals(Text, "You are selected Mobile");
		System.out.println("Text: "+Text);
		System.out.println(Text.equals("You are selected Mobile"));
		factory.DriverManager.getDriver().switchTo().defaultContent();
	}
	public void LaptopCheckBoxButton() throws Exception {
		factory.DriverManager.getDriver().switchTo().frame(frame);
		waitForElement(LaptopCheckBoxButton, 10);
		LaptopCheckBoxButton.click();
		String Text=laptopText.getText();
		assertEquals(Text, "You are Selected Laptop");
		System.out.println("Text: "+Text);
		System.out.println(Text.equals("You are Selected Laptop"));
		factory.DriverManager.getDriver().switchTo().defaultContent();
	}
	public void DesktopCheckBoxButton() throws Exception {
		factory.DriverManager.getDriver().switchTo().frame(frame);
		waitForElement(DesktopCheckBoxButton, 10);
		DesktopCheckBoxButton.click();
		String Text=desktopText.getText();
		assertEquals(Text, "You are Selected Desktop");//assertion/Hard
		System.out.println("Text: "+Text);
		System.out.println(Text.equals("You are Selected Desktop"));
	
		factory.DriverManager.getDriver().switchTo().defaultContent();
	}
}
