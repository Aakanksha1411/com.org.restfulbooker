package test.features;

import org.testng.Assert;
import org.testng.annotations.Test;

import internal.pageobjects.BookerPlatform;
import test.base.BaseTest;

public class SubmitDetails extends BaseTest {
	
	  @Test
	  
	  public void successUserRegistration() {
	  
	  BookerPlatform submitdetailsuser = new BookerPlatform(driver);
	  submitdetailsuser.submitdetails("Aakanksha","aakanksha1411@gmail.com", "971708504521", "Hi There ",
	  "Need to Book room for 4 people"); 
	  String message =submitdetailsuser.Confirmmessage();
	  Assert.assertTrue(message.contains("Thanks for getting in touch"));
	  
	  }
	 


}