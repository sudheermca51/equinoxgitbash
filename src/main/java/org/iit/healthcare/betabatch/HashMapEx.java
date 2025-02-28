package org.iit.healthcare.betabatch;

import java.util.Set;
import java.util.TreeMap;

public class HashMapEx {
	public static void main(String[] args) {
		
		TreeMap<String,Integer> hMap = new TreeMap<String,Integer>();
		hMap.put("Arti",10);
		hMap.put("James",20);
		hMap.put("John",30);
		hMap.put("Charlie",40);
		hMap.put("Arti",50);
		
		
		
		System.out.println("size of the map " + hMap.size());
		System.out.println("Marks of Arti  " + hMap.get("Arti"));
		
		
		Set<String> setofKeys = hMap.keySet();
		
		for (String s: setofKeys)
		{
			System.out.println("Key is :: "+ s); 
			System.out.println("value is :: "+ hMap.get(s));
		}
		
		
		
		
	}

}
