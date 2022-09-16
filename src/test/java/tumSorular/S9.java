package tumSorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S9 {
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
        // 1-C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");
        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        // 4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualBaslik= driver.getTitle();
        String expectedBaslik="Google";
        if (actualBaslik.contains(expectedBaslik)){
            System.out.println("Title test ¨PASSED");
        }else{
            System.out.println("Title test FAILED");
        }
        //  5 Arama cubuguna “Nutella” yazip aratin
      driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Nutella"+ Keys.ENTER);

        //  6 Bulunan sonuc sayisini yazdirin
        String []sonuc=driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonuc[1]);
        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        //  8 Sayfayi kapati
    }
}
