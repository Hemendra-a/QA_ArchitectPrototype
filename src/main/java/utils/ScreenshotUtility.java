//package utils;
//
//import Reader.PropertiesReader;
//import base.BaseLib;
//
//import org.openqa.selenium.*;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//
//import java.nio.file.Files;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Base64;
//
//public class ScreenshotUtility extends BaseLib{
//    // @Override
////    public WebDriver getDriver() {
////        return super.getDriver();
////    }
//    private WebUtils webObj;
//    private PropertiesReader prop;
//    public ScreenshotUtility(WebUtils webObj, PropertiesReader prop) {
//        this.webObj = webObj;
//        this.prop=prop;
//    }
//
//    /**
//     * Captures a screenshot and converts it to a byte array.
//     *
//     * @return byte array representing the screenshot
//     * @throws IOException if there is an issue with file handling
//     */
//
//    public String captureScreenShotOfElement(WebElement element) {
//
//        return element.getScreenshotAs(OutputType.BASE64);
//    }
//
//    public String takeScreenshotBase64() {
//        // Take a screenshot and store it in base64 format
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//    }
//
//    public void takeScreenShot(String RegNumber,String insurer) {
//        TakesScreenshot tss = (TakesScreenshot) driver;
//        File fileFrom = tss.getScreenshotAs(OutputType.FILE);
//        LocalDateTime localDateTime = LocalDateTime.now();
//        String foldername = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//
//        File directory = new File("src\\outputFile\\"+insurer+"\\" + "Failed"+"\\"+foldername);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//        File fileTo = new File(directory, RegNumber + ".png");
//        try {
//            Files.copy(fileFrom.toPath(), fileTo.toPath());
//            System.out.println("ScreenShot Taken Successfully");
//        } catch (IOException e) {
//            System.out.println("ScreenShot could not be taken");
//        }
//    }
//
//    public String scrAshot(WebElement element, String ID_RegNo, int zoomPercentage,String insurer) {
//        String base64String = null;
//        try {
//            // Open the desired URL
//            // Open the desired URL
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
//
//            // Locate the web element
//            // Scroll within the container to make sure it's fully loaded
//            // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop =
//            // arguments[0].scrollHeight", element);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//            // Take screenshot of the full element using AShot
//            // Capture full element screenshot using AShot with scrolling strategy
//            Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()) // Get exact coordinates
//                    // of the element
//                    .takeScreenshot(driver, element);
//
//            // Save the screenshot
//            // ImageIO.write(screenshot.getImage(), "PNG", new
//            // File("C:\\Users\\mohitnagpal\\Desktop\\PB_QuoteGenerationProcess\\src\\outputFile\\"+"full-element-screenshot-ashot.png"));
//            LocalDateTime localDateTime = LocalDateTime.now();
//            String formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//            String foldername = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
////            ImageIO.write(screenshot.getImage(), "PNG", new File("src\\outputFile\\" +"Premium_Summary"+ID_RegNo+ formattedDate + ".png"));
//
//            File outputFolder = new File("src/outputFile/"+insurer+"/" +"Passed"+"/"+ foldername);
//            if (!outputFolder.exists()) {
//                outputFolder.mkdirs();
//            }
//            File outputFile = new File(outputFolder, ID_RegNo + formattedDate + ".png");
//            ImageIO.write(screenshot.getImage(), "PNG", outputFile);
//
//            System.out.println("Screenshot saved : For the premium Summary ");
//            // Zoom back to 100% after taking the screenshot
//            js.executeScript("document.body.style.zoom='100%'");
//            // Get the BufferedImage from the Screenshot object
//
//            BufferedImage image = screenshot.getImage();
//
//            // Convert the BufferedImage to byte array
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(image, "png", baos);
//            byte[] imageBytes = baos.toByteArray();
//
//            // Convert byte array to Base64 String (optional, if needed for further use)
//            base64String = Base64.getEncoder().encodeToString(imageBytes);
//            System.out.println("Base64 String: " + base64String);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return base64String;
//    }
//
//}