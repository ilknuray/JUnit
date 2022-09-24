package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class S18 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dropBox= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drugBox=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(dropBox,drugBox).perform();
        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edi
        WebElement dropped=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals(dropped.getText(),"Dropped!");
    }
}
