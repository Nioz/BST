/*************************************************************
 * Nicholas B
 * 11/5/18
 * This class works on creating abstract Tree Nodes
 *************************************************************/
import java.util.*;

public class BST <Type extends Comparable<Type>>
{
	private TreeNode<Type> root;
	
	//Begin constructors
	public BST()
	{//Default
		root = null;
	}
	
	public BST(Type obj)
	{
		root = new TreeNode<Type>(obj);
	}
	//END constructors
	
	public void add(Type obj)
	{
		TreeNode<Type> newNode = new TreeNode<Type>(obj);
		if(root == null)
			root = newNode;
		else
			addNode(root, newNode); // This gets sent to private void addNode (root gets sent then gets changed in addNode)
	}
	
	private void addNode(TreeNode<Type> current, TreeNode<Type> newNode)
	{	System.out.println(current.getValue());
		System.out.println(newNode.getValue());
		if(newNode.getValue().compareTo(current.getValue()) <= 0) //Activated if going to the left
		{
			if(current.getLeft() == null)
				current.setLeft(newNode);
			else
			{//This searches for a spot
			current = current.getLeft(); 
			addNode(current, newNode);
			}
		}
		else
		{
			if(current.getRight() == null)
				current.setRight(newNode);		//		current = current.getRight();
			else
			{
				current = current.getRight();
				addNode(current, newNode);
			}	
		}
	}
	
	//Start Delete
	public void deleteNode(Type obj)
	{
		TreeNode<Type> child = root;
		TreeNode<Type> parent = root;
		TreeNode<Type> nodeDeleted = new TreeNode<Type>(obj);
		deleteNodeHelperA(child, parent, nodeDeleted);
	}
	
	public void deleteNodeHelperA(TreeNode<Type> child, TreeNode<Type> parent, TreeNode<Type> deleteNode)
	{
		if(child == null)
			System.out.println("Does not exist...");
		else if(deleteNode.getValue().compareTo(child.getValue()) < 0)
		{
			parent = child;
			child = child.getLeft();
			deleteNodeHelperA(child, parent, deleteNode);
		}
		else if(deleteNode.getValue().compareTo(child.getValue()) > 0)
		{
			parent = child;
			child = child.getRight();
			deleteNodeHelperA(child, parent, deleteNode);
		}
		else
			deleteNodeHelperB(child, parent);
	} // End deleteNodeHelper
	
	public void deleteNodeHelperB(TreeNode<Type> child, TreeNode<Type> parent)
	{
		TreeNode<Type> succ = child;
		TreeNode<Type> pred = child;
		
		if(child.getLeft() != null)
		{
			pred = succ = child.getLeft();
			while(succ.getRight() != null)
			{
				pred = succ;
				succ = succ.getRight();
			}
			if(pred != succ)
			{
				pred.setRight(succ.getLeft());
				succ.setLeft(child.getLeft());
				succ.setRight(child.getRight());
			}
			else
				succ.setRight(child.getRight());
			
			if(parent.getRight() == child)
				parent.setRight(succ);
			else
				parent.setLeft(succ);
			if(parent == child)
				root = succ;
		}
		else
			parent.setRight(child.getRight());
	}
	
	//Start In Order Traversal (LVR)
	public void inOrderTraversal()
	{
		if(root != null)
			inorderTraversalHelper(root);
		else
			System.out.println("Tree is empty ");
	}
	
	private void inorderTraversalHelper(TreeNode<Type> current)
	{
		if (current != null)
		{
			inorderTraversalHelper(current.getLeft()); //L
			System.out.print(current.getValue()+" ");	   //V
			inorderTraversalHelper(current.getRight());//R
		}
	}
	//END In Order Traversal

	public void postOrderTraversal()
	{
		if(root != null)
			postOrderTraversalHelper(root);
		else
			System.out.println("Tree is empty ");
	}
	
	private void postOrderTraversalHelper(TreeNode<Type> current)
	{
		if (current != null)
		{
			postOrderTraversalHelper(current.getLeft()); //L
			postOrderTraversalHelper(current.getRight());//R
			System.out.print(current.getValue()+" ");	 //V
		}
	}
	
	public void preOrderTraversal()
	{
		if(root != null)
			preOrderTraversalHelper(root);
		else
			System.out.println("Tree is empty ");
	}
	
	private void preOrderTraversalHelper(TreeNode<Type> current)
	{
		if (current != null)
		{
			System.out.print(current.getValue()+" ");	  //V
			preOrderTraversalHelper(current.getLeft());   //L
			preOrderTraversalHelper(current.getRight());  //R
		}
	}
	
	
	public boolean findNode(Type obj)
	{
		if(root == null)
			return false;
		else
		{
			TreeNode<Type> newNode = new TreeNode<Type>(obj);
			return findNodeHelper(root, newNode);
		}
	}
	
	private boolean findNodeHelper(TreeNode<Type> current, TreeNode<Type> newNode)
	{
		if(current == null)
			return false;
		else if(newNode.getValue().equals(current.getValue()))
			return true;
		else if(newNode.getValue().compareTo(current.getValue()) <= 0)
		{
			return findNodeHelper(current.getLeft(), newNode);
		} 
		else
			return findNodeHelper(current.getRight(), newNode);
	}
	
	
}
