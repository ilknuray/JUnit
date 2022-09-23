package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_FileuploadClass extends TestBaseBeforeAfter {
    @Test
    public void test() {


        //   https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim

        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dosyaYolu="C:\\Users\\fylmz\\OneDrive\\Masaüstü\\Nouveau Document texte.txt";
        dosyaSec.sendKeys(dosyaYolu);
        /*
        dosya sec butonuna direk tiklayamayabiliriz cunku windows a mudahaleye izin vermeyebilir
        bu yuzden dosya sec butonunu locate edip send keys methodu ile string degiskene atadigimizdosya yolumuzu gonderirizd
         */

        //dosyaSec.submit();
        //Yuklemek istediginiz dosyayi secelim.
        //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@class='button']")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed());
    }
}