package factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	protected final static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	private DriverManager() {}
	
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }

}
