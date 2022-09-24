package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class S17 extends TestBaseBeforeAfter {
    @Test
    public void test() {

        //2https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement kutu= driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(kutu).perform();

        //4 Alert’te cikan yazinin “You selected a context menu” oldugunu
        String expectedyazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedyazi, actualYazi);

        //5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6 Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String>handles=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));


        WebElement h1tag= driver.findElement(By.tagName("h1"));
        String actualTag= h1tag.getText();
        String expecedTag="Elemental Selenium";
        Assert.assertEquals(expecedTag,actualTag);

    }
}
