package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity8 {
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
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img")).click();
        Select leavetype = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leavetype.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2022-10-03");
        driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).clear();
        driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).sendKeys("2022-10-05");
        driver.findElement(By.id("applyleave_txtComment")).click();
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        driver.findElement(By.id("calFromDate")).clear();
        driver.findElement(By.id("calFromDate")).sendKeys("2022-10-07");
        driver.findElement(By.id("calToDate")).clear();
        driver.findElement(By.id("calToDate")).sendKeys("2022-10-10");
        driver.findElement(By.id("btnSearch")).click();
        driver.close();
    }
}