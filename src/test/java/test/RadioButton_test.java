package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.RadioButton_page;

public class RadioButton_test extends BaseLib {
	RadioButton_page ob;
	 
	 @Test(priority=0)
	  public void getLaunchtestingBaba() throws Exception
	  {
		  ob = new RadioButton_page();
		  System.out.println("RadioButton_page Thread: " + Thread.currentThread().getId());
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
	  public void clickonRadioButton() throws InterruptedException {
		 Thread.sleep(2000);
		 ob.clickonRadioButton();
		
		}
	 @Test(priority=3)
	  public void clickonYesButton() throws InterruptedException {
		 Thread.sleep(2000);
			ob.clickonYesButton();
		}
	 @Test(priority=4)
	  public void clickonImpressiveButton() throws InterruptedException {
		 Thread.sleep(2000);
			ob.clickonImpressiveButton();
		}
	 @Test(priority=5)
	  public void clickonNoButton() throws InterruptedException {
		 Thread.sleep(2000);
			ob.clickonNoButton();
			
		}


}
