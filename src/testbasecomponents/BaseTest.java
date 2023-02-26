package testbasecomponents;

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

import Aakanksha.pageobjects.Bookerplatform;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Bookerplatform submitdetailsuser;

	public WebDriver intialisedriver() throws IOException

	{
	
		Properties prop = new Properties();

		FileInputStream  fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		
		if (browsername.equalsIgnoreCase("chrome"))
		{ 
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			
	}


	
		else if (browsername.equalsIgnoreCase("edge")) {
			// Edge
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeoptions = new EdgeOptions();
			
			driver = new EdgeDriver(edgeoptions);
			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		return driver;

	}
	@BeforeMethod
	public Bookerplatform launchapplication() throws IOException
	{
		
		intialisedriver();
		submitdetailsuser = new Bookerplatform(driver);
		submitdetailsuser.Goto();
		return submitdetailsuser;

	}
	
	


	@AfterMethod
	public void TearDown()
	{
	
	driver.close();
	}
}

