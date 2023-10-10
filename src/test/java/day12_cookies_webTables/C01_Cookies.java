package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void cookieTest() {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();

        // bu sekilde yazdirinca kac cookie oldugu, ve bunlarin neler oldugu anlasilmiyor
        int sira = 1;
        for (Cookie each : cookieSet
        ) {
            System.out.println(sira + " - " + each);
            sira++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size() > 5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue = "USD";

        String actualValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertEquals(expectedValue, actualValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie newCookie = new Cookie("en sevdigim cookie", "cikolatali");

        driver.manage().addCookie(newCookie);


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        System.out.println("========== New Cookies ==========");
        cookieSet = driver.manage().getCookies();
        sira = 1;
        for (Cookie each : cookieSet
        ) {
            System.out.println(sira + " - " + each);
            sira++;
        }

        boolean isNewCookieAdded = false;

        for (Cookie each : cookieSet
        ) {
            if (each.getName().equals("en sevdigim cookie")) {
                isNewCookieAdded = true;
            }
        }

        Assert.assertTrue(isNewCookieAdded);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        System.out.println("========== New Cookies ==========");
        cookieSet = driver.manage().getCookies();
        sira = 1;
        for (Cookie each : cookieSet
        ) {
            System.out.println(sira + " - " + each);
            sira++;
        }

        boolean isTheCookieDeleted = true;

        for (Cookie each : cookieSet
        ) {
            if (each.getName().equals("skin")) {
                isTheCookieDeleted = false;
            }
        }

        Assert.assertTrue(isTheCookieDeleted);

        //8- tum cookie’leri silin ve silindigini test edin
        System.out.println("========== Cookies Deleted ==========");
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();

        System.out.println(cookieSet);

        int expectedCookieNumber = 0;
        int actualCookieNumber = cookieSet.size();

        Assert.assertEquals(actualCookieNumber, expectedCookieNumber);

    }
}
