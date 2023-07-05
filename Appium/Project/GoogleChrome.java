package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleChrome {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        driver.get("https://www.training-support.net/selenium");
    }
    @Test
    public void chromeTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit wait of 10 seconds
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(newUiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains('To-Do List').instance(0))")).click();
        System.out.println("clicked");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Add Task']")).click();
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Add Task']")).click();
        driver.findElement(AppiumBy.id("taskInput")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='Add Task']")).click();
        System.out.println("added task");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add task to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear list']")).click();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
