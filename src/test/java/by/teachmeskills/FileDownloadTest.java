package by.teachmeskills;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileShouldBeDownloaded() throws InterruptedException {
        driver.get(BASE_URL + "/download");
        String fileToDownloadName = "hello_world.txt";
        driver.findElement(By.xpath(String.format("//*[text()='%s']", fileToDownloadName))).click();
        Thread.sleep(1000);
        File folder = new File(System.getProperty("user.dir"));
        File[] files = folder.listFiles();
        boolean found = false;
        File file = null;
        for (File fileItem : files) {
            if (fileItem.isFile()) {
                String fileName = fileItem.getName();
                System.out.println("File " + fileItem.getName());
                if (fileName.matches(fileToDownloadName)) {
                    file = new File(fileName);
                    found = true;
                }
            }
        }
        try {
            assertTrue(found, "Downloaded document is not found");
        } finally {
            file.deleteOnExit();
        }
    }
}
