package day10_fileExist;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {
    @Test
    public void test01() throws FileNotFoundException {
        String dosyaYolu="\\Users\\User\\Documents\\MerhabaJava.rtf";
       // "C:\Users\User\Documents\MerhabaJava.rtf" dosya yolunu sag tikla als pfad kopieren den kopyalayip getir

        FileInputStream fis = new FileInputStream(dosyaYolu);
        /*
            File testlerinde genellikle dowloads'a indirilecek bir dosyanin
            indirildigini test etmek
            veya masaustundeki bir dosyanin web'e yuklenebildigini test etmek isteriz
            Ancak herkesin bilgisayirinin ismi, kullanici isimleri gibi farkliliklar
            olacagindan testler tek bir bilgisayda calisacak gibi yazilmak zorunda kalinir.
            Bu karisikligin onune gecebilmek icin Java
            2 basit kod blogu sunmus
         */
        System.out.println(System.getProperty("user.dir"));
        // o anda calisan dosyanin (C01_FileInputStreeam) yolunu verir
        // /Users/ahmetbulutluoz/IdeaProjects/com.Team105JUnit
        System.out.println(System.getProperty("user.home"));
        // kullanicinin temel path'ini verir.
        // /Users/ahmetbulutluoz     ==> benimki ==> C:\Users\User
        // Masaustune gitmek istersek
        // /Users/ahmetbulutluoz + /Desktop eklememiz yeterlidir
        // Downloads'a gitmek istersek
        // /Users/ahmetbulutluoz + /Downloads eklememiz yeterlidir
        // Kodlarimizin dinamik olmasi yani kisinin bilgisayarindaki
        // kullanici adi gibi detaylara takilmamasi icin
        // File testlerinde kullanilacak dosya yolunu
        // user.home... temel path'ini calistigi bilgisayardan alacak sekilde
        // olustururuz
        // dosyaYolu="/Users/ahmetbulutluoz/Desktop/MerhabaJava.docx";
        // dosyayolu="\\Users\\User\\Documents\\MerhabaJava.rtf" benimki bu
        String dinamikDosyaYolu= System.getProperty("user.home") +"\\Documents\\MerhabaJava.rtf";
    }
}
