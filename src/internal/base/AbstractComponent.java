package internal.base;

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

	@FindBy(className= ".btn.btn-outline-primary.float-right.openBooking")
	WebElement Bookroom;

	public void  goToBookroom	()

	{

		Bookroom.click();	

	}




}
