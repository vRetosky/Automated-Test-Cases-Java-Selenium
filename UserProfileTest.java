package Test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;



public class UserProfileTest {

	WebDriver driver;
	String mainPage = "http://localhost/dmt/login.php";
	
	@BeforeClass //Sets up the Web driver
	public void SetUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/** 
	* Test Case: ValidLogin 
	* Description: Login with a valid email address and password and verifies the user is redirected to homepage.
	* Preconditions: Valid user account must exist. 
	*/ 
	
	@Test (priority = 1) //Testing login using valid credentials
	public void logIn() {
		
		driver.get(mainPage); //Open the web page
		driver.findElement(By.name("email")).sendKeys("user11@mail.com"); //Finds the "email" text field and enters value
		driver.findElement(By.name("password")).sendKeys("P@ssW0rd"); //Finds the "password" text field and enters value
		driver.findElement(By.id("submit")).click(); //Click the "submit" button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3)); //Sets up wait interval
		Assert.assertTrue(driver.getCurrentUrl().endsWith("home.php"));	//Check if expected URL is displayed	
	}
	
	/** 
	* Test Case: EditUsername 
	* Description: Opens the "Change Profile" page and change the name in the "username" text field. and confirms that username is successfully updated
	* Preconditions: User is logged in using valid email address and password
	*/ 
	
	@Test (priority = 2 , dependsOnMethods = {"logIn"}) //Test: opening the "Change Profile" page, updating the username and logging out
	public void editUsername() {
		
		driver.findElement(By.id("dropdownMenuLink")).click(); //Find the dropdown list and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Sets a wait interval
		WebElement editBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='edit.php?id=18']"))); //Finding the "Change Profile" hyperlink on the dropdown list
		editBtn.click();
		
		WebElement usernameText = driver.findElement(By.name("username")); //Find the "username" text field
		usernameText.clear(); //Clear / Delete the text inside the text field
		usernameText.sendKeys("Updated Username"); //Enter value in the text field
		driver.findElement(By.id("submit")).click(); //Click the "submit" button
		
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //Waits until expected message is displayed after clicking the button
		Assert.assertTrue(message.isDisplayed()); //Confirm that the expected message is displayed
		
		driver.findElement(By.xpath("//a[@href='home.php']")).click(); //Find the "Home" button and click it
		driver.findElement(By.id("dropdownMenuLink")).click(); // Find the dropdown list on homepage and click it
		
		WebElement logOutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='logout.php']"))); //Find the "logout" link on the dropdown list 
		logOutBtn.click(); //Click the logout link
	}
	
	/** 
	* Test Case: VerifyChange 
	* Description: Confirms that the username is successfully updated
	* Preconditions: User is logged in using valid email address and password, and entered new username in "username" text field
	*/ 
		
	@Test (priority = 3) // Test: login in again using the same valid credentials and check if the expected welcome message is displayed
	public void verifyChange() {
		
		driver.get(mainPage); //Open the web page
		driver.findElement(By.name("email")).sendKeys("user11@mail.com"); //Finds the "email" text field and enters value
		driver.findElement(By.name("password")).sendKeys("P@ssW0rd"); //Finds the "password" text field and enters value
		driver.findElement(By.id("submit")).click(); //Click the "submit" button
		WebElement welcomeMessage = driver.findElement(By.className("name")); //Finding the web element with welcoming message
	    String welcomeText = welcomeMessage.getText();
		Assert.assertEquals(welcomeText, "Welcome Updated Username !"); //Checks if expected and displayed messages are equal
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
