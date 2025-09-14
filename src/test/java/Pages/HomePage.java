package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utils.CommonUtils.node;

public class HomePage {

    AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    By Cart = By.xpath("//android.widget.TextView[@text=\"Cart\"]");

public void MycartClick(){
    driver.findElement(Cart).click();
    node.info("clicked on cart");
}




}