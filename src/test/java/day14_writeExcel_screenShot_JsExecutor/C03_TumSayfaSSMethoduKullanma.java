package day14_writeExcel_screenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_TumSayfaSSMethoduKullanma extends TestBase {

    @Test
    public void testWise(){
        // wisequarter anasayfaya gidin
        driver.get("https://wisequarter.com/");

        // url'in wise icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "wise";

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin

        ReusableMethods.tumSayfayiFotografCek(driver,"wiseQuarter");

    }

    @Test
    public void testAB(){
        // ahmetbulutluoz.com anasayfaya gidin
        driver.get("https://www.ahmetbulutluoz.com");

        // url'in bulut icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "bulut";

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin
        ReusableMethods.tumSayfayiFotografCek(driver,"ahmetBulutluoz");

    }

    @Test
    public void testYouTube(){
        // youtube.com anasayfaya gidin
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin
        ReusableMethods.tumSayfayiFotografCek(driver,"youTube");

    }
}
