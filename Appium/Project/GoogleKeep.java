package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleKeep {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
//        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void keepTest() {
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='New text note']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Title']")).sendKeys("Complete Keep Activity");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Note']")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        WebElement note = driver.findElement(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content"));
        Assert.assertEquals(true, note.isDisplayed());

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
