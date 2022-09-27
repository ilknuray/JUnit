package day_16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenshotWE extends TestBaseBeforeAfter {
    @Test
    public void test() throws IOException {
        //amazon sayfasina gidelim nutella aratalim arama sonucunun resmini alalim
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        File yaziSS=sonucYazisi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(yaziSS,new File("target/ekranGoruntusu/webelementSS.jpeg"));





    }
}
