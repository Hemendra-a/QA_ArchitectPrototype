package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.SelectMenu_page;

public class SelectMenu_test extends BaseLib {
	SelectMenu_page ob;
	

		 @Test(priority=0)
		  public void getLaunchtestingBaba() throws Exception
		  {
			  ob = new SelectMenu_page ();
			  System.out.println("SelectMenu_page Thread: " + Thread.currentThread().getId());
			  Login ob1 = new Login(); 
			  ob1.clickonCloseButton();
			  ob1.clickonPractice();
			  
		  }
	  
	 @Test(priority=1)
	  public void clickonwidget() {
			ob.clickonwidget();
		}
	 @Test(priority=2)
	 public void clickonselectmenu() {
			ob.clickonselectmenu();
		}
	 @Test(priority=3)
		public void clickonselectbyvalue() {
			ob.clickonselectbyvalue();
		}
	 @Test(priority=4)
	 public void clickonselectbyone() {
		ob.clickonselectbyone();
		}
	 @Test(priority=5)
	 public void clickonmultiselect() {
			ob.clickonmultiselect();
		}
	 @Test(priority=6)
	 public void clickonmultiselectrobotclass() {
		   ob.clickonmultiselectrobotclass();
		
		}

}
