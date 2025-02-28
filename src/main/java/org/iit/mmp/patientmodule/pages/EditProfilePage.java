package org.iit.mmp.patientmodule.pages;

import org.openqa.selenium.WebDriver;

public class EditProfilePage {
	WebDriver driver;
	public EditProfilePage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public void editFirstName()
	{
		
	}

}
/*
Test Steps :
1. Login to Patient module 
2. Navigate to Profile tab.
3. Click on Edit button.
4. Clear the FirstName textbox and provide the updated value.
		editFirstName();
5. Click on save.
6. Validate the value entered in point#4 is displayed.


Test Steps :
1. Login to Patient module 
2. Navigate to Profile tab.
3. Click on Edit button.
4. Clear the textboxes and edit  for multiple fields:
	Fname- editFirstName1()
	LastName
	
5. Click on save.
6. Validate the value entered in point#4 is displayed. 
*/