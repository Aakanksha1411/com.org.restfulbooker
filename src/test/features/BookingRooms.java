package test.features;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import internal.pageobjects.BookRoom;
import test.base.BaseTest;

public class BookingRooms extends BaseTest 
{

	@Test
	public void validRoomBooking() throws Exception {

		String expectedMessage = "1 night(s) - £200";
		List<String> dateList = Arrays.asList("20", "21");
		
		BookRoom bookRoomDetails = bookerPlatform.submitRoomBooking();
		bookRoomDetails.selectDate("October", dateList);
		String actualMessage = bookRoomDetails.selectedDates();
		
		Assert.assertTrue(actualMessage.equals(expectedMessage));
		bookRoomDetails.bookdetails("Aakanksha", "Mishra", "aakanksha@gmail.com", "97372299288290");
		//// Assert here
		
		bookRoomDetails.closePopUp();
	}

	@Test
	public void validateNumberOfHyperLinksOnHomePage() 
	{
		Assert.assertEquals(bookerPlatform.getFooterCount(), 6);
	}

	/// New Test for verifying hyperlinks
	/// New Test for booking message
}
