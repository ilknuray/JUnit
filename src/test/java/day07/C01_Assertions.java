package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test() {
        //http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
        //sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();
        //email kutusuna @ olmayan bir mail girelim
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("ilknurgmail.com"+ Keys.ENTER);
        //entera bastigimizda invalid email address uyarisi ciktigini test edelim
        WebElement invalidMail= driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(invalidMail.isDisplayed());
    }
}
