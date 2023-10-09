package day07_assertions_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_RadioButtons {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://facebook.com
    // b. Cookies’i kabul edin
    // c. Create an account buton’una basin
    // d. Radio button elementlerini locate edin ve size uygun olani secin
    // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void faceBookTest(){
        driver.get("https://facebook.com");

        driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        WebElement femaleRadio = driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        WebElement maleRadio = driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        WebElement customRadio = driver.findElement(By.xpath("(//input[@name='sex'])[3]"));

        maleRadio.click();

        Assert.assertTrue(maleRadio.isSelected() && !femaleRadio.isSelected() && !customRadio.isSelected());
    }
}
