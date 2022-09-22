package day09;

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

public class C01_Iframe {
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
        //https/::the-internet.herokuapp.com/iframe e gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement baslik = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.isDisplayed());

        WebElement textBox= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(textBox);
        WebElement iframeBox= driver.findElement(By.xpath("//p"));
        iframeBox.clear();
        iframeBox.sendKeys("Merhaba");
        driver.switchTo().defaultContent();

        WebElement altYazi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        System.out.println(altYazi.getText());

    }
}
