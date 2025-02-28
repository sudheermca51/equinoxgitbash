package org.iit.healthcare.betabatch;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleAppointmentTests {
	int i ;
	WebDriver driver ;
	@Test
	public void bookAppointmentTests()
	{
		i=10;
		//System.setProperty("webdriver.chrome.driver","path to the chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

		//Login
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();

		String actual = driver.findElement(By.className("panel-title")).getText().trim();
		String expected ="Patient Portal";
		Assert.assertEquals(actual, expected);
		moduleNavigation("Schedule Appointment");

		///Adding the logic 
		//@author 

		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();

		String expectedDoctor ="Beth";
		selectDoctor("Pediatrician",expectedDoctor);

		driver.switchTo().frame("myframe");

		driver.findElement(By.id("datepicker")).click();

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		List<WebElement> datesList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
		Random rand = new Random();
		int index = rand.nextInt(datesList.size());
		datesList.get(index).click();

		String expectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");

		Select timeSelect = new Select(driver.findElement(By.id("time")));
		String expectedTime = "10Am";
		timeSelect.selectByVisibleText(expectedTime);

		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();
		String expectedAppointment = generateRandomString();
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
		Assert.assertTrue(result);

	}

 
	 
}


