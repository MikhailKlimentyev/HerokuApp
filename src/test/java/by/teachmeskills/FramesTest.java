package by.teachmeskills;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void textInsideFrameShouldMatchExpected() {
        driver.get(BASE_URL + "/iframe");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title*='Rich Text Area.']")));
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.",
                "Text does not match");
    }
}
