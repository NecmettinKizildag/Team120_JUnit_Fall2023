package practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class kontrolsuzPencere extends TestBase {


    @Test
    public void test01(){
        ////1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com");
        String firstHandle = driver.getWindowHandle();

        //        //2."Login Portal" a kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        //        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        //        //4.Diger window'a gecin
        Set<String> handleSet = driver.getWindowHandles();

        String secodHandle = "";

        for (String each: handleSet
             ) {
            if (!(each==firstHandle)){
                secodHandle=each;
            }
        }

        driver.switchTo().window(secodHandle);

        //        //5."username" ve "password" kutularina deger yazdirin

        WebElement userName = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));

        Faker faker = new Faker();

        actions.click(userName).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                perform();



        //        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi = "validation failed";


        String actualYazi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        //        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //        //9.Ilk sayfaya geri donun

        driver.switchTo().window(firstHandle);

        //        //10.Ilk sayfaya donuldugunu test edin

        String exepctedUrl = "http://webdriveruniversity.com/";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(exepctedUrl,actualUrl);

        bekle(3);
    }
}
