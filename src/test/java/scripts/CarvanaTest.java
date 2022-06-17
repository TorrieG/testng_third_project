package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiters;

public class CarvanaTest extends Base{

   @Test(priority = 1, description = "TC1 | Home page title and url")
    public void validateCarvanaHomePageTitleAndURL(){
       Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
       Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
   }

   @Test(priority = 2, description = "TC2 | Carvana logo")
   public void validateTheCarvanaLogo(){
      Assert.assertTrue(home.logo.isDisplayed());
   }

   @Test(priority = 3, description = "TC3 | Main navigation section items")
   public void validateTheMainNavigationSectionItems(){
      String[] navigationSectionText = {"HOW IT WORKS", "ABOUT CARVANA"};
      for (int i = 1; i < 2; i++) {
         Waiters.pause(1);
         Assert.assertEquals(home.howItWorksAndAboutCarvana.get(i).getText(), navigationSectionText[i]);
      }
      Assert.assertEquals(home.supportAndContact.getText(), "SUPPORT & CONTACT");
   }

   @Test(priority = 4, description = "TC4 | Validate the sign in error message")
   public void validateTheSignInErrorMessage(){
      home.signInLink.click();
      Assert.assertTrue(signInModal.accountModal.isDisplayed());

      actions.sendKeys(signInModal.emailPasswordInputBoxes.get(0), "johndoe@gmail.com").perform();
      actions.sendKeys(signInModal.emailPasswordInputBoxes.get(1), "abcd1234").perform();
      actions.click(signInModal.signInButton).perform();
      Assert.assertEquals(signInModal.errorMessage.getText(), "Email address and/or password combination is incorrect\nPlease try again or reset your password.");
   }

   @Test(priority = 5, description = "TC5 | Validate the search filter options and search button")
   public void validateTheSearchFilterOptionsAndSearchButton(){
      home.searchCars.click();
      Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
      String[] filterOptionsText = {
              "PAYMENT & PRICE",
              "MAKE & MODEL",
              "BODY TYPE",
              "YEAR & MILEAGE",
              "FEATURES",
              "MORE FILTERS",
      };
      for (int i = 0; i < 6; i++) {
         Assert.assertEquals(cars.filterOptions.get(i).getText(), filterOptionsText[i]);
      }
   }

   @Test(priority = 6, description = "TC6 | Validate the search result tiles")
   public void validateTheSearchResultTitles(){
      home.searchCars.click();
      Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

      for (WebElement webElement : cars.image) Assert.assertTrue(webElement.isDisplayed());
      for (WebElement webElement : cars.favorite) Assert.assertTrue(webElement.isDisplayed());
      for (WebElement webElement : cars.tileBody) Assert.assertTrue(webElement.isDisplayed());

      for (int i = 0; i < 20; i++) {
         Assert.assertTrue(cars.yearMakeModel.get(i).isDisplayed());
         Assert.assertNotNull(cars.yearMakeModel.get(i).getText());
         Assert.assertTrue(cars.trimMileage.get(i).isDisplayed());
         Assert.assertNotNull(cars.trimMileage.get(i));
      }
      for (int i = 0; i < 40; i++) {
         if (i % 2 == 0){
            //System.out.println(Integer.parseInt(String.valueOf(cars.financialDetails.get(i).getText()).replaceAll("[^0-9]","")));
            Assert.assertTrue(Integer.parseInt(String.valueOf(cars.financialDetails.get(i).getText()).replaceAll("[^0-9]","")) > 0);
         }
         System.out.println(cars.financialDetails.get(i).getText());
         Assert.assertTrue(cars.financialDetails.get(i).isDisplayed());
         Assert.assertNotNull(cars.financialDetails.get(i).getText());
      }
      for (WebElement webElement : cars.delivery) Assert.assertNotNull(webElement.getText());
   }
}

