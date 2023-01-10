package elif;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class N04_booking {
    WebDriver driver;
    String https="https://www.";

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    /*
    // driverimiz ile ilgili kurulumlari baslatalim
    // https://www.booking.com/ sayfasina gidelim
   // para birimi olarak TL secelim
    // ulke olarak Turkiye yi secelim
   // sayfanin en altindan ulkeler kismini secelim
    // ulkeler sayfasindan turkiye yi secelim
   // turkiye sayfasinin secildigini test edin
     */

    @Test
    public void booking() throws InterruptedException {
        // https://www.booking.com/de sayfasina gidin
        driver.get("https://www.booking.com/de");

        Thread.sleep(3000);

        // Cookies i kabul edin
        WebElement cookies= driver.findElement(By.xpath("//button[text()='Akzeptieren']"));
        cookies.click();

        //para birimini TL secelim

        Actions booking =new Actions(driver);
        Thread.sleep(6000);

        WebElement parabirimi= driver.findElement(By.xpath("//button[@data-tooltip-text='Wählen Sie Ihre Währung']"));
        parabirimi.click();
        booking.moveToElement(parabirimi).click(parabirimi).perform();


        booking.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).perform();

        WebElement tr=driver.findElement(By.xpath("(//a[@class='bui-list-item bui-list-item--size-small '])[49]"));
        booking.moveToElement(tr).click(tr).perform();

        // ulke olarak Turkiye yi secelim

        WebElement language= driver.findElement(By.xpath("(//button[@class='bui-button bui-button--light bui-button--large'])[2]"));
        booking.moveToElement(language).click(language).perform();
        WebElement turkishLanguge= driver.findElement(By.xpath("//div[@lang='tr']"));
        booking.moveToElement(turkishLanguge).click(turkishLanguge).perform();

        // sayfanin en altindan ulkeler kismini secelim
        booking.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        WebElement ulkeler= driver.findElement(By.xpath("(//a[@data-ga='seoindexlinks'])[1]"));
        ulkeler.click();

        //ulkeler sayfasindan turkiye yi secelim
        WebElement Turkiye= driver.findElement(By.xpath("(//div[@class='block_header'])[43]"));
        booking.scrollToElement(Turkiye).click(Turkiye).perform();

        // turkiye sayfasinin secildigini test edin
        //Assert.assertTrue(Turkiye.isDisplayed());

        WebElement TR=driver.findElement(By.xpath("//a[normalize-space()='Türkiye']"));
        String actual=TR.getText();
        String exp= "Türkiye";
        Assert.assertEquals(exp,actual);

    }
}
