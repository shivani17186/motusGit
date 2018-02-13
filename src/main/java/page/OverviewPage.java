package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BasicActions;

public class OverviewPage{// extends BasicActions{
	//button[text()='Borrow Amount']

	By borrowAmount=By.xpath("//button[text()='Borrow Amount']");
	By borrowAmountInput=By.xpath("//li/label[text()='Borrow Amount']/following::div[1]//input");
	String borrowAmountStringInput="//li/label[text()='Borrow Amount']/following::div[1]//input";
	By borrowDesc=By.xpath("//label[text()='Description']/following::div[1]//input");
	By borrowButton=By.xpath("//button[text()='Borrow']");
	By yesButton=By.xpath("//button[text()='Yes']");
	By tableFirstSavedDesc=By.xpath("//tbody/tr[1]/td[1]/div/div/strong");
	By tableFirstCurrentBalance=By.xpath("//tr[1]/td[4]/strong");
	By currentBalance=By.xpath("//span[text()='Current Balance']/preceding::span[1]");

	By tableTotalData=By.xpath("//span[@class='table-footer-results']");
	By saveMessage=By.xpath("//div[text()='Record successfully saved.']");
	By driverTab=By.xpath("//div[@class='main-header row']/following::div[1]/div[2]//li[2]/a");

	WebDriver driver;
	BasicActions basicAction;

	public OverviewPage(WebDriver driver){
		this.driver=driver;
		basicAction=new BasicActions(driver);
	}
	public String totalNoOfCustRecord(){
		String text= basicAction.getText(tableTotalData);
		String arr[]=text.split(" ");
		System.out.println("LENGTH="+arr.length+" CO="+arr[arr.length-2]);

		return arr[arr.length-2];
	}
	public OverviewPage clickBorrowButton() throws Exception{
		basicAction.safeJavaScriptClick(borrowAmount);
		return this;
	}

	public OverviewPage enterInPopup(String string) {

		basicAction.insertTextAfterwaitingForDisplay(borrowAmountInput,string);
		return this;
	}
	public OverviewPage enterInDesc(String string) {

		basicAction.insertTextAfterwaitingForDisplay(borrowDesc,string);
		return this;
	}
	public OverviewPage clickBorrowPopupButton() {
		basicAction.clickAfterwaitingForDisplay(borrowButton);
		return this;
	}
	public OverviewPage clickYes(){
		basicAction.clickAfterwaitingForDisplay(yesButton);
		return this;
	}

	public boolean verifySavedMessage(){
		return basicAction.waitForAppearance(saveMessage);
	}
	public String tableFirstData(){
		//	By tableFirstSavedDesc=By.xpath("//tbody/tr[1]/td[1]/div/div/strong");
		return basicAction.getText(tableFirstSavedDesc);
	}

	public boolean tableNewSavedData(String data,String browser){
		boolean flag=false;
		for(int i=1;i<5;i++){
			By tableFirstSavedDesc=By.xpath("//tbody/tr["+i+"]/td[1]/div/div/strong");
			String fl=basicAction.getText(tableFirstSavedDesc);
			System.out.println("Data="+fl+" Browser="+browser);
			if(data.equals(fl))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	public String tableFirstCustBalance(){
		return basicAction.getText(currentBalance);
	}
	public String currentBalance(){
		return basicAction.getText(tableFirstCurrentBalance);
	}
	public DriverTabPage clickDriverTab() {
		basicAction.clickAfterwaitingForDisplay(driverTab);
		return new DriverTabPage(driver);
	}
}
