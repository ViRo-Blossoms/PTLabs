package Labp;

import java.util.Arrays;
//
//Copyright (c) 2023 Promineo Tech
//Author:  Promineo Tech Academic Team
//Subject: Arrays & Methods
//Java Week 03 Lab
//

public class Week03ArraysAndMethodsLab {

	public static void main(String[] args) {
			
		//
		// Arrays:
		//
		
		// 1. Create an array with the following values 1, 5, 2, 8, 13, 6
 int [] arr = {1,5,2,8,13,6};
		
		// 2. Print out the first element in the array
	System.out.println(arr[1]);
		
		// 3. Print out the last element in the array without using the number 5
	System.out.println(arr[4+1]);
		
		// 4. Print out the element in the array at position 6, what happens?
	System.out.println("Out of Bounds error!");
		
		// 5. Print out the element in the array at position -1, what happens?
	System.out.println("Once more, same as before.");
			System.out.println();
		// 6. Write a traditional for loop that prints out each element in the array
	for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
			System.out.println();
		// 7. Write an enhanced for loop that prints out each element in the array
	for (int ar : arr)
		{
			System.out.println(ar);
		}
		System.out.println();
		// 8. Create a new variable called sum, write a loop that adds 
		//			each element in the array to the sum
	int sum = 0;
	for (int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
		}
		System.out.println(sum);
		System.out.println();
		// 9. Create a new variable called average and assign the average value of the array to it
	double average = sum / arr.length;
		System.out.println(average);
		System.out.println();
		// 10. Write an enhanced for loop that prints out each number in the array 
		//			only if the number is odd
	for ( int ar : arr) 
		{
			if (ar % 2 == 1)
			{
				System.out.println(ar);
			}
		}
		System.out.println();
		// 11. Create an array that contains the values "Sam", "Sally", "Thomas", and "Robert"
		String[] names = {"sam", "sally", "thomas", "robert"};
		
		// 12. Calculate the sum of all the letters in the new array
	int nSum = 0;
		for ( String name : names)
		{
			nSum += name.length();
		}
		System.out.println(nSum);
		System.out.println();
		//
		// Methods:
		//
		
		// 13. Write and test a method that takes a String name and prints out a greeting. 
		//			This method returns nothing.
	greeting("Tom");
	System.out.println();
		// 14. Write and test a method that takes a String name and  
		//			returns a greeting.  Do not print in the method.
	System.out.println(greeting2("Sally"));
	System.out.println();
		// Compare method 13 and method 14:  
		//		a. Analyze the difference between these two methods.
		//		b. What do you find? 
		//		c. How are they different?
		
		
		// 15. Write and test a method that takes a String and an int and 
		//			returns true if the number of letters in the string is greater than the int
	if (wordLengthComp("Thomas", 8) == true)
	{
		System.out.println("The word is longer than the number.");
	}
	else
	{
		System.out.println("The word is not longer than the number.");
	}
	System.out.println();
		// 16. Write and test a method that takes an array of string and a string and 
		//			returns true if the string passed in exists in the array
	String[] dictionary = {"Hello", "World", "Windows", "MacOS", "Linux"};
	if (stringLookup(dictionary, "Linux") == true)
	{
		System.out.println("It's in there!");	
	}
	else
	{
		System.out.println("It's not in there.");
	}
	System.out.println();
		// 17. Write and test a method that takes an array of int and 
		//			returns the smallest number in the array
	int[] numbahs = {9,2,8,3,1,7,5,6,4};
		System.out.println("$" + lowBall(numbahs) + " is the best I can do.");
		System.out.println();
		// 18. Write and test a method that takes an array of double and 
		//			returns the average
		double[] grades = {99.98,29.47,78.00,100.01,69.42};
		if (gradeAverager(grades) > 70)
		{
			System.out.println("You passed the class!");
		}
		else
		{
			System.out.println("You failed the class ):");
		}
		System.out.println();
		// 19. Write and test a method that takes an array of Strings and 
		//			returns an array of int where each element
		//			matches the length of the string at that position
		String[] pokemonTeam = {"Charmander", "Shuckle", "Sylveon", "Orion", "Mismagius", "Goodra"};
		System.out.println("The score for your team is " + Arrays.toString(pokedex(pokemonTeam)));
			System.out.println();
		// 20. Write and test a method that takes an array of strings and 
		//			returns true if the sum of letters for all strings with an even amount of letters
		//			is greater than the sum of those with an odd amount of letters.
		String[] wordin = {"Heya", "Charleston", "Cowboy", "Vinegette", "Ranch", "Diaphram"};
		System.out.println(evenOdd(wordin));
	System.out.println();
		// 21. Write and test a method that takes a string and 
		//			returns true if the string is a palindrome
	if (palindrome("Racecar") == true)
		{
			System.out.println("That's a palindrome!");
		}
		else
		{
			System.out.println("Whoops!");
		}
	}
	

	
	// Method 13:
static public void greeting(String name)
	{
		System.out.println("Hello, " + name);
	}

	// Method 14:
static public String greeting2(String name)
{
	String greeting2 = "Hello, " + name + "!";
	return greeting2;
}
	
	// Method 15:
static public boolean wordLengthComp(String word, int length)
{
	boolean wordLengthCompRes = length < word.length();
	return wordLengthCompRes;
}
	// Method 16:
static public boolean stringLookup(String[] dictionary, String word )
{
	for (String dictionare : dictionary)
		if (dictionare.contains(word))
			{
			return true;
			}
	return false;
}
	// Method 17:
static public int lowBall(int[] numbahs)
{
	int lowBall = 9999;
	for (int lint : numbahs)
	{
		if (lowBall > lint)
			lowBall = lint;
	}
return lowBall;
}
	// Method 18:
static public double gradeAverager(double[] grades)
{
	double gSum = 0;
	for (double grade : grades)
	{
		gSum+= grade;
	}
	double avgGrade = gSum / grades.length;
	return avgGrade;
}
	// Method 19:
static public int[] pokedex(String[] pokemonTeam)
{
	int[] pdHash = new int[pokemonTeam.length];
	for (int i = 0; i < pokemonTeam.length; i++)
	{
		pdHash[i] = pokemonTeam[i].length();
	}
	return pdHash;
}
	// Method 20:
static public boolean evenOdd(String[] wordin)
{
	int even = 0;
	int odd = 0;
	for (String worden : wordin)
	{
		if (worden.length() % 2 == 0)
		{
			even++;
		}
		else
		{
			odd++;
		}
	}
	return even > odd;
}
	
	// Method 21:
static public boolean palindrome(String aibohphobia) 
{
	aibohphobia = aibohphobia.toLowerCase();
	for (int i = 0; i < aibohphobia.length() / 2; i++) 
	{
		if (aibohphobia.charAt(i) != aibohphobia.charAt(aibohphobia.length() - i - 1)) 
		{
			return false;
		}
	}
		return true;
}

}