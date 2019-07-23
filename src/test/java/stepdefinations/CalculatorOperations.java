package stepdefinations;

import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.ActionsUtility;
import utility.Hook;
import utility.KeyCoordinate;
import utility.KeyMapper;

public class CalculatorOperations {

	private WebDriver driver;
	
	public CalculatorOperations() {
		this.driver = Hook.getDriver();
	}
	
	@Given("^I open a browser$")
	public void openBrowser() throws Throwable {
		System.out.println("Browser is opened successfully");
	}

	@When("^I navigate to online Calculator page$")
	public void navigateToCalculatorPage() throws Throwable {
		driver.get("https://www.online-calculator.com/full-screen-calculator/");
	}
	
	@Then("^I navigate to canvas page$")
	public void switchToFrame() throws Throwable {
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		System.out.println("********We are switch to the iframe*******");
	}
	
	

	@Then("^I have clicked two buttons \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void clickedOnButtons(String number1, String number2, String operation) throws Throwable {
		WebElement element = driver.findElement(By.xpath("//canvas"));
		
		
		KeyCoordinate number1Coordinate = KeyMapper.getKeyCoordinate(number1);
		KeyCoordinate number2Coordinate = KeyMapper.getKeyCoordinate(number2);
		KeyCoordinate operationCoordinate = KeyMapper.getKeyCoordinate(operation);
		KeyCoordinate equalCoordinate = KeyMapper.getKeyCoordinate("=");
		
		
		System.out.println("Coordinate x:" + number1Coordinate.getX() + ", Coordinate y:" + number1Coordinate.getY());
		
		// Click on first number
		ActionsUtility.click(driver, element, number1Coordinate.getX(), number1Coordinate.getY());
		
		// Click on operation
		ActionsUtility.click(driver, element, operationCoordinate.getX(), operationCoordinate.getY());
		
		// Click on second number
		ActionsUtility.click(driver, element, number2Coordinate.getX(), number2Coordinate.getY());
		
		// Click on =
		ActionsUtility.click(driver, element, equalCoordinate.getX(), equalCoordinate.getY());
		
	}
	
	@Then("^I have clicked \"([^\"]*)\" to test CE operation$")
	public void CE_OperationTesting(String anynumber) throws Throwable {
		WebElement element = driver.findElement(By.xpath("//canvas"));
		
		
		KeyCoordinate number1Coordinate = KeyMapper.getKeyCoordinate(anynumber);
		KeyCoordinate operationCoordinate = KeyMapper.getKeyCoordinate("CE");
		
		
		// Click on first number
		ActionsUtility.click(driver, element, number1Coordinate.getX(), number1Coordinate.getY());
		
		// Click on operation
		ActionsUtility.click(driver, element, operationCoordinate.getX(), operationCoordinate.getY());
	}
	
	@Then("^I have to capture the image of result$")
	public void captureResultImage() throws Throwable {
		Shutterbug.shootPage(driver).save("screenshots-output");
	}
	
	@Then("^I have to compare with \"([^\"]*)\"$")
	public void compareResultImage(String basefile) throws Throwable {
		
		System.out.println("Path:" + basefile);
		
		File file = new File("src/testScreenshot/" + basefile.replaceAll("\"", "") + ".png");
		
		BufferedImage bufferedTestImage = ImageIO.read(file);
		
		boolean status = !Shutterbug.shootPage(driver).withName(basefile + "_output").equals(bufferedTestImage);
	
		Assert.assertTrue(status);
	} 

	@Then("^I have valided the test$")
	public void switchToDefaultContent() throws Throwable {
		
		driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    
	    Thread.sleep(5000);
	}
}
