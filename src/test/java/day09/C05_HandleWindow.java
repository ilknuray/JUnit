package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_HandleWindow {
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
        // driver.quit();
    }

    @Test
    public void test() {

        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement baslik = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String actualText = baslik.getText();
        String expectedText = "Opening a new window";
        Assert.assertTrue(actualText.contains(expectedText));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        //acilan yeni sayfanin basliginin new window old dogrulatin
        String actualTitle = driver.getTitle();
        String expectedTitle = "New Window";
        Assert.assertEquals(expectedTitle, actualTitle);
        //textin new window oldugunu dogrulayin
        String actualText2 = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        String expectedText2 = "New Window";
        Assert.assertEquals(expectedText2, actualText2);
        //bir onceki sayfanin basliginin the internet oldugunu test edin
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }

}
