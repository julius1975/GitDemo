package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefinition extends base {

@Given("Initialize the browser with chrome")
public void initialize_the_browser_with_chrome() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	//driver=initializeDriver();   
	driver.get("https://qaclickacademy.com");
}

@Given("Navigate to {string} site")
public void navigate_to_site(String string) {
    // Write code here that turns the phrase above into concrete actions
	driver.get(string);
}

@Given("Click on login link in home page to land on secured sign in Page")
public void click_on_login_link_in_home_page_to_land_on_secured_sign_in_Page() {
    // Write code here that turns the phrase above into concrete actions
	LandingPage l=new LandingPage(driver);
	LoginPage lp=l.getLogin(); 
	lp.getLogin().click();
}

@When("User enters {string} and {string} and logs in")
public void user_enters_and_and_logs_in(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
	LandingPage l=new LandingPage(driver);
	LoginPage lp=l.getLogin();
	lp.getEmail().sendKeys(string);
	lp.getPassword().sendKeys(string2);
	lp.getLogin().click();
	
	
}

@Then("Verify that user is sucessfully logged in")
public void verify_that_user_is_sucessfully_logged_in() {
    // Write code here that turns the phrase above into concrete actions
    portalHomePage p=new portalHomePage(driver);
    Assert.assertTrue(p.getsearchBox().isDisplayed());
}


}
