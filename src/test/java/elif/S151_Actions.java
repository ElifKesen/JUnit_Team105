package elif;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class S151_Actions extends TestBase {
    /*
    1. "http://webdriveruniversity.com/Actions" sayfasina gidin
2. "Hover over Me First" kutusunun ustune gelin
3. "Link 1" e tiklayin
4. Popup mesajini yazdirin
5. Popup'i tamam diyerek kapatin
6. "Click and hold" kutusuna basili tutun
7. "Click and hold" kutusunda cikan yaziyi yazdirin
8. "Double click me" butonunu cift tiklayin
     */

@Test
    public void test1(){
    //1 "http://webdriveruniversity.com/Actions" sayfasina gidin
    driver.get("http://webdriveruniversity.com/Actions");

    //2 "Hover over Me First" kutusunun ustune gelin
    Actions action=new Actions(driver);
    WebElement HoverOverMeFirst= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
    action.moveToElement(HoverOverMeFirst).perform();
    ReusableMethods.bekle(5);

    //3 "Link 1" e tiklayin
    driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

    //4 Popup mesajini yazdirin
    String popupyazisi=driver.switchTo().alert().getText();
    System.out.println(popupyazisi);

    //5  Popup'i tamam diyerek kapatin
    driver.switchTo().alert().accept();

    //6  "Click and hold" kutusuna basili tutun
    WebElement Clickandhold =driver.findElement(By.xpath("//div[@id='click-box']"));
    action.clickAndHold(Clickandhold).perform();
    ReusableMethods.bekle(5);

    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    WebElement clickyazisi=driver.findElement(By.xpath("//div[@id='click-box']"));
    System.out.println(clickyazisi.getText());
    ReusableMethods.bekle(5);

    //8. "Double click me" butonunu cift tiklayin
    WebElement doubleClickMe =driver.findElement(By.xpath("//div[@id='double-click']"));
    action.doubleClick(doubleClickMe).perform();
    ReusableMethods.bekle(5);






    }
}



