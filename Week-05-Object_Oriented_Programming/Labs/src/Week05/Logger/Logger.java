package Week05.Logger;

import java.util.Scanner;

public class Logger {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		LoggerInterface logal = new AsteriskLogger();
		LoggerInterface logsl = new SpacedLogger();
		
		System.out.println("Enter a test word: ");
		String test = scanner.next();
		System.out.println();
		logal.log(test);
		System.out.println();
		logal.error(test);
		System.out.println();
		logsl.log(test);
		System.out.println();
		logsl.error(test);
	}

}
