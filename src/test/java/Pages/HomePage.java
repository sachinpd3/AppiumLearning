package Pages;

import Utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Utils.CommonUtils.node;

public class HomePage extends CommonUtils {

    AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    By  Cart = By.xpath("//android.widget.TextView[@text=\"Cart\"]");
   // WebElement itemSearch = driver.findElement(By.xpath("//android.widget.TextView[@text=\"vivo 5g mobile\"]"));

public void MycartClick(){
driver.findElement(Cart).click();
    node.info("clicked on cart");

   // tapObject(Cart,"Cart");

}
public void searchItem(String itm){
   // inputMethod(itemSearch,"itemSearch", itm);
}


}