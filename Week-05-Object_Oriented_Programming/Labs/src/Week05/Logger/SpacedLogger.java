package Week05.Logger;

public class SpacedLogger implements LoggerInterface{

	@Override
	public void log(String str) 
	{
		StringBuilder strbldr = new StringBuilder();
		for (int i = 0; i < str.length(); i++)
		{
			strbldr.append(str.charAt(i));
			if (i < str.length()-1)
			{
				strbldr.append(" ");
			}
		}
		System.out.println(strbldr);
	}

	@Override
	public void error(String str) 
	{
		System.out.print("ERROR: ");
		log(str);
	}
}