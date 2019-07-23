package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility {

	public static void click(WebDriver driver, WebElement element, int x, int y) throws InterruptedException {
			
		Actions clickAt = new Actions(driver);
		
		System.out.println("X:" + x + ", y:" + y);
		
		clickAt.moveToElement(element,x,y)
			.click()
			.build()
			.perform(); 
	
		 Thread.sleep(2000);
	}
}
