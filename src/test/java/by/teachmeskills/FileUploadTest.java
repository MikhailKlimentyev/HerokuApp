package by.teachmeskills;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {

    @Test
    public void whenFileUploadThenFileUploaded() {
        driver.get(BASE_URL + "/upload");
        String fileName = "test.txt";
        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        assertEquals(driver.findElement(By.id("uploaded-files")).getText(), fileName, "File name so not match");
    }
}
