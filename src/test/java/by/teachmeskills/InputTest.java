package by.teachmeskills;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InputTest extends BaseTest {

    @Test(dataProvider = "data provider")
    public void verifyWhenEnterTextAndUseArrowsThenTextValidatedAndValueIncreasedAndDecreasedBy1(String text,
                                                                                                 String expectedText) {
        driver.get(BASE_URL + "/inputs");
        WebElement input = driver.findElement(By.xpath("//input[@type='number']"));
        input.sendKeys(text);
        assertEquals(input.getAttribute("value"), expectedText);

        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), getNumberAsString(expectedText, 1));
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), getNumberAsString(expectedText, 2));

        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), getNumberAsString(expectedText, 1));
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), trimLeadingZeros(trimLeadingZeros(expectedText)));
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), getNumberAsString(expectedText, -1));
    }

    @DataProvider(name = "data provider")
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"0", "0"},
                {"1", "1"},
                {"0001", "0001"},
                {"-1", "-1"},
                {"-02", "-02"},
                {"100500", "100500"},
                {"-100500", "-100500"},
                {"50 10", "5010"},
                {"    31", "31"},
                {"-17    ", "-17"},
                {"   0 2   5   ", "025"},
                {"1.5", "1.5"},
                {"0.0001", "0.0001"},
                {"-0.1", "-0.1"},
                {"1000.023", "1000.023"},
                {"-50.3343", "-50.3343"},
                {"0......1", ""},
                {"-0..245", ""},
                {"5......", ""},
                {"0,1", "01"},
                {"5555,,,3", "55553"},
                {"-2,4", "-24"},
                {"adgfhdfjdkfkdgdlgl", ""},
                {"ABC", ""},
                {" fgHvFFb ", ""},
                {"ab  c", ""},
                {"1ab  4c4 35", "14435"},
                {"   4Русский4 текст1", "441"},
                {"描摹 临摹 复写 复制", ""},
                {"0描摹临摹5复写 复制1", "051"},
                {"!@#$%^&*()_+-={}[]\\\"'|,.<>/?~", ""},
                {"1!@#$%^&*()_+2- ={}[]\\\"'|,.<>/?~3", ""},
        };
    }

    private String trimLeadingZeros(String string) {
        if (string.length() == 1) {
            return string;
        } else if ("^0*\\d+".matches(string)) {
            String trimmedString = string.replaceFirst("0*", "");
            return getNumberAsString(trimmedString, 0);
        } else if ("^-0*\\d+".matches(string)) {
            String trimmedString = string.replaceFirst("^-0*", "-");
            return getNumberAsString(trimmedString, 0);
        } else {
            return getNumberAsString(string, 0);
        }
    }

    private String getNumberAsString(String text, int number) {
        if (text.equals("")) {
            return String.valueOf(number);
        }
        double parsedNumber = Double.parseDouble(text);
        if (parsedNumber < 0) {
            return String.valueOf((int) Math.floor(parsedNumber) + number);
        }
        return String.valueOf((int) parsedNumber + number);
    }
}
