package stepdefination;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import initializer.TestBase;
import pages.ListboxCascadingPage;
import utilities.GenericFunctions;

public class MultiSelectionTest extends TestBase{

	public MultiSelectionTest() throws IOException {
		super();
	}

	@Before
	public void setup() throws Exception {
		browserSetup();
	}
	
	@Given("^user navigated to multiselection control$")
    public void user_navigated_to_multiselection_control() throws Throwable {
     driver.get(prop.getProperty("url"));
     ListboxCascadingPage.clickOnListboxFromHomePage();
     WebElement element=driver.findElement(By.xpath("//span[text()='Multi-Selection']"));
		element.click();
    }
	
	@Given("^ensure all options are clickable$")
    public void ensure_all_options_are_clickable() throws Throwable {
		List<WebElement> alloptions=ListboxCascadingPage.listofSkils();
		for (WebElement webElement : alloptions) {
			GenericFunctions.element_ScrollIntoView(driver, webElement);
			webElement.click();
		}
   	}
	
	@Given("^ensure all options are selectable$")
    public void ensure_all_options_are_selectable() throws Throwable {
		List<WebElement> alloptions=ListboxCascadingPage.listofSkils();
		for (WebElement webElement : alloptions) {
			GenericFunctions.element_ScrollIntoView(driver, webElement);
			Actions act=new Actions(driver);
			act.keyDown(Keys.CONTROL).click(webElement).keyUp(Keys.CONTROL).build().perform();
			assertTrue(webElement.getAttribute("class").contains("e-select"));
		}
    }

	
}
