package test.features;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import internal.pageobjects.BookRoom;
import test.base.BaseTest;

public class ErrorValidationBooking extends BaseTest {

	@Test

	public void InValidNameRange() throws Exception

	{

		BookRoom bookroomdetails = submitdetailsuser.BookRoomsclickonButton();
		bookroomdetails.SelectDate("May", Arrays.asList("22", "23", "24"));
		bookroomdetails.bookdetails("Aa", "Mishra", "aakanksha1411@gmail.com", "9713437080452");
		Assert.assertEquals("size must be between 3 and 18", bookroomdetails.getBlankErrorMessage());
	}

	@Test
	public void InValidEmail() throws Exception

	{
		BookRoom bookroomdetails = submitdetailsuser.BookRoomsclickonButton();
		bookroomdetails.SelectDate("May", Arrays.asList("22", "23", "24"));
		bookroomdetails.bookdetails("Aakanksha", "Mishra", "gmail", "97170855550452");
		Assert.assertEquals("must be a well-formed email address", bookroomdetails.getBlankErrorMessage());
	}

	@Test
	public void InValidPhone() throws Exception

	{
		BookRoom bookroomdetails = submitdetailsuser.BookRoomsclickonButton();
		bookroomdetails.SelectDate("May", Arrays.asList("22", "23", "24"));
		bookroomdetails.bookdetails("Aakanksha", "Mishra", "aakanksha@gmail.com", "9733331788217777722992290");
		Assert.assertEquals("size must be between 11 and 21", bookroomdetails.getBlankErrorMessage());
	}

	@Test
	public void Datenull() throws Exception

	{
		BookRoom bookroomdetails = submitdetailsuser.BookRoomsclickonButton();
		bookroomdetails.bookdetails("Aakanksha", "Mishra", "aakanksha@gmail.com", "9733331788217777722992290");
		Assert.assertEquals("must not be null", bookroomdetails.getBlankErrorMessage());
	}

	@Test(dependsOnGroups = { "BookRoomSuccess" })
	public void UnavailableDate() throws Exception

	{
		submitdetailsuser.Goto();
		BookRoom bookroomdetails1 = submitdetailsuser.BookRoomsclickonButton();
		bookroomdetails1.SelectDate("September", Arrays.asList("9", "10"));
		bookroomdetails1.bookdetails("Aakanksha", "Mishra", "aakanksha1411@gmail.com", "9713437080452");
		Assert.assertEquals(
				"The room dates are either invalid or are already booked for one or more of the dates that you have selected.",
				bookroomdetails1.getBlankErrorMessageNull());

	}

}
