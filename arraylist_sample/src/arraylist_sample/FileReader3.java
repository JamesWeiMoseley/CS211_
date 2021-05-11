package arraylist_sample;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReader3 {
	
		public static void main (String [] a) {
			File file = new File ("input.txt");
			ArrayList<String> words = new ArrayList<String>();
			try {
				Scanner fileScanner = new Scanner(file);
				while(fileScanner.hasNextLine()) {
				String word = fileScanner.nextLine();
				words.add(word);
				}
			} catch (FileNotFoundException e) {
				
				System.out.println("not found");
			}
			System.out.println(words);
		}

		
}
