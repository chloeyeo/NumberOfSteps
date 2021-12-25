package steps;

import java.util.Scanner;

public class StepNumber {
	/**
	 * main method of this class stores all given elements in the second line into
	 * an array and returns the number of steps needed to make all elements in the
	 * array have the same value; if not possible, returns -1.
	 *
	 * isSameElement is the method that checks if all the elements in the given
	 * array are the same.
	 */
	public static boolean isPositiveElement(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSameElement(int[] array) {
		boolean same = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i + 1]) {
				same = false;
			}
		}
		return same;
	}

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("number of elements?");
		int elements = Integer.parseInt(scan.nextLine());
		int[] arrayA = new int[elements];
		int[] arrayB = new int[elements];
		System.out.println(
				"elements of arrayA separated by space: " + "(this is the elements that we want to make the same)");
		String[] secondline = scan.nextLine().split(" ");
		System.out.println("elements of arrayB separated by space:");
		String[] thirdline = scan.nextLine().split(" ");
		scan.close();
		for (int i = 0; i < elements; i++) {
			arrayA[i] = Integer.parseInt(secondline[i]);
			arrayB[i] = Integer.parseInt(thirdline[i]);
		}
		int smallest_same_element = arrayA[0];
		/**
		 * found = True when there is any two elements in the arrayA that are same.
		 * smallest_same_element is the smallest such element that has a duplicate in
		 * arrayA.
		 */
		boolean found = false;
		for (int i = 0; i < elements; i++) {
			for (int j = 0; j < elements; j++) {
				if ((i != j) && (arrayA[i] == arrayA[j])) {
					found = true;
					if (arrayA[i] < smallest_same_element) {
						smallest_same_element = arrayA[i];
					}
				}
			}
		}

		/**
		 * numberOfSteps is the no. of steps required to make all elements of array A
		 * equal. (The array given in the second line.)
		 */
		int numberOfSteps = 0;
		/**
		 * same stores the value returned from method isSameElement which checks if all
		 * the elements in the given array has the same value.
		 */
		boolean same = false;
        
		while ((same == false) && (isPositiveElement(arrayA) == true)) {
			for (int i = 0; i < elements; i++) {
				if ((found == false) || ((found == true) && (arrayA[i] != smallest_same_element))) {
					arrayA[i] -= arrayB[i];
					numberOfSteps += 1;
				}

			}
			same = isSameElement(arrayA);
		}
        
		System.out.println("number of steps taken to make elements of arrayA same (-1 if not possible):");
		if (same == false) {
			System.out.println(-1);
		} else if (same == true) {
			System.out.println(numberOfSteps);
		}
	}
}
