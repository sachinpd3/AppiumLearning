package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MyCartPage {

    AppiumDriver driver;

    public MyCartPage(AppiumDriver driver) {
        this.driver = driver;
    }

    By PlaceOrder = MobileBy.androidUIAutomator("new UiSelector().text(\"Place Order \")");
    By Continue = By.xpath("//android.widget.TextView[@text=\"Continue \"]");

    public void PlaceOrderClick(){
        driver.findElement(PlaceOrder).click();
    }

public String validateContinueBtnDisplay(){
        driver.findElement(PlaceOrder).click();
        String getText=  driver.findElement(Continue).getText();
        return getText;
}

}
