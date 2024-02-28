
/*Node for the Binary tree
 * 
 * @author Inhle Cele & CSC2001F Jan Buys notes- Binary trees
 * @version 1.0
 * @since 25-02-2024 
*/
public class BSTNode <T extends Generic>
{
	
	 private Generic data;
	 private BSTNode<Generic> leftChild;
	 private BSTNode<Generic> rightChild;

	 
	 public BSTNode(Generic d)
	 {
		 data= d;
	 }
	 public BSTNode(Generic d, BSTNode<Generic> l, BSTNode<Generic> r )
	 {
		 data = d;
		 leftChild = l;
		 rightChild = r;
	 }
	 
	 public Generic getData() {
		return data;
	}
	 
	 public int compareTo(BSTNode<Generic> compareNode)
	 {
		 return (data.getTerm().compareToIgnoreCase(compareNode.data.getTerm()));

	 }

	 public int compareTo(String compareNode)
	 {
		 return (data.getTerm().compareToIgnoreCase(compareNode)* -1); //we are checking the opposite side one

	 }
	 
	 public BSTNode<Generic> getLeft () { return leftChild; }
	 public BSTNode<Generic> getRight () { return rightChild; }
	 public void setLeftChild(BSTNode<Generic> leftChild) {
		this.leftChild = leftChild;
	}
	 public void setRightChild(BSTNode<Generic> rightChild) {
		this.rightChild = rightChild;
	}
	 
	 @Override
		public String toString() {
			// TODO Auto-generated method stub
			return data.toString();
		}

}
