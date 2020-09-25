package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveTest extends BaseTest {

    @Test
    public void verifyWhenAdd2ElementsAndRemove1ElementThen1ElementRemains() {
        driver.get(BASE_URL + "/add_remove_elements/");
        WebElement addElement = driver.findElement(By.xpath("//*[text()='Add Element']"));
        addElement.click();
        addElement.click();

        By deleteElementsLocator = By.xpath("//div[@id='elements']/button");
        List<WebElement> deleteElements = driver.findElements(deleteElementsLocator);
        deleteElements.get(0).click();
        deleteElements = driver.findElements(deleteElementsLocator);
        assertEquals(deleteElements.size(), 1);
    }
}
