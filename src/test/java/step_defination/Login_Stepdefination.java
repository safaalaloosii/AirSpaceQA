package step_defination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.Base_Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Login_Stepdefination extends Base_Page {
    Base_Page base_page = new Base_Page();

    @When("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/login");
    }

    @When("provides  valid username and password")
    public void provides_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        String usernameValue= ConfigurationReader.getProperties("username");
        String passwordValue = ConfigurationReader.getProperties("password");
        usernameInput.sendKeys(usernameValue);
        passwordInput.sendKeys(passwordValue, Keys.ENTER);
    }

    @Then("see Login success message")
    public void see_login_success_message() {
        WebElement successMessage= Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/h4"));
        String  actualMessage= successMessage.getText();
        String expectedmessage= "Welcome to the Secure Area. When you are done click logout below.";
        Assert.assertEquals(actualMessage,expectedmessage);

    }


}
