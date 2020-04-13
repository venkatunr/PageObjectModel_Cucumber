package stepdefination;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import initializer.TestBase;
import pages.ListboxCascadingPage;
import utilities.GenericFunctions;

public class ListboxCascadingTest extends TestBase{

	public ListboxCascadingTest() throws IOException {
		super();
	}

	@Before
	public void setup() throws Exception {
		browserSetup();
	}	

	@Given("^user navigated to listbox control$")
	public void user_navigated_to_listbox_control() throws Throwable {
		driver.get(prop.getProperty("url"));
		ListboxCascadingPage.clickOnListboxFromHomePage();
	}

	@Given("^user clicks on checkbox control$")
	public void user_clicks_on_checkbox_control(){
		ListboxCascadingPage.clickOnCheckboxFromListboxPage();
	}

	@When("^all checkbox should be unselected$")
	public void all_checkbox_should_be_unselected() throws Throwable {
		ListboxCascadingPage.optionsShouldBeUnselected();
		Thread.sleep(3000);
	}

	@Then("^ensure options are selectable$")
	public void ensure_options_are_selectable() throws InterruptedException {
		ListboxCascadingPage.clickAllOptions();
	}

	@Given("^user clicks on check all option$")
	public void user_clicks_on_check_all_option(){
		ListboxCascadingPage.clickOnCheckboxFromListboxPage();
		ListboxCascadingPage.clickOnCheckAllButton();
	}

	@When("^all options are should be selected$")
	public void all_options_are_should_be_selected(){
		ListboxCascadingPage.ensureCheckboxSelections();
	} 

	@Then("^ensure uncheck option$")
	public void ensure_uncheck_option(){
		ListboxCascadingPage.clickOnUncheckAllButton();
		ListboxCascadingPage.ensureAllOptionsAreUnchecked();
	}

	@Given("^select options from list$")
	public void select_options_from_list() throws Throwable {
		ListboxCascadingPage.checkboxSelectionfromlist("A");
	}

	@When("^clicks on get values$")
	public void clicks_on_get_values() throws Throwable {
		ListboxCascadingPage.clickOnGetValuesButton();
	}

	@Then("^options should be listed based on selected value$")
	public void options_should_be_listed_based_on_selected_value() throws Throwable {
		ListboxCascadingPage.valuesListedBasedOncheckboxSelection("A");
	}

	@Given("^click on hide check box option$")
    public void click_on_hide_check_box_option() throws Throwable {
		ListboxCascadingPage.clickOnCheckboxFromListboxPage();
        ListboxCascadingPage.clickOnHideCheckboxButton();
    }

    @Then("^checkbox options should be disable$")
    public void checkbox_options_should_be_disable() throws Throwable {
        ListboxCascadingPage.disableAllCheckboxoptions();
    }

    @When("^click on show check box option$")
    public void click_on_show_check_box_option() throws Throwable {
    	driver.findElement(By.xpath("//*[@id=\"bthshowhide-wrapper\"]/button")).click();
    }
    
    @Then("^checkbox options should be enable$")
    public void checkbox_options_should_be_enable() throws Throwable {
      List<WebElement> listofElements=driver.findElements(By.xpath("//*[@id=\"skillsets\"]//li//descendant::span[@class='e-chk-inact']"));
      System.out.println(listofElements.size());
      for (WebElement webElement : listofElements) {
    	  GenericFunctions.element_ScrollIntoView(driver, webElement);
		GenericFunctions.verifyDisplayed(webElement);
	}
    }

}
