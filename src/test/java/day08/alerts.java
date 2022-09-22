package day08;

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

public class alerts {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void test() {
        //https://the-internet.herokuapp.com/javascript_alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        // click for is alert butonuna tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();


        //tikladiktan sonra cikan alert uyari mesajina tamam diyelim
        driver.switchTo().alert().accept();
        WebElement succes = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String expectedSucces = "You successfully clicked an alert";
        String actualSucces = succes.getText();
        Assert.assertTrue(actualSucces.contains(expectedSucces));

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement msj = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualMsj = msj.getText();
        String expectedMsj = "You clicked: Cancel";
        Assert.assertTrue(actualMsj.contains(expectedMsj));
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Merhaba");
        driver.switchTo().alert().accept();
        String actual=driver.findElement(By.xpath("//*[text()='You entered: Merhaba']")).getText();
        String expected="Merhaba";
        Assert.assertTrue(actual.contains(expected));
    }
}
