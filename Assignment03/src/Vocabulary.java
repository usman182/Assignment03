import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class Vocabulary extends Thread {
	
	int[] storeLength = new int[50];
	String[] storeWords = new String[100];
	
	int SPACE = 30;
	int space = 5;
	public void run()
	{
		NavigableSet<String> ts = new TreeSet<>();
		
		
		int i=0;
		int j=0;
		try
		{
			FileReader fr = new FileReader("vocabulary.txt");
			Scanner myReader = new Scanner(fr);
			
			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				storeLength[i] = data.length();
				//storeWords[i] = data;
				ts.add(data);
				
				//System.out.println(data);
				//System.out.println("The length of " + data + " is " + storeLength[i]);
				i++;
			}
			myReader.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("An error occured");
			e.printStackTrace();
		}
		finally
		{
			
			for (String value : ts)
			{	
				storeWords[j] = value;
				
				for (int t=0; t<SPACE; t++)
					System.out.print(" ");
				
				
					SPACE += space;
					System.out.println(value);
					System.out.println();
					j++;
			}
			
		}
	}

}
