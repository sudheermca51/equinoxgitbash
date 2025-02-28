package org.iit.healthcare.betabatch;

import java.util.TreeSet;

public class SetExample {
	
	public static void main(String[] args) {
		
		//Set is a interface 
		//implemented by HashSet,LinkedHashSet,TreeSet
		TreeSet<Integer> hSet = new TreeSet<Integer>();
	 
		 
		hSet.add(5);// index 0
		hSet.add(10);//index 1
		hSet.add(20);// index 2
		hSet.add(20);// index 3
		
		System.out.println("Size  " + hSet.size());
		 
		
		for(Integer obj:hSet)
		{
			System.out.println(obj);
		}
	 
		
	}
	
	

}
