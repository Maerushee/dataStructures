package dataStructures;
import java.util.LinkedList;

public class QueueClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		QueueUsingLL queue = new QueueUsingLL();
		queue.enqueue(2);
		queue.enqueue(5);
		queue.enqueue(9);
		queue.display();
		queue.dequeue();
		queue.display();
		

	}

}
