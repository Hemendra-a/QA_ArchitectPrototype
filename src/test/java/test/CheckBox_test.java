package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;

public class CheckBox_test extends BaseLib {
	CheckBox_page ob;

	 @Test(priority=0)
	  public void getLaunchtestingBaba() throws Exception
	  {
		  ob = new CheckBox_page();
		  System.out.println("Checkbox Thread: " + Thread.currentThread().getId());
		  Login ob1 = new Login(); 
		  ob1.clickonCloseButton();
		  ob1.clickonPractice();
		  
	  }
	  
	  @Test(priority=1)
	  public void clickonElements() throws Exception {
			ob.clickonElements();
		}
	  @Test(priority=2)
		public void clickonCheckBox() throws Exception {
			ob.clickonCheckBox();
		}
	  @Test(priority=3)
	  public void mobileCheckBoxButton() throws Exception {
			ob.mobileCheckBoxButton();
		}
	  @Test(priority=4)
	  public void LaptopCheckBoxButton() throws Exception {
			ob.LaptopCheckBoxButton();
		}
	  @Test(priority=5)
	  public void DesktopCheckBoxButton() throws Exception {
			ob.DesktopCheckBoxButton();
			
		}

	  
}
