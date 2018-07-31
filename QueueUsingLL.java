package dataStructures;

public class QueueUsingLL {

	private LinkedList list;
	
	public QueueUsingLL()
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
	
	public void enqueue(int data)
	{
		this.list.addLast(data);
	}
	
	public int dequeue() throws Exception
	{
		int dequeuedElement = this.list.getFirst();
		this.list.removeFirst();
		return dequeuedElement;
		
	}
	
	public void display() throws Exception
	{
		this.list.display();
	}
}
