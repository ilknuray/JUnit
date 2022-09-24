package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class S12 extends TestBaseBeforeAfter {
    @Test
    public void test() {
      //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");

        //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        WebElement birinciButon= driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        birinciButon.click();
        driver.switchTo().alert().accept();

        //“You successfully clicked an alert” oldugunu test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());


        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        WebElement ikinciButon= driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        ikinciButon.click();
        driver.switchTo().alert().dismiss();
        //“successfuly” icermedigini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).isDisplayed());

        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        WebElement ucuncuButton= driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
        ucuncuButton.click();
        driver.switchTo().alert().sendKeys("ilknur");

        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
        driver.switchTo().alert().accept();
        WebElement actualText=driver.findElement(By.xpath("//*[text()='You entered: ilknur']"));
        String expectedText="ilknur";
        String actual= actualText.getText();
        Assert.assertTrue(actual.contains(expectedText));
    }
}
