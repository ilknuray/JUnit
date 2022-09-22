package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowHandle {
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
      driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        String ilkSayfaHandle= driver.getWindowHandle();
        String title=driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(title.contains(expectedTitle));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        String ikinciSayfaHandle=driver.getWindowHandle();
        String actualTitle=driver.getTitle();
        String exTitle="TECHPROEDUCATION";
        Assert.assertFalse(actualTitle.contains(exTitle));


        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        String actual=driver.getTitle();
        String expected="Walmart";
        Assert.assertTrue(actual.contains(expected));

        driver.switchTo().window(ilkSayfaHandle);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }
}
