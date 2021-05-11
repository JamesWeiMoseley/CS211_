package queuedemo;

public class ArrayQueue<Item> implements queueInterface<Item> {
	
	private Item[] array;
	private int front;
	private int rear;
	private int count;
	
	public ArrayQueue(int capacity) {
		array = (Item[]) new Object[capacity];
		front = 0; 
		rear = array.length -1;
		count = 0;
		
		
	}
	
	public void enqueueu(Item item) {
		if(!isFull()) {
			rear = (rear + 1) % array.length;
			array[rear] = item;
		}
	}
	
	public void dequeue() {
		if(!isEmpty())
			front = (front + 1) % array.length;
		
	}
	
	public Item front() {
		if(!isEmpty())
			return array[front];
		return null;
	}
	
}
