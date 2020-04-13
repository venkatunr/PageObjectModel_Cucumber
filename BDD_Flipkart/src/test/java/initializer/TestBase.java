package initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static FileInputStream envfis=null;
	public static FileInputStream locatorfis=null;
	public static Properties prop;
	public static WebDriver driver=null;
	
	public TestBase() throws IOException {
	 envfis=new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"configfiles"+File.separator+"env.properties");
	 locatorfis=new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"configfiles"+File.separator+"locator.properties");
	 prop=new Properties();
	 prop.load(envfis);
	 prop.load(locatorfis);
	}

	public static void browserSetup() throws Exception {
		String browserName=prop.getProperty("browser");
		if(driver==null) {
		if(browserName.equalsIgnoreCase("chrome")) {	
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}
}
