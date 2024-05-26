//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package Labo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// ViRo: Strings are immutable and can't be removed from memory, but stringbuilder strings can.
		// 		a. Instantiate a new StringBuilder
		StringBuilder strbldr = new StringBuilder();
		//		b. Append the characters 0 through 9 to it separated by dashes
		for (int i = 0; i < 10; i++)
			{
				strbldr.append(i);
				if (i < 9)
				{
					strbldr.append("-");				
				}
			}
		System.out.println(strbldr);
		System.out.println();
		// 				Note:  make sure no dash appears at the end of the StringBuilder

		
		// 2. List of String:
		//		a. Create a list of Strings
		List<String> crystalGems = new ArrayList<>();
		//		b. Add 5 Strings to it, each with a different length

		crystalGems.add("Amathyst");
		crystalGems.add("Garnet");
		crystalGems.add("Pearl");
		crystalGems.add("Bismuth");
		crystalGems.add("Rose Quartz");
		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string
		System.out.println(shortestName(crystalGems));
		System.out.println();
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched
		System.out.println(switcheroo(crystalGems));
		System.out.println();
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma
		System.out.println(fusionDance(crystalGems));
		System.out.println();
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)
		System.out.println(lookup(crystalGems, "ar"));
		System.out.println();
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5
		List<Integer> badDream = new ArrayList<>();
		for (int n = 1; n < 1000; n++)
		{
			badDream.add(n);
		}
		System.out.println(badDream);
		System.out.println(nightmare(badDream));
		System.out.println();
		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string
		System.out.println(measureUp(crystalGems));
		System.out.println();
		// 9. Create a set of strings and add 5 values
		crystalGems.add("Steven");
		crystalGems.add("Lapis Lazuli");
		crystalGems.add("Peridot");
		crystalGems.add("Ruby");
		crystalGems.add("Sapphire");
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.
		char charchar = 'S';
		System.out.println(alpharadical(crystalGems, charchar));
		System.out.println();
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
		System.out.println(airRally(crystalGems));
		System.out.println();
		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set
		Set<Integer> baddestDream = new HashSet<>();
		for (int n = 1; n < 1000; n++)
		{
			baddestDream.add(n);
		}
		System.out.println(evenOnly(baddestDream));
		System.out.println();
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word
		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("Abscond", "Leave hurriedly and secretly, typically to avoid detection of or arrest for an unlawful action such as theft.");
		dictionary.put("Strife", "Angry or violent struggle; Conflict");
		dictionary.put("Modus", "A mode of procedure; A way of doing something.");
		System.out.println(dictionary);
		System.out.println();
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)
		System.out.println(lookinUp(dictionary, "Strife"));
		System.out.println();
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		System.out.println(alphanumerical(crystalGems));
	}
	
	
	// Method 15:
	public static Map<Character, Integer> alphanumerical(List<String> names)
	{
		Map<Character, Integer> alphanumerical = new HashMap<>();
		char charcharjr;
		for (String name : names)
		{
			name.toLowerCase();
			charcharjr = name.charAt(0);
			if (alphanumerical.containsKey(charcharjr) != true)
			{
				alphanumerical.put(charcharjr, 1);
			}
			else if (alphanumerical.containsKey(charcharjr))
			{
				alphanumerical.put(charcharjr, alphanumerical.get(charcharjr) + 1);
			}
			else
			{
				System.out.println("Whoops!");
			}
			
		}
	return alphanumerical;
	}
	
	
	// Method 14:
	public static String lookinUp(Map<String, String> dict, String worden)
	{
		String foundIt = "";
		for (String term : dict.keySet())
		{
			if (term == worden)
			{
				foundIt = dict.get(worden);
			}
		}
	return foundIt;
	}
	
	
	// Method 12:
	public static Set<Integer> evenOnly(Set<Integer> numbers)
	{
		Set<Integer> evenOnly = new HashSet<>();
		for (int number : numbers)
		{
			if (number % 2 == 0)
			{
				evenOnly.add(number);
			}
		}
	return evenOnly;
	}

	
	// Method 11:
	public static List<String> airRally(List<String> names)
	{
		return names;
	}


	// Method 10:
	public static List<String> alpharadical(List<String> names, char input)
	{
		List<String> alpharadical = new ArrayList<>();
		for (String neam : names)
			if (neam.charAt(0) == input)
			{
				alpharadical.add(neam);
			}
		return alpharadical;
	}

	
	// Method 8:
	public static List<Integer> measureUp(List<String> names)
	{
		List<Integer> numbahs = new ArrayList<>();
		for (String name : names)
		{
			numbahs.add(name.length());
		}
		return numbahs;
	}

	
	// Method 7:
	public static List<List<Integer>> nightmare(List<Integer> numbers)
	{
		List<List<Integer>> nightmare = new ArrayList<>();
		List<Integer> fearOf2 = new ArrayList<>();
		List<Integer> fearOf3 = new ArrayList<>();
		List<Integer> fearOf5 = new ArrayList<>();
		List<Integer> fearOfNumbersInGeneralReally = new ArrayList<>();
		for (int number : numbers)
		{
			if (number % 2 == 0)
			{
				fearOf2.add(number);
			}
		}
		for (int number : numbers)
		{
			if (number % 3 == 0)
			{
				fearOf3.add(number);
			}
		}
		for (int number : numbers)
		{
			if (number % 5 == 0)
			{
				fearOf5.add(number);
			}
		}
		for (int number : numbers)
		{
			if (number % 5 == 1 && number % 3 == 1 && number % 2 == 1)
			{
				fearOf5.add(number);
			}
		}
		nightmare.add(fearOf2);
		nightmare.add(fearOf3);
		nightmare.add(fearOf5);
		nightmare.add(fearOfNumbersInGeneralReally);
	return nightmare;
	}

	
	// Method 6:
	public static List<String> lookup(List<String> names, String lookup)
	{
		List<String> looked = new ArrayList<>();
		for (String name : names)
		{
			if (name.contains(lookup))
			{
				looked.add(name);
			}
		}
		return looked;
	}

	
	// Method 5:
	public static StringBuilder fusionDance(List<String> names)
	{
		StringBuilder fusionDance = new StringBuilder();
		for (String name : names)
		{
			fusionDance.append(name);
			if (name != names.get(names.size()-1))
			{
				fusionDance.append(", ");
			}
		}
		return fusionDance;
	}
	
	// Method 4:
	public static List<String> switcheroo(List<String> names)
	{
		List<String> seman = new ArrayList<>();
		String firsties = names.get(0);
		String lasties = names.get(names.size()-1);
		for (String name : names)
		{
			if (name == names.get(0))
			{
				seman.add(lasties);
			}
			else if (name != names.get(names.size()-1))
			{
				seman.add(name);
			}
			else
			{
				seman.add(firsties);
			}
		}
		return seman;
	}
	
	// Method 3:
	public static String shortestName(List<String> names)
	{
		String shortestName = names.get(0);
		for (String name : names)
		{
			if (name.length() < shortestName.length())
			{
				shortestName = name;
			}
		}
		return shortestName;
	}
}