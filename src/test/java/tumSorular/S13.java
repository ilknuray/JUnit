package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class S13 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement baslik = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println(baslik.getText());
        //○Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(textBox);
        WebElement textIframe = driver.findElement(By.xpath("//p"));
        textIframe.clear();
        textIframe.sendKeys("Merhaba Dunya" + Keys.ENTER);
        driver.switchTo().defaultContent();
        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin
        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        String actualElemental = elemental.getText();
        String expectedElemental = "Elemental Selenium";
        Assert.assertEquals(expectedElemental, actualElemental);
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    }
}
