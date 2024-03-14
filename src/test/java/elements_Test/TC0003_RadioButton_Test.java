package elements_Test;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.elements.TC0003_RadioButton_Page;
import utilities.Utility;



public class TC0003_RadioButton_Test {
	
	@Parameters("browser")
	@BeforeMethod
	public void open(String browser) throws MalformedURLException 
	{
		BaseClass.doBrowserSetup(browser);
	}
	
	
	@Test(groups = {"smoke","regression"}, dataProviderClass=Utility.class, dataProvider="DemoQAdata")
	public void radioButton_Data(Hashtable<String, String> data) throws Exception 
	{	
		BaseClass.getDriver().get(BaseClass.pro.getProperty("url"));
		
		TC0003_RadioButton_Page rb= new TC0003_RadioButton_Page();
		
		rb.radio_button_Click();
		rb.radio_button_Select_Options(data.get("yes"), data.get("impressive"), data.get("no"));
	
		TC0003_RadioButton_Page.startTest();
		rb.test();
		TC0003_RadioButton_Page.endTest();
	
	}
	
	@AfterMethod
    public void tearDown()
	{	
	  BaseClass.getDriver().quit();
      BaseClass.threadLocalDriver.remove();
    }
	
	

}
