package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.browserwindows_page;

public class browserwindows_test extends BaseLib{
	browserwindows_page ob;


	 
	 @Test(priority=0)
	  public void getLaunchtestingBaba() throws Exception
	  {
		 ob = new browserwindows_page();
		  System.out.println("browserwindows_page Thread: " + Thread.currentThread().getId());
		  Login ob1 = new Login(); 
		  ob1.clickonCloseButton();
		  ob1.clickonPractice();
		  
	  }
	 
	 @Test(priority=1)
	 public void clickonalertframebutton() throws InterruptedException {
		 Thread.sleep(2000);
		 ob.clickonalertframebutton();
	 }
	 @Test(priority=2)
	 public void clickonbrowserwindowsbutton() throws InterruptedException {
		 Thread.sleep(2000);
		 ob.clickonbrowserwindowsbutton();
	 }

	 @Test(priority=3)
	 public void clickonNewWindow() throws InterruptedException {
		 Thread.sleep(2000);
		 ob.clickonNewWindow();
	 }
	 @Test(priority=4)
	 public void clickonNewWindowmsg() throws InterruptedException {
		 Thread.sleep(2000);
		 ob.clickonNewWindowmsg();
	 }

	 
	 

}
