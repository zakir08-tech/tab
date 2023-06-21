package test.automation.tab;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.bolt.common;
import com.automation.bolt.glueCode;
import com.automation.bolt.htmlReportCommon;
	
public class userDefine extends glueCode{
	public static WebDriver xDriver;
	public static WebElement getStatus;
	public static htmlReportCommon htmlReport;
	
	@SuppressWarnings("static-access")
	public static void calcualteNewDateAndSet(String[] args) {
		/* predefine classes can be used to get the current test run-driver and other required methods */
		glueCode gCode = new glueCode();
		common con = new common();
		htmlReportCommon htmlReport = new htmlReportCommon();
		
		xDriver=gCode.boltDriver;
		String xDays =args[0];
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, Integer.valueOf(xDays));
		String newDate = sdf.format(c.getTime());
		
		WebElement setNewDate =xDriver.findElement(By.xpath("//input[@id='endDate']"));
		gCode.keySet(setNewDate, newDate);
		
		/* if required predefine methods can be used to add step description into the word document and html report */
		con.writeStepInWordDocument("set new date: " +newDate);
		htmlReport.writeStepInHtmlReport("set new date: " +newDate);
		
		/* if required predefine methods can be used to add screen-shot into the word document and html report */
		con.attachScreenShotInWordDocument();
		htmlReport.attachScreenShotInHtmlReport();
	}
}