package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static BaseClass.Hooks.driver;

public class CommonUtils {
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static ExtentTest node;
    public static ExtentReports extent = new ExtentReports();
    public static String reportFolderPath = "C:\\production\\Appium\\reports";
    public static void extentReports(String platform, String appName) {

//        spark.config().setTimelineEnabled(true);
        spark = new ExtentSparkReporter(reportFolderPath + "/" + platform + "" + appName + "" + getCurrentDateTime() + ".html");
        spark.config().setCss(
                ".header { animation: zoomIn 0.5s; }" +
                        ".test.pass { animation: fadeIn 0.5s ease-in-out; }" +
                        ".test.fail { animation: shake 0.5s; }" +
                        ".test-summary { animation: pulse 1.5s infinite; }" +
                        ".test:hover { background-color: #f0f8ff; transform: scale(1.02); transition: 0.3s ease-in-out; }" +
                        "@keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }" +
                        "@keyframes shake { 0%, 100% { transform: translateX(0); } 25% { transform: translateX(-5px); } 50% { transform: translateX(5px); } 75% { transform: translateX(-5px); } }" +
                        "@keyframes zoomIn { from { transform: scale(0.5); } to { transform: scale(1); } }" +
                        "@keyframes pulse { 0% { transform: scale(1); } 50% { transform: scale(1.05); } 100% { transform: scale(1); } }"
        );
        spark.config().setDocumentTitle(appName + "Automation Report");
        spark.config().setReportName(platform + appName);
        extent.attachReporter(spark);
    }
    public static String getCurrentDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Define a custom date and time format if needed
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        // Format the current date and time using the formatter
        return currentDateTime.format(formatter);
    }


    public void tapObject(WebElement webElement,String reportInfo){
        webElement.click();
        node.info("Clicked On ["+  reportInfo+"]");

    }

    public void inputMethod(WebElement webElement,String reportInfo,String inputValues){
        webElement.sendKeys(inputValues);
        node.info("Entered ["+inputValues+"] On ["+  reportInfo+"]");
    }

    public String  getElementValues(WebElement webElement,String reportInfo){
       String text= webElement.getText();
        node.info("Fetched value  ["+  reportInfo+"]");
        return text;
    }



    public  void scrollToElement(AppiumDriver driver, String text) {
        try {
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

        } catch (Exception e) {
          //  logInfo("Element not found: " + text);
        }
    }
    public static String getBase64(AppiumDriver driver) {
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return base64;
    }


}
