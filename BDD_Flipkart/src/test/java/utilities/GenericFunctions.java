package utilities;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import initializer.TestBase;

public class GenericFunctions extends TestBase {
	
	public GenericFunctions() throws IOException {
		super();
	}

	/*
	 * Scroll the scroller untill particualar element to be visible
	 */
	public static void element_ScrollIntoView(WebDriver driver,WebElement element) {
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static boolean verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				System.out.println("The element "+ele+" is visible");
				return true;
			} else {
				System.out.println("The element "+ele+" is not visible");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
		return false;

	}
	
	public static boolean verifyDisappeared(WebElement element) {
		return false;
	}

	
	
	
}
