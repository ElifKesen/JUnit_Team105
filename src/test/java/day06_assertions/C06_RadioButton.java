package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {
      /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
 a. Verilen web sayfasına gidin.
     https://facebook.com
 b. Cookies’i kabul edin
 c. Create an account buton’una basin
 d. Radio button elementlerini locate edin ve size uygun olani secin
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

        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	     https://facebook.com
        driver.get("https://facebook.com");
        //	b. Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@title='Nur erforderliche Cookies erlauben']")).click();
        //	c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //	d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        ///a[@data-testid='open-registration-form-button']

        Thread.sleep(4000);
    }



}
