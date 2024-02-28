package Assignment1;

/*Node for the Binary tree
 * 
 * @author Inhle Cele & CSC2001F Jan Buys notes- Binary trees
 * @version 1.0
 * @since 25-02-2024 
*/
public class BSTNode <Generic>
{
	
	 private Generic data;
	 private BSTNode<Generic> left;
	 private BSTNode<Generic> right;

	 
	 public BSTNode(Generic d, BSTNode<Generic> l, BSTNode<Generic> r )
	 {
		 data = d;
		 left = l;
		 right = r;
	 }
	 
	 BSTNode<Generic> getLeft () { return left; }
	 BSTNode<Generic> getRight () { return right; }

}
