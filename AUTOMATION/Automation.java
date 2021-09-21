package Assesment;

import java.util.List;
import java.util.concurrent.TimeUnit;


import javax.swing.Action;
import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.commandhandler.Status;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Automation 
{
	WebDriver d;

	@BeforeMethod
	public void OpenTrello() 
	{
		//Driver Path
		System.setProperty("webdriver.chrome.driver","/home/qq383/Selenium/Driver/chromedriver");
		//System.setProperty("webdriver.gecko.driver","/home/qq383/Selenium/Driver/geckodriver");

		//Set Driver
		d= new ChromeDriver();
		//d=new FirefoxDriver();
		
		//open Trello
		d.get("https://trello.com");
		 Reporter.log("We used Google Chrome Ver 90 for this test");
		d.manage().window().maximize();

		//Click Microsoft
		d.findElement(By.linkText("Log in")).click();
		
		 d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 Reporter.log("We used Microsoft for Logging in Trello");
		d.findElement(By.xpath("//span[contains(text(),'Continue with Microsoft')]")).click();
		
		 WebDriverWait wait=new WebDriverWait(d,20);

		//Enter Username
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
		d.findElement(By.xpath("//input[@type='email']")).sendKeys("thulasigomez@outlook.com");
		
		
		//Click Next
		d.findElement(By.id("idSIButton9")).click();
		
		//Enter Password
		WebElement f=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwd")));
		d.findElement(By.name("passwd")).sendKeys("Thulasiram1999");
		
		//Click Submit
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		WebElement g=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		 Reporter.log("Login Successful");
		
		
	
	}
	 @Test
	  public void CreateBoard() throws InterruptedException 
	 {
		 //Wait untill the element is found
		 WebDriverWait wait=new WebDriverWait(d,20);

		 WebElement f=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='board-tile mod-add']")));
		 
		 Reporter.log("Click Create New Board");
		 d.findElement(By.xpath("//div[@class='board-tile mod-add']")).click();
		 
		 Thread.sleep(3000);
		 
		 Reporter.log("Entering Goa Trip as Board Name");

		 d.findElement(By.xpath("//input[@aria-label=\"Add board title\"]")).sendKeys("Goa Trip");
		 
		 Thread.sleep(2000);
		 
		 Reporter.log("Creating Board - (Goa Trip)");

		 d.findElement(By.xpath("//button[contains(text(),'Create board')]")).click();
	
		 //Create Shopping
		Reporter.log("Creating Shopping List");
		d.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("Shopping");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@value='Add card']")).click();
		
		//Create BookingTickets
		Reporter.log("Creating Booking Tickets List");
		d.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("Booking Tickets");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@value='Add card']")).click();
		
		//Create BookingHotels
		Reporter.log("Creating Booking Hotels List");
		d.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("Booking Hotels");
		Thread.sleep(2000);
		d.findElement(By.xpath("//input[@value='Add card']")).click();

		 		
		//WebElement g=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Goa Trip']")));
		//d.findElement(By.xpath("//div[@title='Goa Trip']")).click();
		
		
		
	  }

	 
	 

	
	@AfterMethod
	  public void MoveBoard() throws InterruptedException
	  {
		
			
		WebDriverWait wait=new WebDriverWait(d,20);
		
		
		//ToD0 - Doing Shopping
		Reporter.log("Moving Shopping list from ToDo - Doing");

		Actions s1=new Actions(d);
		WebElement doing1= d.findElement(By.xpath("(//a[@class='list-card js-member-droppable ui-droppable'])[1]"));
		s1.contextClick(doing1).perform();
		Thread.sleep(2000);

		d.findElement(By.xpath("//span[contains(text(),'Move')]")).click();
		
		
		
		Select u=new Select(d.findElement(By.xpath("//select[@class='js-select-list']")));

		Thread.sleep(2000);

		u.selectByVisibleText("Doing");
		
		Thread.sleep(2000);

		d.findElement(By.xpath("//input[@class='nch-button nch-button--primary wide js-submit']")).click();
		Thread.sleep(2000);
		
		Reporter.log("Successfully Moved Shopping list from ToDo - Doing");

		//ToD0 - Doing Book Tickets
		
		Reporter.log("Moving Booking Tickets list from ToDo - Doing");

		WebElement doing2= d.findElement(By.xpath("(//a[@class='list-card js-member-droppable ui-droppable'])[1]"));
		s1.contextClick(doing2).perform();
		Thread.sleep(2000);

				
		d.findElement(By.xpath("//span[contains(text(),'Move')]")).click();
				
				
		Select u1=new Select(d.findElement(By.xpath("//select[@class='js-select-list']")));
		Thread.sleep(2000);
		
		u1.selectByVisibleText("Doing");

		Thread.sleep(2000);
		
		d.findElement(By.xpath("//input[@class='nch-button nch-button--primary wide js-submit']")).click();
		Thread.sleep(2000);
		
		Reporter.log("Successfully Moved Booking Tickets list from ToDo - Doing");

		//ToD0 - Doing Book Hotels
		
		Reporter.log("Moving Booking Hotels list from ToDo - Doing");

		WebElement doing3= d.findElement(By.xpath("(//a[@class='list-card js-member-droppable ui-droppable'])[1]"));
		s1.contextClick(doing3).perform();
				
		d.findElement(By.xpath("//span[contains(text(),'Move')]")).click();
				
				
		Select u2=new Select(d.findElement(By.xpath("//select[@class='js-select-list']")));
		Thread.sleep(2000);
		
		u2.selectByVisibleText("Doing");
				
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//input[@class='nch-button nch-button--primary wide js-submit']")).click();
		Thread.sleep(2000);

		Reporter.log("Successfully Moved Booking Hotels list from ToDo - Doing");

		//Doing - Done Shopping
		Reporter.log("Moving Shopping list from Doing - Done");

		
		Actions s2=new Actions(d);
		WebElement done1= d.findElement(By.xpath("(//a[@class='list-card js-member-droppable ui-droppable'])[1]"));
		s2.contextClick(done1).perform();
		
		d.findElement(By.xpath("//span[contains(text(),'Move')]")).click();
		
		
		
		Select do1=new Select(d.findElement(By.xpath("//select[@class='js-select-list']")));
		Thread.sleep(2000);

		do1.selectByVisibleText("Done");
		Thread.sleep(2000);

		d.findElement(By.xpath("//input[@class='nch-button nch-button--primary wide js-submit']")).click();
		Thread.sleep(2000);

		Reporter.log("Successfully Moved Shopping list from Doing - Done");


		//Doing - Done Book Tickets
		
		Reporter.log("Moving Booking Tickets list from Doing - Done");

		WebElement done2= d.findElement(By.xpath("(//a[@class='list-card js-member-droppable ui-droppable'])[1]"));
		s2.contextClick(done2).perform();
				
		d.findElement(By.xpath("//span[contains(text(),'Move')]")).click();
				
				
		Select do2=new Select(d.findElement(By.xpath("//select[@class='js-select-list']")));
		Thread.sleep(2000);

		do2.selectByVisibleText("Done");
		Thread.sleep(2000);

		d.findElement(By.xpath("//input[@class='nch-button nch-button--primary wide js-submit']")).click();
		Thread.sleep(2000);

		Reporter.log("Successfully Moved Shopping Tickets list from Doing - Done");

		//ToD0 - Doing Book Hotels
		Reporter.log("Moving Booking Hotels list from Doing - Done");

		WebElement done3= d.findElement(By.xpath("(//a[@class='list-card js-member-droppable ui-droppable'])[1]"));
		s2.contextClick(done3).perform();
				
		d.findElement(By.xpath("//span[contains(text(),'Move')]")).click();
							
		Select do3=new Select(d.findElement(By.xpath("//select[@class='js-select-list']")));
		Thread.sleep(2000);
		
		do3.selectByVisibleText("Done");
		Thread.sleep(2000);

		d.findElement(By.xpath("//input[@class='nch-button nch-button--primary wide js-submit']")).click();
		Thread.sleep(2000);
		
		Reporter.log("Successfully moved  Booking Hotles list from Doing - Done");

		
	  }
}


