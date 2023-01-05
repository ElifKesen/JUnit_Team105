package elif;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class S103_zero {

    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
kontrol edin.
     */


   static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() {

        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {
        //1.
        driver.get("http://zero.webappsecurity.com/");

        //2.
        //driver.findElement(By.id("signin_button")).click();
        // önce id sonra xpath ile yaptim, ikisi de calisiyor
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4.  Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //6. Pay Bills sayfasina gidin(navigate back)
        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        //driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

       // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // “8. Currency” drop down menusunden Eurozone’u secin
        WebElement ddE= driver.findElement(By.id("pc_currency"));
        Select select=new Select(ddE);
        select.selectByVisibleText("Eurozone (euro)");
        //select.selectByIndex(6);

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("2000");
        //driver.findElement(By.xpath("//input[@name='amount'][2]")).sendKeys("2000");
        // burada id den baska attribute olmuyor, cunku uniqe olan sadece id, name ve class ikiser tane

        //10. “US Dollars” in secilmedigini test edin
        //WebElement USD=driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        WebElement USD=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(USD.isSelected());

        //11. “Selected currency” butonunu secin

        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();
        //driver.findElement(By.id("pc_inDollars_false")).click();


        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@class='btn pull-right']")).click();
        //driver.findElement(By.id("pc_calculate_costs"));

        //driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click(); bu calismadi
        driver.findElement(By.id("purchase_cash")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        //WebElement successfully=driver.findElement(By.id("alert_content"));
        WebElement successfully=driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(successfully.isDisplayed());
    }









}
