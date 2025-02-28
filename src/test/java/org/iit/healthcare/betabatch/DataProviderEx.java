package org.iit.healthcare.betabatch;

import java.io.IOException;

import org.iit.mmp.lib.AppLibrary;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
	
	
	@Test(dataProvider="DP")
	public void login(String username,String password)
	{
		System.out.println(username);
		System.out.println(password);
	}
	
	@DataProvider(name="DP")
	public String[][] fetchXLSData() throws IOException
	{
		String data[][] = AppLibrary.readXLSX("InputData.xlsx","data");
		return data;
	}
 

}
