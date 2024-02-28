package Assignment1; 

/* Class with the main method to run the whole program 
 * and let users choose what they wanna do
 * 
 * @author Inhle Cele
 * @version 1.0
 * @since 25-02-2024 
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class GenericMenu 
{

	private static Generic [] genericArr= new Generic[50005];
	private static int len=0;
	
	public static void readFile(String fName) 
	{
	 Scanner fileIn = null;
	  try 
	  {
		fileIn= new Scanner(new FileInputStream(fName));
		while (fileIn.hasNext()) 
		{
			String line= fileIn.nextLine();
			String [] genericDetails = new String[3];
			genericDetails = line.split("\\t");
			Generic temp = new Generic(genericDetails[0],genericDetails[1], genericDetails[2]);
			genericArr[len]= temp;
			len++;
		} 
		
		System.out.println("\nKnowledge base loaded succesfully.");
		fileIn.close();
		
	  } catch (FileNotFoundException f) 
	  {
		System.out.println("File not found");
	  }	
	}
	
	public static void writeToFile()
	{
		PrintWriter pw= null;
		try 
		{
			pw = new PrintWriter(new FileOutputStream("GenericsKB.txt", true));
			for (int j = 0; j < genericArr.length; j++)
			{
				pw.println(genericArr[j].toString()); //if not in file just write/add it to the end
			}
			 pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
	
	public static int search(String term)
	{

		int found= -1;
		int count=0;
		while(count<= len)//loop through the arrary
		{
			if (term.equalsIgnoreCase(genericArr[count].getTerm()))
			{
				found= count;
				break;
			}
			count++;
		}
		return found;
	}
	
	public static int search(String term, String sentence) 
	{

		int found= -1;
		int count=0;
		while(count<= len)//loop through the arrary
		{
			System.out.println(count);
			if (term.equalsIgnoreCase(genericArr[count].getTerm()))
			{	
				if (sentence.equalsIgnoreCase(genericArr[count].getSentence()))
				{	
					found = count;
				}
			}
			count++;
		}
		return found;
	}
	
	public static void main(String[] args) 
	{
		
		Scanner keyboard= new Scanner(System.in);
		System.out.print("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledeg base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\nEnter your choice: ");
		int menuAns= keyboard.nextInt();
		
		while (menuAns!=5)//while the answer isnt quit
		{
			switch (menuAns) 
			{
			case 1://Load data set we are using
				System.out.print("\nEnter a file name: ");
				keyboard.nextLine(); //throw away extra line
				String fileName= keyboard.nextLine();
				readFile(fileName);//code block
				break;
			case 2: //add a new statement to the database
				System.out.print("\nEnter the term: ");
				keyboard.nextLine(); //throw away extra line
				String searchTerm2= keyboard.nextLine();
				System.out.print("Enter the statement to search: ");
				String searchStatement2= keyboard.nextLine();
				System.out.print("Enter the confidence score: ");
				String confidence2= keyboard.nextLine(); //file?
				int pos2= search(searchTerm2, searchStatement2);// COME BACK
				if (pos2 >=0) //if the term exists in the knowledge base
				{
				 genericArr[pos2]= new Generic(searchTerm2,searchStatement2, confidence2);
				}
				
					break;			
			case 3: //searching for an item
				System.out.print("\nEnter the term to search: ");
				keyboard.nextLine(); //throw away extra line
				String searchTerm= keyboard.nextLine();
				int pos= search(searchTerm);
				if (pos>=0)//if the term exists in the knowledge base
				{
				 System.out.println("\nStatement found: " +genericArr[pos].getSentence() + " (Confidence score: " + genericArr[pos].getConfidence() + ")");
				}
					break;
			case 4: //search by term and sentence
				System.out.print("\nEnter the term: ");
				keyboard.nextLine(); //throw away extra line
				searchTerm= keyboard.nextLine();
				System.out.print("Enter the statement to search: ");
				String searchStatement4= keyboard.nextLine();
				pos= search(searchTerm, searchStatement4);
				if (pos>=0) //if the term exists in the knowledge base
				{
				 System.out.println("\nThe statement was found and has a confidence score of " + genericArr[pos].getConfidence()+ ".");
				}
				
					break;
			default:
				System.out.println("incorrect input");
				break;
			}
			
			System.out.print("\nChoose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledeg base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\nEnter your choice: ");
			menuAns= keyboard.nextInt();
		}
		
		writeToFile();
		keyboard.close();
	}
	

}
