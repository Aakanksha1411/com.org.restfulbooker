package Aakanksha.pageobjects;

  
  import java.util.ArrayList; import java.util.Arrays; import java.util.List;
  
  import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
  org.openqa.selenium.WebElement; import
  org.openqa.selenium.interactions.Actions; import
  org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory;
  
  import Aakanksha.Abstractcomponent.AbstractComponent;
  
  public class roomcopy extends AbstractComponent{

	  public static final String MONTH ="May 2023"; 
	  public static final List<String> DATES = Arrays.asList("10","11","12");

	  WebDriver driver;

	  public roomcopy(WebDriver driver)

	  { super(driver); this.driver=driver; PageFactory.initElements(driver, this);
	  }

	  @FindBy(css = ".btn.btn-outline-primary.float-right.openBooking") WebElement
	  Bookingroom;

	  @FindBy(css = "div[aria-label='Month View']") WebElement Selectdates;

	  @FindBy(css = "input[placeholder='Firstname']") WebElement Firstname;

	  @FindBy(css = "input[placeholder='Firstname']") WebElement LastName;

	  public void gotobookroom()

	  { Bookingroom.click(); }

	  public void SelectDate()

	  {

		  Actions actionProvider = new Actions(driver);

		  while(!driver.findElement(By.cssSelector(".rbc-toolbar-label")).getText().
				  contains(MONTH)) {
			  driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

		  }


		  List<WebElement> dates= driver.findElements(By.className("rbc-day-bg"));

		  //int count = driver.findElements(By.className("day")).size();

		  List<WebElement> selectedDates = new ArrayList<>();


		  for ( WebElement webElement : dates) { 
			  String text= webElement.getText();
			  if(DATES.contains(text)) { 
				  selectedDates.add(webElement);


			  }

		  }




		  System.out.println("1" + selectedDates.get(0).getText());
		  System.out.println("1" + selectedDates.get(0).getTagName());
		  System.out.println("1" + selectedDates.get(0).toString());
		  System.out.println("2" + selectedDates.get(1).getText());
		  System.out.println("2" + selectedDates.get(1).getTagName());
		  System.out.println("3" + selectedDates.get(2).getText());
		  System.out.println("3" + selectedDates.get(2).getTagName());
		  //System.out.println("4" + selectedDates.get(3).getText());



		  //List<WebElement> listItems =
			//	  driver.findElements(By.xpath("//*[@id='select_items']/li"));

		  /*
		   * actionProvider .clickAndHold(listItems.get(1))
		   * .clickAndHold(listItems.get(2)) .click() .build() .perform();
		   */

			/*
			 * actionProvider .clickAndHold(selectedDates.get(0))
			 * .moveToElement(selectedDates.get(2)) .release(selectedDates.get(2)) .build()
			 * .perform();
			 */

		  
		  //a.clickAndHold(selectedDates.get(0)).clickAndHold(selectedDates.get(1)).
		  //clickAndHold(selectedDates.get(2)).click().build().perform();

			
			/*
			 * actionProvider .moveToElement(selectedDates.get(0))
			 * .clickAndHold(selectedDates.get(0)) .moveToElement(selectedDates.get(1))
			 * .release(selectedDates.get(2)) .build() .perform();
			 */
			  
//			  actionProvider
//			  .moveToElement(selectedDates.get(0))
//			  .pause(1000)
//			  .clickAndHold(selectedDates.get(0))
//			  .pause(1000)
//			  .moveByOffset(1, 0)
//			  .moveToElement(selectedDates.get(1))
//			  .pause(1000)
//			  .moveByOffset(1, 0)
//			  .moveToElement(selectedDates.get(2))
//			  .pause(1000)
//			  .release() 
//			  .build()
//			  .perform();
		  
		  actionProvider
		  .clickAndHold(selectedDates.get(0))
		  //.moveByOffset(-1, -1)
		  .moveToElement(selectedDates.get(1))
		  .release(selectedDates.get(2)) 
		  .build()
		  .perform();
			 
		  
			
			/*
			 * actionProvider.clickAndHold(selectedDates.get(0)).perform();
			 * 
			 * System.out.println("clicked 1st");
			 * 
			 * actionProvider.moveToElement(selectedDates.get(1)).perform();
			 * 
			 * System.out.println("Moved 2nd");
			 * 
			 * actionProvider.release(selectedDates.get(2)).perform();
			 * 
			 * System.out.println("Released");
			 */
			 
		  
		  //actionProvider.release().build().perform(); //rbc-date-cell

		  System.out.println("Hi");

	  }


  }
  
  
  
 