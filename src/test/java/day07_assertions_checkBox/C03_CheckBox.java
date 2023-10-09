package day07_assertions_checkBox;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ResourceBundle;

public class C03_CheckBox {

    //a. Verilen web sayfasına gidin.
    //     https://the-internet.herokuapp.com/checkboxes
    // b. Checkbox1 ve checkbox2 elementlerini locate edin.
    // c. Checkbox1 seçili değilse onay kutusunu tıklayın
    // d. Checkbox2 seçili değilse onay kutusunu tıklayın
    // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void checkBoxTest() {
        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        ReusableMethods.bekle(2);

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        ReusableMethods.bekle(2);
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        ReusableMethods.bekle(2);

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın

        // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin

        Assert.assertTrue(checkbox1.isSelected() && checkbox2.isSelected()                                                                              );


    }
}
