package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_DragAndDrop extends TestBase {
    /*


1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElementi=driver.findElement(By.id("draggable"));
        WebElement birakilacakAlanElementi=driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElementi,birakilacakAlanElementi).perform();
        ReusableMethods.bekle(5);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYaziElementi= driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']"));
        //ben lokasyonu degistirdim, hocaninki Dropped idi, ben de o calismadi

        Assert.assertTrue(droppedYaziElementi.isDisplayed());
    }


}