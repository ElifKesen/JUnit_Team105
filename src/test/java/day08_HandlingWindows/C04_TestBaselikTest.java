package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaselikTest extends TestBase {
    @Test
    public void test01(){
        //amazona git
        driver.get("https://www.amazon.com");

        //amazona gittigini test et

        String expKelime="amazon";
        String actUrl= driver.getCurrentUrl();

        Assert.assertTrue(actUrl.contains(expKelime));

        ReusableMethods.bekle(3);
    }
}
