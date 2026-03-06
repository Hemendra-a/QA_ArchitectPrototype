package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
@Getter
public class WebUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions actions;
    public static String elementName;
	public static String screenshotName;
    /*
     * []--launchBrowser-- launchBrowser() - is used to initialize all the driver
     * Also maximizing and deleting all cookies. ImplicitWait for 60Seconds.
     *
     * @parameter- browserName
     *
     *
     * @returnType- WebDriver
     */
    private // Configure Chrome options
            ChromeOptions options = new ChromeOptions();

    public WebDriver launchBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Chrome driver loaded successfully");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            System.out.println("Window maximized successfully");
        } catch (Exception e) {
//            driver = new ChromeDriver();
            System.out.println("unable to launch chrome browser due to " + e.getMessage());
        }
        return driver;
    }

    /*
     * []--implicitWait-- implicitWait() - is used to provide implicit wait to
     * driver
     *
     * @parameter- timeInSeconds:
     *
     *
     * @returnType- void
     */
//    public void implicitWait(int timeInSeconds) {
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
//        System.out.println("Implicit wait applied for " + timeInSeconds + " in seconds");
//
//    }

    /*
     * []--defaultImplicitWait-- defaultImplicitWait() - is used to provide implicit
     * wait to driver
     *
     * @parameter-
     *
     *
     * @returnType- void
     */
    public void defaultImplicitWait() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Implicit wait applied for  in seconds");

    }

    /*
     * []--findElement-- findElement() - This method is used to find the element in
     * case is stale
     *
     * @parameter- xpath-locator
     *
     * @returnType- WebElement
     */

    public WebElement findElement(String xpath) {
        WebElement element = null;

        element = driver.findElement(By.xpath(xpath));

        return element;
    }

    public void sleep(int i) {
        int num = i * 1000;
        try {
            Thread.sleep(num);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void openURL(String url) {
        driver.get(url);
        System.out.println("Opened URL: " + url);
    }

    /*
     * []--Click-- Click() - is used to perform click on specific element
     *
     * @parameter- element-reference variable for WebElement
     *
     * @returnType- void
     */
    public void click(WebElement element) {
        try {

            element.click();
            System.out.println(" clicked successfully");
        } catch (ElementNotInteractableException e) {
            System.out.println(" not interactable Trying JavaScriptExecutor");
            jsClick(element);

        }
    }

    /*
     * []--sendKeys-- sendKeys() - is used to perform sendKey any value to specific
     * element
     *
     * @parameter- element-reference variable for WebElement sendKeyValue-
     * sendKeyValue is a value used for input in input field
     *
     * @returnType- void
     */
    public void sendKeys(WebElement element, String sendKeyValue) {

        System.out.println(" field clear before input value");
        element.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        element.sendKeys(sendKeyValue);
        System.out.println(sendKeyValue + " entered in input field successfully");

    }

    /*
     * []--frameHandle-- frameHandle(String nameOrId) - is used to handle the frame
     *
     * @parameter- nameOrId- by passing frame name or id we Can Handle the frame.
     *
     * @returnType- void
     */
    public void frameHandle(String nameOrId) {
        driver.switchTo().frame("frame");

    }

    /*
     * []--frameHandle-- frameHandle(int index) - is used to handle the frame by
     * using index
     *
     * @parameter- index - by passing index we Can Handle the frame.
     *
     * @returnType- void
     */
    public void frameHandle(int index) {

        driver.switchTo().frame(index);

    }

    /*
     * []--frameHandle-- frameHandle(WebElement element) - is used to handle the
     * frame by using index
     *
     * @parameter- index - by passing index we Can Handle the frame.
     *
     * @returnType- void
     */
    public void frameHandle(WebElement element) {

        driver.switchTo().frame(element);

    }

    public String getInnerText(WebElement element) {
        String actualText = element.getText();
        System.out.println(actualText);
        return actualText;
    }

    // ===============================================Validation&AssertionMethod=================================

    public void validateInnerText(WebElement element, String expectedText) {
        String actualText = getInnerText(element);
        if (actualText.equalsIgnoreCase(expectedText)) {
            System.out.println("Validation pass... where Actual- " + actualText + ", Expected- " + expectedText);
        } else {
            System.out.println("Validation pass... where Actual- " + actualText + ", Expected- " + expectedText);
        }
        Assert.assertEquals(element.getText(), expectedText);
        System.out.println(element.getText() + " field text is " + expectedText);
    }

    public boolean verifyEnabled(WebElement element) {
        boolean elementStatus = false;

        if (element.isEnabled()) {
            elementStatus = true;
            System.out.println("Element is enabled");
        }

        return elementStatus;
    }

    public boolean verifyDisabled(WebElement element) {
        boolean elementStatus = element.isEnabled();
        if (elementStatus == false) {
            System.out.println("Element is disabled");
        } else {
            System.out.println("Element is not disabled");
        }
        Assert.assertEquals(element.isEnabled(), false);
        return elementStatus;
    }

    public boolean isCheckBoxChecked(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean isChecked = (Boolean) js.executeScript("return arguments[0].checked;", element);
        return Boolean.TRUE.equals(isChecked);
    }

    public boolean verifyCheckboxChecked(WebElement element) {
        boolean elementStatus = element.isSelected();
        if (elementStatus == true) {
            System.out.println("checkbox is checked");
        } else {
            System.out.println("checkbox is not checked");
        }
        Assert.assertEquals(element.isSelected(), true);
        return elementStatus;
    }

    public void verifyCheckboxUnChecked(WebElement element) {
        boolean elementStatus = element.isSelected();
        if (elementStatus == false) {
            System.out.println("checkbox is unchecked");
        } else {
            System.out.println("checkbox is not unchecked");
        }
        Assert.assertEquals(element.isSelected(), false);
    }

    public void verifyPageTitle(String expectedPageTitle) {
        Assert.assertEquals(driver.getTitle(), expectedPageTitle);
        System.out.println("Actual page title " + driver.getTitle() + " is title " + expectedPageTitle);
    }

    public void verifyPageUrl(String expectedPageUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedPageUrl);
        System.out.println("Actual page url " + driver.getCurrentUrl() + " is url " + expectedPageUrl);

    }
    // ===============================================javaScriptExecutorFunctions====================

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToBottom() {
        JavascriptExecutor js;

        // Scroll to the bottom of the page
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("successfully scroll to Bottom of the Page");

    }

    public void scrollToTopOfPage() {

        // Scroll to the bottom of the page
        js = (JavascriptExecutor) driver;

        js.executeScript("scroll(0, -250);");
        System.out.println("successfully scroll to Bottom of the Page");

    }

    public void jsSendKeys(WebElement element, String sendKeyValue) {

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + sendKeyValue + "'");

    }

    public void jsScrollToElement(WebElement element) {
        elementName = element.toString();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(elementName + " scroll into view");
    }

    public void jsScrollToElementAndClick(WebElement element) {

        // Initialize the JavaScript Executor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll the element into view
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(elementName + " scrolled into view");

        // Click the element using JavaScript
        jsExecutor.executeScript("arguments[0].click();", element);
        System.out.println("Clicked on " + elementName);
    }

    // =========================================TakeScreenShotMethod=====================================

    public String getAttributeVale(WebElement element) {
        String attributeValue;

        attributeValue = element.getAttribute("value");
        System.out.println("Attribute value for the element is " + attributeValue);

        return attributeValue;
    }

    public static void captureScreenshot(WebDriver driver) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/report/" +  screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

    // all WindowSwitch Code & Parent Code
    public void switchToWindowByUrl(String windowUrl) {
        Set<String> handleValue = driver.getWindowHandles();
        for (String handle : handleValue) {
            driver.switchTo().window(handle);
            String url = driver.getCurrentUrl();
            if (url.contains(windowUrl)) {
                break;
            }
        }
    }

    public void switchToWindowByPageTitle(String expectedPageTitle) {
        Set<String> handleValue = driver.getWindowHandles();
        for (String handle : handleValue) {
            driver.switchTo().window(handle);
            String actualPageTitle = driver.getTitle();
            if (actualPageTitle.equalsIgnoreCase(expectedPageTitle)) {
                break;
            }
        }
    }

    public void switchToParentWindow() {

        driver.switchTo().defaultContent();
    }

