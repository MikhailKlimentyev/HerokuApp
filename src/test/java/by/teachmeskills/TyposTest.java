package by.teachmeskills;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {

    private static final String EXPECTED_TEXT = "This example demonstrates a typo being introduced." +
            " It does it randomly on each page load.\n\nSometimes you'll see a typo, other times you won't.";

    @Test
    public void verifyTextSameAsExpected() {
        driver.get(BASE_URL + "/typos");
        String innerText = driver.findElement(By.xpath("//div[@class='example']")).getAttribute("innerText");
        String[] splitterText = innerText.split("\n\n", 2);
        assertEquals(splitterText[1], EXPECTED_TEXT);
    }
}
