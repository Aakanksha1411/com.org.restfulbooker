package internal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import internal.base.AbstractComponent;

public class BookRoom extends AbstractComponent {

	WebDriver driver;
	public BookRoom bookroomdetails;

	public BookRoom(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(css = "div[aria-label='Month View']")
	WebElement Selectdates;

	@FindBy(css = "input[placeholder='Firstname']")
	WebElement Firstname;

	@FindBy(css = "input[placeholder='Lastname']")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='phone']")
	WebElement phone;

	@FindBy(css = ".btn.btn-outline-primary.float-right.book-room")
	WebElement book;

	@FindBy(css = "div[class='alert alert-danger'] p")
	WebElement errormessage;
	
	@FindBy(css = ".alert.alert-danger")
	WebElement errormessagenull;

	@FindBy(xpath = ".//button[contains(text(), 'Close')]")
	WebElement Close;

	@FindBy(xpath = ".//div[@aria-label='onRequestClose Example']")
	WebElement Modal;

	@FindBy(css = ".rbc-event-content")
	WebElement NightSelected;

	public void bookdetails(String Fname, String Lname, String Email, String Phone) {

		Firstname.sendKeys(Fname);
		LastName.sendKeys(Lname);
		email.sendKeys(Email);
		phone.sendKeys(Phone);
		book.click();

	}

	public String getBlankErrorMessage() {

		return errormessage.getText();
	}

	public String getBlankErrorMessageNull () {

		return errormessagenull.getText();
	}

	public void SelectDate(String Month, String targetday, String targetday1, String targetday2) throws Exception

	{
		try {
		Actions actions = new Actions(driver);

		while (!driver.findElement(By.cssSelector(".rbc-toolbar-label")).getText().contains(Month)) {
			driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

		}
		actions.clickAndHold(driver.findElement(
				By.xpath("//div[@class='rbc-row ']//div[not(contains(@class,'rbc-off-range'))]/button[text()="
						+ targetday + "]")))

				.moveToElement(driver.findElement(
						By.xpath("//div[@class='rbc-row ']//div[not(contains(@class,'rbc-off-range'))]/button[text()="
								+ targetday1 + "]")))
				.moveToElement(driver.findElement(
						By.xpath("//div[@class='rbc-row ']//div[not(contains(@class,'rbc-off-range'))]/button[text()="
								+ targetday2 + "]")))
				.release().build().perform();
		}
		
		catch (Exception e)

		{
			throw new  Exception("Invalid Offrange date");


		}
	}

	public void PopUp() {

		Close.click();

	}

	public String confirmation()

	{
		return Modal.getText();
	}

	public String NightSelected()

	{
		return NightSelected.getText();
	}

}
