package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        /*
            14. satiri yazmamiz mecburi degildir
            selenium 4.8 versiyounundan itibaren kendi webdriver'ini olusturmustur
            biz 14. satirdaki gibi disaridan bir Webdriver tanimlamazsak
            selenium oyomatik olarak kendi Webdriver'ini devreye sokar
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.amazon.com");

        //2- arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement actualResultsNumbers = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(actualResultsNumbers.getText());

        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        //6- bir onceki sayfaya donup Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> baslikListesi = driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        for (int i = 0; i < baslikListesi.size(); i++) {
            System.out.println(i+"-"+baslikListesi.get(i).getText());
        }

        //ReusableMethods.bekle(3);
        driver.close();
    }
}
