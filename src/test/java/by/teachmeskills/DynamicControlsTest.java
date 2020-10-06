package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void verifyCheckboxAndInput() {
        driver.get(BASE_URL + "/dynamic_controls");
        Actions actions = new Actions(driver);
        By checkBoxLocator = By.cssSelector("input[type=checkbox]");
        actions.click(driver.findElement(checkBoxLocator));
        driver.findElement(By.xpath("//*[@id='checkbox']/following-sibling::button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        assertTrue(isCheckboxPresent(checkBoxLocator), "Checkbox is present");

        By enableDisableInput = By.xpath("//*[@id='input-example']//input[@type='text']");
        assertFalse(driver.findElement(enableDisableInput).isEnabled(), "Input is enabled");

        driver.findElement(By.xpath("//*[@id='input-example']//button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='input-example']//*[@id='message']")));
        assertTrue(driver.findElement(enableDisableInput).isEnabled(), "Input is disabled");
    }

    private boolean isCheckboxPresent(By locator) {
        return driver.findElements(locator).size() == 0;
    }
}
