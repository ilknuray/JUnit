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

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
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
        //amazon adresine gidin
        driver.get("https://www.amazon.com");
        //kategori sayisinin 45 oldugunu test edin
        List<WebElement> boxElementSayisi = driver.findElements(By.xpath("//option"));
        System.out.println(boxElementSayisi.size());
        for (WebElement each : boxElementSayisi
        ) {
            System.out.println(each.getText());
            int boxSayisi = boxElementSayisi.size();
            int expected = 45;
            Assert.assertNotEquals(expected, boxSayisi);

        }
        //ketegori seceneginden books menusunu secin
        WebElement ddb = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddb.sendKeys("Computers");
        //arama kutusuna java yazin ve aratin
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
        //bulunan sonuc sayisini yazdirin
        WebElement sonuc=driver.findElement(By.xpath("//*[text()='1-24 of over 8,000 results for']"));
        System.out.println(sonuc.getText());
        //sonucun java kelimesini icerdigini test edin
        String sonucYazisi=sonuc.getText();
        String expectedSonucYazisi="Java";
        Assert.assertTrue(sonucYazisi.contains(expectedSonucYazisi));


    }


}
