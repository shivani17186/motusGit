package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.Parameter;

import MotusGropu.MotusArtifact.BaseDriver;

public class BasicActions {//extends BaseDriver {

	WebDriverWait wait;
	WebDriver driver;

	public BasicActions(WebDriver driver){
		this.driver=driver;
		wait=new WebDriverWait(driver, 50);
	}

	String browser;
	public void clickAfterwaitingForDisplay(By loc){
		wait.until(ExpectedConditions.elementToBeClickable(loc)).click();
	}
	public boolean waitForAppearance(By loc){
		wait.until(ExpectedConditions.presenceOfElementLocated(loc));
		return driver.findElement(loc).isDisplayed();
	}
	public String getText(By loc){
		return wait.until(ExpectedConditions.presenceOfElementLocated(loc)).getText();
	}

	public void insertTextAfterwaitingForDisplay(By loc,String text){
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(loc));
		element.clear();
		element.sendKeys(text);
	}

	public void safeJavaScriptClick(By loc) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(loc));
		try {
			if (driver.findElement(loc).isEnabled()
					&& driver.findElement(loc).isDisplayed()) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						driver.findElement(loc));
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}

		System.out.println("Find NULL Ponter 3");
	}



	public void javaScriptExecutorInsertText(String locator, String InputData) {

		WebDriverWait wait=new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		System.out.println("Old Locator is:" + locator);
		locator = locator.replaceAll("'", "\"");
		System.out.println("New Locator is:" + locator);
		String loc = "$('" + locator + "').val('" + InputData + "')";
		System.out.println("Full String is:" + loc);
		executor.executeScript(loc);
	}
}
