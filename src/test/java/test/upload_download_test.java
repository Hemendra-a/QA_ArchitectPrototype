package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.CheckBox_page;
import pages.Login;
import pages.upload_download_page;

public class upload_download_test extends BaseLib {
	upload_download_page ob;

	@Test(priority = 0)
	public void getLaunchtestingBaba() throws Exception {
		ob = new upload_download_page();
		System.out.println("upload_download_page Thread: " + Thread.currentThread().getId());
		Login ob1 = new Login();
		ob1.clickonCloseButton();
		ob1.clickonPractice();

	}

	@Test(priority = 0)
	public void clickonElements() {

		ob.clickonElements();
	}

	@Test(priority = 1)
	public void clickonuploadanddownload() {
		ob.clickonuploadanddownload();
	}
//   @Test(priority=2)
//   public void clickonchoosefile(){
//	ob.clickonchoosefile();
//   }

}
