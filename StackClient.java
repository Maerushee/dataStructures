package dataStructures;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StackUsingLL stack = new StackUsingLL();
		System.out.println(stack.isEmpty());
		stack.push(5);
		stack.push(6);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(0);
		stack.display();
		System.out.println(stack.size());
		System.out.println(stack.pop());
		stack.pop();
		stack.display();
		

	}

}
