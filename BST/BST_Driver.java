/*************************************************************
 * Nicholas B
 * 11/5/18
 * This class works on creating abstract Tree Nodes
 *************************************************************/
public class BST_Driver {

	public static void main(String[] args) 
	{
		
		BST<String> list = new BST<String>();
		BST<Student> list2 = new BST<Student>(); //This won't work w/o a custom compareTo
		list.add("Terry");
		list.add("Darryl");
		list.add("Ian");
		list.add("Andrew");
		list.add("Donald");
		list.inOrderTraversal();
		System.out.println();
		System.out.println(list + " Memory Address of List");
		System.out.println(list.findNode("Cat"));
		System.out.println("\n *************IN ORDER******************");
		list.inOrderTraversal();
		System.out.println("\n *************POST ORDER******************");
		list.postOrderTraversal();
		System.out.println("\n **************PRE ORDER*****************");
		list.preOrderTraversal();
		
		BST<String>BSTLoremIpsum = new BST<String>();
		String M = "LoremIpsum";
		for(int i = 0; i < M.length(); i++)
		{
			BSTLoremIpsum.add(M.charAt(i)+"");
		}
		BSTLoremIpsum.inOrderTraversal(); //Calls method to traverse through the Binary Tree with In Order Traversal
		System.out.println("\n *******************************");
		BSTLoremIpsum.postOrderTraversal(); //Calls method to traverse through the Binary Tree with Post Order Traversal
		System.out.println("\n *******************************");
		BSTLoremIpsum.preOrderTraversal(); //Calls method to traverse through the Binary Tree with Pre Order Traversal
		System.out.println("\n");
		
		
		for(int i = 0; i < M.length(); i++)
		{ //Goes through and starts deleting nodes at specific points in the list
			System.out.println("Deleting " + M.charAt(i));
			BSTLoremIpsum.deleteNode(M.charAt(i) + "");
			BSTLoremIpsum.inOrderTraversal();
			System.out.println();
		}
		
	}

}
