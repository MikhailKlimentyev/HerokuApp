package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    @Test
    public void verifyDropdownContains3OptionsAnd2OptionsCanBeSelectedAnd1OptionCannotBeSelected() {
        driver.get(BASE_URL + "/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        assertEquals(dropdownOptions.size(), 3);
        assertEquals(dropdownOptions.get(0).getText(), "Please select an option");
        assertEquals(dropdownOptions.get(1).getText(), "Option 1");
        assertEquals(dropdownOptions.get(2).getText(), "Option 2");

        dropdown.selectByValue("1");
        assertEquals(dropdown.getAllSelectedOptions().size(), 1);
        assertTrue(dropdown.getAllSelectedOptions().get(0).isSelected());
        assertEquals(dropdown.getAllSelectedOptions().get(0).getText(), "Option 1");

        dropdown.selectByValue("2");
        assertEquals(dropdown.getAllSelectedOptions().size(), 1);
        assertTrue(dropdown.getAllSelectedOptions().get(0).isSelected());
        assertEquals(dropdown.getAllSelectedOptions().get(0).getText(), "Option 2");

        dropdown.selectByVisibleText("Please select an option");
        assertEquals(dropdown.getAllSelectedOptions().size(), 1);
        assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
    }
}
