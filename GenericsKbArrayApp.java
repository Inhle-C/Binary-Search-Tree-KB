import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Class with the main method to run the whole program 
 * but using an array to store the DB
 * 
 * @author Inhle Cele
 * @version 1.0
 * @since 25-02-2024 
*/
public class GenericsKbArrayApp 
{
	/**
	 * Creates the array that we'll be using to store all the items
	 */
	private static Generic [] genericArr= new Generic[100000];
	private static Scanner fileIn = null;
	/**
	 * stores the legth of the array, intially 0 as empty
	 */
	private static int len=0;
	
	/**
	 * Reads in each line from a file with specified name in the folder and 
	 * puts that information into the array
	 * @param fName The name of the file we are going to read in
	 */
	public static void readFile(String fName) 
	{
	if (fileIn== null)
	{
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
	else
	{
		try 
		  {
			fileIn= new Scanner(new FileInputStream(fName));
			while (fileIn.hasNext()) 
			{
				
				String line= fileIn.nextLine();
				String [] genericDetails = new String[3];
				genericDetails = line.split("\\t");
				Generic temp = new Generic(genericDetails[0],genericDetails[1], genericDetails[2]);
				int pos= search(temp.getTerm());
				if (pos >=0) //if the term exists in the knowledge base to replace it
				{
				  genericArr[pos]= temp;
				}
				else
				  {
				  genericArr[len]= temp;
				  genericArr[len]= temp;
				  len++;
				  }
			} 
			
			System.out.println("\nKnowledge base loaded succesfully.");
			fileIn.close();
			
		  } catch (FileNotFoundException f) 
		  {
			System.out.println("File not found");
		  }	
	}
	}
	
	
	/**
	 * All updates and changes made by the user and added to the array are now stored into the file
	 */
	public static void writeToFile()
	{
		PrintWriter pw= null;
		try 
		{
			pw = new PrintWriter(new FileOutputStream("UserDB.txt", true)); //let user chose the file they used?
			for (int j = 0; j < genericArr.length; j++)
			{
				pw.println(genericArr[j].toString()); //if not in file just write/add it to the end
			}
			 pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
	
	public static void writeToFile(String F)
	{
		PrintWriter pw= null;
		try 
		{
			pw = new PrintWriter(new FileOutputStream("GenericsKbBSTfeedback.txt")); //creates new file if doesnt exist
			pw.println(F); 
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
	
	/**
	 * Searches for a specific term to see if it exists in the array from just the term alone
	 * @param term The term of the item we are looking for
	 * @return the position in the array that the term was found if it exist in the file and -1 if statement not found
	 */
	public static int search(String term)
	{

		int found= -1;
		int count=0;
		while(count< len)//loop through the arrary
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
	
	/**
	 * Searches for a specific term and statement to see if it exists in the array from just the Strings alone
	 * @param term The term we are looking for
	 * @param sentence The statement we are looking for
	 * @return the position in the array that the term was found if it exist in the file and -1 if statement not found
	 */
	public static int search(String term, String sentence) 
	{

		int found= -1;
		int count=0;
		while(count<len)//loop through the arrary
		{
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


	/**
	 * The main method of the app that allows user to choose whether they'd like to
	 * add new statements to the knowledge base,  Serach for/Display information from the knowledge base
	 * @param args The command line arguments.
	 */
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
				System.out.print("\nEnter a file name (if returning user type \"UserDB.txt\" ): ");
				keyboard.nextLine(); //throw away extra line
				String fileName= keyboard.nextLine();
				readFile(fileName);//code block
				break;
			case 2: //add a new statement to the database
				System.out.print("\nEnter the term: ");
				keyboard.nextLine(); //throw away extra line
				String searchTerm2= keyboard.nextLine();
				System.out.print("Enter the statement: ");
				String searchStatement2= keyboard.nextLine();
				System.out.print("Enter the confidence score: ");
				String confidence2= keyboard.nextLine(); 
				int pos2= search(searchTerm2);
				if (pos2 >=0) //if the term exists in the knowledge base to replace it
				{
				  genericArr[pos2]= new Generic(searchTerm2,searchStatement2, confidence2);
				}
				else
				  genericArr[len]= new Generic(searchTerm2, searchStatement2, confidence2);
					
				System.out.println("Statement for term " + searchTerm2 + " has been updated");
				
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
				else
					System.out.println("Statement does not exist in the file");
				
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
				else
					System.out.println("Statement does not exist in the file");
				
					break;
			default:
				System.out.println("incorrect input");
				break;
			}
			
			System.out.print("\nChoose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledeg base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\nEnter your choice: ");
			menuAns= keyboard.nextInt();
		}
		keyboard.close();
		writeToFile(); //saving all this
		String feedback= JOptionPane.showInputDialog("Please type any feedback you may have in the box below");
		writeToFile(feedback); //feedback
		System.exit(0);
	}
	

}
