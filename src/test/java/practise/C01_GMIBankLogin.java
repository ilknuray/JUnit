package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin  {
    public static void main(String[] args) {
        //gmi bank adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.gmibank.com");

        //sig in e tikla
        driver.findElement(By.xpath("(//*[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();
        //username Batch81
        WebElement name= driver.findElement(By.xpath("//*[@name='username']"));
        name.sendKeys("Batch81");

        WebElement passWord= driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("Batch81+");

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
       // driver.close();
    }



}
