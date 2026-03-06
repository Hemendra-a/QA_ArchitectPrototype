package test;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.TextBox_page;

public class TextBox_test extends BaseLib {
	TextBox_page ob;

	@Test(priority = 0)
	public void getLaunchtestingBaba() throws Exception {
		ob = new TextBox_page();
		System.out.println("TextBox_page Thread: " + Thread.currentThread().getId());
		Login ob1 = new Login();
		ob1.clickonCloseButton();
		ob1.clickonPractice();

	}

	@Test(priority = 1)
	public void clickonElements(ITestContext test) throws InterruptedException {
		Thread.sleep(1000);
		ob.clickonElements();
	}

	@Test(priority = 2)
	public void clickonTexBoxButton() throws InterruptedException {
		Thread.sleep(1000);
		ob.clickonTexBoxButton();
	}

	@Test(priority = 3)
	public void sendTextFullName() throws InterruptedException {
		Thread.sleep(1000);

		ob.sendTextFullName();
	}

	@Test(priority = 4)
	public void sendTextfullemail1() throws InterruptedException {
		Thread.sleep(1000);
		ob.sendTextfullemail1();
	}

	@Test(priority = 5)
	public void sendTextfulladdresh1() throws InterruptedException {
		Thread.sleep(1000);
		ob.sendTextfulladdresh1();
	}

	@Test(priority = 6)
	public void sendTextPaddresh1() throws InterruptedException {
		Thread.sleep(1000);
		ob.sendTextPaddresh1();
	}

	@Test(priority = 7)
	public void clickonSubmitButton() throws InterruptedException {

		ob.clickonSubmitButton();
		Thread.sleep(5000);

	}

}
