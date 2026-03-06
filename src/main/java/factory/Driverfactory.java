package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//public class Driverfactory {
//
//    public static WebDriver createDriver(String instancedriver) {
//        if (instancedriver.equalsIgnoreCase("Chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*"); // CDP warning avoid
//            options.addArguments("--disable-extensions");
//            options.addArguments("--incognito"); // parallel-safe
//            return new ChromeDriver(options);
//        } else if (instancedriver.equalsIgnoreCase("Edge")) {
//            return new EdgeDriver();
//        } else if (instancedriver.equalsIgnoreCase("Firefox")) {
//            return new FirefoxDriver();
//        } else {
//            throw new IllegalArgumentException("Browser not supported: " + instancedriver);
//        }
//    }
//}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.URL;

public class Driverfactory {

    public static WebDriver createDriver(String instancedriver) {

        WebDriver driver = null;

        try {

        	URL gridUrl = new URL("http://localhost:4444");

            if (instancedriver.equalsIgnoreCase("Chrome")) {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");
                options.addArguments("--incognito");
                options.addArguments("--disable-dev-shm-usage");

                driver = new RemoteWebDriver(gridUrl, options);

            } else if (instancedriver.equalsIgnoreCase("Edge")) {

                EdgeOptions options = new EdgeOptions();
                driver = new RemoteWebDriver(gridUrl, options);

            } else if (instancedriver.equalsIgnoreCase("Firefox")) {

                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(gridUrl, options);

            } else {
                throw new IllegalArgumentException("Browser not supported: " + instancedriver);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }
}
