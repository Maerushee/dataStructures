package dataStructures;

public class StackUsingLL {

	private LinkedList list;
	public StackUsingLL()
	{
		list = new LinkedList();
	}
	
	public int size()
	{
		return this.list.size();
	}
	
	public boolean isEmpty()
	{
		return this.list.isEmpty();
	}
	
	public void push(int data)
	{
		this.list.addFirst(data);
	}
	
	public int pop() throws Exception
	{
		int poppedElement = this.list.getFirst();
		this.list.removeFirst();
		return poppedElement;
		
	}
	
	public void display() throws Exception
	{
		this.list.display();
	}
}
