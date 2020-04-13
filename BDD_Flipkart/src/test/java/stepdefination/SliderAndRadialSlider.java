package stepdefination;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import initializer.TestBase;
import junit.framework.Assert;
import utilities.GenericFunctions;

public class SliderAndRadialSlider extends TestBase {

	public SliderAndRadialSlider() throws IOException {
		super();
	}

	@Before
	public void setup() throws Exception {
		browserSetup();
	}

	@Given("^user clicks on slider link$")
	public void user_clicks_on_slider_link(){
		driver.get(prop.getProperty("url")); 
		WebElement element=driver.findElement(By.xpath("//*[@id=\"accordion2\"]//descendant::span[text()='Slider']"));
		GenericFunctions.element_ScrollIntoView(driver, element);
		element.click();
	}

	@When("^user landed on default functionality$")
	public void user_landed_on_default_functionality() throws Exception {
		String title= driver.getTitle();
		assertTrue(title.contains("Slider - Default Functionalities Demo"));
	}

	@Then("^verify the default value of Details of Loan$")
	public void verify_the_default_value_of_details_of_loan() throws Throwable {
		String loanamount=driver.findElement(By.xpath("(//*[@id='samplefile']//descendant::span[@class='value'])[1]")).getText();
		int i=Integer.parseInt(loanamount);
		assertEquals(25000, i);

		String interestRate=driver.findElement(By.xpath("(//*[@id=\"samplefile\"]//descendant::span[@class='value'])[2]")).getText();
		int j=Integer.parseInt(interestRate);
		assertEquals(4, j);

		String tenture=driver.findElement(By.xpath("(//*[@id=\"samplefile\"]//descendant::span[@class='value'])[3]")).getText();
		int k=Integer.parseInt(tenture);
		assertEquals(3, k);   

		String emiamount=driver.findElement(By.id("EventLog")).getText().replace("$ ", "");
		int l=Integer.parseInt(emiamount);
		assertEquals(738, l);   
	}

	@Given("^ensure min value of loan amount$")
	public void ensure_min_value_of_loan_amount() throws Throwable {
		WebElement slider=driver.findElement(By.xpath("//div[@id='loanSlider']"));
		int xposition=slider.getLocation().getX();
	
		WebElement sliderButton=driver.findElement(By.xpath("//div[@id='loanSlider']//a[contains(@class,'e-handle')]"));
		int buttonposition=sliderButton.getLocation().getX();
		int widthButton=sliderButton.getSize().getWidth();
		int value=-(widthButton-(xposition-buttonposition)*2)/2;
	
		Actions action=new Actions(driver);
		//action.clickAndHold(sliderButton).moveByOffset(value, 0).release().build().perform();
		action.dragAndDropBy(sliderButton, value, 0).build().perform();
		
		WebElement  loanamount=driver.findElement(By.xpath("(//*[@id='samplefile']//descendant::span[@class='value'])[1]"));
		String loanamt=loanamount.getText();
		assertEquals("10000", loanamt);
		assertTrue(sliderButton.getAttribute("style").contains("left: 0%"));
		
	} 

	@When("^ensure max value of loan amount$")
	public void ensure_max_value_of_loan_amount() throws Throwable {
		driver.navigate().refresh();
		WebElement slider=driver.findElement(By.xpath("//div[@id='loanSlider']"));
		Dimension dim=slider.getSize();
		int width=dim.getWidth();
		System.out.println(width);
		
		WebElement sliderButton=driver.findElement(By.xpath("//div[@id='loanSlider']//a[contains(@class,'e-handle')]"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(sliderButton, width, 0).build().perform();
		WebElement  loanamount=driver.findElement(By.xpath("(//*[@id='samplefile']//descendant::span[@class='value'])[1]"));
		String loanamt=loanamount.getText();
		assertEquals("1000000", loanamt);
		assertTrue(sliderButton.getAttribute("style").contains("left: 100%"));
		
	}
	
	 @When("^ensure scroll step by step$")
	    public void ensure_scroll_step_by_step() throws Throwable {
		 driver.navigate().refresh();
			
		 WebElement slider=driver.findElement(By.xpath("//div[@id='loanSlider']"));
			Dimension dim=slider.getSize();
			int width=dim.getWidth();
			System.out.println(width);
			WebElement sliderButton=driver.findElement(By.xpath("//div[@id='loanSlider']//a[contains(@class,'e-handle')]"));
			sliderButton.click();
			Thread.sleep(2000);
			for (int i = 0; i <448; i++) {
				
				Actions action=new Actions(driver);
				//action.dragAndDropBy(sliderButton, i, 0).build().perform();
				for(int j=0;j<100;j++)
				{
				action.sendKeys(Keys.ARROW_RIGHT);
				}
				
				action.build().perform();
				System.out.println(i);
				System.out.println(sliderButton.getAttribute("style"));
				
				if(sliderButton.getAttribute("style").contains("left: 100%")) {
				System.out.println(i);
				break;
				}
			}
	    }


	   @Given("^ensure current state of interest rate$")
	    public void ensure_current_state_of_interest_rate() throws Throwable {
	        
	    }

	    @When("^ensure min value of interest rate$")
	    public void ensure_min_value_of_interest_rate() throws Throwable {
	        
	    }

	    @Then("^ensure max value of interest rate$")
	    public void ensure_max_value_of_interest_rate() throws Throwable {
	        
	    }


	@After
	public void tearDown() {
		//driver.close();
	}
}
