package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.ToolTip_page;

public class ToolTip_Test extends BaseLib {
	ToolTip_page ob;

	@Test(priority = 0)
	public void getLaunchtestingBaba() throws Exception {
		ob = new ToolTip_page();
		System.out.println("ToolTip_page Thread: " + Thread.currentThread().getId());
		Login ob1 = new Login();
		ob1.clickonCloseButton();
		ob1.clickonPractice();

	}

	@Test(priority = 1)
	public void clickonwidgets() {
		ob.clickonwidgets();
	}

	@Test(priority = 2)
	public void clickonToolTip() {
		ob.clickonToolTip();
	}

	@Test(priority = 4)
	public void HandelHover() {
		ob.HandelHover();
	}

}
