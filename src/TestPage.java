import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestPage {
    WebDriver wd;

    @BeforeTest
    public void init() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().window().maximize();
        wd.get("https://gallery-app.vivifyideas.com/");
        Assert.assertTrue(wd.getCurrentUrl().equals("https://gallery-app.vivifyideas.com/"),
                "The URL is correct");
        Page login = new Page(wd);
        login.loginToPage();
    }
    @AfterSuite
    public void close() throws IOException {
        wd.close();
        Runtime.getRuntime().exec("taskkill /F /IM cromedriver.exe /T");
    }
//    @Test
//    public void login() throws InterruptedException {
//        wd.get("https://gallery-app.vivifyideas.com/");
//        Assert.assertTrue(wd.getCurrentUrl().equals("https://gallery-app.vivifyideas.com/"),
//                "The URL is correct");
//        Page login = new Page(wd);
//        login.loginToPage();
//    }
    @Test
    public void createGallery() throws InterruptedException {
        Page createGlr = new Page(wd);
        createGlr.createGallery();
        WebElement loginSuccessful = wd.findElement(By.xpath("//a[contains(text(),'Galerija')]"));
        Assert.assertTrue(loginSuccessful.getText().equals("Galerija"), "Gallery was added successfully.");
    }
    @Test
    public void editGallery() throws InterruptedException {
        Page editGlr = new Page(wd);
        editGlr.createGallery();
        editGlr.editGallery();
    }
    @Test
    public void commentGallery() {
        Page cmntGlr = new Page(wd);
        cmntGlr.createGallery();
        cmntGlr.commentGallery();
    }
    @Test
    public void deleteGallery() {
        Page delGlr = new Page(wd);
        delGlr.createGallery();
        delGlr.deleteGallery();
        wd.switchTo().alert().accept();
    }
    @Test
    public void logout() throws InterruptedException {
        Page logout = new Page(wd);
        Thread.sleep(2000);
        logout.logout();
    }
}
