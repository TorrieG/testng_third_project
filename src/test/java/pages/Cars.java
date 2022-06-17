package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cars {

    public Cars(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-qa='menu-flex'] span")
    public List<WebElement> filterOptions;

    @FindBy(css = "[data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(css = "[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "[class='result-tile']")
    public List<WebElement> tileBody;

    @FindBy(css = "[class^='tk-frame']:nth-child(1) img")
    public List<WebElement> image;

    @FindBy(css = "[class^='tk-frame']:nth-child(1) svg")
    public List<WebElement> favorite;

    @FindBy(css = "[class^='tk-frame']:nth-child(2)")
    public List<WebElement> middleFrame;

    @FindBy(css = "[class='base-delivery-chip delivery-chip']")
    public List<WebElement> delivery;

    @FindBy(css = "[class='result-tile']")
    public List<WebElement> resultTiles;

    @FindBy(css = "[data-qa='base-inventory-type']")
    public List<WebElement> inventoryType;

    @FindBy(css = "[class='tk-pane full-width'] div:nth-child(2)")
    public List<WebElement> yearMakeModel;

    @FindBy(css = "[class='tk-pane full-width'] div:nth-child(3)")
    public List<WebElement> trimMileage;

    @FindBy(css = "div[class='tk-pane middle-frame-pane']>div")
    public List<WebElement> financialDetails;
    // method odd indexes = price and even indexes

    // if above doesn't work for monthly payment
    @FindBy(css = "div[class='tk-pane middle-frame-pane']>div:nth-child(1) span")
    public List<WebElement> monthlyPayment;

//    @FindBy(css = "[class='result-tile']")
//    public List<WebElement> resultTiles;
//
//    @FindBy(css = "[class='result-tile']")
//    public List<WebElement> resultTiles;
//
//    @FindBy(css = "[class='result-tile']")
//    public List<WebElement> resultTiles;
//
//    @FindBy(css = "[class='result-tile']")
//    public List<WebElement> resultTiles;

}
