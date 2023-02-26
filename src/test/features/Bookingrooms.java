package test.features;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import internal.pageobjects.BookRoom;
import test.base.BaseTest;

public class Bookingrooms extends BaseTest {
	
	String bookingMessage = "<days> night(s) - £<amount>";
	
	@Test(groups={"BookRoomSuccess"})
	public void BookRooms() throws Exception {
		
		
		BookRoom bookroomdetails = submitdetailsuser.BookRoomsclickonButton();
		List<String> dateList = Arrays.asList("23", "22","25");
		bookroomdetails.SelectDate("December" ,dateList);

		String actualMessage = driver.findElement(By.cssSelector(".rbc-event-content")).getText();
		int noOfDays = dateList.size();
		String s=String.valueOf(noOfDays);
	
		String expectedMessage =bookingMessage.replace("<days>",String.valueOf(noOfDays));
		 expectedMessage =expectedMessage.replace("<amount>",String.valueOf(noOfDays*100));
		 System.out.println("Actual : " + actualMessage + "  Expected :" + expectedMessage );
		 
		Assert.assertTrue(actualMessage.equals(expectedMessage));
		
		
		bookroomdetails.bookdetails("Aakanksha", "Mishra", "aakanksha1411@gmail.com", "9713437080452");
		bookroomdetails.PopUpClose();

	}

}
