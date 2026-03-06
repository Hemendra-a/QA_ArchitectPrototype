 package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseLib;

public class browserwindows_page extends BaseLib {
	
	public browserwindows_page() {
		PageFactory.initElements(factory.DriverManager.getDriver(), this);
	}
	
	@FindBy(xpath="//*[@id='headingOne']/h2/button")
	private WebElement alertframebutton;
	@FindBy(xpath="//*[@href='#tab_11']")
	private WebElement browserwindowsbutton;
	@FindBy(xpath="//*[@href='https://www.google.co.in/']")
	private WebElement NewTab_button;
	@FindBy(xpath="//*[text()='New Window']")
	private WebElement NewWindow;
	@FindBy(xpath="//*[text()='New Window Message']")
	private WebElement NewWindowmsg;
	
	
	public void clickonalertframebutton() {
		alertframebutton.click();
	}
	public void clickonbrowserwindowsbutton() {
		browserwindowsbutton.click();
	}
	public void clickonNewTab_button() {
		NewTab_button.click();
	
	}
	public void clickonNewWindow() {
		
		NewWindow.click();
		String parent=factory.DriverManager.getDriver().getWindowHandle();
		System.out.println("parentwindow: "+parent);
		Set<String >allwindowid=factory.DriverManager.getDriver().getWindowHandles();
		System.out.println("all window are ");
		for(String childwindow:allwindowid) {
			System.out.println("all window are: "+childwindow);
			if(!parent.equalsIgnoreCase(childwindow)) {
				factory.DriverManager.getDriver().switchTo().window(childwindow);
				factory.DriverManager.getDriver().manage().window().maximize();
				factory.DriverManager.getDriver().getCurrentUrl();
				System.out.println("get current url is  "+factory.DriverManager.getDriver().getCurrentUrl());
				System.out.println("get title "+factory.DriverManager.getDriver().getTitle());
				factory.DriverManager.getDriver().get("https://www.youtube.com/");
				
			}
			
		}
		factory.DriverManager.getDriver().switchTo().window(parent);
		
	}
	public void clickonNewWindowmsg() throws InterruptedException {
		NewWindowmsg.click();
		String parent=factory.DriverManager.getDriver().getWindowHandle();
		System.out.println("parentwindow: "+parent);
		Set<String >allwindowid=factory.DriverManager.getDriver().getWindowHandles();
		System.out.println("all window are ");
		for(String childwindow:allwindowid) {
			System.out.println("all window are: "+childwindow);
			if(!parent.equalsIgnoreCase(childwindow)) {
				factory.DriverManager.getDriver().switchTo().window(childwindow);
				System.out.println("child window "+childwindow);
				Thread.sleep(5000);
				factory.DriverManager.getDriver().manage().window().maximize();
				factory.DriverManager.getDriver().getCurrentUrl();
				System.out.println("get current url is  "+factory.DriverManager.getDriver().getCurrentUrl());
				System.out.println("get title "+factory.DriverManager.getDriver().getTitle());
				
							}
			
		}
		factory.DriverManager.getDriver().switchTo().window(parent);
		
	}
	

}
