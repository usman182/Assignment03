import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.*;

public class InputFile1 extends Thread {
	

	public void run()
	{
		Vector vector = new Vector();
		Vocabulary vocabulary = new Vocabulary();
		
		String[] WordsDeliminator = new String[100];
		String[] StoreWords = new String[100];
		int i = 0;
		try
		{
			FileReader fr = new FileReader("inputfile1.txt");
			Scanner myReader = new Scanner(fr);
			
			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				WordsDeliminator = data.split(" ");
				
				for (String w : WordsDeliminator)
				{
					vector.addElement(w);
					StoreWords[i] = w;
					//System.out.println(w);
					
					
					//if (w == vocabulary.storeWords[i])
					//{
						System.out.println("Match found " + vocabulary.storeWords[i]);
					//}
						
						
						i++;
				}
				
				System.out.println();
				
			}
			setName("inputFile1.txt");
			System.out.println("The vector list for " + getName() + " is : " + vector);
			myReader.close();
			
			
			
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("An error occured");
			e.printStackTrace();
		}
		
	}


}
