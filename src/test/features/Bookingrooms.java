package test.features;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Range;

import internal.pageobjects.BookRoom;
import test.base.BaseTest;

public class Bookingrooms extends BaseTest {

	@Test
	public void BookRooms() throws Exception {

		String bookingMessage = "<days> night(s) - £<amount>";
		BookRoom bookroomdetails = submitdetailsuser.BookRoomsclickonButton();
		List<String> dateList = Arrays.asList("9", "10","11");
		bookroomdetails.SelectDate("October", dateList);
		int noOfDays = 2;
		String actualMessage = bookroomdetails.NightSelected();
        String s = String.valueOf(noOfDays);
        String expectedMessage = bookingMessage.replace("<days>", String.valueOf(noOfDays));
		expectedMessage = expectedMessage.replace("<amount>", String.valueOf(noOfDays * 100));
		System.out.println("Actual : " + actualMessage + "  Expected :" + expectedMessage);
		Assert.assertTrue(actualMessage.equals(expectedMessage));
        bookroomdetails.bookdetails("Aakanksha", "Mishra", "aakanksha@gmail.com", "97372299288290");
		bookroomdetails.PopUpClose();

	}

	@Test

	public void FooterlinkBookRoomPage() {

		Assert.assertEquals(submitdetailsuser.Footerlinks(), 6);
	}
	
}
