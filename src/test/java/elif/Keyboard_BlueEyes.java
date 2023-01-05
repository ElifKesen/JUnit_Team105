package elif;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Keyboard_BlueEyes {
    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {

        //driver.quit();
    }

    @Test
    public void test01() throws IOException {

        //1- https://www.amazon.de sayfasina gidin, cookies i kabul edin
        driver.get("https://www.amazon.de");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement kabulbutonu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cookies akzeptieren']")));
        Actions actions = new Actions(driver);
        actions.click(kabulbutonu).perform();

        //2- Arama kutusuna actions method’larine kullanarak Blue Eyes Katzenklo Matte yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //aramaKutusu.sendKeys("Blue Eyes Katzenklo Matte"+ Keys.ENTER);



        actions
                .click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("b")
                .keyUp(Keys.SHIFT)
                .sendKeys("lue ")
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("yes ")
                .keyDown(Keys.SHIFT)
                .sendKeys("k")
                .keyUp(Keys.SHIFT)
                .sendKeys("atzenklo ")
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("atte ")
                .sendKeys(Keys.ENTER)
                .perform();


        ReusableMethods.bekle(5);

        //WebElement kategori=driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[2]"));
        //Actions actions1=new Actions(driver);
        //actions1.moveToElement(kategori).perform();

        //driver.findElement(By.id("nav-cart-text-container")).click();

        TakesScreenshot tss=(TakesScreenshot)driver;
        File tumsayfaScreenschot=new File("target/erkanResimler/tumEkranSS.jpeg");
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumsayfaScreenschot);


        //3- aramanin gerceklestigini test edin

        //Sonuclarin gösterildigi yerin lokasyonunda hata veriyor diye farkli denemeler yapmak istedim,
        // Alisverissepetine gittim mesela, hata olmuyor, oraya gidiyor,
        //
        //driver.navigate().back();

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYaziElementi.getText());

        //String expectedKelime = "Blue Eyes Katzenklo Matte";
        //WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[text()='7 Ergebnisse für']"));
        //String actualsonuc = sonucYaziElementi.getText();
       // Assert.assertTrue(actualsonuc.contains(expectedKelime));

       // System.out.println(expectedKelime);


    }
}

