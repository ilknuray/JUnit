package practise;

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

public class C03_LoginTest {
    //https://www.koalaresorthotels.com/ a gidiniz
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.koalaresorthotels.com/");
        //logine tikla
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();
        //login demiyim 4 sekilde test edelim
        String expectedTitle="Log in";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement name= driver.findElement(By.xpath("//input[@id='UserName']"));
        Assert.assertTrue(name.isDisplayed());
        WebElement login= driver.findElement(By.xpath("//*[@class='mb-4']"));
        Assert.assertTrue(login.isDisplayed());

        String expectedUrl="https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

}
