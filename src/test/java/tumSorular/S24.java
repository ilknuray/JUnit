package tumSorular;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class S24 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. code.txt dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='text.txt']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edeli
        Files.exists(Paths.get("C:\\Users\\fylmz\\Downloads\\text.txt"));
    }
}
