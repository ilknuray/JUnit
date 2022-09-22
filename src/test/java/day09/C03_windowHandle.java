package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_windowHandle {
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
         driver.close();
    }

    @Test
    public void test() {
        driver.get("https://www.amazon.com");

        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        String ilkSayfaHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://www.bestbuy.com");
        String ikinciSayfa = driver.getWindowHandle();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.switchTo().window(ilkSayfaHandle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);
        WebElement sonuclar = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonuc = sonuclar.getText();
        String expectedSonuc = "Java";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        driver.switchTo().window(ikinciSayfa);
        WebElement logo= driver.findElement(By.xpath("(//*[@class='logo'])[2]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
