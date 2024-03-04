
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/** 
 * Class with the main method to run the whole program 
 * and let users choose what they wanna do but using Binary search tree database
 * 
 * @author Inhle Cele
 * @version 1.0
 * @since 27-02-2024 
*/
public class GenericsKbBSTApp 
{
	/**
	 * Creates a Binary Search Tree that we'll be using to store all the items
	 */
	private static BinarySearchTreeKB mainTree = new BinarySearchTreeKB();
	private static Scanner fileIn = null;
	/**
	 * Reads in each line from a file with specified name in the folder and puts that information into the search tree
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
			mainTree.addNode(temp);
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
				
				BSTNode<Generic> exist= mainTree.search(temp.getTerm());
				if (exist!= null)//if the term exists in the knowledge base
				{
				  if (temp.getConfidence()>= exist.getData().getConfidence())
				  {
					  exist.getData().setTerm(temp.getTerm());
					  exist.getData().setConfidence(temp.getConfidence());
					  exist.getData().setSentence(temp.getSentence());
				  }
				}
				else //if it doesnt
				mainTree.addNode(temp);
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
	 * The main method of the app that allows user to choose whether they'd like to
	 * add new statements to the knowledge base,  Serach for/Display information from the knowledge base
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard= new Scanner(System.in);
		System.out.print("Choose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledeg base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\n6. Partial matches\nEnter your choice: ");
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
				BSTNode<Generic> check= mainTree.search(searchTerm2);
				if (check!= null)//if the term exists in the knowledge base
				{
				  double checkCon =Double.parseDouble(confidence2);
				  if( checkCon >= check.getData().getConfidence()) 
				  {
					  check.getData().setTerm(searchTerm2);
					  check.getData().setConfidence(checkCon);
					  check.getData().setSentence(searchStatement2);
				  }
				}
				else
					{		
					Generic temp2= new Generic(searchTerm2, searchStatement2, confidence2);
					mainTree.addNode(temp2);
					}
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
			case 6: //searching for an item with partial matches
				System.out.print("\nEnter the term to search: ");
				keyboard.nextLine(); //throw away extra line
				String searchTerm6= keyboard.nextLine();
				List<BSTNode> partiallist= mainTree.searchPartial(searchTerm6);
				if (!partiallist.isEmpty())
				{
				 System.out.println("Partial matches found:");
				 for (BSTNode bstNode : partiallist) 
				 {
					System.out.println(bstNode);
				}
				}
				else
					System.out.println("No partial matches");
				
					break;		
			
			default:
				System.out.println("incorrect input");
				break;
			}
			
			System.out.print("\nChoose an action from the menu:\n1. Load a knowledge base from a file\n2. Add a new statement to the knowledeg base\n3. Search for an item in the knowledge base by term\n4. Search for a item in the knowledge base by term and sentence\n5. Quit\n6. Partial matches\nEnter your choice: ");
			menuAns= keyboard.nextInt();
		}
		
		
		keyboard.close();
		writeToFile(); //saving all this
		String feedback= JOptionPane.showInputDialog("Please type any feedback you may have in the box below");
		writeToFile(feedback); //feedback
		System.exit(0);
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
	
	public static void writeToFile()
	{
		PrintWriter pw= null;
		try 
		{
			pw = new PrintWriter(new FileOutputStream("UserDB.txt", true)); //creates new file if doesnt exist
			StringBuilder listItems = new StringBuilder();
			String result = mainTree.traverseInorder(mainTree.getRoot(), listItems);
			pw.print(result);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}
	


