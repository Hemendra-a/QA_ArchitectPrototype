package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login extends BaseLib{

    @FindBy(xpath="//*[text()='×']")
    private WebElement closebutton;

    @FindBy(xpath="//*[text()='Practice']")
    private WebElement practicebutton;

    @FindBy(xpath="//*[@class='btn btn-block p-0 text-left']")
    private WebElement elementsbutton;

    // Constructor
    public Login() {
        PageFactory.initElements(factory.DriverManager.getDriver(), this);
    }

    public void getVerifyTitle() {
        String title = factory.DriverManager.getDriver().getTitle();
        System.out.println("title=" + title);
        Assert.assertEquals(title, "Testing Baba");
    }

    public void clickonCloseButton() throws Exception {
    	sleep(5);
    	waitForElement(closebutton, 50);
        closebutton.click();
    }

    public void clickonPractice() throws Exception {
    	waitForElement(practicebutton, 50);
        practicebutton.click();
    }

    public void clickonElements() throws Exception {
    	waitForElement(elementsbutton, 50);
        elementsbutton.click();
    }
}