package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DMT_SignupTest {

	WebDriver driver;
	String mainPage = "http://localhost/dmt/signup.php";
	
	String validUsername = "TestUser1";
	String validUsername2 = "TestUsername1";
	String validUsername3 = "TestName9";
	String validUsername4 = "TestName90";
	
	String validEmail = "testmail@mail.com";
	String validEmail3 = "testmail9@mail.com";
	String validEmail4 = "testmail90@mail.com";
	
	String validPassword = "Pa$sword123";
	String validPassword3 = "e";
	String validPassword4 = "123";
	
	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1) //Testing new user registration with valid credentials 
	public void validCredentials() {
		driver.get(mainPage); // Open the web page
		WebElement username = driver.findElement(By.name("username")); //Finds the "Username" text field;
		username.sendKeys(validUsername); //Enters value in the "Username" text field
		WebElement email = driver.findElement(By.name("email")); //Finds the "email" text field
		email.sendKeys(validEmail); //Enters value in the "Email" text field
		WebElement password = driver.findElement(By.name("password")); //Finds the "password" text field
		password.sendKeys(validPassword); //Enters value in the "Password" text field
		WebElement confirmPass = driver.findElement(By.name("cpass")); //Finds the "confirm password" text field and enters value
		confirmPass.sendKeys(validPassword);
		driver.findElement(By.id("submit")).click(); //Clicks the submit button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set a wait interval
		WebElement DisplayedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //Waits until expected element is displayed after clicking the button
		Assert.assertTrue(DisplayedMessage.isDisplayed(),"A message: 'You are register successfully!' should be displayed"); //Compares if the expected value is displayed. If False, a message is displayed
	}
	
	@Test (priority = 2) //Testing new user registration with already used email address 
	public void duplicateEmail() {
		driver.get(mainPage); // Open the web page
		WebElement username = driver.findElement(By.name("username")); //Finds the "Username" text field;
		username.sendKeys(validUsername2); //Enters value in the "Username" text field
		WebElement email = driver.findElement(By.name("email")); //Finds the "email" text field
		email.sendKeys(validEmail); //Enters value in the "Email" text field
		WebElement password = driver.findElement(By.name("password")); //Finds the "password" text field
		password.sendKeys(validPassword); //Enters value in the "Password" text field
		WebElement confirmPass = driver.findElement(By.name("cpass")); //Finds the "confirm password" text field and enters value
		confirmPass.sendKeys(validPassword);
		driver.findElement(By.id("submit")).click(); //Clicks the submit button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Set a wait interval
		WebElement DisplayedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //Waits until expected element is displayed after clicking the button
		Assert.assertTrue(DisplayedMessage.isDisplayed(),"A message: 'This email is used, Try another One Please!' should be displayed"); //Compares if the expected value is displayed. If False, a message is displayed
	}
	
	@Test (priority = 3) //Testing password strenght in a new user's registration form 
	public void passwordStrenght_1() {
		driver.get(mainPage); // Open the web page
		WebElement username = driver.findElement(By.name("username")); //Finds the "Username" text field;
		username.sendKeys(validUsername3); //Enters value in the "Username" text field
		WebElement email = driver.findElement(By.name("email")); //Finds the "email" text field
		email.sendKeys(validEmail3); //Enters value in the "Email" text field
		WebElement password = driver.findElement(By.name("password")); //Finds the "password" text field
		password.sendKeys(validPassword3); //Enters value in the "Password" text field
		WebElement confirmPass = driver.findElement(By.name("cpass")); //Finds the "confirm password" text field and enters value
		confirmPass.sendKeys(validPassword3);
		driver.findElement(By.id("submit")).click(); //Clicks the submit button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		WebElement displayedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //Waits until expected element is displayed after clicking the button
		Assert.assertTrue(displayedMessage.isDisplayed(), "'You are register successfully!' should be displayed"); //Compares if the expected value is displayed. If False, a message is displayed
	}
	
	@Test (priority = 4) //Testing password strenght in a new user's registration form 
	public void passwordStrenght_2() {
		driver.get(mainPage); // Open the web page
		WebElement username = driver.findElement(By.name("username")); //Finds the "Username" text field;
		username.sendKeys(validUsername4); //Enters value in the "Username" text field
		WebElement email = driver.findElement(By.name("email")); //Finds the "email" text field
		email.sendKeys(validEmail4); //Enters value in the "Email" text field
		WebElement password = driver.findElement(By.name("password")); //Finds the "password" text field
		password.sendKeys(validPassword4); //Enters value in the "Password" text field
		WebElement confirmPass = driver.findElement(By.name("cpass")); //Finds the "confirm password" text field and enters value
		confirmPass.sendKeys(validPassword4);
		driver.findElement(By.id("submit")).click(); //Clicks the submit button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		WebElement displayedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message p"))); //Waits until expected element is displayed after clicking the button
		Assert.assertTrue(displayedMessage.isDisplayed(), "'You are register successfully!' should be displayed"); //Compares if the expected value is displayed. If False, a message is displayed
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
