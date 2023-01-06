package day13_writeExcel_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecutor extends TestBase {
    @Test
    public void test01() {
        // amazon safyasına gidin
        driver.get("https://www.amazon.com");
        // sell linkine JSExecuter kullanarak click yapın
        WebElement sellLinki=driver.findElement(By.xpath("//a[text()='Verkaufen bei Amazon']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",sellLinki);
        jse.executeScript("alert('Bu iş bu kadar')");
    }

}
