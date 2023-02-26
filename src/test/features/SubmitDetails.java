package test.features;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import internal.pageobjects.BookerPlatform;
import test.base.BaseTest;

public class SubmitDetails extends BaseTest {

	@Test

	public void successUserRegistration() {

		BookerPlatform submitdetailsuser = new BookerPlatform(driver);
		submitdetailsuser.submitdetails("Aakanksha", "aakanksha1411@gmail.com", "971708504521", "Hi There ",
				"Need to Book room for 4 people");
		String message = submitdetailsuser.Confirmmessage();
		Assert.assertTrue(message.contains("Aakanksha"));

	}

	@Test
	public void Homepagemessage() {

		String Message = submitdetailsuser.getwelcomemessage();
		Assert.assertEquals(Message,
				"Welcome to Shady Meadows, a delightful Bed & Breakfast nestled in the hills on Newingtonfordburyshire. A place so beautiful you will never want to leave. All our rooms have comfortable beds and we provide breakfast from the locally sourced supermarket. It is a delightful place.");
	}

	@Test
	public void Footerlinks() {

		WebElement footerlinks = driver.findElement(By.id("footer"));
		System.out.println(footerlinks.findElements(By.tagName("a")).size());
		for (int i = 1; i < footerlinks.findElements(By.tagName("a")).size(); i++) {
			String clickonlinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
             footerlinks.findElements(By.tagName("a")).get(i).sendKeys(clickonlinks);

		}
	}
}
