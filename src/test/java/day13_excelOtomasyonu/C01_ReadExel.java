package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ReadExel {

    @Test
    public void readExcelTestleri() throws IOException {

        String filePath = "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);
        // olusturdugumuz workbook, online olarak excel dosyasina erismez
        // 18.satirda fileInputStream kullanarak excel'deki bilgileri aldik
        // 20.satirda fis'in aldigi bilgileri kullanarak kodlarimizin icinde
        // fiziki excl dosyasinin bir kopyasini olusturmus olduk.

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(3);

        System.out.println(cell); // Cezayir

        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(0).getCell(1)); // Başkent (İngilizce)

        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String data = sheet.getRow(0).getCell(1).toString();
        System.out.println(data); // Başkent (İngilizce)

        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String expectedData = "Kabil";
        String actualData = sheet.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedData,actualData);

        //		- Satir sayisini bulalim
        System.out.println(sheet.getLastRowNum()+1); // 191 //  method 190 yani son satirin index'ini verir biz satir sayisini bulmak icin 1 ekledik

        //		- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows());  // direk fiziki olarak kullanilan satir sayisini yazdirir 191

        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        String country;
        String capitalCity;

        Map<String,String> country_capitalCityMap = new HashMap<>();

        for (int i = 1; i <sheet.getLastRowNum() ; i++) {
            country = sheet.getRow(i).getCell(0).toString();
            capitalCity = sheet.getRow(i).getCell(1).toString();

            country_capitalCityMap.put(country,capitalCity);
        }

        // Ulkeler excel'inde Canada isimli bir ulke oldugunu test edin
        Assert.assertTrue(country_capitalCityMap.containsKey("Canada"));

        // Ulkeler excel'inde Cuba'nin baskentinin Havana oldugunu test edin
        String expectedValue = "Havana";
        String actualValue = country_capitalCityMap.get("Cuba");

        Assert.assertEquals(expectedValue,actualValue);




    }
}
