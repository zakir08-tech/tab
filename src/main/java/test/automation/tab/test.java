package test.automation.tab;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.automation.bolt.common;
import com.automation.bolt.glueCode;

public class test {
	public static WebDriver xDriver;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		
		glueCode gCode = new glueCode();
		glueCode.implicitWaitTime ="120";
		glueCode.pageLoadTimeOut ="120";
		glueCode.getWebDriver("chrome");
		
		xDriver =gCode.boltDriver;
		String xDays ="5";
		
		/* add a break-point and open the required URL in debug mode */
		xDriver.get("https://tab123.com/");
		/* then navigate to the required page manually for which userDefine code needs to be executed*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, Integer.valueOf(xDays));
		String newDate = sdf.format(c.getTime());
		
		WebElement setNewDate =xDriver.findElement(By.xpath("//input[@id='endDate']"));
		gCode.keySet(setNewDate, newDate);
	}
}