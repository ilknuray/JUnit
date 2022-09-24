package tumSorular;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class S14Yapamadim extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //driver.findElement(By.xpath("//button[@class='mat-focus-indicator solo-button mat-button mat-button-base mat-raised-button']")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html
    }
}
