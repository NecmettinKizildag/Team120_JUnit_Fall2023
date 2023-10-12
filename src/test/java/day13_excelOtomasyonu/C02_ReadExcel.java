package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {


        // ilgili ayarlari yapip workbook'u olusturun
        String filePath = "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // 2.sayfaya gidin
        Sheet secondTab = workbook.getSheet("Sayfa2");

        // kullanilan en son satirin 24.satir oldugunu test edin
        int lastRowNum = secondTab.getLastRowNum()+1;
        int expectedLastRowNum = 24;

        Assert.assertEquals(expectedLastRowNum,lastRowNum);

        // fiziki kullanilan satir sayisinin 8 oldugunu test edin
        int expectedPhysicalRowNum = 8;
        int actualPhysicalRowNum = secondTab.getPhysicalNumberOfRows();

        Assert.assertEquals(expectedPhysicalRowNum,actualPhysicalRowNum);

        // olmayan satir veya sutun numarasi yazdirmaya calissak

        // System.out.println(secondTab.getRow(30).getCell(1)); NullPointerException
        System.out.println(secondTab.getRow(5).getCell(10)); // null

    }
}
