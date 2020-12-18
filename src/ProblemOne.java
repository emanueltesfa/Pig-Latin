import java.util.ArrayList;
import java.util.Scanner;

public class ProblemOne {

	public static String[] readText() {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		boolean exit = false;
		ArrayList<String> list = new ArrayList<>();
		String[] inputString = null;
		String startProgram = "";
		int i = 0;
		do {
			System.out.println("Enter any to start a program, -1 to end prompting or put 0 to end program");
			startProgram = scanner.nextLine();
			if (startProgram.equalsIgnoreCase("0")) {
				break;
			}
			System.out.println("Enter a string: ");
			while (!exit) {
				String input = scanner.nextLine();
				if (input.equalsIgnoreCase("-1")) {
					break;
				}
				if ((i % 2) == 0) {
					// System.out.println(This the case );
					input = removePunct(input);
					input = pigLatin(input);
					input = changeCase('1', input);
					i++;
				} else {
					input = changeCase('0', input);
					input = pigLatin(input);
					input = removePunct(input);
					i++;
				} if (!input.equalsIgnoreCase("-1")) {
					list.add(input);
				}

			}

			inputString = new String[list.size()];
			String[] array = list.toArray(inputString);
			System.out.println("*****Print all Strings****");
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[j]);
				System.out.println(" ");
			}

		} while (startProgram.equalsIgnoreCase("Y"));

		return inputString;

	}

	// change case
	static public String changeCase(char case1, String changeCase) {
		String input = null;
		char zero = '0';
		char one = '1';

		int compareZeroAndCase1 = Character.compare(zero, case1);
		int compareOneAndCase1 = Character.compare(one, case1);

		if (compareZeroAndCase1 == 0) {

			input = changeCase.toLowerCase();
		} else if (compareOneAndCase1 == 0) {

			input = changeCase.toUpperCase();
		}

		return input;

	}

	public static String removePunct(String stringInput) {
		String input = stringInput.replaceAll("\\W", "");
		return input;
	}

	static public String pigLatin(String input1) {
		String removePuct = removePunct(input1);
		char first = 0;
		String input = "";
		char arr[] = new char[removePuct.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = removePuct.charAt(i);
		}

		for (int i = 0; i < arr.length; i++) {
			first = arr[0];
			if (i > 0) {
				input = input.concat(Character.toString(arr[i])); 
			}
		}
		
		input = input.concat(Character.toString(first)).concat("ey");
		return input;
	}

}