package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_Webtables extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //bir onceki classtaki adrese gidelim
        //sayfaya girelim login methodu ile
        //input olarak verilen satir ve sutun sayisina sahip olan hucreleri yazdiralim

         int satir=3;
         int sutun=4;
        //● https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //○ Username : manager ○ Password : Manager1!
        //table methodunu olusturun
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

        List<WebElement>hucreSayisi=driver.findElements(By.xpath("//tbody//tr[3]//td[4]"));
        hucreSayisi.stream().forEach(t-> System.out.println(t.getText()));


        //price basligi altindaki tum numaralari yaziniz
        List<WebElement>price=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        price.stream().forEach(t-> System.out.println("price : " +t.getText()));



    }
}
