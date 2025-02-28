package org.iit.mmp.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppLibrary {
	public static String getFutureDate(int noofDays,String dateFormat)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofDays);
		Date d = cal.getTime();
		System.out.println(cal.getTime());
		SimpleDateFormat sdfObj = new SimpleDateFormat(dateFormat);
		String s = sdfObj.format(d);
		System.out.println(s);
		return s;
	}
	public static String generateRandomString()
	{
		/*
		 * Generate the Random Email ID
		 */
		Random rand = new Random();
		int randomNumber = 1+rand.nextInt(100);//0 to 99
		//System.out.println("Random number:" + randomNumber);

		int upperCase = 65+rand.nextInt(26);//0 to 25
		char upperCaseChar = (char) upperCase;
		//System.out.println("UpperCase Char:::" + upperCaseChar);


		int lowerCase = 97+rand.nextInt(26);//0 to 25
		char lowerCaseChar = (char) lowerCase;
		//System.out.println("lowerCase Char:::" + lowerCaseChar);


		String randomString="AutoTester"+upperCaseChar+lowerCaseChar+randomNumber;
		System.out.println("randomString:::  " + randomString);

		return randomString;
	}
	public static String[][] readXLSX(String fileName,String sheetName) throws IOException  
	{
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		wb.getNumberOfSheets();
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of rows" + rows);
		System.out.println("number of cols" + cols);
		String inputData[][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				XSSFRow row = sheet.getRow(i);
				XSSFCell cell = row.getCell(j);
				inputData[i][j]= cell.getStringCellValue();
				System.out.print(inputData[i][j]);
			}
			System.out.println();
		}
		return inputData;

	}

}