//    public void downLoadPdf() {
//        ChromeOptions options = new ChromeOptions();
//        String downloadFilePath = "outputFolder";
//
//        // Update to your desired download path
//
//        // Set preferences for Chrome
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", downloadFilePath);
//        prefs.put("download.prompt_for_download", false);
//        prefs.put("plugins.always_open_pdf_externally", true); // Disable PDF viewer
//        options.setExperimentalOption("prefs", prefs);
//    }
//==========================================================

    /*
     * []* Set explicit wait for an element to be clickable.
     *
     * @parameter- element the locator of the element
     *
     * @param timeoutInSeconds the maximum time to wait
     *
     * @return the WebElement when clickable
     */
    public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /*
     * Set explicit wait for an element to be visible.
     *
     * @param element the locator of the element
     *
     * @param timeoutInSeconds the maximum time to wait
     *
     * @return the WebElement when visible
     */
    public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /*-waitForElementPresence()--
     *                  Set explicit wait for an element to be present in the DOM.
     *
     * @param        locator     the locator of the element
     * @param       timeoutInSeconds the maximum time to wait
     * @return the WebElement when present
     */
    public WebElement waitForElementPresence(By locator, int timeoutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        System.out.println("Waiting for the element should be present");

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    /*
     * Set fluent wait for a condition.
     *
     * @param locator the locator of the element
     *
     * @param timeoutInSeconds the maximum time to wait
     *
     * @param pollingInSeconds the interval between checks
     *
     * @return the WebElement when the condition is met
     */
    public WebElement waitForConditionUsingFluentWait(By locator, int timeoutInSeconds, int pollingInSeconds) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingInSeconds)).ignoring(NoSuchElementException.class);

        return fluentWait.until(driver -> driver.findElement(locator));
    }

    // ============================================Actions
    public void actMoveToElement(WebElement element) {

        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        System.out.println("Hovered to the element ");

    }

    /*
     * []--actClick(WebElement element)-- This Method is used to click on target
     * element by using Actions class
     *
     * @parameter- element-
     *
     *
     * @return- void
     */
    public void actClick(WebElement element) {

        actions = new Actions(driver);
        actions.click(element).build().perform();
        System.out.println("Action clicked successfully");
    }

    public WebElement getSelectedOptions(WebElement element) {
        Select selObj = new Select(element);

        return selObj.getFirstSelectedOption();
    }

    /*
     * []--actScrollToElement(int x,int y)-- This Method is used to Scroll by using
     * Actions class
     *
     * @parameter- x:- refers to x-axis y:- refers to y-axis
     *
     * @return- void
     */
    public void actScrollToElement(int x, int y) {

        actions = new Actions(driver);
        actions.scrollByAmount(x, y).build().perform();
        System.out.println("Actions scroll to Element successfully ");

    }

    public void actDoubleClickOnElement(WebElement element) {
        actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
        System.out.println("Double clicked successfully");

    }
    /*
     * []--actScrollToElement()-- This Method is used to Scroll by using Actions
     * class
     *
     * @parameter- element:- element refers to WebElement
     *
     *
     * @return- void
     */

    public void actScrollToElement(WebElement element) {

        actions = new Actions(driver);
        actions.scrollToElement(element).build().perform();
        System.out.println(" is scrolled successfully");
    }
    /*
     * []--actionSendKeys()-- This Method is used to send value in input box by
     * using Actions class
     *
     * @parameter- element:- element refers to WebElement sendKeyValue:- Value which
     * send to the input box
     *
     * @return- void
     */

    public void actionSendKeys(WebElement element, String sendKeyValue) {
        actions = new Actions(driver);
        actions.sendKeys(sendKeyValue).perform();
        System.out.println("Action sendKeys perform successfully " + sendKeyValue);
    }

    /*
     * []--selectByVisibleText()-- This Method is used to select value in a dropdown
     * by Using its index
     *
     * @parameter- element:- element refers to WebElement visibleText:- visibleText
     * is used to select dropdown by passing its index value .
     *
     * @return- void
     */
    public void selectByVisibleText(WebElement element, String visibleText) {
        Select selObj = new Select(element);
        selObj.selectByVisibleText(visibleText);
        System.out.println(visibleText + " dropdown element selected");

    }

    /*
     * []--selectByValue()-- This Method is used to select value in a dropdown by
     * Using its value
     *
     * @parameter- element:- element refers to WebElement byValue:- value is used to
     * select dropdown by passing its value.
     *
     * @return- void
     */
    public void selectByValue(WebElement element, String byValue) {
        Select selObj = new Select(element);
        selObj.selectByValue(byValue);
        System.out.println(byValue + " dropdown element selected");

    }

    /*
     * []--selectByIndex()-- This Method is used to select value in a dropdown by
     * Using its index
     *
     * @parameter- element:- element refers to WebElement index:- index is used to
     * select dropdown by passing its index value .
     *
     * @return- void
     */
    public void selectByIndex(WebElement element, int index) {
        Select selObj = null;

        selObj = new Select(element);
        selObj.selectByIndex(index);
        System.out.println(index + " dropdown element selected");

    }

    /*
     * []--listOfAllElementInDropDown()-- This Method is used to select value in a
     * dropdown by Using its index
     *
     * @parameter- element:- element refers to WebElement index:- index is used to
     * select dropdown by passing its index value .
     *
     * @return- List<WebElement>--> I
     */
    public List<WebElement> listOfAllElementInDropDown(WebElement element) {
        Select selObj = null;

        selObj = new Select(element);

        assert selObj != null;
        return selObj.getOptions();
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {

            return false;
        }
    }

