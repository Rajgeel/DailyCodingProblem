// Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

// Do this in linear time and in-place.

// For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].




import java.util.Scanner;


// Time complexity is O(n) and Space complexity is O(1).
class SegerateArrayValues {
	

	char[] solution(char[] arr) {

		int i = 0;
		int j = arr.length -1;

		while(i < j) {

			while(arr[i] == 'R') {
				i++;
			}

			while(arr[j] == 'B') {
				j--;
			}

			if(arr[i] != 'R' && arr[j] == 'R') {

				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
				j--;
			}

			if(arr[i] != 'R' && arr[j] != 'R') {

				j--;
			}

		}

		return arr;
	}


	void print(char[] arr) {

		for(int i=0; i<arr.length; i++) {

			System.out.print(arr[i] + " ");
		}
	} 

	public static void main(String... s) {

		SegerateArrayValues obj = new SegerateArrayValues();
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		char[] arr = new char[size];


		for(int i=0; i<size; i++) {

			arr[i] = sc.next().charAt(0);
		}

		char[] ans = obj.solution(arr);

		obj.print(ans);

	}
}