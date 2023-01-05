package elif;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Trendyol extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.trendyol.com/");
        driver.findElement(By.xpath("//*[text()='Akzeptieren']")).click();
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@class='search-bar']"));
        aramakutusu.sendKeys("Kleid"+ Keys.ENTER);


        ReusableMethods.bekle(5);





    }
}
