package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    private static final String NOT_FOUND = "Not Found";

    private static String baseFigurePath = "//div[@class='figure'][%s]//%s";

    @Test
    public void verifyWhenHoverOnUserThenUserNameAndLinkAppearWhenClickOnLinkThenNotFoundPageOpens() {
        driver.get(BASE_URL + "/hovers");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElements(By.className("figure")).get(0)).build().perform();
        String user1NameText = driver.findElement(getUserNameTextLocator(1)).getText();
        Assert.assertEquals(user1NameText.split(" ")[1], "user1");
        driver.findElement(getUserLinkLocator(1)).click();
        Assert.assertEquals(getNotFoundText(), NOT_FOUND);

        driver.navigate().to(BASE_URL + "/hovers");
        action.moveToElement(driver.findElements(By.className("figure")).get(1)).build().perform();
        String user2NameText = driver.findElement(getUserNameTextLocator(2)).getText();
        Assert.assertEquals(user2NameText.split(" ")[1], "user2");
        driver.findElement(getUserLinkLocator(2)).click();
        Assert.assertEquals(getNotFoundText(), NOT_FOUND);

        driver.navigate().to(BASE_URL + "/hovers");
        action.moveToElement(driver.findElements(By.className("figure")).get(2)).build().perform();
        String user3NameText = driver.findElement(getUserNameTextLocator(3)).getText();
        Assert.assertEquals(user3NameText.split(" ")[1], "user3");
        driver.findElement(getUserLinkLocator(3)).click();
        Assert.assertEquals(getNotFoundText(), NOT_FOUND);
    }

    private By getUserNameTextLocator(int userNumber) {
        return By.xpath(String.format(baseFigurePath, userNumber, "h5"));
    }

    private By getUserLinkLocator(int userNumber) {
        return By.xpath(String.format(baseFigurePath, userNumber, "a"));
    }

    private String getNotFoundText() {
        return driver.findElement(By.tagName("body")).getAttribute("innerText");
    }
}
