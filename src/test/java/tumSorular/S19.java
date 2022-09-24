package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class S19 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com");
        //2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        Actions actions = new Actions(driver);
        WebElement sigin = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        actions.moveToElement(sigin).perform();
        //mouse’u bu menunun ustune getirelim
        //3 “Create a list” butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        //4 Acilan sayfada “Your Lists” yazisi oldugunu test edeli
        WebElement text= driver.findElement(By.xpath("//*[@id=\"my-lists-tab\"]"));
        Assert.assertEquals(text.getText(),"Your Lists");
    }
}
