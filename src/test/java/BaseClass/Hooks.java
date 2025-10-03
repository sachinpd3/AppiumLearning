package BaseClass;

import Utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Hooks extends CommonUtils {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public String text;
   @BeforeTest
   @Parameters({"platform"})
   public void Method1(String platform) throws MalformedURLException {
       PreReq(platform);
       extentReports("Android","MyFlipkart");
   }

    public void PreReq(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        if(platform.equalsIgnoreCase("Android")){
            capabilities.setCapability("automationName","UiAutomator2");
            capabilities.setCapability("PlatformName","Android");
            capabilities.setCapability("appium:udid","1707a4af");
            capabilities.setCapability("appium:unicodeKeyboard",true);
        }
     else{
         //for ios
        }
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appium:appWaitForLaunch", true);
        if(platform.equalsIgnoreCase("Android")) {
            driver.set(new AndroidDriver(new URL("http://0.0.0.0:4723/"), capabilities));

        }else {
            //for ios
        }

    }

@AfterTest
    public void after(){
       extent.flush();
}

}
