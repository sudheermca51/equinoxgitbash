package org.iit.healthcare.betabatch;

import org.iit.mmp.lib.AppLibrary;
import org.iit.mmp.lib.BaseClass;
import org.iit.mmp.lib.MMPLibrary;
import org.iit.mmp.patientmodule.pages.MessagesPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendMessagesTests extends BaseClass{

	@Parameters({"subject","message","result"})
	@Test
	public void validateSendMessagesFunc(String subject,String message,String result)
	{	
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(prop.getProperty("patient_username"),prop.getProperty("patient_password"));
		mmpLib.moduleNavigation("Messages");
		MessagesPage msgPage = new MessagesPage(driver);
		String expectedSubject = subject+AppLibrary.generateRandomString();
		String expectedMessage = message+AppLibrary.generateRandomString();
		String expectedResult= result;
		boolean output = msgPage.sendMessages(expectedSubject,expectedMessage,expectedResult);
		Assert.assertTrue(output);
	}
}
