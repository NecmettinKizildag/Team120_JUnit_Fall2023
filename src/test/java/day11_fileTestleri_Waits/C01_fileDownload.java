package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {

    @Test
    public void indirmeTesti(){
        // C:\Users\Ben\Desktop\image.jpg

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        bekle(2);

        //3. image.jpg dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='image.jpg']")).click();

        bekle(2);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = "C://Users//Ben//Downloads/image.jpg";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        bekle(2);
    }
}
