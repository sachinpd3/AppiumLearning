package BaseClass;

import Utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Hooks extends CommonUtils {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public String text;
   @BeforeTest
   public void Method1() throws MalformedURLException {
       PreReq();
       extentReports("Android","MyFlipkart");
   }

    public void PreReq() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("PlatformName","Android");
        capabilities.setCapability("appium:udid","1707a4af");
        capabilities.setCapability("appium:unicodeKeyboard",true);
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appium:appWaitForLaunch", true);
        driver.set(new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities));
        // driver=new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities);

    }

@AfterTest
    public void after(){
       extent.flush();
}

}
