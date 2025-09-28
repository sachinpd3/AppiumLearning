package TestSuite;

import BaseClass.Hooks;
import Pages.HomePage;
import Pages.MyCartPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CartProceeddataProvider extends Hooks {



    @BeforeClass
    public void setUp(){
        test=extent.createTest("Add to cart");

    }
    @BeforeMethod
    public void setUpNode(Method method){
        node=test.createNode(method.getAnnotation(Test.class).description());
    }

    @DataProvider(name="TestData")
    public Object[][] testDataMethod(){

        return new Object[][]{

                {"Home","//android.view.ViewGroup[@content-desc=\"Home\"]/android.view.ViewGroup"},
                {"Play","//android.view.ViewGroup[@content-desc=\"Play\"]/android.view.ViewGroup"},
                {"Categories","//android.view.ViewGroup[@content-desc=\"Categories\"]/android.view.ViewGroup"},
                {"Account","//android.view.ViewGroup[@content-desc=\"Account\"]/android.view.ViewGroup"},
                {"Cart","//android.view.ViewGroup[contains(@content-desc,'Cart')]/android.view.ViewGroup[1]"}
        };
    }

    @Test(description = "Validate",dataProvider = "TestData")
    void validateHomePage(String Object,String xpath){
 boolean validate=   driver.get().findElement(By.xpath(xpath)).isDisplayed();
 if(validate){
     node.info(Object+" is displaying");
 }else {
     System.out.println(Object+ " is not displaying");
 }



    }





}
