import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenize

public class LinkedList<Item> implements StackInterface<Item> {

	public static void main(String[] a) {
		LinkedList<Integer> stack = new LinkedList<Integer>(0);

		// stack.getNumbers();
		String input = ("<< 2 6 << + << * ");
		int now = 0;
		String[] instruct = input.split(" ");

		for (int i = 0; i < instruct.length; i++) {
			try {
				String current = instruct[i];
				if (current.equals("+")) {
					int b = stack.top();
					stack.pop();
					int c = stack.top();
					stack.pop();
					int sum = c + b;
					stack.push(sum);
				} else if (current.equals("-")) {
					int b = stack.top();
					stack.pop();
					int c = stack.top();
					stack.pop();
					int sum = b - c;
					stack.push(sum);
				} else if (current.equals("/")) {
					int b = stack.top();
					stack.pop();
					int c = stack.top();
					stack.pop();
					int sum = b / c;
					stack.push(sum);
				} else if (current.equals("*")) {
					int b = stack.top();
					stack.pop();
					int c = stack.top();
					stack.pop();
					int sum = b * c;
					stack.push(sum);
				} else if (current.equals("%")) {
					int b = stack.top();
					stack.pop();
					int c = stack.top();
					stack.pop();
					int sum = b % c;
					stack.push(sum);
				} else if (current.equals("<<")) {
					stack.print();
					System.out.println("");
				} else if (current.equals("^")) {
					System.out.println(stack.top());
					stack.pop();
				} else if (current.equals("\\")) {
					stack.pop();
					System.out.println(stack);
					break;
				} else { // if just an integer
					stack.push(Integer.parseInt(current));
				}

			} catch (NumberFormatException e) {
				System.out.println("invalid input");
				stack.pop();
			}
		}

		System.out.println("Result: " + stack.top());

//	
	}

	private LinkedList<Item> list = new LinkedList<Item>();
	static String input = "";

	public LinkedList(int capacity) {

	}

//	public String getNumbers() {
//		String num = "";
//
//		System.out.println("Enter numbers and add \\ to the end ");
//		Scanner scan = new Scanner(System.in);
//	
//		num = scan.nextLine();
//		System.out.println("You entered: " + num);
//		input += num;
//		
//
//		return input;
//	}

	public void push(Item item) {
		if (!isFull()) {
			list.push(item);
		}

	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public void print() {
		System.out.print("<");
		for (Item n : list) {
			System.out.print(n + ", ");
		}
		System.out.print(">");
	}

	@Override
	public void pop() {
		if (!isEmpty()) {
			list.pop();
		}

	}

	@Override
	public Item top() {
		if (!isEmpty()) {
			return list.peek();
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isFull() {
		return false;
	}

}

	