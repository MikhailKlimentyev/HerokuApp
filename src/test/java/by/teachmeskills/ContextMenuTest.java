package by.teachmeskills;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ContextMenuTest extends BaseTest {

    @Test
    public void whenContextClickThenAlertOpensWhenCloseAlertThenAlertClosed() {
        driver.get(BASE_URL + "/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "You selected a context menu", "Invalid alert message");
        alert.accept();
        assertFalse(isAlertPresent());
    }

    private boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
