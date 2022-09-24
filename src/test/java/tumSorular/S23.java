package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class S23 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");
        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Iphone"+ Keys.ENTER);


        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(sonucYazisi.getText().contains("Iphone"));
        //4 ikinci ürüne relative locater kullanarak tıklayin
        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    }
}
