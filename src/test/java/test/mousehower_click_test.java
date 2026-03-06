package test;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.mousehower_click_page;

public class mousehower_click_test extends BaseLib {
	mousehower_click_page ob;
   
	  
		 @Test(priority=0)
		  public void getLaunchtestingBaba() throws Exception
		  {
			  ob = new mousehower_click_page();
			  System.out.println("mousehower_click_page Thread: " + Thread.currentThread().getId());
			  Login ob1 = new Login(); 
			  ob1.clickonCloseButton();
			  ob1.clickonPractice();
			  
		  }
	  
	 @Test(priority=1)
	 public void clickonwidgets() {
			ob.clickonwidgets();
		}
	 @Test(priority=2)
		public void clickonmenu() {
			ob.clickonmenu();
		}
	 @Test(priority=3)
		public void mousehower() {
			ob.mousehower();
		}
	 @Test(priority=4)
	    public void mousehowerandclick() {
			ob.mousehowerandclick();
		}
		
}
