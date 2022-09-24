package tumSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class S22 extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //amazon gidin
        driver.get("https://www.amazon.com");
        //2 Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddb= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        ddb.click();
        //3 dropdown menude 40 eleman olduğunu doğrulayı
        Select select=new Select(ddb);
        List<WebElement>ddbox=select.getOptions();
        int actualDdb=ddbox.size();
        int expectedDdb=40;

        Assert.assertNotEquals(expectedDdb,actualDdb);

    }
}
