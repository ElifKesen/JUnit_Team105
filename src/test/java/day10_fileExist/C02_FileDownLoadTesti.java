package day10_fileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownLoadTesti extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim. sayfa 140
        driver.get("https://the-internet.herokuapp.com/download");
        //3. Facebookd.png dosyasını indirelim (Ben sonraki denemede selenium.png indirdim)
        driver.findElement(By.xpath("//a[text()='selenium.png']")).click();
        ReusableMethods.bekle(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // Test icin oncelikle dosyanin indirildiginde dosyaYolu ne olacak bunu olusturmaliyiz
        String dosyaYolu= System.getProperty("user.home")+ "/Downloads/selenium.png";
        // Bir dosyanin bilgisayarimizda var oldugunu (exist) test etmek icin
        // Java'daki Files class'indan yardim alacagiz
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void test02(){
        // Masaustunde Merhabajava.docx dosyasi oldugunu test edin
        // dinamik dosya yolu olusturalim
        String dosyaYolu= System.getProperty("user.home")+ "\\Documents\\MerhabaJava.rtf";
        // Assert edelim
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
