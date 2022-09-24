package tumSorular;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class S25TekrarBak extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get(" https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        driver.findElement(By.xpath("//input[@id='file-upload']")).submit();
        //4. Yuklemek istediginiz dosyayi secelim.
        //5. Upload butonuna basalim.
        //6. “File Uploaded!” textinin goruntulendigini test edelim
    }
}
