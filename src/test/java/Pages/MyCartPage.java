package Pages;

import Utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage extends CommonUtils {

    AppiumDriver driver;

    /*public MyCartPage(AppiumDriver driver) {
        this.driver = driver;
    }*/

    public MyCartPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //  platform = StatusLogger.Config.getInstance().getPlatform();
    }

    @iOSXCUITFindBy(xpath = "test")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue \"]")
    private WebElement Continue;

    @iOSXCUITFindBy(xpath = "test")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Place Order \")")
    private WebElement PlaceOrder;
    //By PlaceOrder = MobileBy.androidUIAutomator("new UiSelector().text(\"Place Order \")");


    public void PlaceOrderClick(){

        tapObject(PlaceOrder,"PlaceOrder");
    }

public String ContinueBtnDisplay(){
    String getText= getElementValues(Continue,"Continue");
    return getText;
}

}
