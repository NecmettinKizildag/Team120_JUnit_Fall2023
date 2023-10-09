package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class yanlisEmailTesti {
    //1. Bir Class olusturalim YanlisEmailTesti
    //2. http://automationpractice.pl/index.php sayfasina gidelim
    //3. Sign in butonuna basalim
    //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
    //email address” uyarisi ciktigini test edelim
    WebDriver driver;

    @Test
    public void emailTest(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://automationpractice.pl/index.php");

        //3. Sign in butonuna basalim

        driver.findElement(By.xpath("//a[@class='login']")).click();

        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("asd.asd.com");

        driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']")).click();

        WebElement invalidPassword = driver.findElement(By.xpath("//*[contains(text(),'Invalid email address.')]"));

        //System.out.println(invalidPassword.getText());

        Assert.assertTrue("invalid password pop-up has been showed",invalidPassword.isDisplayed());



    }

    @After
    public void teardown(){
        ReusableMethods.bekle(3);
        driver.close();
    }
}
