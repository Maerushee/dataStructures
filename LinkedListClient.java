package dataStructures;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.addFirst(2);
		list.addLast(3);
		list.addFirst(5);
		list.addAt(4, 1);
		list.addLast(6);
		list.addLast(7);
		list.addLast(9);
		list.addLast(8);
		list.addLast(10);
		
		list.display();
		list.removeFirst();
		list.display();
		list.removeAt(1);
		list.display();
		list.removeAt(2);
		list.display();
		list.removeAt(5);
		list.display();

	}

}
