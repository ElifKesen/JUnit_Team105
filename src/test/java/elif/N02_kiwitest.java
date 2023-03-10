package elif;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class N02_kiwitest extends TestBase {
    @Test
            public void kiwitest() throws InterruptedException {
    // https://www.kiwi.com sayfasina gidin
      driver.get("https://www.kiwi.com");

    // Cookies i reddedin
    WebElement cookies= driver.findElement(By.xpath("//div[text()='Akzeptieren']"));
    cookies.click();

    //WebElement Datenschutzeinstellungen= driver.findElement(By.xpath("//*[@role='dialog']"));

    //Datenschutzeinstellungen.sendKeys(Keys.PAGE_DOWN);
       // Einstellungen speichern
        //WebElement einstellungen= driver.findElement(By.xpath("(//div[text()='Einstellungen speichern'])"));

        //einstellungen.click();
        Thread.sleep(4000);
    // Sayfa basliginin "kiwi" icerdigini test edin
    Assert.assertTrue(driver.getTitle().contains("Kiwi"));

    // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    WebElement dilsecimi= driver.findElement(By.xpath("//button[@data-test='RegionalSettingsButton']"));
    dilsecimi.click();
    WebElement selectWebElemeti= driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
    Select select=new Select(selectWebElemeti);
    select.selectByValue("tr");

    WebElement currencyElementi=driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
    Select select1=new Select(currencyElementi);
    select1.selectByVisibleText("Turkish lira - TRY");

    WebElement saveButton= driver.findElement(By.xpath("//button[@data-test='SubmitRegionalSettingsButton']"));
    saveButton.click();

    WebElement text= driver.findElement(By.xpath("//*[text()='TRY']"));
    Assert.assertTrue(text.getText().contains("TRY"));

    // Ucus secenegi olarak tek yon secelim
    WebElement tekYonMenu= driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1r81o9a-0 ZYrQU'])[10]"));
    tekYonMenu.click();

    WebElement tekYon= driver.findElement(By.xpath("//a[@data-test='ModePopupOption-oneWay']"));
    tekYon.click();
    // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim

    WebElement defaultCloseCity= driver.findElement(By.xpath("//div[@data-test='PlacePickerInputPlace-close']"));
    defaultCloseCity.click();

    WebElement kalkisTextBox= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
    kalkisTextBox.sendKeys("Istanbul");
    driver.findElement(By.xpath("//*[text()='??stanbul, T??rkiye']")).click();

    WebElement varisNoktasiBox= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
    varisNoktasiBox.sendKeys("Varsova");

    driver.findElement(By.xpath("//*[text()='Var??ova, Polonya']")).click();

    // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    driver.findElement(By.xpath("//input[@data-test='SearchFieldDateInput']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//div[@data-value='2023-02-10']")).click();
    driver.findElement(By.xpath("//button[@data-test='SearchFormDoneButton']")).click();
    driver.findElement(By.xpath("//*[text()='Booking.com ile konaklama aray??n']")).click();
    driver.findElement(By.xpath("//a[@data-test='LandingSearchButton']")).click();

        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim

        driver.findElement(By.xpath("(//div[@class='Radio__IconContainer-sc-crlwn1-1 ixtoRa'])[1]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[text()='En ucuz']")).click();

        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
        WebElement fiyatText= driver.findElement(By.xpath("(//span[@class=' length-8'])[4]"));
        String fiyat=fiyatText.getText();
        System.out.println(fiyat);
        fiyat=fiyat.replaceAll(" TL","").replaceAll("\\.","");
        System.out.println(fiyat);

        Assert.assertTrue(Integer.parseInt(fiyat)<5000);


    }
}

