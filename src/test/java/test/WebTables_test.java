package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.WebTables_page;

public class WebTables_test extends BaseLib {
	WebTables_page ob;
	 
	 @Test(priority=0)
	  public void getLaunchtestingBaba() throws Exception
	  {
		 ob = new WebTables_page();
		  System.out.println("WebTables_page Thread: " + Thread.currentThread().getId());
		  Login ob1 = new Login(); 
		  ob1.clickonCloseButton();
		  ob1.clickonPractice();
		  
	  }
	 
	 @Test(priority=1)
	  public void clickonElements() throws InterruptedException  {
		 Thread.sleep(2000);
			ob.clickonElements();
		}
	 
	 
	 @Test(priority=2)
	  public void clickonWebTablesbutton() throws InterruptedException  {
		 Thread.sleep(1000);
			ob.clickonWebTablesbutton();
			
		}
	 

	 @Test(priority=3)
	 public void filldetails() throws InterruptedException {
		 Thread.sleep(1000);
		 ob.filldetails();
	 }
	 
	 @Test(priority=4)
	 public void editdetails() throws InterruptedException {
		 Thread.sleep(1000);
		 
		 ob.editdetails();
	 }
	 
	 @Test(priority=5)
	 public void matched_Data()throws InterruptedException {
		 Thread.sleep(1000);
		 ob.matched_Data();
		
	 }

}
