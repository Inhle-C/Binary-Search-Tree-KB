
/**
 * Class to create and store Binary Search trees
 * 
 * @author Inhle Cele ;CSC2001F Jan Buys notes- Binary trees
 * @version 1.0
 * @since 25-02-2024 
*/
public class BinarySearchTreeKB 
{
	/**
	 * the root/beggining node of the tree
	 */
	private BSTNode<Generic> root = null;
	
	/**
	 * adds a node to the binary search tree in the specified order its meant to be in
	 * @param data Node we want to add to the database/tree
	 */
	public void addNode(Generic data) 
	{
		BSTNode<Generic> newNode= new BSTNode<Generic>(data);
		
		if (getRoot()== null)
		{
			setRoot(newNode);
		}
		else
		{
			BSTNode<Generic> focus= getRoot();
			BSTNode<Generic> parent;
			
			while(focus!=null) 
			{	
				parent= focus;
				if (newNode.compareTo(focus)<0) 
				{
					focus= focus.getLeft();
					if (focus == null)
					{
						parent.setLeftChild(newNode);
					}
				}
				else
				{
					focus= focus.getRight();
					if (focus == null)
					{
						parent.setRightChild(newNode);
					}		
				}
			}
				
		}
	}
	
	/**
	 * Gives the nodes of the tree in alphabetical order aka from lowest to highest
	 * @param focus Node we are starting the traverse at - usually gonna be root
	 */
	public String traverseInorder(BSTNode<Generic> focus, StringBuilder listItems) //check for myself to make sure code is working
	{
		if (focus!= null)
		{
			traverseInorder(focus.getLeft(), listItems);
			listItems.append(focus.toString()).append("\n");
			traverseInorder(focus.getRight(), listItems);
		}
		
		return listItems.toString().trim(); // Trim removes trailing newline if present
	}
	
	/**
	 * Searches for a specific term to see if it exists in the tree from just the term alone
	 * @author CSC2001 notes (Jan Buys)
	 * @param focus The term of the node we are looking for
	 * @return the node if found, null if nothing is found
	 */
	public BSTNode<Generic> search(String focus) 
	{
		
		if (getRoot()==null)
			return null;
		else 
			return search(focus, getRoot());
	}
	
	/**
	 * Used in the search(String focus) and is used to compare the term of the node to the string
	 * 
	 * @author CSC2001 notes (Jan Buys)
	 * @param focus The term we are looking for
	 * @param node the node we are comparing to the term to see if its equal
	 * @return the node if found, null if nothing is found
	 */
	public BSTNode<Generic> search(String focus, BSTNode<Generic> node) 
	{
		int cmp= node.compareTo(focus);
		if (cmp == 0)
			return node;
		else if (cmp<0)
			return (node.getLeft()== null) ? null : search(focus, node.getLeft());
		else
			return (node.getRight() == null) ? null : search (focus, node.getRight());

	}
	
	/**
	 * Searches for a specific term and statement to see if it exists in the tree from just the Strings alone
	 * 
	 * @author CSC2001 notes (Jan Buys)
	 * @param focusT The term we are looking for
	 * @param focuSen The statement we are looking for
	 * @return the node if found, null if nothing is found
	 */
	public BSTNode<Generic> search(String focusT, String focuSen) 
	{
		
		if (getRoot()==null)
			return null;
		else 
			return search(focusT,focuSen, getRoot());
	}
	/**
	 * Used in the search(String focusT, foucSen) and is used to compare the term and sentence of the node to the Strings
	 * 
	 * @author CSC2001 notes (Jan Buys)
	 * @param focus The term we are looking for
	 * @param sentence The sentence we are looking for
	 * @param node The node we are comparing
	 * @return the node if found, null if nothing is found
	 */
	public BSTNode<Generic> search(String focus,String sentence,BSTNode<Generic> node) 
	{
		int cmp1= node.compareTo(focus);
		int cmp2= sentence.compareToIgnoreCase(node.getData().getSentence());
		if (cmp1 == 0 && cmp2==0)
			return node;
		else if (cmp1<0)
			return (node.getLeft()== null) ? null : search(focus,sentence, node.getLeft());
		else
			return (node.getRight() == null) ? null : search (focus, sentence,node.getRight());

	}

	public BSTNode<Generic> getRoot() {
		return root;
	}

	public void setRoot(BSTNode<Generic> root) {
		this.root = root;
	}
}
