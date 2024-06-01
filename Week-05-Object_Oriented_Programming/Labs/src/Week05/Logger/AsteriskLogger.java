package Week05.Logger;

public class AsteriskLogger implements LoggerInterface{

	@Override
	public void log(String str) {
		System.out.println("***" + str + "***");
		
	}

	@Override
	public void error(String str) {
		astPrinter(str);
		System.err.println("***ERROR: " + str + "***");
		astPrinter(str);
	}
	
	private void astPrinter(String str)
	{
		StringBuilder strbldr = new StringBuilder();
		for (int i = 0; i < str.length() + 13 ; i++)
		{
			strbldr.append("*");
		}
		System.err.println(strbldr);
	}
}