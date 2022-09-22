package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDrown {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        WebElement ddb= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddb);
        List<WebElement>ddbList=select.getOptions();
        System.out.println(ddbList.size());//bu sekildede optionlarin sayisina ulasiriz
        int expectedSayi=45;
        int actualSayi=ddbList.size();
        Assert.assertNotEquals(expectedSayi,actualSayi);
        /*
        dropdown menuye ulasmak icin select classindan bir obje olustururuz.ve locate ettigimiz dropdown webelementini select classinda tanimlariz.
        getOption methodu ile dropdown u bir liste atarak dropdown menunun butun elemanlarinin sayisina ulasabiliriz
         */
        //books secenegini secin
        WebElement ddM= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select.selectByVisibleText("Books");

        //arama kutusunda java aratin
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        //bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());




    }
}