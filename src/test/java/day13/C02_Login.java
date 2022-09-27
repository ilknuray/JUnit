package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_Login extends TestBaseBeforeAfter {
    @Test
    public void test() {

        //login( ) metodun oluşturun ve oturum açın.
        login();

        table();

        printrows();


        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> hucreler = driver.findElements(By.xpath("//tbody//td"));
        System.out.println(" Hucre sayisi : " +hucreler.size());

        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.


        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.

        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.

        //○ 5.column daki elementleri konsolda yazdırın
    }

    private void printrows() {
        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Stir sayisi : " + satirSayisi.size());

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w : satirSayisi
        ) {
            System.out.println(w.getText());

        }
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> dorduncuStir = driver.findElements(By.xpath("//tbody//tr[4]"));
        for (WebElement w : dorduncuStir
        ) {
            System.out.println(w.getText());

        }

    }

    private void table() {
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        /*
        tabloda table tagi altinda tablonun basligini gosteren thead tag i bulunur eger baslikta satir varsa thead tagi altinda
        tr (satir)tagi vardir ve basliktaki sutunlara yani hucrelere cell de th tagi ile ulasilir
        basligin altindaki verilere tbody tagi ile altindaki satirlara tr tagi ile cell hucrelere sutunlara td tagi ile ulasiriz
         */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi :" + sutunSayisi.size());

        //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("Bodyler : " + tumBody.getText());
        WebElement tumBaslik = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + tumBaslik.getText());


    }

    private void login() {
        //● https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //○ Username : manager ○ Password : Manager1!
        //table methodunu olusturun
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
