package login.web.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class globaltradingnetwork {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://difc.globaltradingnetwork.com/web/login");
        Thread.sleep(15000);
    }

    @Test
    public void emptyFieldLoginTest() throws InterruptedException {
       driver.findElement(By.xpath("//button[@id='LoginButton']")).click();
       Thread.sleep(5000);
       String errMsg = driver.findElement(By.xpath("//div[@class='login_error_msg']")).getText();
       System.out.println("Empty Field Error: " + errMsg);
       Thread.sleep(5000);
    }

    @Test
    public void randomLoginTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='form-input-live-u']")).sendKeys("TestUser1");
        driver.findElement(By.xpath("//input[@id='form-input-live-p']")).sendKeys("TestUser@1");
        driver.findElement(By.xpath("//button[@id='LoginButton']")).click();
        Thread.sleep(20000);
        String errMsg = driver.findElement(By.xpath("//div[@class='login_error_msg']")).getText();
        System.out.println("Random Login Error: " + errMsg);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
