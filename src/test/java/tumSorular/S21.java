package tumSorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class S21 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement box1= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(box1).perform();
        //3 Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();
        //4 Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5 Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6 “Click and hold" kutusuna basili tutun
        WebElement box2= driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(box2).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(box2.getText());
        //8- “Double click me" butonunu cift tiklayi
        WebElement box3= driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(box3).perform();
    }
}
