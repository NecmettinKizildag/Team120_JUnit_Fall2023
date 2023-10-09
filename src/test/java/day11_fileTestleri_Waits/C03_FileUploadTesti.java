package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void fileUpdateTesti(){
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        //4. text.txt dosyasini secelim.

        /*
            insan olarak dosya secimi icin
            chooseFile butonuna bastiktan sonra
            acilan windows dosya penceresinden
            istedigimiz dosyayi secip yukleriz.

            Selenium'da otomasyon ile bu islemi yapmak icin
            chooseFile butonu locate edilip,
            bu webelement'e sendKeys(yuklenecekDosyaninDosyaYolu); yapilir
         */

        WebElement uploadButtonElement = driver.findElement(By.xpath("//input[@name='file']"));

        String dinamicFilePath = System.getProperty("user.dir")+"/src/test/java/day11_fileTestleri_Waits/text.txt";
        System.out.println(dinamicFilePath);

        uploadButtonElement.sendKeys(dinamicFilePath);
        // C:\Users\Ben\IdeaProjects\Team120_JUnit_Fall2023/src/test/java/day11_fileTestleri_Waits/text.txt

        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElement.isDisplayed());

        bekle(2);
    }
}
