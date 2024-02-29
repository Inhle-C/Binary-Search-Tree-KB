
/**
 * Node for the Binary tree
 * 
 * @author Inhle Cele & CSC2001F Jan Buys notes- Binary trees
 * @version 1.0
 * @since 25-02-2024 
*/

public class BinarySearchTreeKB 
{
	BSTNode root = null;
	
	public void addNode(Generic data) 
	{
		BSTNode<Generic> newNode= new BSTNode<Generic>(data);
		
		if (root== null)
		{
			root=newNode;
		}
		else
		{
			BSTNode focus= root;
			BSTNode parent;
			
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
	
	public void traverseInorder(BSTNode<Generic> focus) //check for myself to make sure code is working
	{
		if (focus!= null)
		{
			traverseInorder(focus.getLeft());
			System.out.println(focus.toString());
			traverseInorder(focus.getRight());
		}
	}
	
	public BSTNode<Generic> search(String focus) 
	{
		
		if (root==null)
			return null;
		else 
			return search(focus, root);
	}
	
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
	
	public BSTNode<Generic> search(String focusT, String focuSen) 
	{
		
		if (root==null)
			return null;
		else 
			return search(focusT,focuSen, root);
	}
	
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
}
