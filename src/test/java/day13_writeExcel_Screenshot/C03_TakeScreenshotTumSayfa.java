package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TakeScreenshotTumSayfa extends TestBase {

    //amazon.com'a gidip
    // Nutella aratıp
    // arama sonuclarının Nutella içerdiğini test edin
    //Tum sayfanın screenshot'ını alın

    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSunucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String exp="Nutella";
        String actuel= aramaSunucElementi.getText();
        Assert.assertTrue(actuel.contains(exp));


        TakesScreenshot tss=(TakesScreenshot)driver;
        File tumsayfaScreenschot=new File("target/erkanResimler/tumEkranSS.jpeg");
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumsayfaScreenschot);

        ReusableMethods.bekle(5);

    }
}
