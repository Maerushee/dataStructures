package dataStructures;

public class LinkedList {

	private class Node {
		int data;
		Node next;

		private Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	private LinkedList(Node head, Node tail, int size)
	{
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void addFirst(int data) {
		if (this.isEmpty()) {
			Node newNode = new Node(data, null);
			this.head = newNode;
			this.tail = this.head;
		}

		else {
			Node newNode = new Node(data, this.head);
			this.head = newNode;
		}

		this.size++;
	}

	public void addLast(int data) {
		if (this.isEmpty()) {
			Node newNode = new Node(data, null);
			this.tail = newNode;
			this.head = this.tail;
		}

		else {
			Node newNode = new Node(data, null);
			this.tail.next = newNode;
			this.tail = newNode;
		}

		this.size++;

	}

	private Node getNodeAt(int index) throws Exception {
		if (index < 0 || index >= this.size()) {
			throw new Exception("Invalid Index");
		}

		int counter = 0;
		Node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}

		return temp;
	}

	public void addAt(int data, int index) throws Exception {
		if (index < 0 || index > this.size()) {
			throw new Exception("Invalid Index");
		}

		if (index == 0) {
			this.addFirst(data);
		}

		if (index == this.size()) {
			this.addLast(data);
		}

		else {
			Node prev = getNodeAt(index - 1);
			
			Node newNode = new Node(data, prev.next);
			prev.next = newNode;
			this.size++;
		}

	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty. Add some Elements first.");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty. Add some Elements first.");
		}

		return this.tail.data;
	}

	public int getAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty. Add some Elements first.");
		}

		if (index < 0 || index >= this.size()) {
			throw new Exception("Invalid index");
		}

		return this.getNodeAt(index).data;

	}

	public void display() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty, Can't display");
		}

		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}

		System.out.println("END");
	}

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		}

		else {
			this.head = this.head.next;
		}

		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		}

		else {
			this.tail = this.getNodeAt(this.size() - 2);
			this.tail.next = null;
		}

		this.size--;

	}

	public void removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty. Add some Elements first.");
		}

		if (index < 0 || index >= this.size()) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			this.removeFirst();
		}

		if (index == this.size - 1) {
			this.removeLast();
		}

		else {
			Node temp = this.getNodeAt(index - 1);
			temp.next = temp.next.next;
			this.size--;
		}

	}
	
	public void reverseDI() throws Exception
	{
		int li = 0, ri = this.size - 1;
		while(li <= ri)
		{
			Node left = this.getNodeAt(li);
			Node right = this.getNodeAt(ri);
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			li++;
			ri--;
		}
	}
	
	public void reversePI()
	{
		Node prev = this.head; 
		Node curr = prev.next;
		while(curr != null)
		{
			Node tempPrev = prev;
			Node tempCurr = curr;
			prev = curr;
			curr = curr.next;
			tempCurr.next = tempPrev;
		}
		
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}
	
	public void reversePR() 
	{ reversePR(this.head);
	  Node temp = this.tail;
	  this.tail = this.head;
	  this.head = temp;
	  this.tail.next = null;
	  
		
	}
	
	private void reversePR(Node node)
	{  if(node == this.tail) return;
	   
	   reversePR(node.next);
	   node.next.next = node;
		
	}
	
	public void reverseDR()
	{
		HeapMover obj = new HeapMover(this.head);
		reverseDR(obj, this.head, 0);
	}
	
	private void reverseDR(HeapMover left, Node right, int level)
	{   if(right == null)
	   {
		return;
	   }
	
	   reverseDR(left, right.next, level + 1);
	   if(level >= this.size / 2)
	   {
		   int temp = left.node.data;
		   left.node.data = right.data;
		   right.data = temp;
		   left.node = left.node.next;
	   }
		
	}
	
	private class HeapMover
	{
		Node node;
		
		HeapMover(Node node)
		{
			this.node = node;
		}
	}
	
	public int midNode()
	{
		return this.getMidNode().data;
	}
	
	private Node getMidNode()
	{   Node present = this.head;
	    Node future = this.head;
	    
	    while(future.next != null && future.next.next != null)
	    {
	    	present = present.next;
	    	future = future.next.next;
	    }
	    
	    return present;
		
	}
	
	public int KthNodeFromEnd(int k) throws Exception
	{
		if(k <= 0 || k > this.size)
		{
			throw new Exception("Invalid Index");
		}
		
		Node reqd = this.head;
		Node skip = this.head;
		
		for(int i = 0; i < k; i++)
		{
			skip = skip.next;
		}
		
		while(skip != null)
		{
			reqd = reqd.next;
			skip = skip.next;
		}
		
		return reqd.data;
	}
	
	public LinkedList merge(LinkedList second)
	{
		Node firstPtr = this.head;
		Node secondPtr = second.head;
		LinkedList merged = new LinkedList();
		
		while(firstPtr != null && secondPtr != null)
		{
			if(firstPtr.data < secondPtr.data)
			{
				merged.addLast(firstPtr.data);
				firstPtr = firstPtr.next;
			}
			
			else
			{
				merged.addLast(secondPtr.data);
				secondPtr = secondPtr.next;
			}
		}
		
		while(firstPtr != null)
		{
			merged.addLast(firstPtr.data);
			firstPtr = firstPtr.next;
		}
		
		while(secondPtr != null)
		{
			merged.addLast(secondPtr.data);
			secondPtr = secondPtr.next;
		}
		return merged;
	}
	
	public void mergeSort()
	{
		LinkedList sorted = this.mergeSortHelper(this.head, this.tail);
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;
	}
	
	private LinkedList mergeSortHelper(Node head, Node tail)
	{
		if(this.size() == 1)
		{
			return this;
		}
		
		Node midNode = this.getMidNode();
		Node midNext = midNode.next;
		midNode.next = null;
		
		LinkedList firstPart = new LinkedList(this.head, midNode, (this.size() + 1) / 2);
		LinkedList secondPart = new LinkedList(midNext, this.tail, this.size() / 2);
		
		firstPart.mergeSort();
		secondPart.mergeSort();
		
		return firstPart.merge(secondPart);
	}

}
