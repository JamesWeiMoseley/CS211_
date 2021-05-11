package practice;

import java.util.Scanner;

public class practice {

	public static int roman(char c) {
		int x = 0;
		switch (c) {
		case 'I':
			x = 1;
			break;
		case 'V':
			x = 5;
			break;
		case 'X':
			x = 10;
			break;
		default:
			System.out.println("invalid");
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println("Enter your number: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		int length = input.length();
		int sum = roman(input.charAt(0));
		 
		if(length == 2) {
			if(roman(input.charAt(1))>sum) {
				sum = roman(input.charAt(1))-sum;
			} else {
				sum += roman(input.charAt(1));
			}
			
		} else {
			int i = 0; 
			sum = 0;
			while(i<length-1) {
				if(roman(input.charAt(i))>=roman(input.charAt(i+1))) {
					sum += roman(input.charAt(i));
					i++;
				}
			}
			if(i==length -1) {
				sum+=roman(input.charAt(i));
			}
		} 
		

		System.out.println(Math.abs(sum));
		scan.close();
	}
	
}