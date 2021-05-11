package arraylist_sample;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class tokenizerExample {
	
	public static void main (String[]a) {
		File file = new File("reader.txt");
		ArrayList<Integer> ages = new ArrayList<Integer>();
		//students.add();
		
		try {
			Scanner fileScanner = new Scanner(file);
			
			while(fileScanner.hasNextLine()) {
				//read the Line
				//String name = fileScanner.next();
				//String ageStr = fileScanner.nextLine();
				//StringTokenizer tokenizer = new StringTokenizer(line, ",");
				//String name = tokenizer.nextToken();
				
				//int grade = Integer.parseInt(tokenizer.nextToken());
				//students s = new students(name, grade);
				//students.add(s);
				
				String line = fileScanner.nextLine();
				Scanner strScanner = new Scanner(line);
			String name = strScanner.next();
				String ageStr = strScanner.next();
				int age = Integer.parseInt(ageStr);
				ages.add(age);
				
				
				
			}
		}
			catch (FileNotFoundException e) {
				System.out.println("found not found stupid");
			}
		
		System.out.println(ages);
	}
	

}
