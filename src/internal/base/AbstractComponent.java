package internal.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {
	WebDriver driver ;	
	public AbstractComponent(WebDriver driver)

	{

		this.driver= driver;
		PageFactory.initElements(driver, this);

	}


	
	@FindBy(id = "footer")
	WebElement footerlinks;

	@FindBy(tagName = "a")
	List<WebElement> tagreference;


	public int Footerlinks()
	{
		
		
		System.out.println(footerlinks.findElements(By.tagName("a")).size());
		for (int i = 1; i < footerlinks.findElements(By.tagName("a")).size(); i++) {
			String clickonlinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
	         footerlinks.findElements(By.tagName("a")).get(i).sendKeys(clickonlinks);
		}
	         return footerlinks.findElements(By.tagName("a")).size();



}
}
