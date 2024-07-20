package com.promineotech;

import java.util.Random;

public class TestDemo {

public int addPositive(int a, int b) {
	if (a > 0 && b > 0)
	{
		System.out.println(a + " plus " + b + " equals " + (a+b));
		return a + b;
	}
	else
	{
		System.err.println("Both parameters must be positive!");
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
} //AP

public int randomNumberSquared() {
	int a = getRandomInt();
	System.out.println(a + " squared is " + (a*a));
	return a * a;
	
} //RNS
public int getRandomInt() {
    Random random = new Random();
    return random.nextInt(10) + 1;
} //GRI

}//CLASS
