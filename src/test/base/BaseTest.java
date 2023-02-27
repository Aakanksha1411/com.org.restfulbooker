package test.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import internal.pageobjects.BookerPlatform;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public BookerPlatform submitdetailsuser;

	public WebDriver intialisedriver() throws IOException

	{

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\resources\\global.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		}

		else if (browsername.equalsIgnoreCase("edge")) {
		
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeoptions = new EdgeOptions();

			driver = new EdgeDriver(edgeoptions);

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod
	public BookerPlatform launchapplication() throws IOException {

		intialisedriver();
		submitdetailsuser = new BookerPlatform(driver);
		submitdetailsuser.Goto();
		return submitdetailsuser;

	}

	
	  @AfterMethod 
	  public void TearDown() {
	  
	  driver.close(); 
	  
	  }
	 

}
