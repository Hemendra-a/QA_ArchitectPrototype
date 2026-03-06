package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Frame_page;
import pages.Login;

public class Frame_test extends BaseLib {
	Frame_page ob;
	 @Parameters("env")
   
	 
	 @Test(priority=0)
	  public void getLaunchtestingBaba() throws Exception
	  {
		 ob = new Frame_page();
		  System.out.println("Frame_page Thread: " + Thread.currentThread().getId());
		  Login ob1 = new Login(); 
		  ob1.clickonCloseButton();
		  ob1.clickonPractice();
		  
	  }
	 
	 @Test(priority=1)
	 public void clickonalertframebutton() throws Exception {
		
		 ob.clickonalertframebutton();
	 }
	 @Test(priority=2)
	 public void clickonframe() throws Exception {
		
		 ob.clickonframe();
	 }
	 @Test(priority=3)
	 public void enterinparentframe1() throws Exception{
		
		 ob.enterinparentframe1();
	 }
	 @Test(priority=4)
	 public void enterinchildframe2() throws Exception{
		
		 ob.enterinchildframe2();
	 }


}
