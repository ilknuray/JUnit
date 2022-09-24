package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class S20 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //2 https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //3 Arama kutusuna actions method’larine
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);

        //kullanarak samsung A71 yazdirin ve Enter’a

        actions.sendKeys(searchBox,"A71"+ Keys.ENTER).perform();


        //4 aramanin gerceklestigini test edi
        WebElement aranan= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aranan.getText().contains("A71"));
    }
}
