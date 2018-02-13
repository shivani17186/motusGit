package MotusGroup.MotusArtifact;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MotusGropu.MotusArtifact.BaseDriver;
import page.HomePage;
import page.OverviewPage;
import util.WaitUtil;

/**
 * Unit test for simple App.
 */
public class CustomerOverviewTabTest extends BaseDriver
{
	HomePage home;//=new HomePage(driver);
	OverviewPage page;//=new OverviewPage(driver);
	WaitUtil util;


	private final Lock lock = new ReentrantLock();



	@BeforeClass
	public void setUpObjects(){
		home=new HomePage(driver);
		page=new OverviewPage(driver);
		util=new WaitUtil(driver);
		System.out.println("EXECUTED CURRENT"+driver);
	}

	@Test
	synchronized public void testBorrowAmount() throws Exception{
		String comment="";
		
			home.clickFirstTableData(); 
			String descDataToSave="Automation Desc"+browser+page.totalNoOfCustRecord();

			page.clickBorrowButton()
			    .enterInPopup("23")
			    .enterInDesc(descDataToSave)
			    .clickBorrowPopupButton()
			    .clickYes();
			boolean flag=page.verifySavedMessage();
			if(flag==false){
				comment=comment+"Saved Messange Did not appear";
			}
			//	String dataSaved=page.tableFirstData();
            util.waitForPageToLoad();
		    flag=page.tableNewSavedData(descDataToSave,browser);

			if(flag==false){
				comment=comment+"Desc did not match, means data not saved"+" Expected="+descDataToSave+"for browser="+browser;
			}

			String currentBalanceDisp=page.currentBalance();
			String currentBalanceTable=page.tableFirstCustBalance();

			if(!currentBalanceDisp.equals(currentBalanceTable)){
				comment=comment+"Current Balance did not match"+" Expected="+currentBalanceDisp+" Actual="+currentBalanceTable;
			}

			System.out.println("Comment="+comment);
			Assert.assertEquals(comment,"");
		
	}
}
