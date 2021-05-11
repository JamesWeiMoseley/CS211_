package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkTest {

	@Test
	void test() {
		LinkedList list = new LinkedList();
		list.add(4);
		list.add(10);
		int expected = 2;
		int actual = list.getSize();
		assertEquals(expected, actual);
	}

}
