package tests;

import manager.ApplicationManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME)
    );

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method){
        logger.info("Started test ----> " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(Method method){
        logger.info("Finished test ----> " + method.getName());
        logger.info("================================================================");

    }

    @BeforeSuite(alwaysRun = true)

    public void setup(){
        app.init();
    }


    @AfterSuite(alwaysRun = true)

    public void stop(){
        app.tearDown();
    }


}
