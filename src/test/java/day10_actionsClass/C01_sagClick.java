package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;


public class C01_sagClick extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstHandle = driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);

        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlertText = driver.switchTo().alert().getText();
        String expextedAlertText = "You selected a context menu";

        Assert.assertEquals(expextedAlertText,actualAlertText);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        String secondHAndle= "";

        Set<String> handels = driver.getWindowHandles();

        for (String each: handels
             ) {
            if (!each.contains(firstHandle)){
                secondHAndle = each;
            }
        }

        driver.switchTo().window(secondHAndle);

        String actualH1Text = driver.findElement(By.tagName("h1")).getText();

        String exepctedH1Text = "Make sure your code lands";

        Assert.assertEquals(exepctedH1Text,actualH1Text);


        bekle(2);
    }
}
