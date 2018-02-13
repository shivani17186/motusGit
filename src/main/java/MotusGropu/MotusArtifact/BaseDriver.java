package MotusGropu.MotusArtifact;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Hello world!
 *
 */
public class BaseDriver 
{
	public  WebDriver driver;

	public Properties prop;
	protected String browser="firefox";
	FirefoxProfile profile;


	public BaseDriver(){
		
	}

//	@Parameters("browser")
	@BeforeTest
//	public   void setUp(String browser) throws IOException{
	public void setUp()throws IOException{
		System.out.println("B="+browser);
		setUpProperties(browser);
		this.browser=prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("firefox")){
			profile = new FirefoxProfile();
			System.out.println("I am able to reach here profile");
			System.out.println("I am able to reach here preference");
			driver=new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files (x86)"+File.separator+"Mozilla Firefox"+"//firefox.exe")),profile);//,dc);
		}
		if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "F:\\InternetDrivers\\IE_11_2.53.1_64Bit\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();

			System.out.println("IE opens"+browser);
		}
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\InternetDrivers\\Chrome32Bit\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("IE opens"+browser);
		}
		openURL();
	}

	public void openURL(){

		driver.get(prop.getProperty("url"));
		System.out.println("Opening URL on "+browser);
	}

	public void setUpProperties(String browser) throws IOException{

		File file=new File("C:\\Users\\Shivani\\workspace\\MotusArtifact\\env.properties");
		FileInputStream fi=new FileInputStream(file);
		prop=new Properties();		
		prop.load(fi);

		if(browser!=null)
		{
			System.out.println("BROW="+browser);
			prop.setProperty("browser",browser);
			System.out.println("Test Browser="+browser);
		}
		System.out.println("URL="+prop.getProperty("url"));
	}

}
