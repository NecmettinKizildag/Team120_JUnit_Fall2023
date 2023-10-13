package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void tumSayfayiFotografCek(WebDriver driver, String resimAdi) {
        // her screenshot'in benzersiz bir isme sahip olmasi icin
        // 1- method'un cagrildigi yerden resim adi yollanacak
        // 2- sonuna tarih etiketi ekleyelim 2310062013

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);

        TakesScreenshot tss = (TakesScreenshot) driver;

        String dosyaYolu = "target/ScreenShots/"+resimAdi+tarihEtiketi+".jpeg";

        File tumSayfaSS = new File(dosyaYolu);

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void webElementFotografCek(WebElement webElement, String resimAdi) {
        // her screenshot'in benzersiz bir isme sahip olmasi icin
        // 1- method'un cagrildigi yerden resim adi yollanacak
        // 2- sonuna tarih etiketi ekleyelim 2310062013

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);

        String dosyaYolu = "target/ScreenShots/"+resimAdi+tarihEtiketi+".jpeg";

        File tumSayfaSS = new File(dosyaYolu);

        File geciciDosya = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
