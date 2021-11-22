import java.io.*;
import java.util.*;


public class MyProgram {
	
	
String putString[] = new String[3];
int countOfFileWord = 0;
int initialValue=0;

public class Word
{
		String[] word = new String[1000];
		
		Word(String[] name)
		{
			this.word[initialValue] = name[initialValue];
			initialValue++;
		}
	}



public class Vocabulary extends Thread 
{
		
		int[] storeLength = new int[50];
		String[] storeWords = new String[100];
		String[] storeWordsSecondTime = new String[100];
		NavigableSet<String> ts = new TreeSet<>();
		NavigableSet<String> ts2 = new TreeSet<>();
		int lengthofStoreWords;
		
		int SPACE = 30;
		int space = 5;
		
		
		
		Vocabulary(String[] str)
		{
			putString[0] = str[0];
		}
		
		
		public void run()
		{
			
			int i=0;
			int j=0;
			try
			{
				FileReader fr = new FileReader(putString[0]);
				Scanner myReader = new Scanner(fr);
				
				while (myReader.hasNextLine())
				{
					String data = myReader.nextLine();
					storeLength[i] = data.length();
					ts.add(data);
					
					//System.out.println(data);
					//System.out.println("The length of " + data + " is " + storeLength[i]);
					i++;
				}
				//System.out.println("The size is : " + ts.size());
				lengthofStoreWords = ts.size();
				
				myReader.close();
				fr.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("An error occured");
				e.printStackTrace();
			} 
			
			catch (IOException e) 
			{
				System.out.println("An error occured in the file which is IO");
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
		
public void settheWords(String[] str) throws IOException
{
			
			FileReader fr2 = new FileReader(str[0]);
			Scanner myReader2 = new Scanner(fr2);
			//countOfFileWord++;
			while (myReader2.hasNextLine())
			{
				String data = myReader2.nextLine();
				ts2.add(data);
			}
			myReader2.close();
			fr2.close();
			
			int k=0;
			for (String value : ts2)
			{	
				storeWordsSecondTime[k] = value;
				//System.out.println("Hi : " + storeWordsSecondTime[k]);
				k++;
			}
			lengthofStoreWords = ts2.size();
			//System.out.println("The length of vocabulary file is : " + lengthofStoreWords);
		}


	

public void checkingTheQuery(String[] str, String[] queryWords) throws IOException
{
	
			
			FileReader fr2 = new FileReader(str[0]);
			Scanner myReader2 = new Scanner(fr2);
			//countOfFileWord++;
			while (myReader2.hasNextLine())
			{
				String data = myReader2.nextLine();
				ts2.add(data);
			}
			
			
			int k=0;
			for (String value : ts2)
			{	
				storeWordsSecondTime[k] = value;
				k++;
			}
			lengthofStoreWords = ts2.size();
			
			// Checking how much of the query exits in the file
			int[] count = new int[lengthofStoreWords];
			for (int i=0; i<lengthofStoreWords; i++)
			{
				count[i] = 0;
			}
			int z=0;
			int counterForQueryMatch=0;
			for (int i=0; i<lengthofStoreWords; )
			{
				String sr1 = storeWordsSecondTime[z];
				String sr2 =  queryWords[i];
				if (sr1.equalsIgnoreCase(sr2))
				{
					counterForQueryMatch++;
					count[i]++;
					System.out.print("Word " + queryWords[i] + " from the query to the " + str[0] + " file" + "\tThe frequency of " + queryWords[i] + " is : " + count[i] + "\n");
					i++;
				}
				else
				{
					z++;
				}
				
			}
			
			System.out.println(counterForQueryMatch + " number of words match with the " + str[0] + " file");
			System.out.println(counterForQueryMatch + " number of matches found in " + str[0] + " file");
			if (storeWordsSecondTime.equals(queryWords))
			{
				System.out.println("Proper match with the " + str[0] + " file");
			}
			myReader2.close();
			fr2.close();
		}

}
	
public class InputFile1  extends Thread 
{
	
		InputFile1(String[] str)
		{
			putString[1] = str[1];
		}
	
		MyProgram a1 = new MyProgram();
		Vector vector = new Vector();
		Vocabulary vocabulary = a1.new Vocabulary(putString);
		NavigableSet<String> ts = new TreeSet<>();
		
		
		String[] WordsDeliminator = new String[100];
		String[] StoreWords2 = new String[100];
		String[] StoreWords3 = new String[100];
		String[] StoreWords4 = new String[100];
		int len=0;
		
		
		
		public void run()
		{
			
			int i = 0;
			try
			{
				FileReader fr = new FileReader(putString[1]);
				Scanner myReader = new Scanner(fr);
				
				
			synchronized (this)
			{
				while (myReader.hasNextLine())
				{
					String data = myReader.nextLine();
					WordsDeliminator = data.split(" ");
					
					for (String w : WordsDeliminator)
					{
						vector.addElement(w);
						StoreWords2[i] = w;
						//System.out.println(w);
							
							i++;
					}
					
					System.out.println();
					
				}
				setName(putString[1]);
				System.out.println("The vector list for " + getName() + " is : " + vector);
				System.out.println();
				
			}	
				
				len = vector.size();
				
					 myReader.close();
		}
			catch (IOException e)
			{
				System.out.println("An error occured");
				e.printStackTrace();
			} 
			
			
			
			
			
		
}
		
public void setFrequency(String[] str) throws IOException
{
	System.out.println("Word matching using " + str[1] + " file");
			FileReader fr = new FileReader(str[1]);
			Scanner myReader = new Scanner(fr);
			int p=0;
			
			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				WordsDeliminator = data.split(" ");
				
				for (String w : WordsDeliminator)
				{
					vector.addElement(w);
					StoreWords3[p] = w;
					//System.out.print(StoreWords3[p] + " ");
						
						p++;
				}
			}
				System.out.println();
			
				vocabulary.settheWords(str);
				len = vector.size();
				//System.out.println("The length of input file is: " + len);
				int[] count=new int[len];
				String[] storeMatchedWords = new String[len];
				for (int i=0; i<len; i++)
				{
					count[i] = 0;
				}
				int z=0;
				for (int b=0; b<len; )
				{
					String val1 = StoreWords3[b];
					String val2 = vocabulary.storeWordsSecondTime[z];
					
				
					if (val1.equalsIgnoreCase(val2) && z < vocabulary.lengthofStoreWords)
					{
						System.out.print("Word matched : " + val1);
						storeMatchedWords[b] = val1;
						Word obj = new Word(storeMatchedWords);// created object of the class Word
						z++;
						count[b]++;
						System.out.println("\tThe frequency of " + storeMatchedWords[b] + " is : " + count[b]);
					}
					
					else if (z < vocabulary.lengthofStoreWords)
					{
						z++;
					}
					
					else
					{
						b++;
						z=0;
					}
				}
				
				System.out.println();
		




}
public void checkingTheQuery(String[] str, String[] queryWords) throws IOException
{
	
			
			FileReader fr2 = new FileReader(str[1]);
			Scanner myReader2 = new Scanner(fr2);
			//countOfFileWord++;
			FileReader fr = new FileReader(str[1]);
			Scanner myReader = new Scanner(fr);
			int p=0;
			
			while (myReader2.hasNextLine())
			{
				String data = myReader2.nextLine();
				WordsDeliminator = data.split(" ");
				
				for (String w : WordsDeliminator)
				{
					vector.addElement(w);
					StoreWords3[p] = w;
					//System.out.print(StoreWords3[p] + " ");
						
						p++;
				}
			}
				System.out.println();
			
			
			
			// Checking how much of the query exits in the file
			int[] count = new int[p];
			for (int i=0; i<p; i++)
			{
				count[i] = 0;
			}
			int z=0;
			int counterForQueryMatch=0;
			for (int i=0; i<p; )
			{
				String sr1 = StoreWords3[z];
				String sr2 =  queryWords[i];
				if (sr1.equalsIgnoreCase(sr2))
				{
					counterForQueryMatch++;
					count[i]++;
					System.out.print("Word " + queryWords[i] + " from the query to the " + str[1] + " file" + "\tThe frequency of " + queryWords[i] + " is : " + count[i] + "\n");
					i++;
					
				}
				else
				{
					z++;
				}
				
			}
			
			System.out.println(counterForQueryMatch + " number of words match with the " + str[1] + " file");
			System.out.println(counterForQueryMatch + " number of matches found in " + str[1] + " file");
			if (StoreWords3.equals(queryWords))
			{
				System.out.println("Proper match with the " + str[1] + " file");
			}
			myReader2.close();
			fr2.close();
		}

}
		

public class InputFile2  extends Thread 
{
		
