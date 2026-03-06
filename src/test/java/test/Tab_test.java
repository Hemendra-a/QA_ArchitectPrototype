package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.Tab_page;

public class Tab_test extends BaseLib {
	Tab_page ob;

	@Test(priority = 0)
	public void getLaunchtestingBaba() throws Exception {
		ob = new Tab_page();
		System.out.println("Tab_page Thread: " + Thread.currentThread().getId());
		Login ob1 = new Login();
		ob1.clickonCloseButton();
		ob1.clickonPractice();

	}

	@Test(priority = 1)
	public void clickonwidgets() {
		ob.clickonwidgets();
	}

	@Test(priority = 2)
	public void clickonTab() {
		ob.clickonTab();
	}

	@Test(priority = 3)
	public void gettextTab1() throws InterruptedException {
		ob.gettextTab1();

	}

	@Test(priority = 4)
	public void gettextTab2() throws InterruptedException {
		ob.gettextTab2();

	}

	@Test(priority = 5)
	public void gettextTab3() throws InterruptedException {
		ob.gettextTab3();

	}

}
