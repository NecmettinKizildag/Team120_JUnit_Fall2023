package day14_writeExcel_screenShot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_WebElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        // Amazon'a gidin
        driver.get("https://www.amazon.com");

        //Nutella icin arama yapin
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("Nutella"+ Keys.ENTER);

        // Sonuclarin Nutella icerdigi8ni test edin
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedResult = "Nutella";
        String actualResult = result.getText();
        // Rapora eklemek icin sonmuc yazisinin ss ini alin

        File filePath = new File("target/ScreenShots/result.jpeg");

        File tempSS = result.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tempSS,filePath);

        ReusableMethods.webElementFotografCek(result,"resultNutella");
    }
}