		Vector vector = new Vector();
		Vocabulary vocabulary = new Vocabulary(putString);
		NavigableSet<String> ts = new TreeSet<>();
		
		
		String[] WordsDeliminator = new String[100];
		String[] StoreWords2 = new String[100];
		String[] StoreWords3 = new String[100];
		int len=0;
		int s1=0;
		int s2=0;
		int p=0;
		
		
		InputFile2(String[] str)
		{
			putString[2] = str[2];
		}
		
		public void run()
		{
			
			int i = 0;
			try
			{
				FileReader fr = new FileReader(putString[2]);
				Scanner myReader = new Scanner(fr);
				
				//System.out.println("First i " + vocabulary.storeWordsSecondTime[2]);
				
				
				while (myReader.hasNextLine())
				{
					String data = myReader.nextLine();
					WordsDeliminator = data.split(" ");
					
					for (String w : WordsDeliminator)
					{
						vector.addElement(w);
						StoreWords2[i] = w;
						//System.out.println(w);
							
							i++;
					}
					
					System.out.println();
					
				}
				setName(putString[2]);
				System.out.println("The vector list for " + getName() + " is : " + vector);
				System.out.println();
				
				
				len = vector.size();
				
				//System.out.println("The size is : " + len);
				
				//int m=0;
				//System.out.println("The size is : " + vector.size());
			
				
					int pk1=0;
					int pk2=0;
			
					 myReader.close();
		}
			catch (IOException e)
			{
				System.out.println("An error occured");
				e.printStackTrace();
			} 
			
			
				
}
		
public void setFrequency(String[] str) throws IOException
{
					System.out.println("Word matching using " + str[2] + " file");
					FileReader fr = new FileReader(str[2]);
					Scanner myReader = new Scanner(fr);
					int p=0;
					
					while (myReader.hasNextLine())
					{
						String data = myReader.nextLine();
						WordsDeliminator = data.split(" ");
						
						for (String w : WordsDeliminator)
						{
							vector.addElement(w);
							StoreWords3[p] = w;
							//System.out.print(StoreWords3[p] + " ");
								
								p++;
						}
					}
						System.out.println();
					
						vocabulary.settheWords(str);
						len = vector.size();
						//System.out.println("The length of input file is: " + len);
						int[] count=new int[len];
						String[] storeMatchedWords = new String[len];
						for (int i=0; i<len; i++)
						{
							count[i] = 0;
						}
						int z=0;
						for (int b=0; b<len; )
						{
							String val1 = StoreWords3[b];
							String val2 = vocabulary.storeWordsSecondTime[z];
							
						
							if (val1.equalsIgnoreCase(val2) && z < vocabulary.lengthofStoreWords)
							{
								System.out.print("Word matched : " + val1);
								storeMatchedWords[b] = val1;
								Word obj2 = new Word(storeMatchedWords);// created object of the class Word
								z++;
								count[b]++;
								System.out.println("\tThe frequency of " + storeMatchedWords[b] + " is : " + count[b]);
							}
							
							else if (z < vocabulary.lengthofStoreWords)
							{
								z++;
							}
							
							else
							{
								b++;
								z=0;
							}
						}
						
						
				}

public void checkingTheQuery(String[] str, String[] queryWords) throws IOException
{
	
			
			FileReader fr2 = new FileReader(str[2]);
			Scanner myReader2 = new Scanner(fr2);
			int p=0;
			
			while (myReader2.hasNextLine())
			{
				String data = myReader2.nextLine();
				WordsDeliminator = data.split(" ");
				
				for (String w : WordsDeliminator)
				{
					vector.addElement(w);
					StoreWords3[p] = w;
					//System.out.print(StoreWords3[p] + " ");
						
						p++;
				}
			}
				System.out.println();
			
			
			
			// Checking how much of the query exits in the file
			int[] count = new int[p];
			for (int i=0; i<p; i++)
			{
				count[i] = 0;
			}
			int z=0;
			int counterForQueryMatch=0;
			for (int i=0; i<p; )
			{
				String sr1 = StoreWords3[z];
				String sr2 =  queryWords[i];
				if (sr1.equalsIgnoreCase(sr2))
				{
					counterForQueryMatch++;
					count[i]++;
					System.out.print("Word " + queryWords[i] + " from the query to the " + str[2] + " file" + "\tThe frequency of " + queryWords[i] + " is : " + count[i] + "\n");
					i++;
					
				}
				else
				{
					z++;
				}
				
			}
			
			System.out.println(counterForQueryMatch + " number of words match with the " + str[2] + " file");
			System.out.println(counterForQueryMatch + " number of matches found in " + str[2] + " file");
			if (StoreWords3.equals(queryWords))
			{
				System.out.println("Proper match with the " + str[2] + " file");
			}
			myReader2.close();
			fr2.close();
		}

}







// main function	
public static void main(String[] args) throws InterruptedException, IOException
	{
		int counterForFiles=0;
		
		for (int i=0; i<args.length; i++)
		{
			counterForFiles++;
		}
		System.out.println("\nThe number of files are : " + counterForFiles + "\n");
		
		System.out.println("The names of the file input are : ");
		for (int i=0; i<args.length; i++)
		{
			System.out.println(args[i]);
		}
		System.out.println();
		MyProgram a1 = new MyProgram();
		System.out.println("Choose any option from the following");
		System.out.println("1. Displaying BST build from Vocabulary File");
		System.out.println("2. Displaying Vectors build from Input File");
		System.out.println("3. Viewing Match words and its frequency");
		System.out.println("4. Searching a query - It should display all the files query found in");
		System.out.println("5. Enter 5 for Exiting");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		String[] storeTextFile = new String[3];
		String[] WordsDeliminatorForQuery = new String[1000];
		Vector vec = new Vector();
		String[] storeWordsForQuery = new String[1000];
		int queryCounter=0;
		
		switch (option)
		{
			case 1:
			{
				storeTextFile[0] = args[0];
				Vocabulary vocabulary = a1.new Vocabulary(storeTextFile);		// Thread 1
				vocabulary.start();
				break;
			}
			
			case 2:
			{
				storeTextFile[1] = args[1];
				InputFile1 inputfile1 = a1.new InputFile1(storeTextFile);		// Thread 2
				//synchronized (inputfile1)			// In this way firstly inputfile1 will fully complete and will not time out
				//{
					inputfile1.start();
				//}
				
				storeTextFile[2] = args[2];
				InputFile2 inputfile2 = a1.new InputFile2(storeTextFile);		// Thread 2
				//synchronized (inputfile2)		// After inputfile1 has fully exected inputfile2 will fully complete and will not time out
				//{
					inputfile2.start();
				//}
				
			
				break;
			}
			
			case 3:
			{
				storeTextFile[0] = args[0];
				storeTextFile[1] = args[1];
				storeTextFile[2] = args[2];
				InputFile1 inputfile11 = a1.new InputFile1(storeTextFile);
				InputFile2 inputfile12 = a1.new InputFile2(storeTextFile);
				//inputfile11.start();
				
				
				//inputfile11.wait();
				inputfile11.setFrequency(storeTextFile);
				//inputfile11.wait();
				inputfile12.setFrequency(storeTextFile);
				//System.out.println("The matching words are : ");
		
				break;
			}
			
			case 4:
			{
				System.out.println("Enter a query : ");
				Scanner obj = new Scanner(System.in);
				String enteringQuery = obj.nextLine();
				storeTextFile[0] = args[0];
				storeTextFile[1] = args[1];
				storeTextFile[2] = args[2];
				Vocabulary vocabulary = a1.new Vocabulary(storeTextFile);
				InputFile1 inputfile112 = a1.new InputFile1(storeTextFile);
				InputFile2 inputfile122 = a1.new InputFile2(storeTextFile);
				// Firstly we will tokenize the query in order to compare
				WordsDeliminatorForQuery = enteringQuery.split(" ");
				
				for (String w : WordsDeliminatorForQuery)
				{
					vec.addElement(w);
					storeWordsForQuery[queryCounter] = w;
					//System.out.println(w);
						
					queryCounter++;
				}
				
				vocabulary.checkingTheQuery(storeTextFile, storeWordsForQuery);
				inputfile112.checkingTheQuery(storeTextFile, storeWordsForQuery);
				inputfile122.checkingTheQuery(storeTextFile, storeWordsForQuery);
				break;
			}
			
			case 5:
			{
				System.out.println("Exiting");
				break;
			}
				
		}
		
		
		
	}

}
