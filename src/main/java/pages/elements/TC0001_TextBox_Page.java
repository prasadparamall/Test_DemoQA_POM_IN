package pages.elements;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;




public class TC0001_TextBox_Page extends BaseClass {
	
	public static ExtentTest test;
	public static ExtentReports report;
	public static String screenshotName;
	
	
	public TC0001_TextBox_Page(){
       
        PageFactory.initElements(getDriver(), this);

    }
	

	@FindBy(xpath = "//div[@class='category-cards']/div[1]")
	WebElement click_elment_XPATH;
	
	@FindBy(xpath = "//span[contains(text(),'Text Box')]")
	WebElement textboxbtn_xpath;
	
	@FindBy(xpath = "//input[@id='userName']")
	WebElement fullname_xpath;
	
	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement email_xpath;
	
	@FindBy(xpath = "//textarea[@id='currentAddress']")
	WebElement caddress_xpath;
	
	@FindBy(xpath = "//textarea[@id='permanentAddress']")
	WebElement paddress_xpath;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement submit_xpath;
	
	@FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
	List<WebElement> printoutput_xpath;
	
	
	
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\target\\extentreports\\ExtentReportResults.html");
		test = report.startTest("");
		
		
	}
	
	
	

	public void textbox_Link_Click() throws Exception {
		
		clickJS(click_elment_XPATH);
		log.info("click on Home Page element link");
		Thread.sleep(1000);
		clickJS(textboxbtn_xpath);
		log.info("click on textbox element button");
		Thread.sleep(1000);
		
	}
	
	
	
	public void textbox_fill_The_Form_And_Print(String fname, String email, String cadd, String padd) throws Exception {
		
		fullname_xpath.clear();
		fullname_xpath.sendKeys(fname);
		log.info("Enter textbox fill data first name");

		email_xpath.clear();
		email_xpath.sendKeys(email);
		log.info("Enter textbox fill data email");

		caddress_xpath.clear();
		caddress_xpath.sendKeys(cadd);
		log.info("Enter textbox fill data current address");

		paddress_xpath.clear();
		paddress_xpath.sendKeys(padd);
		log.info("Enter textbox fill data parment address");
		//Assert.assertFalse(true);
		clickJS(submit_xpath);
		log.info("click on submit button");
		
		Thread.sleep(1000);
		print_All_GetText(printoutput_xpath);
		log.info("print textbox data");
		Thread.sleep(1000);
		
		 Assert.assertTrue(false);
			
	}
	
	
	public void test() throws Exception
	{
		System.out.println(getDriver().getTitle());
		
		if(getDriver().getTitle().equals("DEMOQA1"))
		{
		test.log(LogStatus.PASS, " PASS");
		test.log(LogStatus.INFO, test.addScreenCapture(TC0001_TextBox_Page.captureScreenshot1()));
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		test.log(LogStatus.INFO, test.addScreenCapture(TC0001_TextBox_Page.captureScreenshot1()));
		}
	}
	


	public static  String captureScreenshot1() throws IOException 
	{
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
         String destination = System.getProperty("user.dir") + "\\target\\extentreports\\" + screenshotName;
		
       //  String destination = System.getProperty("user.dir") + "\\target\\extentreports\\Extentreportimg.jpg";
		
		File finalDestination = new File(destination);
		FileUtils.copyFile(scrFile, finalDestination);
		
		return destination;
	}
	
	
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
	
	


}