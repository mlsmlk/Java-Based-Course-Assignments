package fileSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program reads a specified text file and echos it to standard display.
 * You can use this as the basis of Assignment 2, adding the necessary
 * components to implement the program specifications.
 *
 */

public class fileSort {
	@SuppressWarnings("resource")

	public static void main(String args[]) {

		System.out.println("Simple File Listing Program");
		Scanner sc = new Scanner(System.in);
		BufferedReader rd = null;

		while (rd == null) {
			System.out.print("Enter name of file to list: ");
			String filename = sc.nextLine();
			if (filename.equals("")) {
				System.out.println("Program terminated");
				System.exit(0);
			}

			try {
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				System.out.println("Unable to open file, try again.");
			}

		}

		bTree BT = new bTree();
		BT.ms = new Stack();
		System.out.println("");
		try {

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				BT.addNode(line);

			}
			System.out.println("File in sort order:\n");
			BT.inorder();
			System.out.println("\nFile in reverse order:\n");
			BT.ms.pop();
		} catch (IOException ex) {
			System.out.println("I/O Error - program terminated");
			System.exit(-1);
		}

		System.out.println("\n\nProgram terminated");

	}
}
