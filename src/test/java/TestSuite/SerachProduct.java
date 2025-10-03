package TestSuite;

import BaseClass.Hooks;
import Pages.HomePage;
import Pages.MyCartPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SerachProduct extends Hooks {


    @BeforeClass
    public void setUp(){
        test=extent.createTest("Serach Product");

    }


    @BeforeMethod
    public void setUpNode(Method method){
        node=test.createNode(method.getAnnotation(Test.class).description());
    }

    @Test(description = "Validate Search Product",enabled = true)
    void ClickOncart(){
        HomePage homePage = new HomePage(driver.get());
     //   homePage.searchItem("Mobile");



        homePage.MyaccountClick();
       // scroll("My Activity");
        scrollToElement(driver.get(), "My Activity");
    }

}
