package org.iit.mmp.patientmodule.pages;

import java.time.Duration;

import org.iit.mmp.lib.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {

	WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public void selectDoctor(String departmentName,String doctorName)
	{
		driver.findElement(By.xpath("//p[text()='Description:"+departmentName+"']/parent::div/preceding-sibling::"
				+ "h4[text()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();

	}
	public boolean bookAppointment(String doctorName)
	{

		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		String expectedDoctor =doctorName;
		selectDoctor("Pediatrician",expectedDoctor);
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		String futureDate = AppLibrary.getFutureDate(60,"dd/MMMM/YYYY");
		String[] futureDateArr = futureDate.split("/");
		String expectedDay =  futureDateArr[0];//16
		String expectedMonth= futureDateArr[1];//April
		String expectedYear= futureDateArr[2];//2024

		String displayedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().trim();//2024
		String displayedMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim();//February

		while((Integer.parseInt(displayedYear))!=(Integer.parseInt(expectedYear)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			displayedYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		while(!(displayedMonth.equals(expectedMonth)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			displayedMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}

		driver.findElement(By.linkText(expectedDay)).click();

		String expectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
 
		Select timeSelect = new Select(driver.findElement(By.id("time")));
		String expectedTime = "10Am";
		timeSelect.selectByVisibleText(expectedTime);

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement  continueButton= wait.until(ExpectedConditions.elementToBeClickable(By.id("ChangeHeatName")));
		continueButton.click();
		
		driver.switchTo().defaultContent();
		String expectedAppointment = AppLibrary.generateRandomString();
		driver.findElement(By.id("sym")).sendKeys(expectedAppointment);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String actualDate = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		String actualTime = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
		String actualAppointment = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
		String actualDoctor = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();

		boolean result = false;
		if((actualDate.equals(expectedDate))&&(actualTime.equals(expectedTime))&&
				(actualAppointment.equals(expectedAppointment))&&(actualDoctor.equals(expectedDoctor)))
		{
			result = true;
		}
		return result;
	}
}
