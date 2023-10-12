package day12_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03_FarkliWebTable extends TestBase {

    @Test
    public void webTableTest(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> headers = driver.findElements(By.xpath("//*[@*='columnheader']"));

        for (int i = 0; i < headers.size() ; i++) {
            System.out.print(headers.get(i).getText()+", ");
        }
        System.out.println("");

        //3. 3.sutunun basligini yazdirin
        System.out.println(headers.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        List<WebElement> allDatas = driver.findElements(By.xpath("//*[@*='grid']"));

        for (int i = 0; i < allDatas.size() ; i++) {
            System.out.print(allDatas.get(i).getText()+", ");
        }
        System.out.println("");

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> allCells = driver.findElements(By.xpath("((//*[@role='rowgroup']) //*[@role = 'gridcell'])"));

        int sayac =0;

        for (WebElement each:allCells
             ) {
            if (!each.getText().isBlank()){
                sayac++;
            }
        }
        System.out.println(sayac);

        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> rowCount = driver.findElements(By.xpath("//*[@*='rowgroup']"));
        System.out.println("Row count of table : "+rowCount.size());

        //7. Tablodaki sutun sayisini yazdirin
        List<WebElement> columnCount = driver.findElements(By.xpath("(//*[@*='rowgroup'])[2]//*[@role='gridcell']"));
        System.out.println("Column count of table :"+columnCount.size());

        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("=========== 3. column datas ===========");
        List<WebElement> thirthColumnDatas = driver.findElements(By.xpath("(//*[@*='rowgroup'])//*[@role='gridcell'][3]"));

        for (WebElement each: thirthColumnDatas
             ) {
            if (!each.getText().isBlank()){
                System.out.println(each.getText());
            }
        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        /*
            bu sorunun cozumu icin, bir for loop ile her satirin ilk elemanina (isim) bakalim
            ((//*[@*='rowgroup'])[?]//*[@*='gridcell'])[1]
         */

        String dinamicFirstNameXpath ;
        String dinamicSalaryXpath;
        String firstName;
        String salary;


        for (int i = 1; i <rowCount.size() ; i++) {
           dinamicFirstNameXpath = "((//*[@*='rowgroup'])["+i+"]//*[@*='gridcell'])[1]";
           dinamicSalaryXpath = "((//*[@*='rowgroup'])["+i+"]//*[@*='gridcell'])[5]";

           firstName = driver.findElement(By.xpath(dinamicFirstNameXpath)).getText();
           salary = driver.findElement(By.xpath(dinamicSalaryXpath)).getText();

           if (firstName.equals("Kierra")){
               System.out.println("Salary of Kierra is : "+salary);
           }
        }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin

        printDataOfCell(3,3); // Data of cell : 29
        printDataOfCell(1,4); // Data of cell : cierra@example.com
    }

    public void printDataOfCell(int row, int column){
        String xpath = "((//*[@*='rowgroup'])["+row+"]//*[@*='gridcell'])["+column+"]";

        System.out.println("Data of cell : "+driver.findElement(By.xpath(xpath)).getText());
    }

}
