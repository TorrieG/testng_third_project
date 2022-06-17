package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInModal {

    public SignInModal(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-cv-test='Header.Modal']")
    public WebElement accountModal;

    @FindBy(css = "[data-qa='account-modal-row']")
    public List<WebElement> emailPasswordInputBoxes;

    @FindBy(css = "[data-cv='sign-in-submit']")
    public WebElement signInButton;

    @FindBy(css = "[data-qa='error-message-container']")
    public WebElement errorMessage;
}
