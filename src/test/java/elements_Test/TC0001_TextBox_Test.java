package elements_Test;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.annotations.*;

import base.BaseClass;
import pages.elements.TC0001_TextBox_Page;
import utilities.Utility;

public class TC0001_TextBox_Test {

	@Parameters("browser")
	@BeforeMethod
	public void open(String browser) throws MalformedURLException 
	{
		BaseClass.doBrowserSetup(browser);
	}

	@Test(groups = { "smoke", "regression" }, dataProviderClass = Utility.class, dataProvider = "DemoQAdata")
	public void testBox_Data(Hashtable<String, String> data) throws Exception 
	{
		BaseClass.getDriver().get(BaseClass.pro.getProperty("url"));
		
		TC0001_TextBox_Page tb = new TC0001_TextBox_Page();
		
		tb.textbox_Link_Click();
	    tb.textbox_fill_The_Form_And_Print(data.get("fname"), data.get("email"), data.get("caddress"),data.get("paddress"));

	    TC0001_TextBox_Page.startTest();
		tb.test();
		TC0001_TextBox_Page.endTest();
	}
	
	
	@AfterMethod
    public void tearDown()
	{	
	  BaseClass.getDriver().quit();
      BaseClass.threadLocalDriver.remove();
    }
	
	
	}

