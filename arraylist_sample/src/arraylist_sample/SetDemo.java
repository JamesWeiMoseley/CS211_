package arraylist_sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class SetDemo {

	public static void main (String[]a) throws FileNotFoundException {
		File file1 = new File("A.txt");
		File file2 = new File("B.txt");
		HashSet<String> s1 = new HashSet<String>();
		HashSet<String> s2 = new HashSet<String>();
		
		//read from file 1 and store the names in set 1
		Scanner file1Scanner = new Scanner(file1);
		while(file1Scanner.hasNextLine()) {
			String name = file1Scanner.nextLine();
			s1.add(name);
		}
		
		//read from file 2 and store the names in set 2
				Scanner file2Scanner = new Scanner(file1);
				while(file2Scanner.hasNextLine()) {
					String name = file2Scanner.nextLine();
					s2.add(name);
				}
				s1.retainAll(s2);
	}
}
