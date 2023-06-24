package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class Activity6 {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get("https://alchemy.hguy.co/jobs");
            driver.findElement(By.id("txtUsername")).sendKeys("jobs");
            Thread.sleep(20);
            driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("orangepassword123");
            Thread.sleep(20);
            driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_directory_viewDirectory']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_directory_viewDirectory']"))).click();
            String ActualTitle = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
            System.out.println(ActualTitle);
            String ExpectedTitle = "Search Directory";
            if (ActualTitle.equals(ExpectedTitle)) {
                driver.close();
            }
        }
    }

