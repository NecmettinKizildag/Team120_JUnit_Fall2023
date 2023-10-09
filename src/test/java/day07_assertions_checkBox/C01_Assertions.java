package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_Assertions {

    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void bestbuyUrlTest(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";

        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test
    public void titleTest(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String actualTitle = driver.getTitle();
        String unexpectedTitle = "Rest";

        Assert.assertFalse(actualTitle.contains(unexpectedTitle));
    }

    @Test
    public void logoTest(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin

        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }

    @Test
    public void francaisLinkTest(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francaisLinkElement = driver.findElement(By.xpath("(//button[normalize-space()='Français'])"));

        Assert.assertTrue(francaisLinkElement.isDisplayed());
    }
}
