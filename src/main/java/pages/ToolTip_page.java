package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseLib;

public class ToolTip_page extends BaseLib {

	public ToolTip_page() {
		PageFactory.initElements(factory.DriverManager.getDriver(), this);
	}

	@FindBy(xpath = "//*[@data-target='#widget']")
	private WebElement Widgets;

	@FindBy(xpath = "//*[@href='#tab_22']")
	private WebElement ToolTip;

	@FindBy(xpath = "//*[@class='btn btn-primary'][@data-toggle='tooltip']")
	private WebElement mousehower;

	public void clickonwidgets() {
		Widgets.click();
	}

	public void clickonToolTip() {
		ToolTip.click();
	}

	public void HandelHover() {
		actMoveToElement(mousehower);
		String ToolTip = mousehower.getAttribute("title");
		System.out.println("ToolTip :" + ToolTip);
	}

}
