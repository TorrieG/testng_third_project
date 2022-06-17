package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home {

    public Home(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@data-qa='icon-wrapper'])[5]")
    public WebElement logo;

    @FindBy(css = "[data-qa='navigation-wrapper'] span")
    public List<WebElement> howItWorksAndAboutCarvana;

    @FindBy(css = "[class$=hsULzE]")
    public WebElement supportAndContact;

    @FindBy(css = "[class*='SignInLink']>a")
    public WebElement signInLink;

    @FindBy(xpath = "//*[text()='Search Cars']")
    public WebElement searchCars;


}
