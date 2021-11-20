import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class InputFile2 extends Thread{

	public void run()
	{
		Vector vector = new Vector();
		
		String[] WordsDeliminator = new String[100];
		String[] StoreWords = new String[100];
		int i = 0;
		try
		{
			FileReader fr = new FileReader("inputfile2.txt");
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
					i++;
				}
				
				//System.out.println();
				
			}
			setName("inputFile2.txt");
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
