package day07_dropdown_jsAlerts;

public class C05_ozet {
    /*
        1- Dropdown menu : Select tagı ile olusturulan acılır menudur. Secenekler de option tag'ı ile olusturulur.Dropdown ile islem yapabilmemiz için Selenium
        Select class' olusturmustur.Bizde  bu class'dan olusturacagımız obje ıle dropdown menuden ıstediğimiz işlemleri yapabılırız.
                1.adim : dropdown webelementini locate etmek
                2.adim : Select class'ından bır obje olusturmak ve parametre olarak dropdown  elementini girmek
                3.adim : select objesi ile istediğimiz hazır method'u kullanmak
        2- JSAlerts    :    HTML sayfalarda iki tür alert ile karsılasabiliriz.
                1-    HTML alerts :  inspect yapılabilir ve locate edilerek kullanılabilir.
                2-    JSAlerts    : inspect yapılamaz dolayısıyla locate edip kullanılamaz.Bu tur bır alert ile karsılastıgımızda
                her işlem yapmak istediğimizde Driver.switchTo().alert diyerek önce alert'e geçiş yapıp sonra nokta (.) koyup
                istediğimiz işlemi yapabiliriz.
        3-iFrame : Bir HTML sayfasının içinde gömülü bir HTML sayfa oluşturmak için kullanılır.Bir sayfada webelement'i locate etmemize
        rağmen kullanamıyorsak , kullanmak istediğimiz webelement bir Iframe içerisinde olabilir.
        Eğer aradığımız webelement bir iframe içerisindeyse önce o iframe'i locate edip o iframe'e driver.switchTo().iframe()
        ile geçiş yapıp sonra istediğimiz elementi locate etmeliyiz.iframe'de işimiz bittiğinde yeniden anasayfaya geçmek içinde switchTo
        kullanmalıyız.
         */
}
