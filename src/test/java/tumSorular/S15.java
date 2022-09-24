package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseBeforeAfter;

public class S15 extends TestBaseBeforeAfter {
    @Test
    public void test() {

        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle= driver.getWindowHandle();
        //● Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String techproTitle=driver.getTitle();
        String exTitle="TECPROEDUCATION";
        Assert.assertFalse(techproTitle.contains(exTitle));
        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle=driver.getTitle();
        String exWalmart="Walmart";
        Assert.assertTrue(walmartTitle.contains(exWalmart));
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edi
        driver.switchTo().window(amazonHandle);
    }
}
