package tumSorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class S27 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin

        WebElement button1 = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(button1);
        WebElement button = driver.findElement(By.xpath("//a[text()='Our Products']"));
        button.click();


        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        //4. Popup mesajini yazdirin
        WebElement text = driver.findElement(By.xpath("//*[@class='modal-content']"));
        System.out.println(text.getText());
        //5. “close” butonuna basin
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edi
    }
}
