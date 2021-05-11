package LinkedList;


public interface ListInterface<Item> {
	
	public void add(Item item); //adds an item to the list
	public void add(int index, Item item); //adds an item to given index
	public void remove(int index);	//remove item at the given index
	public Item get(int index);	//returns the items at the given index
	public int indexOf(Item item);	//returns the index of the item
	public int size();
	public boolean isEmpty();

}

	
