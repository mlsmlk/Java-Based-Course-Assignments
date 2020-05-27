package dec2base;

import acm.program.ConsoleProgram;

public class dec2base extends ConsoleProgram {

	private String dec2B(int number, int base) {

		String LUT = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		int lastQ = number;
		int R;
		String result = "";
		while (lastQ != 0) {
			R = lastQ % base;
			lastQ = lastQ / base;
			char rem = LUT.charAt(R);
			result = result + rem;
		}
		return result;
	}

	private String reverseString(String result) {

		String reverseresult = "";
		for (int i = result.length() - 1; i >= 0; i--) {
			reverseresult = reverseresult + result.charAt(i);
		}
		return reverseresult;
	}

	public void run() {
		println("Java base conversion demo:");
		while (true) {
			int number = readInt("Enter number to be converted: ");
			if (number < 0)
				break;
			int base = readInt("Enter base to convert to: ");
			String output = dec2B(number, base); // applying dec2B method
			String last = reverseString(output);// applying reverseString method to the result of dec2B
			println(number + " is represented in Base-" + base + " as " + last);// printing the final result
		}
		println("Program ended");
	}

}
