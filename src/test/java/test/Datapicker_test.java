package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Datapicker_page;
import pages.Login;



public class Datapicker_test  extends BaseLib{
	
	Datapicker_page ob;

	  
		 @Test(priority=0)
		  public void getLaunchtestingBaba() throws Exception
		  {
			  ob = new Datapicker_page();
			  System.out.println("Datapicker_page Thread: " + Thread.currentThread().getId());
			  Login ob1 = new Login(); 
			  ob1.clickonCloseButton();
			  ob1.clickonPractice();
			  
		  }
	  
	 @Test(priority=1)
	 public void clickonwidgets() {
		 ob.clickonwidgets();
			
		}
	 @Test(priority=2)
		public void clickondatapicker() {
		ob.clickondatapicker();
		}
	 @Test(priority=3)
		public void clickonselectdate() {
			ob.clickonselectdate();
		}
	 @Test(priority=4)
	 public void selectdate_timePS() {
			ob.selectdate_timePS();
	 }
	 @Test(priority=5)
	 public void selectgetdate_time()  {
			ob.selectgetdate_time();
			
			
		}
//	 @AfterTest
//     public void teardown() {
//    	 driver.quit();
//     }
}
