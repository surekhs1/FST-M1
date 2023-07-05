package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTasks {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
//        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void TasksTest() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        String taskName = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).getText();
        Assert.assertEquals(taskName, "Complete Activity with Google Keep");

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
