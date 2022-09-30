package practise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_P01 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //ikinci emojiye tiklayin
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        //tum hayvan emojilerine tiklayin
        List<WebElement> emojiList=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
       // for (WebElement w:emojiList) {
            //w.click();}

        emojiList.stream().forEach(t->t.click());
        driver.switchTo().defaultContent();
        //formu doldurun
        Actions actions=new Actions(driver);
        List<WebElement>formList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        actions.sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB)
                .sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").sendKeys(Keys.ENTER).perform();

       /*
       2.yol
       List<String>text=new ArrayList<>(Arrays.asList("bu","a","b","c","d","e","f","d","e","f","g"));
        for (int i = 0; i <formList.size() ; i++) {
            formList.get(i).sendKeys(text.get(i));}*/


        //apply butonuna tiklayin
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }

}
