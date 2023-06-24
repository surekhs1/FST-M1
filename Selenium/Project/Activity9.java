package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity9 {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_pim_viewMyDetails']")));
        driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
        WebElement table = driver.findElement(By.id("emgcontact_list"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> cols = rows.get(0).findElements(By.tagName("th"));
        for (int c1=0; c1<cols.size(); c1++) {
            System.out.print(cols.get(c1).getText()+" ");
        }
        System.out.print("\n");
        for (int r=1; r<rows.size(); r++) {
            List<WebElement> cols1 = rows.get(r).findElements(By.tagName("td"));
            for (int c=0; c<cols1.size(); c++) {
                System.out.print(cols1.get(c).getText()+" ");
            }
            System.out.print("\n");
        }
        driver.close();
    }
}