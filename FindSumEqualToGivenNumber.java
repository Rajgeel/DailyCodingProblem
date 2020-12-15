/*

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

*/

import java.util.Scanner;
import java.util.ArrayList;

class FindSumEqualToGivenNumber {
	

	public boolean solution(ArrayList<Integer> A, int k) {

		int size = A.size();
		int i = 0;
		int j = size - 1;

		while(i<j) {

			if(A.get(i) + A.get(j) == k) {
				return true;
			}

			else if(A.get(i) + A.get(j) > k) {
				j--;
			}
			else {
				i++;
			}
		}

		return false;
	}

	public static void main(String... s) {

		FindSumEqualToGivenNumber obj = new FindSumEqualToGivenNumber();

		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		ArrayList<Integer> arrayList = new ArrayList<>();

		for(int i=0; i<size; i++) {
			arrayList.add(sc.nextInt());
		}

		int k = sc.nextInt();

		System.out.print(obj.solution(arrayList, k));

	}
}
