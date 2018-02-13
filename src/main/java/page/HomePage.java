package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BasicActions;


public class HomePage  {
	By tableFirstData=By.xpath("//table[@class='table table-bordered table-loading']/tbody/tr/td[2]/strong");
	String customerOnTableByIDBeg="//strong[text()='";
	String customerOnTableByIDEnd="']";
	

	WebDriver driver;
	BasicActions basicAction;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		System.out.println("Executed Page Class"+driver);
		basicAction=new BasicActions(driver);
	}

	

	public void clickFirstTableData() throws Exception{
	
		basicAction.safeJavaScriptClick(tableFirstData);
	}
	
	public void openParticularCustomerByID(String id) throws Exception{
		basicAction.safeJavaScriptClick(By.xpath(customerOnTableByIDBeg+id+customerOnTableByIDEnd));
	}


}
