
/** 
 * Class with the main method to run the whole program 
 * and let users choose what they wanna do but using Binary search tree database
 * 
 * @author Inhle Cele
 * @version 1.0
 * @since 27-02-2024 
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class GenericsKbBSTApp 
{
	private static BinarySearchTreeKB mainTree = new BinarySearchTreeKB();
	
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
			mainTree.addNode(temp);
		} 
		
		System.out.println("\nKnowledge base loaded succesfully.");
		fileIn.close();
		
	  } catch (FileNotFoundException f) 
	  {
		System.out.println("File not found");
	  }	
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
				// doesnt update statements?
				System.out.print("\nEnter the term: ");
				keyboard.nextLine(); //throw away extra line
				String searchTerm2= keyboard.nextLine();
				System.out.print("Enter the statement: ");
				String searchStatement2= keyboard.nextLine();
				System.out.print("Enter the confidence score: ");
				String confidence2= keyboard.nextLine(); 
				Generic temp2= new Generic(searchTerm2, searchStatement2, confidence2);
				mainTree.addNode(temp2);					
				System.out.println("Statement for term " + searchTerm2 + " has been updated");
				
					break;			
			case 3: //searching for an item
				System.out.print("\nEnter the term to search: ");
				keyboard.nextLine(); //throw away extra line
				String searchTerm= keyboard.nextLine();
				BSTNode<Generic> temp= mainTree.search(searchTerm);
				if (temp!= null)//if the term exists in the knowledge base
				{
				 System.out.println("\nStatement found: " +temp.getData().getSentence() + " (Confidence score: " + temp.getData().getConfidence() + ")");
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
				BSTNode<Generic> temp4= mainTree.search(searchTerm, searchStatement4);
				if (temp4!= null)//if the term exists in the knowledge base
				{
				 System.out.println("\nThe statement was found and has a confidence score of: " + temp4.getData().getConfidence());
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
		
		// writeToFile(); if we need to save all this to files when we are done
		keyboard.close();
	} //proper end?
}
	


