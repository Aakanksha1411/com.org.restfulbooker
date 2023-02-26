package test;

import org.testng.Assert;
import org.testng.annotations.Test;


import Aakanksha.pageobjects.Bookerplatform;
import testbasecomponents.BaseTest;

public class SubmitDetails extends BaseTest {
	
	  @Test
	  
	  public void successUserRegistration() {
	  
	  Bookerplatform submitdetailsuser = new Bookerplatform(driver);
	  submitdetailsuser.submitdetails("Aakanksha","aakanksha1411@gmail.com", "971708504521", "Hi There ",
	  "Need to Book room for 4 people"); 
	  String message =submitdetailsuser.Confirmmessage();
	  Assert.assertTrue(message.contains("Thanks for getting in touch"));
	  
	  }
	 


}