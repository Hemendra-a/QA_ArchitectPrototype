package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.ProgressBar_page;


public class ProgressBar_test extends BaseLib{
	 ProgressBar_page ob;

	 
	 @Test(priority=0)
	  public void getLaunchtestingBaba() throws Exception
	  {
		  ob = new  ProgressBar_page();
		  System.out.println("ProgressBar_page Thread: " + Thread.currentThread().getId());
		  Login ob1 = new Login(); 
		  ob1.clickonCloseButton();
		  ob1.clickonPractice();
		  
	  }
	 
	 @Test(priority=1)
	 public void clickonwidgets() {
		ob.clickonwidgets();
		}
	 @Test(priority=2)
	    public void clickonprogressbarbutton() {
	    ob.clickonprogressbarbutton();
		}
	 @Test(priority=3)
	    public void widthbeforestart() {
	    	ob.widthbeforestart();
	  	}
	 @Test(priority=4)
	    public void clickonStart() throws InterruptedException {
	    	ob.clickonStart();
	   	}
	 @Test(priority=5)
	    public void widthafterstart() {
	    	ob.widthafterstart();
	   	}
		

}
