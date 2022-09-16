package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
/*
facebook adresine gidin
cookiesi kabul edin
create an account butonuna basin
radio button elementlerini locate edin
secili degilse cinsiyeti secin
 */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
   /* @Test
    public void test1(){
        driver.get("https://www.facebook.com");
        WebElement acceptCookies=driver.findElement(By.xpath("//*[@id='u_0_e_Bj']"));
        acceptCookies.click();
        //driver.findElement(By.xpath("//*[@id='u_0_d_ee']")).click();
       WebElement create= driver.findElement(By.xpath("//*[@class='_8esh']"));
       create.click();*/
    }

