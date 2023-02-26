package Aakanksha.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Aakanksha.Abstractcomponent.AbstractComponent;

public class Bookerplatform extends AbstractComponent{

WebDriver driver;

public Bookerplatform(WebDriver driver)

{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


@FindBy(id ="name")
WebElement name;

@FindBy(id ="email")
WebElement email;

@FindBy(id ="phone")
WebElement phone;

@FindBy(id ="subject")
WebElement subject;

@FindBy(id ="description")
WebElement Message;

@FindBy(id ="submitContact")
WebElement submit;


@FindBy(css = "div[class='alert alert-danger'] p")
WebElement errormessage;


@FindBy(css = "div[class='col-sm-5'] div h2")
WebElement Confirmmessage;

@FindBy(xpath = "//button[normalize-space()='Book this room']")
WebElement Bookingroom;


  public void submitdetails(String name1,String Email,String Number1,String
  subject1,String message1) 
  { 
	  
	  
  name.sendKeys(name1); 
  email.sendKeys(Email);
  phone.sendKeys(Number1); 
  subject.sendKeys(subject1);
  Message.sendKeys(message1); 
  submit.click();
 
  
  
  }
  
  public BookRoom BookRoomsclickonButton()
  
  {
		
      Bookingroom.click();
		
	  BookRoom bookroomdetails = new BookRoom(driver);  
	  return bookroomdetails;
  }
  
  
  
  
 
  public String getBlankErrorMessage()
	{
		
		return errormessage.getText();
	}
	
public String Confirmmessage()
 	{
 		
 		return Confirmmessage.getText();
 	}

public void Goto()

{
	driver.get("https://automationintesting.online/#/");
}



}

		

		

	


