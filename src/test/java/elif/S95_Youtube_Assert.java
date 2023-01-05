package elif;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S95_Youtube_Assert {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void tearDowm() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void titleTest(){
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void imageTesti(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement resim =driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(resim.isDisplayed());
    }
    @Test
    public void searchBoxTesti(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.id("search-input")).isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle="youtube";
        String actualTitle= driver.getTitle();
        System.out.println(expectedTitle);
        System.out.println(actualTitle);

        Assert.assertNotEquals(expectedTitle,actualTitle);
    }
}
