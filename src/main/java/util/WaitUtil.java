package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class WaitUtil  {
	
	WebDriverWait wait;
	WebDriver driver;

	public WaitUtil(WebDriver driver){
		this.driver=driver;
		wait=new WebDriverWait(driver, 40);
	}
	public void waitForPageToLoad() throws InterruptedException{
		boolean flag=false;
		Thread.sleep(2000);
		try{
			ExpectedCondition<Boolean> pageToLoad=new ExpectedCondition<Boolean>(){
				
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript(
							"return document.readyState").equals("complete");
				}
			};
			
			wait.until(pageToLoad);
			flag=true;
		}
		catch(Exception e){}
		
	}

}
