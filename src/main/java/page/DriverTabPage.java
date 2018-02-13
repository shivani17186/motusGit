package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BasicActions;

public class DriverTabPage {
	
	WebDriver driver;
	BasicActions basicAction;
	
	By firstData=By.xpath("//tbody/tr[1]/td[2]/strong");
	By searchTextBar=By.xpath("//div[@class='search-input']/input");

	public DriverTabPage(WebDriver driver){
		this.driver=driver;
		basicAction=new BasicActions(driver);
	}

	public String getFirstData() {
		return basicAction.getText(firstData);
	}

	public void searchData(String data) {
		 basicAction.insertTextAfterwaitingForDisplay(searchTextBar,data);
		
	}

}
