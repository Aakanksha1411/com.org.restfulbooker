package test.features;

import org.testng.Assert;
import org.testng.annotations.Test;

import internal.pageobjects.BookRoom;
import test.base.BaseTest;

public class Bookingrooms extends BaseTest {
	
	
	@Test
	public void BookRooms() throws Exception {
		
		BookRoom bookroomdetails = submitdetailsuser.BookRoomsclickonButton();
		
		bookroomdetails.SelectDate("May", "22", "23", "24");
		//String message1 = bookroomdetails.NightSelected();
		//Assert.assertTrue(message1.contains("1 night(s) - £100"));
		bookroomdetails.bookdetails("Aakanksha", "Mishra", "aakanksha1411@gmail.com", "9713437080452");
        bookroomdetails.PopUp();

	}

}