//	public boolean isElementVisible(WebElement ele, int timeoutInSeconds) {
//		boolean isElementVisible = false;
//
//		try {
//			if (waitForElementToBeVisible(ele, timeoutInSeconds).isDisplayed()) {
//
//				isElementVisible = true;
//
//			}
//		} catch (Exception e) {
//
//		}
//
//		return isElementVisible;
//	}



    public boolean isElementVisible( WebElement ele, int timeoutInSeconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(500)) // Polling every 500 milliseconds
                .ignoring(NoSuchElementException.class);

        try {
            WebElement visibleElement = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return ele.isDisplayed() ? ele : null;
                }
            });
            return visibleElement != null;
        } catch (Exception e) {
            return false;
        }
    }


    // Updated By Dheeraj
    public List<String> listOfElementName(List<WebElement> elements) {
        List<String> names = new ArrayList<>();
        for (WebElement we : elements) {
            names.add(we.getText());
        }
        return names;
    }

    public String getSelectedOptionText(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public String getAttributeValue(WebElement element) {
        String attributeValue = element.getAttribute("value");
        System.out.println("Attribute value for the element is " + attributeValue);

        return attributeValue;
    }

    public List<String> listOfAllOptionsInDropDown(WebElement element) {
        Select selObj = null;
        List<String> options = new ArrayList<String>();

        selObj = new Select(element);
        for (WebElement option : selObj.getOptions()) {
            String text = option.getText();
            options.add(text);
        }
        return options;
    }

    public String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date currentDateTime = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(currentDateTime);
    }

    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public LocalDateTime getLocalDateTimeLogs() {
        return LocalDateTime.now();
    }

    public String getLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }

    // This method checks if the page has fully loaded by querying the browser's
    // document.readyState
    public boolean isPageLoaded() {
        try {
            // Execute JavaScript to get the readyState of the page
            String pageState = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");

            // If the page is fully loaded, the readyState will be 'complete'
            return pageState.equals("complete");
        } catch (Exception e) {
            System.out.println("Error checking page load status: " + e.getMessage());
            return false; // Return false if there's any issue in checking the page state
        }
    }

    // Method to wait for a page to load with a timeout
    public void waitForPageLoad(int timeoutInSeconds) throws Exception {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) / 1000 < timeoutInSeconds) {
            if (isPageLoaded()) {
                return;
            }
            sleep(1); // Wait 1 second before checking again
        }
        throw new Exception("Page load timeout exceeded.");
    }

    // Method to wait for an element to be present with a timeout
    public void waitForElement(WebElement element, int timeoutInSeconds) throws Exception {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) / 1000 < timeoutInSeconds) {
            if (element.isDisplayed()) {
                return;
            }
            sleep(1); // Wait 1 second before checking again
        }
        throw new Exception("Element load timeout exceeded.");
    }

    public int getRandomInteger() {
        Random random = new Random();
        return random.nextInt(); // Generates a random integer
    }

    public void waitForLoaderDisable(int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until((ExpectedCondition<Boolean>) wd -> (Boolean) ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void waitForLoaderToDisappear() {
    
        if(isElementVisible(driver.findElement(By.xpath("//div[@id='divLoading']/p//img")), 5)) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='divLoading']/p//img"))));
        }

    }
    public void waitForLoaderToDisappear(WebElement webElement) {
    	   if(isElementVisible(webElement,5)) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    	   }
    }
    public Alert isAlertVisible(int timeoutInSeconds) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void robotEnterPress() throws AWTException {
		Robot robot = new Robot();
		// Wait for "Save As" dialog to appear

		robot.keyPress(KeyEvent.VK_ENTER); // Press Enter
		sleep(1);
		robot.keyRelease(KeyEvent.VK_ENTER); // Release Enter key
		System.out.println("Save As dialog handled successfully");
	}

	public void robotSelectAndCopyAll() throws AWTException {
		Robot robot = new Robot();
		sleep(3); // Wait for "Save As" dialog to appear

		// Select all text (Ctrl + A)
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		sleep(1);

		// Copy selected text (Ctrl + C)
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		sleep(1);
	}

	// Method to release only Ctrl, A, and C keys
	public void releaseCtrlAandC() throws AWTException {
		Robot robot = new Robot();
		int[] keys = { KeyEvent.VK_CONTROL, KeyEvent.VK_A, KeyEvent.VK_C };

		for (int key : keys) {
			robot.keyRelease(key); // Release each key safely
		}
	}

	public void downloadFileWithJs(String currentUrl, String quoteNoValue, int sleepSeconds) {

		// JavaScript for downloading the file
		String jsScript = "var link = document.createElement('a');" + "link.href = '" + currentUrl + "';"
				+ "link.download = '" + quoteNoValue + ".pdf';" + "document.body.appendChild(link);" + "link.click();"
				+ "document.body.removeChild(link);";

		// Execute the JavaScript
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Optional sleep to ensure execution timing
		sleep(2);

		jsExecutor.executeScript(jsScript);
		System.out.println("File download triggered: " + quoteNoValue + ".pdf");

	}

	public boolean isAlertVisibleNew(int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
    
	public void jsSendKeysNew(WebElement element, String sendKeyValue) {

	    js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].value='" + sendKeyValue + "'",element);

	}

	/**
     * Fetches numeric values from a dropdown and returns them as a list of integers.
     *
     * @param driver The WebDriver instance.
     * @param dropdownLocator The locator of the dropdown element.
     * @return A list of integers representing the numeric values in the dropdown.
     */
    public  List<Integer> getNumericValuesFromDropdown(WebElement element) {
        // Find the dropdown element
  
        // Initialize the Select object
        Select dropdown = new Select(element);
        
        // Retrieve all options
        List<WebElement> options = dropdown.getOptions();
        
        // Create a list to store numeric values
        List<Integer> numericValues = new ArrayList<>();
        
        // Iterate through the options
        for (WebElement option : options) {
            try {
                // Parse the option text to an integer and add to the list
                numericValues.add(Integer.parseInt(option.getText().trim()));
            } catch (NumberFormatException e) {
                // Handle cases where the option text is not a number
                System.out.println("Skipping non-numeric option: " + option.getText());
            }
        }
        
        return numericValues;
    }
    

	public void doubleclick(WebElement ele) {
		 Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
		
		
	}


	public void rightclick(WebElement ele) {
		 Actions act=new Actions(driver);
		act.contextClick(ele).perform();
		//act.contextClick().perform();
		
		
	}


	public void elementtobeclickable(WebElement ele, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time)); 
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		;
	}


	public void Alert(int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time)); 
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public String getdate() {
		String value="";
		try {
			Date sb = new Date();
			DateFormat db= new SimpleDateFormat("dd-MM-yyyy");
			value=db.format(sb);
			
		} catch (Exception e) 
		{
			System.out.println("Issue in get date"+e);
		}
		
		return value;
	}
	
	public String getdate_time() {
		String value="";
		try {
			Date sb = new Date();
			DateFormat db= new SimpleDateFormat("hhmm");
			
			value=db.format(sb);
			
			
		} catch (Exception e) 
		{
			System.out.println("Issue in get date"+e);
		}
		
		return value;
	}
	
	public void mousehower_click(WebElement ele, String target) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();//when we need to perform more than one actionbuild.perform
		driver.findElement(By.linkText(target)).click();
	}
	
	public void multiselect(WebElement ele) {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_SPACE);
			
			robot.keyRelease(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
		} catch (Exception e) {
			
			System.out.println("issue in selectmenu");
		}
		
		
	}
	
	public String getReaddata(String path, int sheetno, int colno, int rowno) {
	String value="";
		try {
			FileInputStream fis=new  FileInputStream(path);//Java FileInputStream class obtains input bytes from a file.
			XSSFWorkbook wb=new XSSFWorkbook(fis);// This class has methods to read and write Microsoft Excel and OpenOffice xml files in .xls or .xlsx format.
			XSSFSheet sheet=wb.getSheetAt(sheetno);
			value=sheet.getRow(rowno).getCell(colno).getStringCellValue();
		} catch (Exception e) {
		System.out.println("Issue in get data");
		}
		return value;
	}
	
}