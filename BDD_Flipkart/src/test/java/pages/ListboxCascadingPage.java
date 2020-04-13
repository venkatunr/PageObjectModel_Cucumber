package pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import initializer.TestBase;
import utilities.GenericFunctions;

public class ListboxCascadingPage extends TestBase  {

	public ListboxCascadingPage() throws IOException {
		super();
	}

	public static void clickOnListboxFromHomePage() {
		WebElement element=driver.findElement(By.xpath(prop.getProperty("homepage_listbox_xpath")));
		GenericFunctions.element_ScrollIntoView(driver, element);
		element.click();
	}
	public static void clickOnCheckboxFromListboxPage() {
		WebElement element=driver.findElement(By.xpath(prop.getProperty("listboxpage_checkbox_xpath")));
		GenericFunctions.element_ScrollIntoView(driver, element);
		element.click();
	}
	public static List<WebElement> listofSkils() {
		List<WebElement> listOfSkils=driver.findElements(By.xpath(prop.getProperty("lisboxpage_listofoption_xpath")));
		return listOfSkils;
	}
	public static void optionsShouldBeUnselected() {
		List<WebElement> skils=ListboxCascadingPage.listofSkils();    	
    	for (WebElement webElement : skils) {
			if(webElement.isDisplayed()) {
				if(webElement.isEnabled()) {
					if(!webElement.isSelected()) {
						GenericFunctions.element_ScrollIntoView(driver, webElement);
						System.out.println("Element is not Selected = " + webElement.getText());
					}
				}
			}
    	}
	}

	
	public static void clickAllOptions() throws InterruptedException {
		List<WebElement> skils=ListboxCascadingPage.listofSkils();

    	for (WebElement webElement : skils) {
    		if(!webElement.isSelected()) {
    			GenericFunctions.element_ScrollIntoView(driver, webElement);
    			webElement.click();
    		}
    	}
    	
    	List<WebElement> skils1=ListboxCascadingPage.listofSkils();
    	System.out.println(skils1.size());
    	for (WebElement webElement : skils1) {
    		GenericFunctions.element_ScrollIntoView(driver, webElement);
    		if(webElement.isEnabled()) {
    		webElement.click();
    		}
		}
	}
	
	public static void clickOnCheckAllButton() {
		WebElement element=driver.findElement(By.xpath(prop.getProperty("listboxpage_checkallbutton_xpath")));
		GenericFunctions.element_ScrollIntoView(driver, element);
		element.click();
	}
	
	public static void ensureCheckboxSelections() {
		List<WebElement> skils=ListboxCascadingPage.listofSkils();
    	for(WebElement webElement : skils) {  			
    		GenericFunctions.element_ScrollIntoView(driver, webElement);
    		if(webElement.isEnabled()) {
    		assertTrue(webElement.isEnabled());
    		}
    	  }
	}
	
	public static void clickOnUncheckAllButton() {
		WebElement element=driver.findElement(By.xpath(prop.getProperty("listboxpage_uncheckallbutton_xpath")));
		GenericFunctions.element_ScrollIntoView(driver, element);
		element.click();
	}
	
	public static void ensureAllOptionsAreUnchecked() {
		List<WebElement> skils=ListboxCascadingPage.listofSkils();
		
		for (WebElement webElement : skils) {
			GenericFunctions.element_ScrollIntoView(driver, webElement);
			assertTrue(!webElement.isSelected());
			}	
		}

	public static void checkboxSelectionfromlist(String s) {
		ListboxCascadingPage.clickOnCheckboxFromListboxPage();

		List<WebElement> skils=ListboxCascadingPage.listofSkils();
		for (WebElement webElement : skils) {
			GenericFunctions.element_ScrollIntoView(driver, webElement);
			if(webElement.getText().startsWith(s)) {
				webElement.click();
			}
		}
	}

	public static void clickOnGetValuesButton() {
		driver.findElement(By.xpath(prop.getProperty("listboxpage_getvaluebutton_xpath"))).click();
	}
	
	public static void valuesListedBasedOncheckboxSelection(String s) {
		List<WebElement> selectedItems=driver.findElements(By.xpath(prop.getProperty("listboxpage_listofitemchecked_xpath")));
		for (WebElement webElement : selectedItems) {
			assertTrue(webElement.getText().startsWith(s));
		}
	}
	
	public static void clickOnHideCheckboxButton() {
		
		driver.findElement(By.xpath(prop.getProperty("listboxpage_hidecheckboxbutton_xpath"))).click();
	}
	
	public static void disableAllCheckboxoptions() {
		try {
			WebElement webElement= driver.findElement(By.xpath("//*[@id='skillsets']//li//span"));	
		}
		catch(NoSuchElementException e) {
		System.out.println("Element is distroyed from DOM");
		}
			
		
		
	}

}
	
	

