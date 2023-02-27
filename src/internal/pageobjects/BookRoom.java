package internal.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(css = "button[class='btn btn-outline-primary']")
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

    public void SelectDate(String Month, List<String> daysList) throws Exception

    {
    	
    	

        List<String> sortedList = daysList.stream().sorted().collect(Collectors.toList());     

        try {
            Actions actions = new Actions(driver);

            while (!driver.findElement(By.cssSelector(".rbc-toolbar-label")).getText().contains(Month)) {
                driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();

            }



            WebElement startDay = driver.findElement(
                    By.xpath("//div[@class='rbc-row ']//div[not(contains(@class,'rbc-off-range'))]/button[text()="
                            + sortedList.get(0) + "]"));

            WebElement endDay = driver.findElement(
                    By.xpath("//div[@class='rbc-row ']//div[not(contains(@class,'rbc-off-range'))]/button[text()="
                            + sortedList.get(sortedList.size()-1) + "]"));

            actions.clickAndHold(startDay)
            .moveByOffset(-6, 0)
            .moveToElement(endDay)
            .release().build().perform();

            System.out.println("HI");
        }



        catch (Exception e)

        {
            throw new  Exception("Invalid Offrange date");


        }
    }

    public void PopUpClose() {

        Close.click();

    }

    public String confirmation()

    {
        return Modal.getText();
    }

    public String NightSelected()

    {
        return NightSelected.getText();
    }}
