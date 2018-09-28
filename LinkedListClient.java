package dataStructures;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
//		LinkedList list2 = new LinkedList();
//		LinkedList merged = new LinkedList();
//		list.addLast(2);
//		list.addLast(3);
//		list.addLast(4);
//		list.addLast(5);
//		list.addLast(6);
//		
//		list2.addLast(6);
//		list2.addLast(7);
//		list2.addLast(8);
//		list2.addLast(9);
//		list2.addLast(10);
//		
//		merged = list.merge(list2);
//		merged.display();
		list.addFirst(2);
		list.addLast(3);
		list.addFirst(5);
		list.addAt(4, 1);
		list.addLast(6);
		list.addLast(7);
		list.addLast(9);
		list.addLast(8);
		list.addLast(10);
		list.addLast(11);
		list.display();
		list.mergeSort();
		list.display();
		/*list.removeFirst();
		list.display();
		list.removeAt(1);
		list.display();
		list.removeAt(2);
		list.display();
		list.removeAt(5);
		list.display();*/
		

//		System.out.println("2nd Node from end: " + list.KthNodeFromEnd(2));

	}

}
