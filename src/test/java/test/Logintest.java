package test;





import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseLib;
import pages.Login;

public class Logintest extends BaseLib {
    Login ob;

    @Test(priority=0)
    public void getTitle() {
        ob = new Login(); // driver automatically ThreadLocal safe
        ob.getVerifyTitle();
        System.out.println("Login Thread: " + Thread.currentThread().getId());
    }

    @Test(priority=1)
    public void clickonCloseButton() throws Exception {
        ob.clickonCloseButton();
    }

    @Test(priority=2)
    public void clickonpractice() throws Exception {
        ob.clickonPractice();
    }

    @Test(priority=3)
    public void clickonElements() throws Exception {
        ob.clickonElements();
    }
}