package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        String ActualTitle = driver.getTitle();
        System.out.println(ActualTitle);
        String ExpectedTitle = "Alchemy Jobs – Job Board Application";
        if(ActualTitle.equals(ExpectedTitle)){
            driver.close();
        }
    }
}

