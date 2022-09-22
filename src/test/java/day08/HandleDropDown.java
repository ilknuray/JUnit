package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HandleDropDown {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //index kullanarak option1i seciniz
        WebElement ddb= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddb);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //value kullanarak option2yi secin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());


        //visible olarak option1i secin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //tum dropdown degerlerini yazdirin
        List<WebElement>ddlist=select.getOptions();
        ddlist.stream().forEach(t-> System.out.println(t.getText()));
        System.out.println(select.getAllSelectedOptions().get(0).getText());

        //dropdown in boyutunu bulun dropdan 4 oge varsa true degilse false yazdirin
        System.out.println(ddlist.size());
        if (ddlist.size()==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        Assert.assertNotEquals(ddlist.size(),4);

    }
}
