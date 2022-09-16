package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazon ssayfasina gidelim
        driver.get("https://www.amazon.com");
        //arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //"Samsung headphones" ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //bulunan sonuc sayisini yazdiralim

        WebElement sonucListesi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucListesi.getText());

        //ilk urunu tiklayin
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

        //tum basliklari yazdiralim
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
    }
}
