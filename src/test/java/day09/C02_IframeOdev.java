package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_IframeOdev {
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
    public void test01(){
        driver.get("http://demo.guru99.com/test/guru99home/");
        //driver.findElement(By.xpath("//button[@id='save']")).click();//cerezlzeri kabul ettim.
      //  List<WebElement> iframeSayisi=driver.findElement(By.xpath("//iframe")).getText();

    }
}
