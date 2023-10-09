package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSAlerts extends TestBase {

    @Test
    public void test01(){
        // youtube ana sayfaya gidin
        driver.get("https://www.youtube.com");

        // cookies kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[16]")).click();


        bekle(2);
    }



    @Test
    public void jsAlertTesti(){
        //2. Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        // - 1.alert’e tiklayin
        // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        // - OK tusuna basip alert’i kapatin

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        bekle(2);

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        bekle(2);

        String actualYazi = driver.switchTo().alert().getText();
        String exepctedYazi = "I am a JS Alert";

        Assert.assertEquals(exepctedYazi,actualYazi);

        driver.switchTo().alert().accept();
        bekle(2);




    }




    @Test
    public void cancelTesti(){
        //3.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        // - 2.alert’e tiklayalim
        // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        driver.switchTo().alert().dismiss();

        WebElement sonucYaziELementi = driver.findElement(By.xpath("//*[@id='result']"));
        String exepctedYazi = "You clicked: Cancel";


        Assert.assertEquals(exepctedYazi,sonucYaziELementi.getText());

    }





    @Test
    public void promptTesti(){
        //4.Test
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        // - 3.alert’e tiklayalim
        // - Cikan prompt ekranina “Abdullah” yazdiralim
        // - OK tusuna basarak alert’i kapatalim
        // - Cikan sonuc yazisinin Abdullah icerdigini test edelim

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("Abdullah");

        driver.switchTo().alert().accept();

        WebElement sonucYaziELementi = driver.findElement(By.xpath("//*[@id='result']"));
        String exepctedYazi = "Abdullah";

        Assert.assertTrue(sonucYaziELementi.getText().contains(exepctedYazi));

    }
}
