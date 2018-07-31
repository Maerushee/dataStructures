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

}
