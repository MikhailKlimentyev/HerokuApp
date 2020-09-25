package by.teachmeskills;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest extends BaseTest {

    @Test
    public void verifyCellValueAsExpected() {
        driver.get(BASE_URL + "/tables");
        assertEquals(driver.findElement(By.xpath("//table[@id='table1']//tr[1]/td[3]")).getText(),
                "jsmith@gmail.com");
        assertEquals(driver.findElement(By.xpath("//table[@id='table1']//tr[4]/td[5]")).getText(),
                "http://www.timconway.com");
        assertEquals(driver.findElement(By.xpath("//table[@id='table1']//tr[3]//a[@href='#edit']")).getText(),
                "edit");
        assertEquals(driver.findElement(By.xpath("//table[@id='table2']//tr[2]/td[@class='last-name']")).getText(),
                "Bach");
        assertEquals(driver.findElement(By.xpath("//table[@id='table2']//tr[2]/td[@class='dues']")).getText(),
                "$51.00");
    }
}
