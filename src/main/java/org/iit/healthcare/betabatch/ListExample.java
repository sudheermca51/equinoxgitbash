package org.iit.healthcare.betabatch;

import java.util.ArrayList;

public class ListExample {
	
	public static void main(String[] args) {
		
		//List is a interface 
		//implemented by ArrayList,LinkedList,Vector
		ArrayList<Integer> aList = new ArrayList<Integer>();
	 
		 
		aList.add(5);// index 0
		aList.add(10);//index 1
		aList.add(20);// index 2
		aList.add(20);// index 3
		
		System.out.println("Size" + aList.size());
		System.out.println(aList.get(2));
		
		for (int i =0;i<aList.size();i++)
		{
			System.out.println(aList.get(i));
		}
	 
		
	}
	
	

}
