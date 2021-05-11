package earthquake;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EarthApplicator {

	public static void main(String[] a) throws FileNotFoundException {
		ArrayList<Earthquake> earth = new ArrayList(); // object for input
		ArrayList<Earthquake> matches = new ArrayList(); // object for output

		EarthManager e = new EarthManager("earthquake.csv"); // reading the file

		while (true) { // setting up the while loop for the last yes no questions

			System.out.println("===========Earthquake Search Application===========");
			System.out.println("===================================================");
			Scanner scan = new Scanner(System.in);
			System.out.print("Date [yyyy-mm-dd][from]:"); // starting the console in questions
			String fromDate = scan.next();

			StringTokenizer tokenizer = new StringTokenizer(fromDate, "-");
			int year = Integer.parseInt(tokenizer.nextToken()); // separating year month date
			int month = Integer.parseInt(tokenizer.nextToken());
			int day = Integer.parseInt(tokenizer.nextToken());

			System.out.print("Date [yyyy-mm-dd][to]:"); // to dates
			String toDate = scan.next();

			StringTokenizer tokenizer2 = new StringTokenizer(toDate, "-"); // separating year month date
			int toYear = Integer.parseInt(tokenizer2.nextToken());
			int toMonth = Integer.parseInt(tokenizer2.nextToken());
			int toDay = Integer.parseInt(tokenizer2.nextToken());

			System.out.print("State:"); // asking for state
			String state = scan.next();

			System.out.print("Magnitude [min]:");
			Double mag = Double.parseDouble(scan.next());

			PrintWriter out = new PrintWriter(new File("Earthquake_" + state + ".txt")); // printwriter object

			earth = e.getList(); // loading input onto object

			for (int i = 0; i < earth.size(); i++) {
				if (year < earth.get(i).getYear() || (year == earth.get(i).getYear() && month < earth.get(i).getMonth())
						|| (year == earth.get(i).getYear() && month == earth.get(i).getMonth() // from date condition
								&& day <= earth.get(i).getDay())) {

					if (toYear > earth.get(i).getYear() // toDate Condition
							|| (toYear == earth.get(i).getYear() && toMonth > earth.get(i).getMonth())
							|| (toYear == earth.get(i).getYear() && toMonth == earth.get(i).getMonth()
									&& toDay >= earth.get(i).getDay())) {

						if (state.equals(earth.get(i).getState())) { // matching the states

							if (mag < earth.get(i).getMagnitude()) { // minimum magnitude

								matches.add(earth.get(i)); // loading qualifying data onto matches list

							}
						}
					}
				}

			}

			for (int i = 0; i < matches.size(); i++) { // printing all matching data
				System.out.println(matches.get(i));
				out.println(matches.get(i)); // printing to txt file

			}

			out.println("---------------------------------------"); // printing lines to txt file
			out.println("Results found: " + matches.size());
			out.flush();
			System.out.println("---------------------------------------");

			if (matches.size() > 0) { // end results found display
				System.out.println("Results found: " + matches.size());
			} else {
				System.out.println("No Results Found");
			}

			System.out.print("Do you want to continue (yes/no): "); // if yes to continue make another scanner
			Scanner again = new Scanner(System.in);
			String input = again.next();

			matches.clear(); // clear the marches arraylist otherwise it will display total searches

			if (input.equals("no")) { // last yes no question
				System.out.println("Thanks!\nBe Earthquake Prepared...");
				break;
				// stopping the loop

			}
		}

	}
}
