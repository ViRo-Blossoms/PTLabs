package Labo;

import java.util.HashSet;
import java.util.Set;

public class week4CodeProject {

	public static void main(String[] args) {
		//Coding Steps

		//1. Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93.
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
			//ViRo: This is what my comments will look like
		
		//a. Programmatically subtract the value of the first element in the array from the value in the last element of the array (i.e. do not use ages[7] in your code). Print the result to the console.  
		System.out.println(firstFromLast(ages)); //ViRo: We saw the next problem and moved the code that was here to its own method, now we just call firstFromLast
		
		//b. Create a new array of int called ages2 with 9 elements (ages2 will be longer than the ages array, and have more elements).  
			//i. Make sure that there are 9 elements of type int in this new array.  
			//ii. Repeat the subtraction from Step 1.a. (Programmatically subtract the value of the first element in the new array ages2 from the last element of ages2). 
			//iii. Show that using the index values for the elements is dynamic (works for arrays of different lengths).
		int[] ages2 = {5, 9, 35, 23, 13, 12, 66, 101, 88};
		System.out.println(firstFromLast(ages2)); // ViRo: Just calling the method again
		
		//c. Use a loop to iterate through the array and calculate the average age. Print the result to the console.
		System.out.println(plainEven(ages, true)); // ViRo: It's average; Plain, even.		I cannot stop laughing lmao
		System.out.println(plainEven(ages2, true));
		System.out.println(); //ViRo: Keeping the console clean, one sysout at a time 
		
		//2. Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		//a. Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
		int holden = 0; //ViRo: I personally like goofy variable names, but try to keep my stuff at least relevant 
		for (String name : names) 
		{
			holden += name.length(); 
		}
		System.out.println(holden/names.length); //ViRo: Same with plainEven, dont need the average for anything so it doesn't get its own variable in memory
		//b. Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.
		StringBuilder strbldr = new StringBuilder(); //ViRo: Stringbuilder time. We still don't get what the value of mutability in memory is yet, but we know it's apparently a big deal so making it a habit to use it when we can.	
		for (int i = 0; i < names.length; i++) //ViRo: Need the counter, so regular loop. names.length to keep it dynamic.
			{
				strbldr.append(names[i]); //ViRo: Using the for counter to run through the index of names.
				if (i < names.length-1) //ViRo: If statement after to add the space, going up to the last cycle where the statement flips to keep from putting on an extra space.
				{
					strbldr.append(" ");				
				}
			}
		System.out.println(strbldr); //ViRo: And then sysout the result
		System.out.println();
		
		//3. How do you access the last element of any array?
		String[] decisiviness = {"That", "Uhh", "Maybe", "Perchance", "This"};
		System.out.println("Like " + decisiviness[decisiviness.length-1]);
		
		//4. How do you access the first element of any array?
		System.out.println("Like " + decisiviness[0]);
		System.out.println();
		
		//5. Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name to the nameLengths array.
		int[] nameLengths = new int[names.length]; //ViRo: Fun reminder, arrays are zero indexed, but setting them isn't
		for (int i = 0; i < names.length; i++)
		{
			nameLengths[i] = names[i].length();
			System.out.print(nameLengths[i]); //ViRo: Ok, this is technically debug code and so is everything below it, but to show in the video this step actually works it's staying in
			if (i < names.length-1) 
			{
				System.out.print(" ");				
			}
		}
		System.out.println();
		
		//6. Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console.
		System.out.println(plainEven(nameLengths, false));
		System.out.println();
		
		//7. Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. (i.e. if I pass in “Hello” and 3, I expect the method to return “HelloHelloHello”).
		System.out.println(didIStutter("Ness", 64));
		System.out.println();
		
		//8. Write a method that takes two Strings, firstName and lastName, and returns a full name (the full name should be the first and the last name as a String separated by a space).
		System.out.println(myNameIs("Buddy", "Holly"));
		System.out.println();
		
		//9. Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100.
		System.out.println(bigWinner(ages));
		System.out.println(bigWinner(nameLengths));
		System.out.println();
		
		//10. Write a method that takes an array of double and returns the average of all the elements in the array.
		double[] burger = {25.3, 235.3, 7.8, 44.4, 12.34, 999.99};
		double[] burgerWithCheese = {666.66, 4.20, 1.23, 60.1};
		System.out.println(plainestEvener(burger));
		System.out.println(plainestEvener(burgerWithCheese));

		//11. Write a method that takes two arrays of double and returns true if the average of the elements in the first array is greater than the average of the elements in the second array.
		System.out.println(orderUp(burger, burgerWithCheese)); //ViRo: Order matters! This way it returns true...
		System.out.println(orderUp(burgerWithCheese, burger)); //ViRo: But this way is false!
		System.out.println();
		
		//12. Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, and returns true if it is hot outside and if moneyInPocket is greater than 10.50.
		double moneyInPocket = 5.82;
		boolean isHotOutside = true;
		System.out.println(willBuyDrink(moneyInPocket, isHotOutside)); // ViRo: Returns false because we're short on cash.
		moneyInPocket += 20;
		System.out.println(willBuyDrink(moneyInPocket, isHotOutside)); // ViRo: but finding a 20 gives us some spending money!
		System.out.println();
		
		//13. Create a method of your own that solves a problem. In comments, write what the method does and why you created it.
		//ViRo: Knowing that sets have no order to them, we've created a set of words that when read in order make sense. They are normalWords.
		Set<String> normalWords = new HashSet<>();
		normalWords.add("Hello");
		normalWords.add("My");
		normalWords.add("Name");
		normalWords.add("Is");
		normalWords.add("Doctor");
		normalWords.add("Frankenstien");
		normalWords.add("It's");
		normalWords.add("Very");
		normalWords.add("Nice");
		normalWords.add("To");
		normalWords.add("Meet");
		normalWords.add("You");
		
		System.out.println(frankentence(normalWords)); // ViRo: It's ALIVE!!!
	}

