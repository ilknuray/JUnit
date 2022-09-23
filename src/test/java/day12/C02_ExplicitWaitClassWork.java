package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C02_ExplicitWaitClassWork extends TestBaseBeforeAfter {
    @Test
    public void test1() {


// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
// 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
// 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

// 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
// 7. It's back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //"It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWebelementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGoneWebelementi.isDisplayed());
        //add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //It's back mesajinin gorundugunu test edin

        WebElement back=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='message']"))));
        Assert.assertTrue(back.isDisplayed());



    }
}
