package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import testbasecomponents.BaseTest;

public class ErrorValidationsLanding extends BaseTest {
	
	@Test
	
	public void Blankname()
	
	{
		submitdetailsuser.submitdetails(" ", "aakanksha1411@gmail.com", "97170804521", "Hi There ", "Need to Book room for 4 people");
		Assert.assertEquals("Name may not be blank", submitdetailsuser.getBlankErrorMessage());
	}

	
	@Test
	public void InvalidEmail()
	
	{
		submitdetailsuser.submitdetails("Aakanksha ", "aakanksha1411", "97170804521", "Hi There ", "Need to Book room for 4 people");
		Assert.assertEquals("must be a well-formed email address", submitdetailsuser.getBlankErrorMessage());
	}
	

	@Test
	public void InvalidPhone()
	
	{
		submitdetailsuser.submitdetails("Aakanksha ", "aakanksha1411@gmail.com", "971708045", "Hi There ", "Need to Book room for 4 people");
		Assert.assertEquals("Phone must be between 11 and 21 characters.", submitdetailsuser.getBlankErrorMessage());
	}

	@Test
	public void InvalidSubject()
	
	{
		submitdetailsuser.submitdetails("Aakanksha ", "aakanksha1411@gmail.com", "9717080454444", "Hi", "Need to Book room for 4 people");
		Assert.assertEquals("Subject must be between 5 and 100 characters.", submitdetailsuser.getBlankErrorMessage());
	}

	@Test
	public void InvalidMessage()
	
	{
		submitdetailsuser.submitdetails("Aakanksha ", "aakanksha1411@gmail.com", "971708045234", "Hi There ", "Need to Book");
		Assert.assertEquals("Message must be between 20 and 2000 characters.", submitdetailsuser.getBlankErrorMessage());
	}
	
	
}


	
