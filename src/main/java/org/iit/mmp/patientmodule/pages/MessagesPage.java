package org.iit.mmp.patientmodule.pages;

import org.iit.mmp.lib.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage {

	WebDriver driver;
	public MessagesPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public boolean sendMessages(String subject,String message,String expected)
	{	 
		driver.findElement(By.id("subject")).sendKeys(subject);
		driver.findElement(By.id("message")).sendKeys(message);
		driver.findElement(By.xpath("//input[@value='Send']")).submit();
		MMPLibrary mmpLib = new MMPLibrary(driver);
		String actual = mmpLib.handleAlerts();
		return actual.equals(expected);
	}
}
