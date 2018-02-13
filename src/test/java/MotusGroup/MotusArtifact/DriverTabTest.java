package MotusGroup.MotusArtifact;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MotusGropu.MotusArtifact.BaseDriver;
import page.DriverTabPage;
import page.HomePage;
import page.OverviewPage;
import util.ActionUtil;
import util.WaitUtil;

/**
 * Unit test for simple App.
 */
public class DriverTabTest extends BaseDriver
{
	HomePage home;//=new HomePage(driver);
	DriverTabPage driverPage;//=new OverviewPage(driver);
	OverviewPage page;
	WaitUtil util;
	ActionUtil actionUtil;

	@BeforeClass
	public void setUpObjects(){
		home=new HomePage(driver);
		driverPage=new DriverTabPage(driver);
		page=new OverviewPage(driver);
		util=new WaitUtil(driver);
		actionUtil=new ActionUtil(driver);
		System.out.println("EXECUTED CURRENT"+driver);
	}

	@Test
	public void testDriverSearch() throws Exception{
		String comment="";
System.out.println("Hello1");
home.openParticularCustomerByID("ACME1 LTD");
	//	home.clickFirstTableData(); 
		System.out.println("Hello2");
		driverPage=page.clickDriverTab();
		System.out.println("Hello3");
		String data=driverPage.getFirstData();
		System.out.println("Hello4");
		driverPage.searchData(data);
		System.out.println("Hello5");
		actionUtil.pressEnterKey();
		

		System.out.println("Comment="+comment);
		Assert.assertEquals(comment,"");

	}
}
