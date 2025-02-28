package org.iit.healthcare.betabatch;

import java.util.Random;

 
public class RandomGeneratorUtil 
{
    public static void main( String[] args )
    {
    	RandomGeneratorUtil randomUtilObj = new RandomGeneratorUtil();
    	randomUtilObj.generateRandomEmailID();
    	randomUtilObj.generateRandomEmailID();
    	randomUtilObj.generateRandomEmailID();
    	randomUtilObj.generateRandomEmailID();
    	randomUtilObj.generateRandomEmailID();
        
        
    }
    public String generateRandomEmailID()
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
    	
    	
    	String emailID="AutoTester"+upperCaseChar+lowerCaseChar+randomNumber+"@rediffmail.com";
    	System.out.println("EmailID:::  " + emailID);
    	
    	return emailID;
    }
}
