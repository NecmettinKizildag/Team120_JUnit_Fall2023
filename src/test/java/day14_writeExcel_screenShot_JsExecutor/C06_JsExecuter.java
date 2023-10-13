package day14_writeExcel_screenShot_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JsExecuter extends TestBase {

    @Test
    public void test01(){
        // wisequarter anasayfasina gidin
        driver.get("https://www.wisequarter.com");

        // alt kisimda bulunan “Go To Career Page” butonuna kadar asagi inin

        WebElement button = driver.findElement(By.xpath("(//a[@class='elementskit-btn  whitespace--normal'])[4]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);", button);

        jse.executeScript("arguments[0].click();", button);

        jse.executeScript("alert('yasasinnnn');");

        bekle(2);

    }
}
