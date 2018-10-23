package dataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	
	private class Node{

		int data;
		ArrayList<Node> children;
		
		Node(int data)
		{
			this.data = data;
			this.children = new ArrayList<>();
		}
	
	}
	
	Node root;
	int size = 0;
	
	public GenericTree() {
		// TODO Auto-generated constructor stub
		Scanner s = new Scanner(System.in);
		this.root = takeInput(s, null, 0);
		
	}
	
	public int size()
	{
		return this.size;
	}
	
	private Node takeInput(Scanner s, Node parent, int ithChild)
	{
		if(parent == null)
		{
			System.out.println("Enter data for root node: ");
		}
		
		else
		{
			System.out.println("Enter data for child " + ithChild + " of parent " + parent.data);
		}
		
		int data = s.nextInt();
		Node newNode = new Node(data);
		this.size++;
		System.out.println("Enter the number of children for " + data);
		int childCount = s.nextInt();
		for(int i = 0; i < childCount; i++)
		{
			Node child = takeInput(s, newNode, i);
			newNode.children.add(child);
		}
		
		return newNode;
	}
	
	public void display()
	{
		display(this.root);
	}
	
	private void display(Node node)
	{
		System.out.print(node.data + " => ");
		for(Node n : node.children)
		{
			System.out.print(n.data + ", ");
		}
		
		System.out.println("END");
		for(Node n : node.children)
		{
			display(n);
		}
	}
	
	public int size2()
	{
		return this.size2(this.root);
	}
	
	private int size2(Node node)
	{
		int count = 0;
		for(Node n : node.children)
		{
			int childCount = this.size2(n);
			count = count + childCount;
		}
		
		count = count + 1;
		
		return count;
	}
	
	public int max()
	{
		return this.max(this.root);
	}
	
	private int max(Node node)
	{
		int maxele = node.data;
		for(Node n : node.children)
		{  int maxChild = max(n);
		   if(maxChild > maxele)
		   {
			   maxele = maxChild;
		   }
		}
		
		return maxele;
	}
	
	public int height()
	{
		return this.height(this.root);
	}
	
	private int height(Node node)
	{
		int height = -1;
		for(Node n : node.children)
		{
			int childHeight = this.height(n);
			if(childHeight > height)
			{
				height = childHeight;
			}
		}
		
		height = height + 1;
		
		return height;
	}
	
	public boolean find(int element)
	{
		return this.find(this.root, element);
	}
	
	private boolean find(Node node, int element)
	{
		if(node.data == element)
		{
			return true;
		}
		
		for(Node n : node.children)
		{
			boolean isFoundinChild = find(n, element);
			
			if(isFoundinChild)
			{
				return true;
			}
		}
		
		return false;
	}
	

}
