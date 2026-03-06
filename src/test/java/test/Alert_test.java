package test;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.Alert_page;
import pages.CheckBox_page;
import pages.Login;

public class Alert_test extends BaseLib {
	Alert_page ob;


		 @Test(priority=0)
		  public void getLaunchtestingBaba() throws Exception
		  {
			  ob = new Alert_page();
			  System.out.println("Alert_page Thread: " + Thread.currentThread().getId());
			  Login ob1 = new Login(); 
			  ob1.clickonCloseButton();
			  ob1.clickonPractice();
			  
		  }
	 @Test(priority=1)
	 public void clickonalertframe() {
		 ob.clickonalertframe();
	 }
	 @Test(priority=2)
	 public void clickonalertbutton() {
		 ob.clickonalertbutton();
	 }
	 @Test(priority=3)
	 public void clickonclickmealert() {
		 ob.clickonclickmealert();
	 }
     @Test(priority=4)
     public void clickmeafter5sec() {
    	
    	 ob.clickmeafter5sec();
     }
     @Test(priority=5)
     public void clickonmyconfirm() {
    	
    	 ob.clickonmyconfirm();
     }
     @Test(priority=6)
     public void clickonmypromt()  {
    	
    	 ob.clickonmypromt() ;
     }

}
