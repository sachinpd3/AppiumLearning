package Pages;

import Utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.status.StatusLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static Utils.CommonUtils.node;

public class HomePage extends CommonUtils {

    AppiumDriver driver;

   /* public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }*/

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
      //  platform = StatusLogger.Config.getInstance().getPlatform();
    }

    @iOSXCUITFindBy(xpath = "test")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cart\"]")
    private WebElement Cart;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    private WebElement searchBox;

   // By  Cart = By.xpath("//android.widget.TextView[@text=\"Cart\"]");
   // WebElement itemSearch = driver.findElement(By.xpath("//android.widget.TextView[@text=\"vivo 5g mobile\"]"));


@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Account\"]/android.view.ViewGroup")
private WebElement account;


public void MycartClick(){
/*driver.findElement(Cart).click();
    node.info("clicked on cart");*/

   tapObject(Cart,"Cart");

}
public void searchItem(String itm){
    tapObject(searchBox,"searchbox");
   //inputMethod(searchBox,"itemSearch", itm);
}
    public void MyaccountClick(){
/*driver.findElement(Cart).click();
    node.info("clicked on cart");*/

        tapObject(account,"account");

    }

}