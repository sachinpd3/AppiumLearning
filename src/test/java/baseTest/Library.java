package baseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Library {
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    //private AppiumDriver driver;
    String text;

    @BeforeTest
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

    @Test
    public void ClickOncart(){
        driver.get().findElement(By.xpath("//android.widget.TextView[@text=\"Cart\"]")).click();
        // driver.findElement(By.xpath("//android.widget.TextView[@text=\"Cart\"]")).click();
        // driver.get().findElement()
        driver.get().findElement(MobileBy.androidUIAutomator("new UiSelector().text(\"Place Order \")")).click();
        text=driver.get().findElement(By.xpath("//android.widget.TextView[@text=\"Continue \"]")).getText();
        System.out.println(text);
        if(text.equals("Continue ")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
    }




}
