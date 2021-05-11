package arraylistdemo;

import java.util.Iterator;

public class myArrayList implements listInterface, Iterable {

			//define the state of arraylist
		private int[] data;
		private int capacity = 10;		//total size of array
		private int count;		//num of items in list
	
		
	
	public myArrayList() {
		capacity = 10;		//default capacity for array
		count = 0;
		data = new int[capacity];
	}

	@Override
	public void add(int item) {
		resize();
		data[count] = item;
		count++;
		
	}
	
	public void resize() {
		if(count == capacity) {
			capacity *= 2;
			int[]temp = new int [capacity];
			for(int i = 0; i<count; i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
	}

	@Override
	public void add(int index, int item) {
		for(int i = count; i>index; i--) {
			data[i] = data[i-1];
		}
		
		data[index] = item;
		count++;
		
	}
	
	public void remove(int index) {
		if(index < 0 || index >= count)
			throw new ArrayIndexOutOfBoundsException();
		
		for(int i = index; i < count-1; i++) {
			data[i] = data[i+1];
		}
		count--;
	}

	@Override
	public int get(int index) {
		if(index < 0 || index >= count)
			throw new ArrayIndexOutOfBoundsException();
		
		return data[index];
		
	}

	@Override
	public int indexOf(int item) {
		for(int i = 0; i<count; i++) {
			if(data[i]== item) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int getCapacity() {
		return capacity;
	}
	

	@Override
	public Iterator iterator() {
		
		return new MyListIterator();
	}
	
	private class MyListIterator implements Iterator {
		
		private int cursor = -1;

		@Override
		public boolean hasNext() {
			return cursor!=count-1;
		}

		@Override
		public Object next() {
			return data[++cursor];
		}
		
		
		
	}
	
	

}
