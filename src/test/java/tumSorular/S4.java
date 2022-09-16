package tumSorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S4 {
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
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.xpath("//*[@id='sign-in']")).click();
        WebElement emailbox = driver.findElement(By.xpath("//*[@id='session_email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//*[@id='session_password']"));
        WebElement signin = driver.findElement(By.xpath("//input[@name='commit']"));
        emailbox.sendKeys("ijdkdkdk@gmail.com");
        passwordBox.sendKeys("ertyui");
        signin.click();
        String expectedUser = "ijdkdkdk@gmail.com";
        String actualUser = driver.getCurrentUrl();
        if (actualUser.contains(expectedUser)) {
            System.out.println("test passed");
        } else {
            System.out.println("failed");

        }
    }
}