import java.io.*;
import java.util.*;
	
	
public class MyProgram {	
	
	public static void main(String[] args) //throws FileNotFoundException
	{
		
		System.out.println("Choose any option from the following");
		System.out.println("1. Displaying BST build from Vocabulary File");
		System.out.println("2. Displaying Vectors build from Input File");
		System.out.println("3. Viewing Match words and its frequency");
		System.out.println("4. Searching a query - It should display all the files query found in");
		System.out.println("5. Enter 5 for Exiting");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		
		switch (option)
		{
			case 1:
			{
				Vocabulary vocabulary = new Vocabulary();		// Thread 1
				vocabulary.start();
				break;
			}
			
			case 2:
			{
				InputFile1 inputfile1 = new InputFile1();		// Thread 2
				inputfile1.start();
				
				InputFile2 inputfile2 = new InputFile2();		// Thread 2
				inputfile2.start();
				
				break;
			}
			
			case 3:
			{
				System.out.println("The matching words are : ");
			}
			
			default:
				System.out.println("You entered the wrong option");
		}
		
		
		
	}

}
