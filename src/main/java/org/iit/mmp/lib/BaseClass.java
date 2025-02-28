package org.iit.mmp.lib;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;//null
	ProjectConfiguration projConfig;  
	protected Properties prop;
	String environment,browserType;
	@BeforeTest//for all classes once-1
	public void readPropertyFile() throws IOException
	{
		projConfig = new ProjectConfiguration();
		prop = projConfig.loadProperties("config/mmp.properties");
		environment = prop.getProperty("environment");
		browserType = prop.getProperty("browserType");
	}
	@BeforeClass// for each and every class it will trigger once-3
	public void instantiateDriver() throws IOException
	{
		System.out.println("Executing the testcases on the environment::: " +environment +"::: browserType::::" + browserType);
		
		if(environment.equals("qa") && browserType.equals("chrome"))
		{
			prop = projConfig.loadProperties("config/mmp_qa.properties");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Reading the patient_url" +prop.entrySet());
			driver.get(prop.getProperty("patient_url"));
			driver.manage().window().maximize();
		}
		
		 
	
	}

}

//@BeforeClass:
//The annotated method will be run before the first test method in the current class is invoked.