	public static StringBuilder frankentence(Set<String> nWs) //ViRo: So letting our good assistant iRNGor take the words apart and hand them back to us to stitch together in a monsterly fashion seemed like fun!
	{
		StringBuilder notNormalWords = new StringBuilder();
		for (String words : nWs)  //We go through the set
		{
			notNormalWords.append(words + " "); //ViRo: And append them together
		}
		return notNormalWords; //ViRo: Before sending our creature out into the night!
	}
	
	public static double plainEven(int[] numbers, boolean average)
	{
		int holder = 0; //ViRo: initializing holder out here to hold our sum while we run the loop
		for (int num : numbers) //ViRo: Enhanced loops are our go to if we don't need to use a counter in out function
		{
			holder += num;
		}
		if (average == true) //ViRo: Originally, this just added and averaged before returning the int, but with p5 it's cooler to just add a boolean check to see if it should be averaged
		{
			return holder / numbers.length;
		}
		else
		{
			return holder; //Ro: Granted, this breaks the joke we were laughing at earlier, but I think it was worth the cost
		}
	}
	
	public static boolean willBuyDrink(double mIP, boolean iHO)
	{
		if (mIP > 10.50 && iHO == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean orderUp(double[] d1, double[] d2)
	{	
		if (plainestEvener(d1) > plainestEvener(d2)) //ViRo: Figured while we were doing mad science we would try this and it worked! we look forward to accidently creating infinite loops using methods.
		{
			return true;
		}
		else
		{
			return false;
		}
}
	
	public static double plainestEvener(double[] numbers)
	{
		double holder = 0;
		for (double num : numbers)
		{
			holder += num;
		}
			return holder / numbers.length;
	}

	public static boolean bigWinner(int[] numbers)
	{
		int holder = 0;
		for (int num : numbers)
		{
			holder += num;
		}
		if (holder > 100)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public static int firstFromLast(int[] numbers)
	{
		return numbers[numbers.length-1] - numbers[0];
		//ViRo: .length returns the number of elements in an array, but arrays are zero-indexed, so '-1' prevents an out of bounds error. We do it this way to keep the program dynamic.
	}
	
	public static String myNameIs(String firstName, String lastName)
	{
		return firstName + " " + lastName; //ViRo: Honestly didn't think this work, but figured we should try and really glad we did
	}
	
	public static StringBuilder didIStutter(String word, int times)
	{
		StringBuilder strbldr = new StringBuilder(); //ViRo: strbuilder is our shorthand for STRingBuiLDeR, so we really really hope it isn't a method or something
		for (int i = 0; i < times; i++) 
			{
				strbldr.append(word); //ViRo: Just the .concat but fancy
			}
		return strbldr;
	}
}
//Vi: whatcha doin?