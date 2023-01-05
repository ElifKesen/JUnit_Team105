package elif;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestBase;

import java.io.IOException;

public class BlueEyes extends TestBase {
    @Test
    public void test01() throws IOException, InterruptedException {

        //1- https://www.amazon.de sayfasina gidin, cookies i kabul edin
        driver.get("https://www.amazon.de");

        Thread.sleep(10);

        WebElement kabulbutonu = driver.findElement(By.xpath("//span[text()='Cookies akzeptieren']"));
        kabulbutonu.click();

    }
}
