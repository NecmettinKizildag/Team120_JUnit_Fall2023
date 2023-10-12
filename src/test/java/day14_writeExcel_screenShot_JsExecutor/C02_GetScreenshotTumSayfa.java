package day14_writeExcel_screenShot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;


public class C02_GetScreenshotTumSayfa extends TestBase {

    @Test
    public void tumSayfaScreenshot() throws IOException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapin
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("Nutella"+ Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedResult = "Nutella";
        String actualResult = result.getText();

        Assert.assertTrue(actualResult.contains(expectedResult));

        // rapor icin sayfanin fotografini cekin
        // 1.adim TakeScreenshot objesi olusturma
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosyayi olusturalim, dosya yolunu yazalim
        File ssCreate = new File("target/ScreenShots/pageSS.jpeg");

        // 3.adim bir gecici dosya olusturup buna tss objesi ile cektigimiz fotografi kaydedelim
        File tempFile = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici resmi asil dosyaya kopyalayalim
        FileUtils.copyFile(tempFile,ssCreate);


    }
}
