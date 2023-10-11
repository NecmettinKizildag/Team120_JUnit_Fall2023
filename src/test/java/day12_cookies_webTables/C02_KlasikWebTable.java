package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_KlasikWebTable extends TestBase {

    @Test
    public void test01(){
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.END).perform();

        bekle(1);

        //3.Web table tum body’sini yazdirin
        WebElement table = driver.findElement(By.xpath("//tbody"));

        System.out.println(table.getText());

        //4.Web table’daki satir sayisinin 7 oldugunu test edin
        List<WebElement> rows = driver.findElements(By.xpath("//tr"));

        int expectedRowsCount = 7;
        int actualRowsCount = rows.size();

        Assert.assertEquals(expectedRowsCount,actualRowsCount);

        //5.Tum satirlari yazdirin

        for (int i = 0; i <rows.size() ; i++) {
            System.out.println((i+1)+". satir :"+rows.get(i).getText());
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> firstcolumn = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedColumnCount = 13;
        int actualColumnCount = firstcolumn.size();

        Assert.assertEquals(expectedColumnCount,actualColumnCount);

        //7. 5.sutunu yazdirin
        List<WebElement> fifthColumn = driver.findElements(By.xpath("//tbody/tr/td[5]"));

        System.out.println("======= 5. column ========");
        for (int i = 0; i < fifthColumn.size() ; i++) {
            System.out.println(fifthColumn.get(i).getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //döndüren bir method olusturun
        System.out.println("======================");

        System.out.println(dinamicCellInfo(3, 5));


        bekle(2);
    }

    public String dinamicCellInfo(int row,int column){
        String xpath = "//tr["+row+"]/td["+column+"]";

        WebElement dataOfElement = driver.findElement(By.xpath(xpath));

        return  dataOfElement.getText();
    }
}
