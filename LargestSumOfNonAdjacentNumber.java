/*
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
*/

// Time complexity is O(n) and space complexity is O(1)
import java.util.Scanner;

class LargestSumOfNonAdjacentNumber {

	int solution(int[] arr) {

		int n = arr.length;

		int include = arr[0];
		int exclude = 0;
		int newEnclude = 0;

		for(int i=1; i<n; i++) {

			newExclude = Math.max(include, exclude);
			include = exclude + arr[i];
			exclude = newExclude;
		}

		return Math.max(include, exclude);
	}
	
	public static void main(String... s) {

		LargestSumOfNonAdjacentNumber obj = new LargestSumOfNonAdjacentNumber();

		Scanner sc = new Scanner(System.in);
		int sizeArray = sc.nextInt();

		int arr[] = new int[sizeArray];

		for(int i=0; i<sizeArray; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(obj.solution(arr));
	}
}
