package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class S16 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        Assert.assertTrue(text.isDisplayed());
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(), "The Internet");
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        List<String> handelles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handelles.get(1));
        Assert.assertEquals(driver.getTitle(), "New Window");
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newText= driver.findElement(By.xpath("//h3[text()='New Window']"));
        String text1=newText.getText();
        String text1ex="New Window";
        Assert.assertEquals(text1ex,text1);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        driver.switchTo().window(handelles.get(0));
    }
}
