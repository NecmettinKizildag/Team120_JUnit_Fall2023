package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C05_KontrolsuzCokluSayfa extends TestBase {

    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe url'ine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // sayfa basliginin Internet icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Internet";

        // Elemental Selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();
        String firstTabHandle = driver.getWindowHandle();

        // Yeni acilan tab'in Title'inin Selenium icerdigini test edin
        String secondTabHandle = "";

        Set<String> tabsHandles = driver.getWindowHandles();

        for (String each:tabsHandles
             ) {
            if (!(each==firstTabHandle)){
                secondTabHandle = each;
            }
        }

        driver.switchTo().window(secondTabHandle);
        actualTitle = driver.getTitle();
        expectedTitle = "Selenium";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Ilk sayfaya donup url'in internet icerdigini test edin

        driver.switchTo().window(firstTabHandle);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "internet";

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
