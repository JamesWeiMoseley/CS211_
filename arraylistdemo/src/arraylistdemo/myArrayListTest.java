package arraylistdemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class myArrayListTest {

	@Test
	void testAddValidIndex() {
		myArrayList list = new myArrayList();
		list.add(10);
		int expected = 10;
		int actual = list.get(0);
		
		assertEquals(expected, actual);
	}

}
