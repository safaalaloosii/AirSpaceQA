package step_defination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.Base_Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Negitve_Login extends Base_Page {


        @When("user is on the home page")
        public void user_is_on_the_home_page() {
                Driver.getDriver().get("https://the-internet.herokuapp.com/login");
        }

        @When("provides invalid username and password")
        public void provides_invalid_username_and_password() {
                // Write code here that turns the phrase above into concrete actions
                String usernameValue= ConfigurationReader.getProperties("invaliduserName");
                String passwordValue = ConfigurationReader.getProperties("invalidPassword");
                usernameInput.sendKeys(usernameValue);
                passwordInput.sendKeys(passwordValue, Keys.ENTER);
        }

        @Then("user should see failure message")
        public void user_should_see_failure_message() {
                WebElement failureMessage = Driver.getDriver().findElement(By.xpath("/*[@id=flash]"));
                String actualMessage = failureMessage.getText();
                String expectedMessage = "Your username is invalid!";
                Assert.assertEquals(actualMessage, expectedMessage);
        }
    }

