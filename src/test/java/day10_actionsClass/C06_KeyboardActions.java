package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //4- videoyu izlemek icin Play tusuna basin
        // once iframe e gecis yapalim
        WebElement iFrame = driver.findElement(By.xpath("//*[@*='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iFrame);

        WebElement playButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playButton.click();

        bekle(1);

        //5- videoyu calistirdiginizi test edin
        WebElement youtubeLogo = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue(youtubeLogo.isDisplayed());

        bekle(3);
    }
}
