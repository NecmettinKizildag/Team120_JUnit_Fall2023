package day14_writeExcel_screenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_YouTubeArama extends TestBase {

    @Test
    public void youTubeAramaTesti(){

        // youtube anasayfasina git
        driver.get("https://www.youtube.com/");

        driver.findElement(By.xpath("(//button[@class='yt-spec-button-shape-next yt-spec-button-shape-next--filled yt-spec-button-shape-next--mono yt-spec-button-shape-next--size-m'])[2]")).click();

        bekle(3);

        //ahmetbulutluoz icin arama yap
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.click();
        searchBox.sendKeys("ahmet bulutluoz"+ Keys.ENTER);
        // bulunan videolardan  ilkinmin isminde bulut icerdegini test edin
        WebElement firstVideo = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));

        String expectedHeader ="QA";
        String actualHeader = firstVideo.getText();

        Assert.assertTrue(actualHeader.contains(expectedHeader));

        // ilk videonnun ss ini cek
        ReusableMethods.webElementFotografCek(firstVideo,"ahmetBulutluozVideo");


    }
}
