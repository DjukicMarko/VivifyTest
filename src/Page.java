import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    private WebDriver wd;

    public Page(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement pass;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submit;
    @FindBy(xpath = "//a[contains(text(),'Create Gallery')]")
    WebElement createGallery;
    @FindBy(id = "title")
    WebElement title;
    @FindBy(id = "description")
    WebElement description;
    @FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]")
    WebElement imageUrl;
    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitBtn;
    @FindBy(xpath = "//a[contains(text(),'Galerija')]")
    WebElement galleryCreated;
    @FindBy(xpath = "//button[contains(text(),'Delete Gallery')]")
    WebElement deleteGallery;
    @FindBy(xpath = "//a[contains(text(),'My Galleries')]")
    WebElement myGalleries;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;

    public void loginToPage() throws InterruptedException {
        loginButton.click();
        inputEmail.sendKeys("testmail@gmail.com");
        pass.sendKeys("123456789");
        submit.click();
        Thread.sleep(3000);
    }
    public void createGallery() {
        createGallery.click();
        title.sendKeys("Galerija");
        description.sendKeys("Opis galerije");
        imageUrl.sendKeys("https://i.pinimg.com/originals/c4/bf/ff/c4bfff970d3a444eb3374089ddbd28b9.jpg");
        submitBtn.click();
    }
    public void editGallery() throws InterruptedException {
        myGalleries.click();
        galleryCreated.click();
        WebElement editGalleryBtn = wd.findElement(By.xpath("//a[contains(text(),'Edit Gallery')]"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", editGalleryBtn);
        editGalleryBtn.click();
        title.clear();
        Thread.sleep(2000);
        title.sendKeys("Nova galerija");
        submitBtn.click();
    }
    public void commentGallery() {
        galleryCreated.click();
        WebElement commentTextBox = wd.findElement(By.xpath("//textarea[@id='']"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", commentTextBox);
        commentTextBox.sendKeys("Comment this gallery");
        submitBtn.click();
    }
    public void deleteGallery() {
        galleryCreated.click();
        WebElement deleteGallery = wd.findElement(By.xpath("//button[contains(text(),'Delete Gallery')]"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", deleteGallery);
        deleteGallery.click();
    }
    public void logout() {
        logout.click();
    }
}
