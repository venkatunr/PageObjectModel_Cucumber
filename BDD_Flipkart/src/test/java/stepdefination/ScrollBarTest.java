package stepdefination;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import initializer.TestBase;
import utilities.GenericFunctions;

public class ScrollBarTest extends TestBase{

	public ScrollBarTest() throws IOException {
		super();
	}

	
	@Before
	public void setup() throws Exception {
		browserSetup();
	}
	
	@Given("^user clicks on scrollbar$")
    public void user_clicks_on_scrollbar() throws Throwable {
    driver.get(prop.getProperty("url"));
    WebElement element=driver.findElement(By.xpath("//span[text()='ScrollBar' and @class='anchor']"));
	GenericFunctions.element_ScrollIntoView(driver, element);
	element.click();
	}
	
	@Given("^ensure up and down slider functionalites for virtual scrollbar$")
    public void ensure_up_and_down_slider_functionalites_for_virtual_scrollbar() throws Throwable {
		WebElement element=driver.findElement(By.xpath("//*[@id=\"scrollcontent\"]/div[2]/div/div[3]"));

		for (int i = 0; i < 3; i++) {
			element.click();
		} 
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"scrollcontent\"]/div[2]/div/div[1]"));
		for (int i = 0; i < 3; i++) {
			element1.click();
		}
	}

    @When("^ensure left and right slider functionalites for horizontal scrollbar$")
    public void ensure_left_and_right_slider_functionalites_for_horizontal_scrollbar() throws Throwable {
    	WebElement element=driver.findElement(By.xpath("//*[@id=\"scrollcontent\"]/div[3]/div/div[3]"));
		for (int i = 0; i < 3; i++) {
			element.click();
		} 
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"scrollcontent\"]/div[3]/div/div[1]"));
		for (int i = 0; i < 3; i++) {
			element1.click();
		}
    }

}
