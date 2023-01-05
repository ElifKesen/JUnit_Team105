package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
    /*
    Selenium 4 ile windows konusunda yeni bir özellik geldi

    istersek kontrollu olarak driver icin yeni bir window yada tab acabiliriz
    bu durumda driverimiz da otomatik yeni sayfaya gecmis olur

    Testin ilerleyen asamalarinda yeniden eski sayfaya dönus görevci varsa o sayfada iken
    o sayfanin handle degeri alinip kaydedilir
    ve o sayfaya gecmek istendiginde
    driver.swichto.window (istenen sayfanin handle degeri)
    kodu ile o sayfaya gecis yapilir
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.quit();
    }


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");


        Thread.sleep(3000);

        //Testin ilerleyen asamalarinda yeniden amazon a dönmek gerekiyorsa,
        // amazon sayfasindayken bu windowun window handle degerini alip kaydetmeliyiz
        String ilksayfaHandledegeri= driver.getWindowHandle();

        //yeni bir TAB a gecelim, gittigimizi test edelim

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedKelime= "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);

        //wisequarter testini yaptiktan sonra yeniden amazonun acik oldugu tab a gecin
        // amazon anasayfanin acik oldugunu test edin

        driver.switchTo().window(ilksayfaHandledegeri);

        actualUrl= driver.getCurrentUrl();
         expectedKelime= "amazon";

        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);

    }




}
