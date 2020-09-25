package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NotificationTest extends BaseTest {

    @Test
    public void verifyWhenClickOnLinkThenNotificationWithExpectedTextAppears() {
        driver.get(BASE_URL + "/notification_message_rendered");
        driver.findElement(By.xpath("//a[@href='/notification_message']")).click();
        WebElement flashElement = driver.findElement(By.id("flash"));
        String flashElementText = flashElement.getText();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(flashElement, flashElementText));
        assertEquals(flashElementText, "Action successful\n" +
                "×");
    }
}
