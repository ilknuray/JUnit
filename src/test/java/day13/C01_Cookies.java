package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //-tum cookie’leri listeleyin
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println(allCookies);
        allCookies.stream().forEach(t-> System.out.println(t.getName()+t.getValue()));
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookie=5;
        int actualCookie=allCookies.size();
        Assert.assertNotEquals(expectedCookie,actualCookie);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:allCookies
             ) {
            if(w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }

        }
        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie>cookiler=driver.manage().getCookies();
        cookiler.stream().forEach(t-> System.out.println(t.getName()+t.getValue()));
        Assert.assertTrue(cookiler.contains(newCookie));
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
       // driver.manage().deleteCookie();
        //8-tum cookie’leri silin ve silindigini test edin
        //Collapse
    }
}
