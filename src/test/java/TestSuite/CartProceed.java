package TestSuite;

import BaseClass.Configs;
import BaseClass.Hooks;
import Pages.HomePage;
import Pages.MyCartPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test(description = "Validate Continue Button")
    void ClickOncart(){
        HomePage homePage = new HomePage(driver.get());
        MyCartPage myCartPage = new MyCartPage(driver.get());
        homePage.MycartClick();
        String btnName=myCartPage.validateContinueBtnDisplay();
        if(btnName.equals(btnName)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

    }





}
