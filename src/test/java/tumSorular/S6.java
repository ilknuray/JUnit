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

public class S6 {
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
    public void test(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        WebElement addElements= driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (addElements.isDisplayed()){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        addElements.click();
        WebElement add=driver.findElement(By.xpath("//h3"));
        if (add.isDisplayed()){
            System.out.println("add test PASSED");
        }else{
            System.out.println("add test FAILED");
        }
    }
}
