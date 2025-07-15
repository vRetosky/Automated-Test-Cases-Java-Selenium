package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


public class Hyperlink_check {
	
	WebDriver driver;
	
	//Set up the ChromeDriver
	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/** 
	* Test Case: HomeLinkTest 
	* Description: Clicks the "Home" link on homepage and confirms that it is functional
	* Preconditions: User has opened the web page and is currently on homepage
	*/ 
	
	@Test (priority = 1) //Testing the "Home" link on Homepage
	public void homeLink() {
		driver.get("http://localhost/dmt/"); //Open the web page
		driver.findElement(By.xpath("//a[@href='#home']")).click(); //Find the "Home" link and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set a wait interval
		WebElement HomepageMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))); //Wait after clicking the link, the expected element to be visible
		String Message = HomepageMessage.getText(); //Get text from the page
		Assert.assertEquals(Message, "The Digital Service You Really Want"); //Compare if the expected and the actual value are the same
	}
	
	/** 
	* Test Case: ServicesLinkTest 
	* Description: Clicks the "Services" link on homepage and confirms that it is functional
	* Preconditions: User has opened the web page and is currently on homepage
	*/ 
	
	@Test (priority = 2) // Testing the "Services" link on Homepage
	public void servicesLink() {
		driver.get("http://localhost/dmt/"); //Open the web page
		driver.findElement(By.xpath("//a[@href='#services']")).click(); //Find the "Services" link and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set the wait interval
		WebElement ServicesMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))); //Wait after clicking the link, the expected element to be visible
		String Services = ServicesMessage.getText(); //Get text from the page
		Assert.assertEquals(Services, "Services"); //Compare if the expected and the actual value are the same
	}
	  
	/** 
	* Test Case: AboutUsLinkTest 
	* Description: Clicks the "AboutUs" link on homepage and confirms that it is functional
	* Preconditions: User has opened the web page and is currently on homepage
	*/ 
	
	@Test (priority = 3) //Tesing the "About Us" link on Homepage
	public void aboutUsLink() {
		driver.get("http://localhost/dmt/"); //Open the web page
		driver.findElement(By.xpath("//a[@href='#about']")).click(); //Find the "About Us" link and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set the wait interval
		WebElement AboutMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Providing creative and technology services for growing brands.')]"))); //Wait after clicking the link, the expected element to be visible
		String About = AboutMessage.getText(); //Get text from the page
		Assert.assertEquals(About, "Providing creative and technology services for growing brands."); //Compare if the expected and the actual value are the same
	}
	
	/** 
	* Test Case: ProjectsLinkTest 
	* Description: Clicks the "Projects" link on homepage and confirms that it is functional
	* Preconditions: User has opened the web page and is currently on homepage
	*/ 
	
	@Test (priority = 4) //Tesing the "Projects" link on Homepage
	public void projectsLink() {
		driver.get("http://localhost/dmt/"); //Open the web page
		driver.findElement(By.xpath("//a[@href='#projects']")).click(); //Find the "Projects" link and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set the wait interval
		WebElement ProjectsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Travel Website')]"))); //Wait after clicking the link, the expected element to be visible
		String Projects = ProjectsMessage.getText(); //Get text from the page
		Assert.assertEquals(Projects, "Travel Website"); //Compare if the expected and the actual value are the same
	}

	/** 
	* Test Case: ContactLinkTest 
	* Description: Clicks the "Contact" link on homepage and confirms that it is functional
	* Preconditions: User has opened the web page and is currently on homepage
	*/ 
	
	@Test (priority = 5) //Tesing the "Contacts" link on Homepage
	public void contactLink() {
		driver.get("http://localhost/dmt/"); //Open the web page
		driver.findElement(By.xpath("//a[@href='#contact']")).click(); //Find the "Contact" link and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set the wait interval
		WebElement ContactMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Call Us')]"))); //Wait after clicking the link, the expected element to be visible
		String Projects = ContactMessage.getText(); //Get text from the page
		Assert.assertEquals(Projects, "Call Us"); //Compare if the expected and the actual value are the same
	}
	
	/** 
	* Test Case: LoginLinkTest 
	* Description: Clicks the "Login" link on homepage and confirms that it is functional
	* Preconditions: User has opened the web page and is currently on homepage
	*/ 
	
	@Test (priority = 5) //Tesing the "Login" link on Homepage
	public void loginLink() {
		driver.get("http://localhost/dmt/"); //Open the web page
		driver.findElement(By.xpath("//a[@href='login.php']")).click(); //Find the "Login" link and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set the wait interval
		WebElement loginbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))); //Wait after clicking the link, the expected element to be visible
		Assert.assertTrue(loginbtn.isDisplayed(), "Login form is not displayed"); //Check if the expected element is displayed
	}
	
	/** 
	* Test Case: SignupLinkTest 
	* Description: Clicks the "Signup" link on homepage and confirms that it is functional
	* Preconditions: User has opened the web page and is currently on homepage
	*/ 
		
	@Test (priority = 6) //Tesing the "Signup" link on Homepage
	public void signUpLink() {
		driver.get("http://localhost/dmt/"); //Open the web page
		driver.findElement(By.xpath("//a[@href='signup.php']")).click(); //Find the "Signup" link and click it
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); //Set the wait interval
		WebElement submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))); //Wait after clicking the link, the expected element to be visible
		Assert.assertTrue(submitbtn.isDisplayed(),"Signup form is not displayed"); //Check if the expected element is displayed 
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
