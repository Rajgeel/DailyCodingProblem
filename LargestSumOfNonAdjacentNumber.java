import java.util.Scanner;

class LargestSumOfNonAdjacentNumber {

	int solution(int[] arr) {

		int n = arr.length;

		int include = arr[0];
		int exclude = 0;
		int newEnclude = 0;

		for(int i=1; i<n; i++) {

			newEnclude = Math.max(include, exclude);
			include = exclude + arr[i];
			exclude = newEnclude;
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