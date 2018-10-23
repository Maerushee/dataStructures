package dataStructures;

public class TreeClient {
	
	public static void main(String[] args)
	{
		GenericTree tree = new GenericTree();
		tree.display();
		System.out.println(tree.size2());
		System.out.println(tree.max());
		System.out.println(tree.height());
		System.out.println(tree.find(10));
		
	}

}
