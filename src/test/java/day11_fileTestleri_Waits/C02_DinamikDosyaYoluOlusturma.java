package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DinamikDosyaYoluOlusturma {

    @Test
    public void test01(){

        /*
            Testlerimizin farkli bilgisayarlarda da calismasi gerekiyorsa
            file testleri icin gerekli olan DOSYA YOLU dinamik yapilmalidir

            Java'da dosya yolunu kodun calistigi bilgisayardan
            otomatik olarak almak icin 2 secenek vardir

            System.getProperty("user.home") ===> bilgisayarin ana dosya yolunu verir
            System.getProperty("user.dir")  ===>
         */

        // masustunuzde bulunan image.jpg dosyasinin varligini
        // dinamik dosya yolu kullnarak test edelim

        // C:\Users\Ben\Desktop\image.jpg

        // "C:\Users\Ben" + "\Desktop\image.jpg"
        //  ana dosya yolu    herkeste ayni olan kisim


        String dinamicFilePath = System.getProperty("user.home")+"/Desktop/image.jpg";
        System.out.println(dinamicFilePath);

        Assert.assertTrue(Files.exists(Paths.get(dinamicFilePath)));

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\Ben\IdeaProjects\Team120_JUnit_Fall2023

        // projemizde var olan text.txt 'nin varligini
        // dinamik dosya yolu ile test edelim


        // pojemizde var olan text.txt nin varligini
        // dinamik dosya yolu ile test edelim

        //C:\Users\Ben\IdeaProjects\Team120_JUnit_Fall2023
        //      \src\test\java\day11_fileTestleri_Waits\text.txt

        String dinamicTextFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\day11_fileTestleri_Waits\\text.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamicTextFilePath)));


    }
}
