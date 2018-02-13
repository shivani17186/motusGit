package util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil {
	
	WebDriver driver;
	Actions act;

	public ActionUtil(WebDriver driver){
		this.driver=driver;
		act=new Actions(driver);
	}
	
	public void pressEnterKey() throws InterruptedException{
		
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	}

}
