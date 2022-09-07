package com.westernunion.step_definitions;

import com.westernunion.pages.WU_settingPage;
import com.westernunion.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class WU_StepDef {

    WU_settingPage wu_pages= new WU_settingPage();

    @Given("User should launches on the given url")
    public void user_launches_on_the_given_url() {
        wu_pages.acceptCookies.click();
    }

    @When("User should expand burger menu")
    public void user_expand_burger_menu(){

        wu_pages.closeButton.click();

        wu_pages.burgerMenu.click();

    }
    @And("User should be able to click Settings option")
    public void user_selects_settings_page() {
        wu_pages.settings.click();

    }
    @And("User should changes country to United States")
    public void User_should_changes_country_to_United_States() {


        Select select = new Select(wu_pages.dropdown);
        select.selectByVisibleText("United States");

        wu_pages.yesButton.click();

    }
    @Then("Verify User navigates to selected country")
    public void verify_user_navigates_to_selected_country() {

        String[] currentUrl = Driver.getDriver().getCurrentUrl().split("/");

        String expectedCountryID = "us";

        Assert.assertEquals(expectedCountryID,currentUrl[3]);

    }


    @When("User should be able to click Find locations option")
    public void user_should_be_able_to_click_find_locations_option() {

       wu_pages.findLocation.click();
    }
    @And("User should enter the zip code")
    public void user_should_enter_the_zip_code() {

        Driver.getDriver().switchTo().frame(wu_pages.Iframe);
        wu_pages.zipCodeInput.sendKeys("08247"+ Keys.ENTER);
    }
    @And("User clicks the Open now button")
    public void user_clicks_the_open_now_button() {
        wu_pages.openNowButton.click();
    }
    @Then("Verify User can get the first agent's adress")
    public void verify_user_can_get_the_first_agent_s_adress() {
        System.out.println( wu_pages.getAddress());
    }


}
