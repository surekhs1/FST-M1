package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        String ActualHeader = driver.findElement(By.xpath("//*[@id=\"post-16\"]/div/h2")).getText();
        System.out.println(ActualHeader);

        String ExpectedHeader = "Quia quis non";
        if(ActualHeader.equals(ExpectedHeader)){
            driver.close();
        }
    }
}
