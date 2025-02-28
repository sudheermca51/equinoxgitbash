package org.iit.healthcare.betabatch;

import org.iit.mmp.lib.BaseClass;
import org.iit.mmp.lib.MMPLibrary;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScheduleAppointmentDatePickerTests extends BaseClass{
 
	@Parameters({"doctorName"})
	@Test
	public void bookAppointmentTests(String doctorName)
	{	
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		String actual =   mmpLib.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
		String expected ="Patient Portal";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		mmpLib.moduleNavigation("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		boolean result =sPage.bookAppointment(doctorName);
		sa.assertTrue(result);
		sa.assertAll();

	}

	 
	 
 
}
/*
 
User : 365 days / 

Fetch the current date : 13 -02 

Add the 7 days 
						20-06-2025 this should be selected 
						
						
Year : 2025
int x=2;
int y=3; 
while(x!=y)
{
	syso();
	x=3;
	
}

while( CurrentYear 2024 is not equals to FutureYear 2025)
{
		click on next 
		CurrentYear=Fetch the current year 

}
Month: June
while (Current month Feb is not equals to Future month June)
{
		click on next 
		Currentmonth=Fetch the current month  

}
Date: 20
driver.findElement(By.linkText(date)).click();
						
						
						
						
 */


