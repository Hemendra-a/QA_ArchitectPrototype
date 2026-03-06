package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseLib;
import pages.Button;
import pages.CheckBox_page;
import pages.Login;

public class Button_test extends BaseLib {
	Button ob;

	@Test(priority = 0)
	public void getLaunchtestingBaba() throws Exception {
		ob = new Button();
		System.out.println("Button Thread: " + Thread.currentThread().getId());
		Login ob1 = new Login();
		ob1.clickonCloseButton();
		ob1.clickonPractice();

	}

	@Test(priority = 1)
	public void clickonElements() throws InterruptedException {
		Thread.sleep(1000);
		ob.clickonElements();
	}

	@Test(priority = 2)
	public void clickonButton() throws InterruptedException {
		Thread.sleep(1000);
		ob.clickonButton();
	}

	@Test(priority = 3)
	public void clickondoubleclick() throws InterruptedException {
		Thread.sleep(1000);
		ob.clickondoubleclick();
	}

	@Test(priority = 4)
	public void clickonrightclick() throws InterruptedException {
		Thread.sleep(1000);
		ob.clickonrightclick();
	}

	@Test(priority = 5)
	public void clickonclickme() throws InterruptedException {
		Thread.sleep(1000);
		ob.clickonclickme();

	}

}
