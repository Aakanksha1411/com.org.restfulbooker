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

	@FindBy(id = "footer")
	WebElement footerLink;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public int getFooterCount()
	{
		List<WebElement> footerLinkList= footerLink.findElements(By.tagName("a"));
		
		return footerLinkList.size();
	}
	
	public void clickFooters()
	{
		List<WebElement> footerLinkList= footerLink.findElements(By.tagName("a"));
		for (WebElement footer : footerLinkList) {
			String footerLoc = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footer.sendKeys(footerLoc);
			/// Assert if my page opened
			/// Close the page here			
		}
	}	
}
