package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxTest extends BaseTest {

    @Test
    public void verifyWhenCheckboxesClickedThenTheyChangeState() {
        driver.get(BASE_URL + "/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//form[@id='checkboxes']/input[@type='checkbox']"));

        WebElement firstCheckbox = checkboxes.get(0);
        assertFalse(firstCheckbox.isSelected());
        firstCheckbox.click();
        assertTrue(firstCheckbox.isSelected());

        WebElement secondCheckbox = checkboxes.get(1);
        assertTrue(secondCheckbox.isSelected());
        secondCheckbox.click();
        assertFalse(secondCheckbox.isSelected());
    }
}
