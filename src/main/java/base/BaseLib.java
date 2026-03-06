package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import factory.DriverManager;
import factory.Driverfactory;
import utils.WebUtils;


public class BaseLib extends WebUtils {

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        System.out.println("Setup Thread ID: " + Thread.currentThread().getId());
        DriverManager.setDriver(Driverfactory.createDriver(browser));
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get("https://www.testingbaba.com/old/");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
        	try {
        		Thread.sleep(5000);	
			} catch (Exception e) {
				// TODO: handle exception
			}
        
            DriverManager.quitDriver();
            System.out.println("Browser Closed. Thread ID: " + Thread.currentThread().getId());
        }
    }
}