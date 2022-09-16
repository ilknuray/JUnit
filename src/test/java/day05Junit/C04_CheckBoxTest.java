package day05Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_CheckBoxTest {
    WebDriver driver;

    @Before
    public void setUp() {
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
    public void test1() {
        //web sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //checkbo1 ve checkbox2 elementlerini locate ediniz
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //checbox1 secili degilse onay kutusunu tiklayin
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        //checkbox2 tikli degilse tikla
        if (!checkbox2.isSelected()){
            checkbox2.click();

        }
        List<WebElement>boxes=driver.findElements(By.xpath("(////input[@type='checkbox'])"));
        boxes.stream().filter(t->!t.isSelected()).forEach(t->t.click());

    }
}
