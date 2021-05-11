package earthquake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EarthManager {

	private String file;
	private ArrayList list;

	public ArrayList getList() { // getter for arraylist
		return list;
	}

	public EarthManager(String file) { // constructors for file and arraylist
		this.file = file;
		list = new ArrayList();

		load();
	}

	public void load() {
		File input = new File(file);
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(input);

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine(); // each line is called line

				StringTokenizer tokenizer = new StringTokenizer(line, ","); // separating everything by columns
				while (tokenizer.hasMoreTokens()) {
					String name = tokenizer.nextToken(); // first token, the date and time, is called name
					double depth = Double.parseDouble(tokenizer.nextToken());
					double magnitude = Double.parseDouble(tokenizer.nextToken());
					String address = tokenizer.nextToken();
					String state = tokenizer.nextToken();

					Earthquake earthquake = new Earthquake(); // earthquake object for setting

					StringTokenizer dateTokenizer = new StringTokenizer(name, "T"); // breaking down the date
					String date = dateTokenizer.nextToken();

					StringTokenizer dayTokenizer = new StringTokenizer(date, "-"); // breaking down date to year month
																					// day

					int year = Integer.parseInt(dayTokenizer.nextToken());
					int month = Integer.parseInt(dayTokenizer.nextToken());
					int day = Integer.parseInt(dayTokenizer.nextToken());

					String[] temp2; // taking away the quotations from state
					String delimiter2 = "\"";
					temp2 = state.split(delimiter2);
					String state2 = temp2[0].substring(1); // getting rid of spaces

					earthquake.setDate(date); // setting all the variables to object
					earthquake.setMagnitude(magnitude);
					earthquake.setState(state2);
					earthquake.setYear(year);
					earthquake.setMonth(month);
					earthquake.setDay(day);
					earthquake.setNames(name);

					list.add(earthquake); // adding object to the arraylist

				}
			}

		}

		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

}
