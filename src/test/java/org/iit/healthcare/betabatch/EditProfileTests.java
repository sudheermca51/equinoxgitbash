package org.iit.healthcare.betabatch;

import org.iit.mmp.lib.BaseClass;
import org.iit.mmp.lib.MMPLibrary;
import org.testng.annotations.Test;

public class EditProfileTests extends BaseClass{

	@Test
	public void validateFirstName(String subject,String message,String result)
	{	
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
		mmpLib.moduleNavigation("Profile");
		 
	}
}
