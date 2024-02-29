
/**Node for the Binary tree
 * 
 * @author Inhle Cele and CSC2001F notes- Binary trees (Prof. Jan Buys)
 * @version 1.0
 * @since 25-02-2024 
*/
public class BSTNode <T extends Generic>
{
	
	/**
	 * Object which stores the Term, Statement and Confidence score of an item in the Database
	 */
	 private Generic data;
	 /**
	  * left child of the current node
	  */
	 private BSTNode<Generic> leftChild;
	 /**
	  * righ child of the currentt node
	  */
	 private BSTNode<Generic> rightChild;

	 /**
	  * Constructor which creates a object of the BSTNode class that 
	  * has to be of type Generic and has no children/leaf nodes 
	  * 
	  * @param d Object which holds the term, statement and confidence score of the specified item
	  */
	 public BSTNode(Generic d)
	 {
		 data= d;
		 leftChild= null;
		 rightChild=null;
	 }
	 
	 /**
	  * Constructor which creates a object of the BSTNode class that 
	  * has to be of type Generic but has children/leaf nodes that are known 
	  * @param d Object which holds the term, statement and confidence score of the specified item
	  * @param l left child of object specified in d
	  * @param r right child of object specified in d
	  */
	 public BSTNode(Generic d, BSTNode<Generic> l, BSTNode<Generic> r )
	 {
		 data = d;
		 leftChild = l;
		 rightChild = r;
	 }
	 
	 /**
	  * Returns the data of the specified node as a Generic Object 
	  * which holds the term, statement and confidence score
	  * 
	  * @return Generic object of the node with the term, statement and confidence score
	  */
	 public Generic getData() {
		return data;
	}
	 
	 /**
	  * Compares the data in the BSTnode to other BSTNode object alphabetically
	  * @param compareNode the BTSNode object of type Generic being compared to data
	  * @return -1, 0 or 1 as this compareNode is alphabetically less than, equal to, or greater than the BSTNode.
	  */
	 public int compareTo(BSTNode<Generic> compareNode)
	 {
		 return (data.getTerm().compareToIgnoreCase(compareNode.data.getTerm()));

	 }

	 /**
	  * Compares the data in the BSTnode to a string/Term, alphabetically
	  * @param compareNode the String object being compared to data
	  * @return -1, 0 or 1 as this compareNode is alphabetically less than, equal to, or greater than the BSTNode.
	  */
	 public int compareTo(String compareNode)
	 {
		 return (data.getTerm().compareToIgnoreCase(compareNode)* -1); //we are checking the opposite side one

	 }
	 
	 /**
	  * Returns the left child of the Node
	  * @return left child of node
	  */
	 public BSTNode<Generic> getLeft () { return leftChild; }
	 
	 /**
	  * Returns the right child of the Node
	  * @return right child of node
	  */
	 public BSTNode<Generic> getRight () { return rightChild; }
	 
	 /**
	  * Sets the left child as type BSTNode of the current BSTNode
	  * @param leftChild the left child of the node
	  */
	 public void setLeftChild(BSTNode<Generic> leftChild) {
		this.leftChild = leftChild;
	}
	 
	 /**
	  * Sets the right child as type BSTNode of the current BSTNode
	  * @param rightChild the right child of the node
	  */
	 public void setRightChild(BSTNode<Generic> rightChild) {
		this.rightChild = rightChild;
	}
	 
	 /**
	  * Outputs the string of the Generic data type, use the toString() of the Generic class
	  * 
	  * @return the data in the format: Term\tSentence\tConfidence_score
	  */
	   @Override
		public String toString() {
			// TODO Auto-generated method stub
			return data.toString();
		}

}
