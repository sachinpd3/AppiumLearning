package TestSuite;

import BaseClass.Configs;
import BaseClass.Hooks;
import Pages.HomePage;
import Pages.MyCartPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//testing
import java.lang.reflect.Method;

public class CartProceed extends Hooks {



    @BeforeClass
    public void setUp(){
        test=extent.createTest("Add to cart");

    }

    @BeforeMethod
    public void setUpNode(Method method){
        node=test.createNode(method.getAnnotation(Test.class).description());
    }

    @Test(description = "Validate Continue Button",enabled = true)
    void ClickOncart(){
        HomePage homePage = new HomePage(driver.get());
        MyCartPage myCartPage = new MyCartPage(driver.get());
        homePage.MycartClick();
        myCartPage.PlaceOrderClick();
        String btnName=myCartPage.ContinueBtnDisplay();
        if(btnName.equalsIgnoreCase("continue")){
            System.out.println("pass");
           node.pass("Continue Button is displayed");
        }else{
            System.out.println("fail");
         node.log(Status.FAIL,  "Continue Button is not displayed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64(driver.get()), "Faied image").build());
        }
    }


}
